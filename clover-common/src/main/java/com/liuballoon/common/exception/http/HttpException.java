/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:15
 */
package com.liuballoon.common.exception.http;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义HTTP异常
 */
@Getter
@Setter
public class HttpException extends RuntimeException {
    protected int messageCode;
    protected int statusCode;
}
