package org.psnyc.core.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mohit on 8/26/14.
 */
public class User {

    @JsonProperty
    @NotNull
    long id;

    @JsonProperty("email")
    @NotNull
    private String emailId;

    @JsonProperty("password")
    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    private Authority role;

    public User() {
    }

    public User(long id, String emailId, String password, Authority role) {
        this.id = id;
        this.emailId = emailId;
        this.password = password;
        this.role = role;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authority getRole() {
        return role;
    }

    public void setRole(Authority role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
