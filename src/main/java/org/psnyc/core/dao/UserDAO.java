package org.psnyc.core.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by mohit on 8/25/14.
 */
public interface UserDAO {
    @SqlQuery("select count(*) as email_count from User where email = :email")
    int findNameById(@Bind("email") String email);


    @SqlQuery("select password from User where email = :email")
    String getUserPassword(@Bind("email") String email);

    @SqlUpdate("insert into User (firstname, lastname, email, password) values (:firstname, :lastname, :email, :password)")
    void insert(@Bind("firstname") String firstname, @Bind("lastname") String lastname, @Bind("email") String email, @Bind("password") String password);


}