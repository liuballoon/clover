/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/20 13:01
 */
package com.liuballoon.core.exception.http;

public class ServerException extends HttpException {

    public ServerException(int messageCode) {
        super.messageCode = messageCode;
        super.statusCode = 500;
    }
}
