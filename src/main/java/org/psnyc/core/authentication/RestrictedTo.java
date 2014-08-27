package org.psnyc.core.authentication;

import java.lang.annotation.*;

/**
 * Created by mohit on 8/26/14.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface RestrictedTo {
    // No value assumes only an admin can reach the resource
    Authority[] value() default Authority.ROLE_CLIENT;
}
