/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/10 21:24
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UserInfoDTO {
    /**
     * 主键
     */
    @NotNull
    private String id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别（0保密 1男 2女）
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private LocalDate birthDate;
}
