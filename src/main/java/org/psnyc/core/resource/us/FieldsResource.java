package org.psnyc.core.resource.us;

import io.dropwizard.views.View;
import org.apache.commons.lang.StringUtils;
import org.psnyc.core.constants.Subsite;
import org.psnyc.core.dao.FieldDAO;
import org.psnyc.core.dao.UserDAO;
import org.psnyc.views.us.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(FieldsResource.class);
    private final FieldDAO fieldDAO;

    public FieldsResource(FieldDAO fieldDAO) {
        this.fieldDAO = fieldDAO;
    }

    @GET
    public View displayFields(@QueryParam("fieldname") String fieldname) {
        if (StringUtils.isEmpty(fieldname))
            return new MainView(Subsite.US, "Fields","fields.ftl", "field", fieldDAO.getFieldByCountry("US"));
        else
            return new MainView(Subsite.US, "Fields", "field.ftl", "field", fieldDAO.getFieldByCity(fieldname));
    }

}
