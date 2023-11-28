package com.fly.common.handler;

import com.fly.common.exception.ApiStatus;
import com.fly.common.exception.ServerException;
import com.fly.common.model.response.ApiResult;
import org.springframework.security.core.AuthenticationException;
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
    public ApiResult<String> handleServerException(ServerException ex) {
        return ApiResult.error(ex.getCode(), ex.getMessage());
    }

    /***
     * @Description: 处理绑定参数异常
     * @Author: zchengfeng
     * @Date: 2023-02-15 23:44:23
     * @param: ex 绑定参数异常对象
     * @return: com.fly.common.model.Result<java.lang.String>
     */
    @ExceptionHandler(BindException.class)
    public ApiResult<String> handleBindException(BindException ex) {
        FieldError fieldError = ex.getFieldError();
        assert fieldError != null;
        return ApiResult.error(fieldError.getDefaultMessage());
    }

    /***
     * @Description: 处理拒绝访问异常
     * @Author: zchengfeng
     * @Date: 2023-02-15 23:43:48
     * @param: ex 拒绝访问异常对象
     * @return: com.fly.common.model.Result<java.lang.String>
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ApiResult<String> handleAccessDenied(AccessDeniedException ex) {
        return ApiResult.error(ApiStatus.ACCESS_DENIED.getCode(), ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ApiResult<String> handleAuthentication(AuthenticationException ex) {
        return ApiResult.error(ApiStatus.AUTHENTICATION_FAILED.getCode(), ex.getMessage());
    }

    /**
     * @Description: 处理异常
     * @Author: zchengfeng
     * @Date: 2023-02-15 23:49:47
     * @param: ex 异常对象
     * @return: com.fly.common.model.Result<java.lang.String>
     */
    @ExceptionHandler(Exception.class)
    public ApiResult<String> handleException(Exception ex) {
        return ApiResult.error(ApiStatus.ERROR.getCode(), ex.getMessage());
    }
}
