package org.psnyc.core.authentication;

import org.junit.Assert;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by mk on 9/19/14.
 */
public class TestBCryptHash {


    public @Test void testHash(){
        String salt = BCrypt.gensalt(10);
        Assert.assertNotNull(salt,"Salt is null");
        System.out.println(salt);
        String hash = BCrypt.hashpw("12345678",salt);
        Assert.assertNotNull(hash,"HASH is null");
    }
}
