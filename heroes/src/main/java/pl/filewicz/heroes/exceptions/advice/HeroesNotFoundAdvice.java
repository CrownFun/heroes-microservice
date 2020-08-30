package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.HeroesNotFoundException;

@RestControllerAdvice
public class HeroesNotFoundAdvice {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String heroesNotFoundHandler(HeroesNotFoundException e){
        return e.getMessage();
    }

}
