package org.psnyc.core.resource.us;

import io.dropwizard.views.View;
import org.apache.commons.lang.StringUtils;
import org.psnyc.core.constants.Subsite;
import org.psnyc.views.us.MainView;

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
            return new MainView(Subsite.US, "Fields","fields.ftl");
        else
            return new MainView(Subsite.US, "Fields", city + ".ftl");
    }

}
