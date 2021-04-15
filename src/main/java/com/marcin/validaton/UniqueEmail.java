package com.marcin.validaton;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = CustomEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueEmail {

    public String message() default "There is already user with this email";

    public Class<?>[] groups() default{};

    public Class<? extends Payload>[] payload() default{};

}

