package com.fly.common.exception;


/**
 * @Description:服务异常类
 * @Author: zchengfeng
 * @Date: 2023-02-15 23:20:43
 */
public class ServerException extends RuntimeException {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ServerException() {

    }

    public ServerException(String message) {
        super(message);
        this.code = ResultStatus.ERROR.getCode();
        this.message = message;
    }

    public ServerException(ResultStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public ServerException(String message, Throwable t) {
        super(message, t);
        this.code = ResultStatus.ERROR.getCode();
        this.message = message;
    }
}
