/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/24 15:17
 */
package com.liuballoon.core.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

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
     * @param userLevel 用户等级
     * @return token
     */
    public String generate(String userId, int userLevel) {
        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        return JWT.create()
                .withIssuer(this.issuer)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(this.expireTime))
                .withClaim("userId", userId)
                .withClaim("userLevel", userLevel)
                .sign(algorithm);
    }

    /**
     * 验证token
     *
     * @param token token
     * @return ture false
     */
    public boolean verify(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        return true;
    }
}
