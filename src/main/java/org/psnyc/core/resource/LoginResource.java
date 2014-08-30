package org.psnyc.core.resource;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.psnyc.core.authentication.Authority;
import org.psnyc.core.authentication.User;
import org.psnyc.core.dao.UserDAO;
import org.psnyc.data.ForgotEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

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
    public Response login(@Valid User user) throws AuthenticationException {
        User dbUser = userDAO.getUser(user.getEmailId());
        String hashPasswd = dbUser.getPassword();
        if (hashPasswd != null && BCrypt.checkpw(user.getPassword(), hashPasswd)) {
            Authority role = dbUser.getRole();
            String secretHeader = user.getEmailId() + ":" + role.toString();
            String secretHeaderMD5 = null;
            try {
                byte[] bytesOfMessage = secretHeader.getBytes("UTF-8");
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] md5Hash = digest.digest(bytesOfMessage);
                secretHeader = new String(md5Hash);
            } catch (Exception e) {
                return Response.status(500).entity("{ \"error\" : \"Error in hashing\" }").build();
            }
            return Response.status(200).entity("{ \"message\": \"success\" }").header("psnyc-auth", secretHeader).header("psnyc-role", role.toString()).build();
        }
        return Response.status(422).entity("{ \"error\" : \"Email or Password incorrect\" }").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/forgotpassword")
    public Response forgotPassword(@Valid ForgotEmail forgotEmail) throws AuthenticationException {
        if(1 == userDAO.getEmail(forgotEmail.getEmail()))
            return Response.status(200).entity("{ \"success\": \"success\" }").build();
        return Response.status(422).entity("{ \"error\" : \"Email does not exist\" }").build();
    }


}
