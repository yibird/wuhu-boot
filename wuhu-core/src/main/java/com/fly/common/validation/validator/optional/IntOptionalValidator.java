package com.fly.common.validation.validator.optional;

import com.fly.common.validation.annotation.optional.IntOptional;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

/**
 * @Description int类型可选值验证器
 * @Author zchengfeng
 * @Date 2023/11/16 11:38
 */
public class IntOptionalValidator implements ConstraintValidator<IntOptional, Integer> {

    private int[] value;
    private String message;

    @Override
    public void initialize(IntOptional optional) {
        this.message = optional.message();
        this.value = optional.value();
        ConstraintValidator.super.initialize(optional);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(this.message);
        return Arrays.stream(this.value).boxed().toList()
                .contains(value);
    }
}
