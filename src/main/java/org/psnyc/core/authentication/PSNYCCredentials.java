package org.psnyc.core.authentication;

/**
 * Created by mohit on 8/26/14.
 */
public class PSNYCCredentials {

    private Authority[] reguiredAuthorities;

    public PSNYCCredentials(Authority[] reguiredAuthorities, User user) {
        this.reguiredAuthorities = reguiredAuthorities;
    }

    public Authority[] getReguiredAuthorities() {
        return reguiredAuthorities;
    }

    public void setReguiredAuthorities(Authority[] reguiredAuthorities) {
        this.reguiredAuthorities = reguiredAuthorities;
    }

}
