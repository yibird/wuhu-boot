package com.fly.common.exception;

import com.fly.common.model.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * @Description: 全局异常处理类
 * @Author: zchengfeng
 * @Date: 2023-02-15 23:25:34
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public Result<String> handleServerException(ServerException ex) {
        return Result.error(ex.getCode(), ex.getMessage());
    }

    /***
     * @Description: 处理绑定参数异常
     * @Author: zchengfeng
     * @Date: 2023-02-15 23:44:23
     * @param: ex 绑定参数异常对象
     * @return: com.fly.common.model.Result<java.lang.String>
     */
    @ExceptionHandler(BindException.class)
    public Result<String> handleBindException(BindException ex) {
        FieldError fieldError = ex.getFieldError();
        assert fieldError != null;
        return Result.error(fieldError.getDefaultMessage());
    }

    /***
     * @Description: 处理拒绝访问异常
     * @Author: zchengfeng
     * @Date: 2023-02-15 23:43:48
     * @param: ex 拒绝访问异常对象
     * @return: com.fly.common.model.Result<java.lang.String>
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result<String> handleAccessDenied(AccessDeniedException ex) {
        return Result.error(ResultStatus.ACCESS_DENIED);
    }

    /**
     * @Description: 处理异常
     * @Author: zchengfeng
     * @Date: 2023-02-15 23:49:47
     * @param: ex 异常对象
     * @return: com.fly.common.model.Result<java.lang.String>
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception ex) {
        System.out.println("Exception ex：" + ex);
        return Result.error(ResultStatus.ERROR.getCode(),ex.getMessage());
    }
}
