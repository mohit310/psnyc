package org.psnyc.core.dao;

import org.psnyc.core.authentication.User;
import org.psnyc.core.dao.mapper.UserMapper;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mohit on 8/25/14.
 */
public interface UserDAO {

    @Mapper(UserMapper.class)
    @SqlQuery("select a.*, b.role from User a, UserRole b where a.email = :email")
    User getUser(@Bind("email") String email);

    @SqlQuery("select count(email) as email_count from User where email = :email")
    int getEmail(@Bind("email") String email);

    @SqlUpdate("insert into User (firstname, lastname, email, phone, password) values (:firstname, :lastname, :email, :phone, :password)")
    @GetGeneratedKeys
    long insert(@Bind("firstname") String firstname, @Bind("lastname") String lastname, @Bind("email") String email, @Bind("phone") String phone, @Bind("password") String password);

    @SqlUpdate("insert into UserRole (id, role) values (:id, :role)")
    int insertUserRole(@Bind("id") long id, @Bind("role") String role);

}

