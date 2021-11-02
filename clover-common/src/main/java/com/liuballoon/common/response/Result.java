/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/27 18:45
 */
package com.liuballoon.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义响应对象
 */
@AllArgsConstructor
@Getter
@Setter
public class Result {
    private int code;
    private String message;
    private Boolean success;
    private Object data;

    public static Result success(Object data) {
        return new Result(200, "请求成功", true, data);
    }

    public static Result failure(int code, String message) {
        return new Result(code, message, false, null);
    }
}
