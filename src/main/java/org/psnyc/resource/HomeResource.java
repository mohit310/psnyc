package org.psnyc.resource;

import io.dropwizard.views.View;
import org.psnyc.views.MainView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by mk on 8/13/14.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

    public HomeResource() {
    }

    @GET
    public View displayHome() {
        return new MainView("Home","home.ftl");
    }

}
