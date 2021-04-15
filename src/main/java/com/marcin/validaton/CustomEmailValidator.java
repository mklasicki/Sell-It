package com.marcin.validaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.marcin.service.UserService;

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
