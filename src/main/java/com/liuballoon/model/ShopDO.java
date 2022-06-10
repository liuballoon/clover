/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 13:26
 */
package com.liuballoon.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopDO extends BaseDO {
    /**
     * 店铺名称
     */
    private String name;

    /**
     * 商标
     */
    private String logo;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 店铺等级
     */
    private Integer level;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 描述
     */
    private String description;
}
