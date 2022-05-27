package com.bagofideas.springboot.form.app.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required,String>
{

    @Override
    public void initialize(Required constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        if(s== null || !StringUtils.hasText(s))
        //if(s== null || s.isEmpty() || s.isBlank())
        {
            return false;
        }
        return true;
    }
}
