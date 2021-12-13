/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/4 21:25
 */
package com.liuballoon.pojo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("user")
public class UserDO extends BaseDO {
    private String username;
    private String password;
    private String avatar;
    private Integer gender;
    private Date birthDate;
    private String phone;
    private String email;
}
