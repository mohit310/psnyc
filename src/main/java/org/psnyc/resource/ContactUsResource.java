package org.psnyc.resource;

import io.dropwizard.views.View;
import org.psnyc.data.Contact;
import org.psnyc.views.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        return new MainView("ContactUs","contactus.ftl");
    }

    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveContactUsInfo(Contact contact){
        LOGGER.debug(contact.toString());
        return Response.status(200).type(MediaType.TEXT_HTML).entity("Your query has been submitted. Someone will get back to you soon.").build();
    }
}
