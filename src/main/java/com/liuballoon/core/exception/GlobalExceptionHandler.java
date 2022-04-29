/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:15
 */
package com.liuballoon.core.exception;

import com.liuballoon.common.utils.MessageCodesReader;
import com.liuballoon.core.exception.http.HttpException;
import com.liuballoon.core.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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
        e.printStackTrace();
        return Result.failure(code, message);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<Result> handleHttpException(HttpException e) {
        String message = this.messageCodesReader.read(e.getMessageCode());
        HttpStatus httpStatus = HttpStatus.resolve(e.getStatusCode());
        assert httpStatus != null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(Result.failure(e.getMessageCode(), message), headers, httpStatus);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        int code = 9201;
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = this.formatErrorsMessages(errors);
        return Result.failure(code, message);
    }

    /**
     * 格式化 MethodArgumentNotValidException 的错误信息
     *
     * @param errors 错误列表
     * @return 格式化信息
     */
    private String formatErrorsMessages(List<ObjectError> errors) {
        StringBuilder message = new StringBuilder();
        int length = errors.size();
        for (var i = 0; i < length; i++) {
            message.append(errors.get(i).getDefaultMessage());
            if (i == length - 1) {
                break;
            }
            message.append(", ");
        }
        return message.toString();
    }
}
