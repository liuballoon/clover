/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 13:09
 */
package com.liuballoon.common.exception.general;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用异常
 */
@Getter
@Setter
public abstract class GeneralException extends RuntimeException {
    protected int messageCode;
    protected int statusCode;
}
