package org.psnyc.core.resource;

import org.mindrot.jbcrypt.BCrypt;
import org.psnyc.core.dao.UserDAO;
import org.psnyc.data.Signup;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.TransactionCallback;
import org.skife.jdbi.v2.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mohit on 8/22/14.
 */
@Path("/signup")
public class SignUpResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpResource.class);
    private UserDAO userDAO;
    private DBI database;

    public SignUpResource(DBI dbi, UserDAO userDAO) {
        this.userDAO = userDAO;
        this.database = dbi;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp(@Valid Signup signup) {
        LOGGER.debug(signup.toString());
        if (!(signup.getPassword().equals(signup.getConfirmPassword())))
            return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{ \"errors\" : [\"Passwords dont match.\"] }").build();
        if(userDAO.getEmail(signup.getEmail()) > 0 )
            return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{ \"errors\" : [\"Email already in use.\"] }").build();
        String hashPwd = BCrypt.hashpw(signup.getPassword(), BCrypt.gensalt());
        database.inTransaction(
                new TransactionCallback<Boolean>() {
                    public Boolean inTransaction(Handle h, TransactionStatus status) {
                        long userId = userDAO.insert(signup.getFirstName(), signup.getLastName(), signup.getEmail(), signup.getPhone(), hashPwd);
                        int insertCount = userDAO.insertUserRole(userId, "CLIENT");
                        if (insertCount != 1) {
                            status.setRollbackOnly();
                            return false;
                        }
                        return true;
                    }
                }
        );
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{ \"message\" : \"success\" }").build();
    }
}
