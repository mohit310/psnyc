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
@Path("/fields")
@Produces(MediaType.TEXT_HTML)
public class FieldsResource {

    public FieldsResource() {
    }

    @GET
    public View displayFields(@QueryParam("city") String city) {
        if (StringUtils.isEmpty(city))
            return new MainView("Fields","fields.ftl");
        else
            return new MainView("Fields", city + ".ftl");
    }

}
