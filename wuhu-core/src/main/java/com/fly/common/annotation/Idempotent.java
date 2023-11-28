package com.fly.common.annotation;

import java.lang.annotation.*;

/**
 * @Description 幂等性注解
 * @Author zchengfeng
 * @Date 2023/06/07 10:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Idempotent {
    /**
     * token值
     */
    String value() default "";
    /**
     * token过期时间,默认为60秒
     */
    long expireSeconds() default 30;

    /**
     * token前缀,默认为idempotent:
     */
    String prefix() default "idempotent:";
}
