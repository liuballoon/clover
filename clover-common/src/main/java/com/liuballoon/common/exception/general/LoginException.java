/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 13:10
 */
package com.liuballoon.common.exception.general;

public class LoginException extends GeneralException {

    public LoginException(int messageCode) {
        super.messageCode = messageCode;
        super.statusCode = 404;
    }
}
