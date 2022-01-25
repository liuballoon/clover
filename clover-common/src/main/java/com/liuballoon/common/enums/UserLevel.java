package com.liuballoon.common.enums;

import java.util.stream.Stream;

/**
 * 用户等级
 */
public enum UserLevel {
    VISITOR(0, "游客"),
    GENERAL(1, "普通用户");

    private final int value;
    private final String description;

    UserLevel(int value, String description) {
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
    public static UserLevel toType(int value) {
        return Stream.of(UserLevel.values())
                .filter(userLevel -> userLevel.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
