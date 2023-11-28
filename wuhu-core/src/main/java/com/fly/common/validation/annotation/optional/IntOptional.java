package com.fly.common.validation.annotation.optional;

import com.fly.common.validation.validator.IdCardValidator;
import com.fly.common.validation.validator.optional.IntOptionalValidator;
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
 * @Description int类型可选值验证注解
 * @Author zchengfeng
 * @Date 2023/11/16 11:38
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = IntOptionalValidator.class)
@Documented
@Repeatable(IntOptional.List.class)
public @interface IntOptional {
    int[] value() default {};

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        IntOptional[] value();
    }
}
