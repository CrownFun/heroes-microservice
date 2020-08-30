package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.CreatureNotFoundException;
import pl.filewicz.heroes.exceptions.CreatureServiceException;

@RestControllerAdvice
public class CreatureNotFoundAdvice {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String creatureNotFoundHandler(CreatureServiceException e) {
        return e.getMessage();
    }
}
