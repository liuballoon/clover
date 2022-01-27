/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 12:51
 */
package com.liuballoon.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liuballoon.common.utils.RandomUtil;
import com.liuballoon.common.utils.Serializer;
import com.liuballoon.core.auth.JWTBuilder;
import com.liuballoon.core.enums.SelectBy;
import com.liuballoon.core.enums.UserLevel;
import com.liuballoon.core.exception.general.LoginException;
import com.liuballoon.core.exception.http.ServerException;
import com.liuballoon.dto.LoginDTO;
import com.liuballoon.model.UserDO;
import com.liuballoon.service.LoginService;
import com.liuballoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTBuilder jwtBuilder;

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.code2session}")
    private String code2session;

    @Override
    public String accountLogin(LoginDTO loginDTO) {
        if (loginDTO.getPassword() == null) {
            throw new LoginException(70006);
        }
        UserDO user = this.userService.getUserByCondition(loginDTO.getAccount(), SelectBy.ACCOUNT);
        if (user == null) {
            throw new LoginException(70004);
        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new LoginException(70005);
        }
        return jwtBuilder.generate(user.getId(), user.getLevel());
    }

    @Override
    public String wechatLogin(LoginDTO loginDTO) {
        String code = loginDTO.getAccount();
        String url = String.format(this.code2session, this.appId, this.secret, code);
        String res = new RestTemplate().getForObject(url, String.class);
        HashMap<String, String> response = Serializer.jsonToObject(res, new TypeReference<>() {
        });
        return this.registerUser(response.get("openid"));
    }

    /**
     * 注册用户并生成token
     *
     * @param openid 微信openid
     * @return token
     */
    private String registerUser(String openid) {
        if (openid == null) {
            throw new ServerException(9001);
        }
        UserDO user = this.userService.getUserByCondition(openid, SelectBy.OPENID);
        if (user != null) {
            return jwtBuilder.generate(user.getId(), user.getLevel());
        }
        user = UserDO.builder()
                .nickname(RandomUtil.nickname())
                .openid(openid)
                .level(UserLevel.GENERAL.getValue())
                .gender(0)
                .build();
        this.userService.save(user);
        return jwtBuilder.generate(user.getId(), user.getLevel());
    }
}
