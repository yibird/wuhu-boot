package com.fly.common.annotation.security;

import java.lang.annotation.*;

/**
 * @Description 加密注解
 * @Author zchengfeng
 * @Date 2023/11/11 15:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Encrypt {
}
