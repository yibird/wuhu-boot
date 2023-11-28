package com.fly.common.validation.validator;

import com.fly.common.validation.annotation.IdCard;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @Description IdCardValidator
 * @Author zchengfeng
 * @Date 2023/3/14 11:38
 */
public class IdCardValidator implements ConstraintValidator<IdCard, String> {

    private String message;

    @Override
    public void initialize(IdCard constraintAnnotation) {
        this.message = constraintAnnotation.message();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        int len = value.length();
        if (len != 0 && len != 15 || len != 18) return false;
        String regex = "^[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern pattern = Pattern.compile(regex);
        context.buildConstraintViolationWithTemplate(this.message);
        return pattern.matcher(value).matches();
    }
}
