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
    private String name;
    private String logo;
    private String account;
    private String password;
    private String salt;
    private Integer level;
    private String email;
    private String description;
}
