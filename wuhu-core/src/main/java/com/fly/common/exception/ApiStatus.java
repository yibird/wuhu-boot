package com.fly.common.exception;

import lombok.Getter;

/**
 * @Description 响应状态码枚举类
 * @Author zchengfeng
 * @Date: 2023-02-15 23:17:46
 */
@Getter
public enum ApiStatus {
    // 响应成功
    SUCCESS(200, "Response successful"),
    // 响应错误
    ERROR(500, "Response error"),
    // 没有权限访问资源
    ACCESS_DENIED(1, "No permission to access this resource"),
    // 访问令牌非法
    INVALID_TOKEN(2, "Illegal access token"),
    // 验证码无效
    INVALID_CAPTCHA(3, "Invalid verification code"),
    // 错误凭证
    BAD_CREDENTIALS(4, "Bad credentials(username or password error)"),
    // 认证失败
    AUTHENTICATION_FAILED(5, "Authentication failed"),
    // 未授权访问
    UNAUTHORIZED(6,"Unauthorized access"),
    ADD_SUCCESS(200, "Added successfully"),
    ADD_FAIL(20002, "Added failed"),
    ADD_ERROR(10003, "Added Error"),
    UPDATE_SUCCESS(200, "Updated successfully"),
    UPDATE_FAIL(10005, "Updated failed"),
    UPDATE_ERROR(10006, "Updated error"),
    DEL_SUCCESS(200, "Deleted successfully"),
    DEL_FAIL(10008, "Deleted failed"),
    DEL_ERROR(10009, "Deleted error"),
    OP_SUCCESS(10010, "Operation successfully"),
    OP_FAIL(10011, "Operation failed"),
    OP_ERROR(10012, "Operation error");

    private final int code;
    private final String message;

    ApiStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
