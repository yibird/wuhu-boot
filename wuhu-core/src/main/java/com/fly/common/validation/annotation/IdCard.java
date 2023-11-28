package com.fly.common.validation.annotation;

import com.fly.common.validation.validator.IdCardValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description 身份证验证注解
 * @Author zchengfeng
 * @Date 2023/3/14 11:37
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = IdCardValidator.class)
@Documented
@Repeatable(IdCard.List.class)
public @interface IdCard {

    String message() default "身份证格式错误";

    // 验证分组
    Class<?>[] groups() default {};

    // 验证载荷
    Class<? extends Payload>[] payload() default {};

    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        IdCard[] value();
    }
}
