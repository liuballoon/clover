package com.liuballoon.common.enums;

/**
 * 用户等级
 */
public enum UserLevel {
    VISITOR(0, "游客"),
    GENERAL(1, "普通用户");

    private int value;
    private String description;

    UserLevel(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
