package org.psnyc.core.resource;

import org.apache.commons.lang.StringUtils;
import org.psnyc.core.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mohit on 8/26/14.
 */
@Path("/checkemail")
public class EmailCheckResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailCheckResource.class);

    private UserDAO userDAO;

    public EmailCheckResource(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @GET
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkEmail(@QueryParam("useremail") String email) {
        LOGGER.debug(email);
        if (StringUtils.isEmpty(email))
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("false").build();
        int emailCount = userDAO.findNameById(email);
        if (emailCount > 0) return Response.status(200).type(MediaType.APPLICATION_JSON).entity("false").build();
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity("true").build();
    }
}
