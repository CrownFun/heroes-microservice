package pl.filewicz.heroes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CreatureNotFoundAdvice {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String creatureNotFoundHandler(CreatureNotFoundException e) {
        return e.getMessage();
    }
}
