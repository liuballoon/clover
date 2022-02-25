/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 9:42
 */
package com.liuballoon.common.enums;

/**
 * 查询用户方式
 */
public enum SelectBy {
    ID("id", "根据主键"),
    ACCOUNT("account", "根据账号"),
    OPENID("openid", "根据微信openid");

    private final String value;
    private final String description;

    public String getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    SelectBy(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
