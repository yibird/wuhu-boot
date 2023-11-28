package com.fly.common.annotation;

import java.lang.annotation.*;

/**
 * @Description 限流注解
 * @Author zchengfeng
 * @Date 2023/11/07 10:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RateLimit {
    /**
     * 默认限流阈值,每秒最多100次请求
     */
    int value() default 100;
}
