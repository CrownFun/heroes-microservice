package com.filewicz.castle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CastleNotFoundAdvice {

    @ExceptionHandler(CastleNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String castleNotFoundHandler(CastleNotFoundException e) {
        return e.getMessage();
    }
}
