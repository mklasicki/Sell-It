package com.marcin.validaton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CustomUsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueUsername {

    public String message() default "This username is already taken";

    public Class<?>[] groups() default{};

    public Class<? extends Payload>[] payload() default{};


}
