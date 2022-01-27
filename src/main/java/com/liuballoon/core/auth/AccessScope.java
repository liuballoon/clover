package com.liuballoon.core.auth;

import com.liuballoon.core.enums.UserLevel;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessScope {
    UserLevel value();
}
