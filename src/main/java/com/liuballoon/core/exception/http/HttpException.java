/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:15
 */
package com.liuballoon.core.exception.http;

import lombok.Getter;
import lombok.Setter;

/**
 * HTTP异常
 */
@Getter
@Setter
public abstract class HttpException extends RuntimeException {
    protected int messageCode;
    protected int statusCode;
}
