/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 12:51
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.auth.JWTBuilder;
import com.liuballoon.common.exception.general.LoginException;
import com.liuballoon.common.exception.http.ServerException;
import com.liuballoon.common.utils.RandomUtil;
import com.liuballoon.common.utils.Serializer;
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

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

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
            // TODO: 密码为空的验证是否放在拦截器中更加合适？
            throw new LoginException(70006);
        }
        UserDO user = this.userMapper.selectUserByAccount(loginDTO.getAccount()).orElseThrow(() -> new LoginException(70004));
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new LoginException(70005);
        }
        return jwtBuilder.generate(user.getId());
    }

    @Override
    public String wechatLogin(LoginDTO loginDTO) {
        String code = loginDTO.getAccount();
        String url = new Formatter().format(this.code2session, this.appId, this.secret, code).toString();
        String res = new RestTemplate().getForObject(url, String.class);
        // TODO: 解决未参数化的问题
        HashMap<String, String> response = Serializer.jsonToObject(res, HashMap.class);
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
        String userId = this.userMapper.selectUserIdByOpenid(openid);
        if (userId != null) {
            return jwtBuilder.generate(userId);
        }
        UserDO user = UserDO.builder()
                .nickname(RandomUtil.nickname())
                .openid(openid)
                .gender(0)
                .build();
        this.userMapper.insert(user);
        return jwtBuilder.generate(user.getId());
    }
}
