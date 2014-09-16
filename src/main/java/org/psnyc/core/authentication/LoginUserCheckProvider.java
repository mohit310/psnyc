package org.psnyc.core.authentication;

import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;


/**
 * Created by mohit on 9/4/14.
 */
public class LoginUserCheckProvider implements Injectable<User>, InjectableProvider<LoginCheckUser, Type> {

    private final HttpServletRequest request;

    public LoginUserCheckProvider(@Context HttpServletRequest request) {
        this.request = request;
    }


    @Override
    public User getValue() {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return user;
    }

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable getInjectable(ComponentContext ic, LoginCheckUser loginCheckUser, Type type) {
        if (type.equals(User.class)) {
            return this;
        }
        return null;
    }
}
