package org.psnyc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by mohit on 8/19/14.
 */
public class Contact {

    @JsonProperty("fname")
    @NotEmpty
    private String firstName;

    @JsonProperty("lname")
    @NotEmpty
    private String lastName;

    @JsonProperty("email")
    @NotEmpty
    private String emailId;

    @JsonProperty
    @NotEmpty
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
