package com.fly.common.model;

import com.fly.common.exception.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: 通用响应对象
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> {

    private T data;
    private int code;
    private String message;
    private long timestamp;

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    public static <T> Result<T> ok() {
        return Result.ok(null, ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getMessage());
    }

    public static <T> Result<T> ok(T data) {
        return Result.ok(data, ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getMessage());
    }

    public static <T> Result<T> ok(String message) {
        return Result.ok(null, ResultStatus.SUCCESS.getCode(), message);
    }

    public static <T> Result<T> ok(ResultStatus status) {
        return Result.ok(null, status.getCode(), status.getMessage());
    }

    public static <T> Result<T> ok(T data, int code) {
        return Result.ok(data, code, ResultStatus.SUCCESS.getMessage());
    }

    public static <T> Result<T> ok(T data, String message) {
        return Result.ok(data, ResultStatus.SUCCESS.getCode(), message);
    }

    public static <T> Result<T> ok(int code, String message) {
        return Result.ok(null, code, message);
    }

    public static <T> Result ok(T data, int code, String message) {
        return new Result().setData(data)
                .setCode(code)
                .setMessage(message)
                .setTimestamp(Result.getCurrentTimestamp());
    }

    public static <T> Result<T> error() {
        return Result.error(ResultStatus.ERROR);
    }

    public static <T> Result<T> error(String message) {
        return Result.error(null, ResultStatus.ERROR.getCode(), message);
    }

    public static <T> Result<T> error(T data) {
        return Result.error(data, ResultStatus.ERROR.getCode());
    }

    public static <T> Result<T> error(ResultStatus status) {
        return Result.error(null, status.getCode(), status.getMessage());
    }


    public static <T> Result<T> error(T data, int code) {
        return Result.error(data, code, ResultStatus.ERROR.getMessage());
    }

    public static <T> Result<T> error(int code, String message) {
        return Result.error(null, code, message);
    }

    public static <T> Result<T> error(T data, int code, String message) {
        return new Result<T>().setData(data)
                .setCode(code)
                .setMessage(message)
                .setTimestamp(Result.getCurrentTimestamp());
    }
}
