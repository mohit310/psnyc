package org.psnyc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mohit on 8/22/14.
 */
public class Signup {

    @JsonProperty("useremail")
    @NotNull
    @Email
    private String email;

    @JsonProperty("fname")
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @JsonProperty("lname")
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @JsonProperty("password")
    @NotNull
    @Size(min=8, max=50)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Signup{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
