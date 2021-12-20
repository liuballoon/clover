package com.liuballoon.common.auth;

import com.liuballoon.common.enums.UserLevel;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessScope {
    UserLevel value();
}
