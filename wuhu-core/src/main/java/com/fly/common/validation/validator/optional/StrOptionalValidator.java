package com.fly.common.validation.validator.optional;

import com.fly.common.validation.annotation.optional.StrOptional;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

/**
 * @Description String类型可选值验证器
 * @Author zchengfeng
 * @Date 2023/11/16 11:38
 */
public class StrOptionalValidator implements ConstraintValidator<StrOptional, String> {

    private String[] value;
    private String message;

    @Override
    public void initialize(StrOptional optional) {
        this.message = optional.message();
        this.value = optional.value();
        ConstraintValidator.super.initialize(optional);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        context.buildConstraintViolationWithTemplate(this.message);
        return Arrays.stream(this.value).toList().contains(value);
    }
}
