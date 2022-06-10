/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/4 21:25
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("user")
public class UserDO extends BaseDO {
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
     * 微信openid
     */
    private String openid;

    /**
     * 用户等级
     */
    private Integer level;

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
    private LocalDateTime birthDate;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;
}
