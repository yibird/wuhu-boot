package com.fly.common.exception;

/**
 * @Description: 响应状态码枚举类
 * @Author: zchengfeng
 * @Date: 2023-02-15 23:17:46
 */
public enum ResultStatus {
    // 响应成功
    SUCCESS(200, "响应成功"),
    ERROR(500, "服务器错误"),
    // 访问令牌非法
    INVALID_TOKEN(2001, "Illegal access token"),
    // 没有权限访问资源
    ACCESS_DENIED(2003, "No permission to access this resource"),
    // 客户端认证失败
    CLIENT_AUTHENTICATION_FAILED(1001, "Client authentication failed"),
    // 用户或密码错误
    USERNAME_OR_PASSWORD_ERROR(1002, "User name or password error");

    private final int code;
    private final String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
