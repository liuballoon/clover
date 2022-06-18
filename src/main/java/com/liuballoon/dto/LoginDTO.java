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
import javax.validation.constraints.Positive;

@Getter
@Setter
public class LoginDTO {
    @NotBlank(message = "账号不能为空")
    private String account;

    @Length(min = 8, max = 16, message = "密码长度必须为8~16")
    private String password;

    @NotNull(message = "登陆方式不能为空")
    @Positive(message = "登录方式必须用正整数表示")
    private Integer loginWay;
}
