package com.marcin.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.marcin.service.UserService;
import com.marcin.util.UniqueEmail;

public class CustomEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    public CustomEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && userService.isEmailTaken(value);
    }
}
