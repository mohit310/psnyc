package org.psnyc.core.resource.us;

import io.dropwizard.views.View;
import org.psnyc.data.Contact;
import org.psnyc.core.constants.Subsite;
import org.psnyc.views.us.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mk on 8/14/14.
 */
@Path("/contactus")
public class ContactUsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsResource.class);

    public ContactUsResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public View displayContactUs() {
        return new MainView(Subsite.US,"ContactUs","contactus.ftl");
    }

    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveContactUsInfo(@Valid Contact contact) throws WebApplicationException{
        LOGGER.debug(contact.toString());
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{ \"message\" : \"Your query has been submitted. Someone will get back to you soon.\"}").build();
    }
}
