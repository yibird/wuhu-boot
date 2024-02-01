package com.fly.common.convert;

/**
 * @Description 基础转换类, 提供了常用model转换
 * @Author zchengfeng
 * @Author 2022/12/6 16:13
 */
public interface BaseConvert<S, T> {
    S toSource(T target);

    T toTarget(S source);
}
