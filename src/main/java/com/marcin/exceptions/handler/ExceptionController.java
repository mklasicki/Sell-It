package com.marcin.exceptions.handler;

import com.marcin.dto.ExceptionResponse;
import com.marcin.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(annotations = Controller.class)
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest request, UserNotFoundException exc) {

        ExceptionResponse error = new ExceptionResponse();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


}
