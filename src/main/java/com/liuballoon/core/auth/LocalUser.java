/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 18:52
 */
package com.liuballoon.core.auth;

import com.liuballoon.model.UserDO;

public class LocalUser {

    private static final ThreadLocal<UserDO> local = new ThreadLocal<>();

    public static void setUser(UserDO user) {
        LocalUser.local.set(user);
    }

    public static UserDO getUser() {
        return LocalUser.local.get();
    }

    public static Integer getLevel() {
        return LocalUser.local.get().getLevel();
    }

    public static void clear() {
        LocalUser.local.remove();
    }
}
