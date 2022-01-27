/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 0:09
 */
package com.liuballoon.core.exception.http;

public class UnauthorizedException extends HttpException {

    public UnauthorizedException(int messageCode) {
        super.messageCode = messageCode;
        super.statusCode = 401;
    }
}
