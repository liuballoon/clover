/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:34
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class LoginDTO {
    /**
     * 账号
     */
    @NotNull(message = "账号不能为空！")
    @NotBlank
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录方式
     */
    @NotNull
    @Positive
    private Integer loginWay;
}
