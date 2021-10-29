/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:15
 */
package com.liuballoon.common.exception;

import com.liuballoon.common.exception.http.HttpException;
import com.liuballoon.common.response.Result;
import com.liuballoon.common.utils.MessageCodesReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常统一处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageCodesReader messageCodesReader;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        int code = 9999;
        String message = this.messageCodesReader.read(code);
        System.out.println(e);
        return new Result().failure(code, message);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity handleHttpException(HttpException e) {
        String message = this.messageCodesReader.read(e.getMessageCode());
        HttpStatus httpStatus = HttpStatus.resolve(e.getStatusCode());
        assert httpStatus != null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new Result(), headers, httpStatus);
    }
}
