/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/20 10:22
 */
package com.liuballoon.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuballoon.core.exception.http.ServerException;

/**
 * 序列化工具
 */
public class Serializer {

    private static ObjectMapper mapper;

    static {
        Serializer.mapper = new ObjectMapper();
    }

    /**
     * 对象转JSON
     *
     * @param obj 对象
     * @return JSON
     */
    public static <T> String objectToJson(T obj) {
        try {
            return Serializer.mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerException(60100);
        }
    }

    /**
     * JSON转对象
     *
     * @param json JSON
     * @param clazz 对象元类
     * @return 对象
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            return Serializer.mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerException(60100);
        }
    }

    /**
     * JSON转对象
     *
     * @param json JSON
     * @param type 对象类型
     * @return 对象
     */
    public static <T> T jsonToObject(String json, TypeReference<T> type) {
        try {
            return Serializer.mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerException(60100);
        }
    }
}
