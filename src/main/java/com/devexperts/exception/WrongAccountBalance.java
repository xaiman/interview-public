package com.devexperts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WrongAccountBalance extends RuntimeException {
    public WrongAccountBalance(String message) {
        super(message);
    }
}
