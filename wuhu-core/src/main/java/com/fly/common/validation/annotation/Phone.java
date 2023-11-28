package com.fly.common.validation.annotation;

import com.fly.common.validation.validator.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description 手机号验证注解
 * @Author zchengfeng
 * @Date 2023/3/14 11:27
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
@Repeatable(Phone.List.class)
public @interface Phone {
    @AliasFor("value")
    String message() default "手机号格式错误";

    // 验证分组
    Class<?>[] groups() default { };

    // 验证载荷
    Class<? extends Payload>[] payload() default { };

    @AliasFor("message")
    String value() default "手机号格式错误";

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Phone[] value();
    }
}
