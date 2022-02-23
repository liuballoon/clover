/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 18:52
 */
package com.liuballoon.core.auth;

import com.liuballoon.model.UserDO;

public class LocalUser {

    private static final ThreadLocal<UserDO> local = new ThreadLocal<>();

    /**
     * 保存用户
     *
     * @param user 用户
     */
    public static void set(UserDO user) {
        LocalUser.local.set(user);
    }

    /**
     * 获取用户
     *
     * @return 用户
     */
    public static UserDO get() {
        return LocalUser.local.get();
    }

    /**
     * 获取用户等级
     *
     * @return 用户等级
     */
    public static Integer getLevel() {
        return LocalUser.local.get().getLevel();
    }

    /**
     * 清空
     */
    public static void clear() {
        LocalUser.local.remove();
    }
}
