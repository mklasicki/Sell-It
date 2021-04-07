package com.marcin.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DuplicatedDataException.class)
    public String handleDoubleDataException(HttpServletRequest request, Exception e) {
        log.info(request.getRequestURL() + " caused " + e);

        return "redirect:/user/register";
    }

    @ExceptionHandler(EmptySearchFormFieldException.class)
    public String handleEmptySearchFormException(HttpServletRequest request, Exception e) {
        log.info(request.getRequestURL() + " caused " + e);

        return "redirect:/main";
    }

}
