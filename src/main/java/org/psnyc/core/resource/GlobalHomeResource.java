package org.psnyc.core.resource;

import io.dropwizard.views.View;
import org.apache.commons.lang.StringUtils;
import org.psnyc.views.GlobalView;
import org.psnyc.views.us.MainView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by mk on 8/13/14.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class GlobalHomeResource {

    public final static String SUBSITE_US = "us";
    public final static String SUBSITE_EU = "eu";

    public GlobalHomeResource() {
    }

    @GET
    public View displayHome(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("region")) {
                String regionName = cookie.getValue();
                if (StringUtils.isNotEmpty(regionName)) {
                    return new MainView(regionName, "Home", "home.ftl",null, null);
                }
            }
        }
        return new GlobalView("global_home.ftl");
    }


}
