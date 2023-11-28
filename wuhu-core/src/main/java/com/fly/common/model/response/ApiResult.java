package com.fly.common.model.response;

import com.mybatisflex.core.paginate.Page;
import com.fly.common.exception.ApiStatus;
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
public class ApiResult<T> {
    private T data;
    private int code;
    private String message;

    public static <T> ApiResult<T> ok() {
        return ApiResult.ok(null, ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage());
    }

    public static <T> ApiResult<T> ok(T data) {
        return ApiResult.ok(data, ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage());
    }

    public static <T> ApiResult<T> okWithMessage(String message) {
        return ApiResult.ok(null, ApiStatus.SUCCESS.getCode(), message);
    }

    public static <T> ApiResult<T> ok(ApiStatus status) {
        return ApiResult.ok(null, status.getCode(), status.getMessage());
    }

    public static <T> ApiResult<PageResult<T>> ok(Page<T> page) {
        return ApiResult.ok(PageResult.of(page), ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage());
    }

    public static <T> ApiResult<T> ok(T data, int code) {
        return ApiResult.ok(data, code, ApiStatus.SUCCESS.getMessage());
    }

    public static <T> ApiResult<T> ok(T data, String message) {
        return ApiResult.ok(data, ApiStatus.SUCCESS.getCode(), message);
    }

    public static <T> ApiResult<T> ok(int code, String message) {
        return ApiResult.ok(null, code, message);
    }

    public static <T> ApiResult<T> ok(T data, int code, String message) {
        return new ApiResult<T>().setData(data)
                .setCode(code)
                .setMessage(message);
    }

    public static <T> ApiResult<T> error() {
        return ApiResult.error(ApiStatus.ERROR);
    }

    public static <T> ApiResult<T> error(String message) {
        return ApiResult.error(null, ApiStatus.ERROR.getCode(), message);
    }

    public static <T> ApiResult<T> error(ApiStatus status) {
        return ApiResult.error(null, status.getCode(), status.getMessage());
    }

    public static <T> ApiResult<T> error(T data, int code) {
        return ApiResult.error(data, code, ApiStatus.ERROR.getMessage());
    }

    public static <T> ApiResult<T> error(int code, String message) {
        return ApiResult.error(null, code, message);
    }

    public static <T> ApiResult<T> error(T data, int code, String message) {
        return new ApiResult<T>().setData(data)
                .setCode(code)
                .setMessage(message);
    }

    public static <T> ApiResult<T> of(boolean b, String m1, String m2) {
        int code = b ? ApiStatus.SUCCESS.getCode() : ApiStatus.ERROR.getCode();
        return ApiResult.ok(code, b ? m1 : m2);
    }

    public static <T> ApiResult<T> save(boolean bool) {
        return ApiResult.ok(bool ? ApiStatus.ADD_SUCCESS : ApiStatus.ADD_ERROR);
    }

    public static <T> ApiResult<T> update(boolean bool) {
        return bool ? ApiResult.ok(ApiStatus.UPDATE_SUCCESS)
                : ApiResult.ok(ApiStatus.UPDATE_ERROR);
    }

    public static <T> ApiResult<T> del(boolean bool) {
        return bool ? ApiResult.ok(ApiStatus.DEL_SUCCESS)
                : ApiResult.ok(ApiStatus.DEL_ERROR);
    }

    public static <T> ApiResult<T> op(boolean bool) {
        return bool ? ApiResult.ok(ApiStatus.OP_SUCCESS)
                : ApiResult.ok(ApiStatus.OP_ERROR);
    }
}
