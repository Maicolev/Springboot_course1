package com.bagofideas.springboot.form.app.validation;

import com.bagofideas.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidate implements Validator
{

    @Override
    public boolean supports(Class<?> clazz)
    {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        User user = (User) target;

        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.user.name");

        if(!user.getId().matches("[0-9]{2}[.][\\\\d]{3}[.][\\\\d]{3}[-][A-Z]{1}"))
        {
            errors.rejectValue("id", "Pattern.user.id");
        }
    }
}
