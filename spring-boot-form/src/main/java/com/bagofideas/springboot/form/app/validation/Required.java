package com.bagofideas.springboot.form.app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = RequiredValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface Required
{
    String message() default "The field is required - with annotation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
