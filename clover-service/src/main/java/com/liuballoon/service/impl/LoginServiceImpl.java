/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 12:51
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.auth.JWTBuilder;
import com.liuballoon.common.exception.general.LoginException;
import com.liuballoon.mapper.UserMapper;
import com.liuballoon.pojo.dto.LoginDTO;
import com.liuballoon.pojo.model.UserDO;
import com.liuballoon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.code2session}")
    private String code2session;

    @Override
    public String accountLogin(LoginDTO loginDTO) {
        if (loginDTO.getPassword() == null) {
            throw new LoginException(70001);
        }
        return null;
    }

    @Override
    public String wechatLogin(LoginDTO loginDTO) {
        // TODO: 根据session_key请求微信服务器获取open_id并存入用户表
        String sessionKey = loginDTO.getAccount();
        String url = new Formatter().format(this.code2session, this.appId, this.secret, sessionKey).toString();
        Map response = new RestTemplate().getForObject(url, HashMap.class);
        String token = JWTBuilder.generate();
        UserDO user = UserDO.builder()
                .build();
        this.userMapper.insert(user);
        return token;
    }
}
