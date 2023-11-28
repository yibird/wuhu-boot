package com.fly.common.assertion;

import com.fly.common.exception.ApiStatus;
import com.fly.common.exception.ServerException;

/**
 * @Description 业务断言类
 * @Author zchengfeng
 * @Date 2023/3/14 10:35
 */
public class BizAssert {
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ServerException(message);
        }
    }
    public static void isTrue(boolean expression, ApiStatus status){
        if (!expression) {
            throw new ServerException(status);
        }
    }
}
