package org.psnyc.core.resource;

import com.google.common.base.Optional;
import com.sun.jersey.api.core.HttpResponseContext;
import com.sun.jersey.core.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.psnyc.core.authentication.User;
import org.psnyc.core.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mohit on 8/26/14.
 */
@Path("/login")
public class LoginResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginResource.class);
    private UserDAO userDAO;

    public LoginResource(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid User user) throws AuthenticationException {
        String hashPasswd = userDAO.getUserPassword(user.getEmailId());
        if (hashPasswd != null && BCrypt.checkpw(user.getPassword(), hashPasswd)) {
            return Response.status(200).entity("{ \"message\": \"success\" }").header("psnyc-email", user.getEmailId()).build();
        }
        return Response.status(422).entity("{ \"error\" :\"Login or Password incorrect\" }").build();
    }
}
