/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/24 15:17
 */
package com.liuballoon.common.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT
 */
@Component
public class JWTBuilder {

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expire-time}")
    private Long expireTime;

    /**
     * 生成token
     *
     * @param userId 用户主键
     * @return token
     */
    public String generate(String userId) {
        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        return JWT.create()
                .withIssuer(this.issuer)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(this.expireTime))
                .withClaim("userId", userId)
                .sign(algorithm);
    }
}
