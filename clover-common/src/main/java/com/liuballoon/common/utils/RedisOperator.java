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

}
