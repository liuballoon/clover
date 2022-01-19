/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/19 10:06
 */
package com.liuballoon.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置Redis
 */
@Configuration
public class RedisConfig {

    /**
     * 配置序列化机制
     *
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        StringRedisSerializer serializer = new StringRedisSerializer();
        RedisTemplate<String, Object> redis = new RedisTemplate<>();
        redis.setConnectionFactory(new LettuceConnectionFactory());
        redis.setKeySerializer(serializer);
        redis.setValueSerializer(serializer);
        redis.setHashKeySerializer(serializer);
        redis.setHashValueSerializer(serializer);
        return redis;
    }
}
