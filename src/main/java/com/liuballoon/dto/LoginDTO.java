/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:34
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDTO {
    /**
     * 账号
     */
    @NotNull(message = "账号缺失")
    @NotBlank(message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @Length(min = 8, max = 16, message = "密码长度必须为8~16")
    private String password;

    /**
     * 登录方式
     */
    @NotNull(message = "登陆方式缺失")
    private Integer loginWay;
}
