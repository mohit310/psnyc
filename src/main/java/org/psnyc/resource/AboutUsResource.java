package org.psnyc.resource;

import io.dropwizard.views.View;
import org.apache.commons.lang.StringUtils;
import org.psnyc.views.MainView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by mk on 8/14/14.
 */
@Path("/aboutus")
@Produces(MediaType.TEXT_HTML)
public class AboutUsResource {

    public AboutUsResource() {
    }

    @GET
    public View displayAboutUs() {
        return new MainView("AboutUs","aboutus.ftl");
    }
}
