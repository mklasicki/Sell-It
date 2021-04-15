package com.marcin.validaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.marcin.service.UserService;
import com.marcin.validaton.annotation.UniqueUsername;

public class CustomUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public CustomUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && userService.isUsernameTaken(value);
    }
}
