/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/5/31 15:17
 */
package com.liuballoon.core.exception.general;

public class OrderException extends GeneralException {

    public OrderException(int messageCode) {
        super.messageCode = messageCode;
        super.statusCode = 404;
    }
}
