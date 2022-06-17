/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/10 21:24
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
public class UserInfoDTO {
    private String id;

    @NotBlank(message = "昵称不能为空")
    private String nickname;
    private String avatar;

    @Positive(message = "性别必须用正整数表示")
    private Integer gender;
    private LocalDate birthDate;
}
