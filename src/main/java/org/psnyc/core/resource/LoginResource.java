package org.psnyc.core.resource;

import org.mindrot.jbcrypt.BCrypt;
import org.psnyc.core.authentication.Authority;
import org.psnyc.core.authentication.User;
import org.psnyc.core.dao.UserDAO;
import org.psnyc.data.ForgotEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * Created by mohit on 8/26/14.
 */
@Path("/login")
public class LoginResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginResource.class);
    private UserDAO userDAO;

    public LoginResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid User user, @Context HttpServletRequest request) throws AuthenticationException {
        User dbUser = userDAO.getUser(user.getEmailId());
        if (dbUser != null) {
            String hashPasswd = dbUser.getPassword();
            if (hashPasswd != null && BCrypt.checkpw(user.getPassword(), hashPasswd)) {
                Authority role = dbUser.getRole();
                return Response.status(200).entity("{ \"message\": \"success\", \"emailId\": \"" + dbUser.getEmailId() + "\", \"firstname\": \"" + dbUser.getFirstName() + "\", \"lastname\": \"" + dbUser.getLastName() + "\", \"role\": \"" + role.toString() + "\", \"id\": \"" + dbUser.getId() + "\" }").build();
            }
        }
        return Response.status(422).entity("{ \"error\" : \"Email or Password incorrect\" }").build();
    }

    private String createSessionToken(String emailId, String id, String role) {
        String sessionToken = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = emailId + ":" + id + ":" + role;
            md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            byte[] token64 = Base64.getEncoder().encode(digest);
            sessionToken = new String(token64);
        }catch(Exception e){
            LOGGER.error("Error in getting creating sessionToken", e);
        }
        return sessionToken;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/forgotpassword")
    public Response forgotPassword(@Valid ForgotEmail forgotEmail) throws AuthenticationException {
        if (1 == userDAO.getEmail(forgotEmail.getEmail()))
            return Response.status(200).entity("{ \"success\": \"success\" }").build();
        return Response.status(422).entity("{ \"error\" : \"Email does not exist\" }").build();
    }


}
