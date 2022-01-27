/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/19 12:03
 */
package com.liuballoon.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisOperator {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储值（字符串）
     *
     * @param key 键
     * @param value 值
     */
    public void set(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取值（字符串）
     *
     * @param key 键
     * @return 值
     */
    public String get(String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }
}
