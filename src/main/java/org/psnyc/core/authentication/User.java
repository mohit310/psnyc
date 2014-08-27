package org.psnyc.core.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by mohit on 8/26/14.
 */
public class User {


    @JsonProperty("email")
    @NotNull
    private String emailId;

    @JsonProperty("password")
    @NotNull
    private String password;

    public User() {
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
}
