package org.psnyc.core.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.psnyc.core.resource.Subsite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mohit on 8/20/14.
 */
public class RegionCookieFilter implements ContainerResponseFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionCookieFilter.class);

    private static final List<String> byPassList = new ArrayList<String>();

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        boolean regionCookieSet = false;
        Map<String, Cookie> cookies = request.getCookies();
        if (cookies.get("region") != null) {
            regionCookieSet = true;
        }

        if (!regionCookieSet) {
            String uriPath = request.getRequestUri().toASCIIString();
            if (uriPath.contains("/" + Subsite.US) || uriPath.contains("/" + Subsite.EU)) {
                String region = uriPath.contains("/" + Subsite.US) ? Subsite.US : Subsite.EU;
                NewCookie cookie = new NewCookie("region", region);
                Response regionCookieResponse = Response.fromResponse(response.getResponse()).cookie(cookie).build();
                response.setResponse(regionCookieResponse);
            }
        }
        return response;
    }


}
