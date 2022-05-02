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
    private String account;
    private String password;
    private String salt;
    private String openid;
    private Integer level;
    private String nickname;
    private String avatar;
    private Integer gender;
    private LocalDateTime birthDate;
    private String phone;
    private String email;
}
