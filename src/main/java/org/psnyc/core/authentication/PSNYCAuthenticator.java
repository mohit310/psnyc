package org.psnyc.core.authentication;


import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import org.mindrot.jbcrypt.BCrypt;
import org.psnyc.core.dao.UserDAO;

/**
 * Created by mohit on 8/25/14.
 */
public class PSNYCAuthenticator implements Authenticator<PSNYCCredentials, User> {

    private UserDAO userDAO;

    public PSNYCAuthenticator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public Optional<User> authenticate(PSNYCCredentials psnycCredentials) throws AuthenticationException {
//        String hashPasswd = this.userDAO.getUserPassword(psnycCredentials.getUser().getPassword());
//        if (hashPasswd != null && BCrypt.checkpw(psnycCredentials.getUser().getPassword(), hashPasswd)) {
//            return Optional.of(new User(psnycCredentials.getUser().getEmailId()));
//        }
          return Optional.absent();
    }
}
