package org.psnyc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by mohit on 8/19/14.
 */
public class Contact {

    @JsonProperty("fname")
    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstName;

    @JsonProperty("lname")
    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @JsonProperty("useremail")
    @NotEmpty
    @Email
    private String emailId;

    @JsonProperty
    @NotEmpty
    @Size(min=10, max=500)
    private String query;

    public Contact(){

    }



    public Contact(String firstName, String lastName, String emailId, String query) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.query = query;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return new StringBuffer(" First Name : ").append(this.firstName)
                .append(" Last Name : ").append(this.lastName)
                .append(" Email : ").append(this.emailId)
                .append(" Query : ").append(this.query)
                .toString();
    }
}
