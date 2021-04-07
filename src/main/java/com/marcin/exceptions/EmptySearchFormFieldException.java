package com.marcin.exceptions;

public class EmptySearchFormFieldException extends RuntimeException {

    public EmptySearchFormFieldException(String message) {
        super(message);
    }
}
