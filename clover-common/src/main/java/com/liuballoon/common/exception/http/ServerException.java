/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/20 13:01
 */
package com.liuballoon.common.exception.http;

public class ServerException extends HttpException {

    public ServerException() {
        super.messageCode = 9999;
        super.statusCode = 500;
    }
}
