package org.psnyc.core.resource;

import org.apache.commons.lang.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.psnyc.core.dao.UserDAO;
import org.psnyc.data.Signup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mohit on 8/22/14.
 */
@Path("/signup")
public class SignUpResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpResource.class);
    private UserDAO userDAO;

    public SignUpResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp(@Valid Signup signup) {
        LOGGER.debug(signup.toString());
        if (!(signup.getPassword().equals(signup.getConfirmPassword())))
            Response.status(422).type(MediaType.APPLICATION_JSON).entity("{ \"errors\" : [\"Passwords dont match.\"] }").build();
        String hashPwd = BCrypt.hashpw(signup.getPassword(), BCrypt.gensalt());
        userDAO.insert(signup.getFirstName(), signup.getLastName(), signup.getEmail(), hashPwd);
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{ \"message\" : \"success\" }").build();
    }
}
