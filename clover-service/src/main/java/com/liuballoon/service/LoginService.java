/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 12:51
 */
package com.liuballoon.service;

import com.liuballoon.pojo.dto.LoginDTO;

public interface LoginService {
    /**
     * 账号登录
     *
     * @param loginDTO 登录信息
     * @return token
     */
    String accountLogin(LoginDTO loginDTO);

    /**
     * 微信登录
     *
     * @param loginDTO 登录信息
     * @return token
     */
    String wechatLogin(LoginDTO loginDTO);
}
