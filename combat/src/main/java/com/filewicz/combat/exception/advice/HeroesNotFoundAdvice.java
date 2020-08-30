package com.filewicz.combat.exception.advice;

import com.filewicz.combat.exception.HeroesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HeroesNotFoundAdvice {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String heroesNotFoundHandler(HeroesNotFoundException e){
        return e.getMessage();
    }

}
