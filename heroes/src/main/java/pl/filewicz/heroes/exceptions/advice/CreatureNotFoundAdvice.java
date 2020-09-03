package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.CreatureNotFoundException;

@RestControllerAdvice
public class CreatureNotFoundAdvice {

    @ExceptionHandler(CreatureNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String creatureNotFoundHandler(CreatureNotFoundException e) {
        return e.getMessage();
    }
}
