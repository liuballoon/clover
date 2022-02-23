/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/28 11:58
 */
package com.liuballoon.core.exception.http;

public class ForbiddenException extends HttpException {

    public ForbiddenException(int messageCode) {
        super.messageCode = messageCode;
        super.statusCode = 403;
    }
}
