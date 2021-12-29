/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/12/29 14:11
 */
package com.liuballoon.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisOperator {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储值
     *
     * @param key 键
     * @param value 值
     */
    public void set(String key, String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 存储值
     *
     * @param key 键
     * @param value 值
     * @param expired 过期时间（秒）
     */
    public void set(String key, String value, Long expired) {
        this.stringRedisTemplate.opsForValue().set(key, value, expired, TimeUnit.SECONDS);
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return
     */
    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除
     *
     * @param key 键
     */
    public void del(String key) {
        this.stringRedisTemplate.delete(key);
    }

    /**
     * 获取键的过期时间
     *
     * @param key 键
     * @return
     */
    public Long ttl(String key) {
        return this.stringRedisTemplate.getExpire(key);
    }
}
