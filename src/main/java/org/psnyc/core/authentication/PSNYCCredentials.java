package org.psnyc.core.authentication;

/**
 * Created by mohit on 8/26/14.
 */
public class PSNYCCredentials {

    private Authority[] reguiredAuthorities;
    private User user;

    public PSNYCCredentials(Authority[] reguiredAuthorities, User user) {
        this.reguiredAuthorities = reguiredAuthorities;
        this.user = user;
    }

    public Authority[] getReguiredAuthorities() {
        return reguiredAuthorities;
    }

    public void setReguiredAuthorities(Authority[] reguiredAuthorities) {
        this.reguiredAuthorities = reguiredAuthorities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
