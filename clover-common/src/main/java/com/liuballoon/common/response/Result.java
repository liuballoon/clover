/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/27 18:45
 */
package com.liuballoon.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private int code;
    private String message;
    private Boolean success;
    private T data;

    public void success(T data) {
        this.code = 200;
        this.message = message;
        this.success = true;
        this.data = data;
    }

    public Result<T> failure(int code, String message) {
        this.code = code;
        this.message = message;
        this.success = false;
        this.data = null;
        return null;
    }
}
