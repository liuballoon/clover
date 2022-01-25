package com.liuballoon.common.enums;

import java.util.stream.Stream;

/**
 * 登录方式
 */
public enum LoginWay {
    ACCOUNT(0, "账号登录"),
    WECHAT(1, "微信登录");

    private final int value;
    private final String description;

    LoginWay(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * 根据枚举值获取枚举
     *
     * @param value 枚举值
     * @return 枚举
     */
    public static LoginWay toType(int value) {
        return Stream.of(LoginWay.values())
                .filter(loginWay -> loginWay.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
