/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:17
 */
package com.liuballoon.core.exception.http;

public class NotFoundException extends HttpException {

    public NotFoundException(int messageCode) {
        super.messageCode = messageCode;
        super.statusCode = 404;
    }
}
