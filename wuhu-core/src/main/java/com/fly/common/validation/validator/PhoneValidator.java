package com.fly.common.validation.validator;

import cn.hutool.core.lang.Validator;
import com.fly.common.validation.annotation.Phone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Description 手机号验证器
 * @Author zchengfeng
 * @Date 2023/3/14 11:31
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private String value;
    private String message;

    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        context.buildConstraintViolationWithTemplate(this.value);
        return Validator.isMobile(value);
    }
}
