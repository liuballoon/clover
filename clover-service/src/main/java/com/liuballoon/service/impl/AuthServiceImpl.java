/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:24
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.enums.LoginWay;
import com.liuballoon.pojo.dto.LoginDTO;
import com.liuballoon.pojo.vo.TokenVO;
import com.liuballoon.service.AuthService;
import com.liuballoon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private LoginService loginService;

    @Override
    public TokenVO login(LoginDTO loginDTO) {
        String token = null;
        LoginWay way = LoginWay.toType(loginDTO.getLoginWay());
        switch (way) {
            case ACCOUNT -> token = this.loginService.accountLogin(loginDTO);
            case WECHAT -> token = this.loginService.wechatLogin(loginDTO);
        }
        return new TokenVO(token);
    }
}
