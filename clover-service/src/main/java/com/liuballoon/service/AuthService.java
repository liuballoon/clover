/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:24
 */
package com.liuballoon.service;

import com.liuballoon.pojo.dto.LoginDTO;
import com.liuballoon.pojo.vo.TokenVO;

public interface AuthService {
    /**
     * 登录
     *
     * @param loginDTO 登录信息
     * @return token
     */
    TokenVO login(LoginDTO loginDTO);
}
