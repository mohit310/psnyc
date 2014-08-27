package org.psnyc.core.authentication;

import com.google.common.base.Optional;
import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.server.impl.inject.AbstractHttpContextInjectable;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by mohit on 8/26/14.
 */
public class PSNYCRestrictedToProvider<T> implements InjectableProvider<RestrictedTo, Parameter> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PSNYCRestrictedToProvider.class);
    private final String realm;
    private Authenticator<PSNYCCredentials, T> authenticator;

    public PSNYCRestrictedToProvider(Authenticator<PSNYCCredentials, T> authenticator, String realm) {
        this.authenticator = authenticator;
        this.realm = realm;
    }

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable getInjectable(ComponentContext ic, RestrictedTo restrictedTo, Parameter parameter) {
        return new PSNYCServerRestrictedToInjectable<T>(authenticator, realm, restrictedTo.value(), parameter);
    }

    static class PSNYCServerRestrictedToInjectable<T> extends AbstractHttpContextInjectable<T> {

        private final Authenticator<PSNYCCredentials, T> authenticator;
        private final String realm;
        private final Authority[] requiredAuthorities;
        private final Parameter parameter;

        /**
         * @param authenticator       The Authenticator that will compare credentials
         * @param realm               The authentication realm
         * @param requiredAuthorities The required authorities as provided by the RestrictedTo annotation
         */
        PSNYCServerRestrictedToInjectable(
                Authenticator<PSNYCCredentials, T> authenticator,
                String realm,
                Authority[] requiredAuthorities,
                Parameter parameter) {
            this.authenticator = authenticator;
            this.realm = realm;
            this.requiredAuthorities = requiredAuthorities;
            this.parameter = parameter;
        }

        @Override
        public T getValue(HttpContext httpContext) {

            try {

                // Get the Authorization header
                final String header = httpContext.getRequest().getHeaderValue(HttpHeaders.AUTHORIZATION);

                if (header != null) {

                    final PSNYCCredentials credentials = new PSNYCCredentials(requiredAuthorities, new User());

                    final Optional<T> result = authenticator.authenticate(credentials);
                    if (result.isPresent()) {
                        return result.get();
                    }
                }
            } catch (IllegalArgumentException e) {
                PSNYCRestrictedToProvider.LOGGER.debug("Error decoding credentials",e);
            } catch (AuthenticationException e) {
                PSNYCRestrictedToProvider.LOGGER.warn("Error authenticating credentials",e);
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }

            // Must have failed to be here
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED)
                    .header(HttpHeaders.AUTHORIZATION,null)
                    .entity("Credentials are required to access this resource.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());
        }

    }

}
