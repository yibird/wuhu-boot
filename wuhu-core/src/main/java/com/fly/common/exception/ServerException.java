package com.fly.common.exception;

import lombok.Getter;

/**
 * @Description:服务异常类
 * @Author: zchengfeng
 * @Date: 2023-02-15 23:20:43
 */
@Getter
public class ServerException extends RuntimeException {
    private int code;
    private String message;

    public ServerException() {
    }

    public ServerException(String message) {
        super(message);
        this.code = ApiStatus.ERROR.getCode();
        this.message = message;
    }

    public ServerException(ApiStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public ServerException(String message, Throwable t) {
        super(message, t);
        this.code = ApiStatus.ERROR.getCode();
        this.message = message;
    }
}
