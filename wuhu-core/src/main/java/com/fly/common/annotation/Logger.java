package com.fly.common.annotation;

import java.lang.annotation.*;

/**
 * @Description Logger
 * @Author zchengfeng
 * @Date 2023/3/14 10:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Logger {
}
