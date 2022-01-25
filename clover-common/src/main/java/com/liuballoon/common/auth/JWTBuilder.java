/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/24 15:17
 */
package com.liuballoon.common.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * JWT
 */
public class JWTBuilder {

    @Value("${jwt.issuer}")
    private static String issuer;

    @Value("${jwt.secret-key}")
    private static String secretKey;

    @Value("${jwt.expire-time}")
    private static Long expireTime;

    public static String generate() {
        Algorithm algorithm = Algorithm.HMAC256(JWTBuilder.secretKey);
        return JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(expireTime))
                .sign(algorithm);
    }
}
