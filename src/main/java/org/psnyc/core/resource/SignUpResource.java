package org.psnyc.core.resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mohit on 8/22/14.
 */
@Path("/signup")
public class SignUpResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpResource.class);

    @GET
    @Path("/checkemail")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkEmail(@QueryParam("useremail") String email) {
        LOGGER.debug(email);
        if (StringUtils.isEmpty(email))
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("false").build();
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity("true").build();
    }
}
