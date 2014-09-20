package org.psnyc.core.dao.mapper;

import org.psnyc.core.authentication.Authority;
import org.psnyc.core.authentication.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mohit on 8/28/14.
 */
public class UserMapper implements ResultSetMapper<User> {
    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        User user = new User();
        user.setFirstName(r.getString("firstname"));
        user.setLastName(r.getString("lastname"));
        user.setEmailId(r.getString("email"));
        user.setPassword(r.getString("password"));
        user.setId(r.getLong("id"));
        String role = r.getString("role");
        if (role.equals("ADMIN"))
            user.setRole(Authority.ADMIN);
        else
            user.setRole(Authority.USER);
        return user;
    }
}