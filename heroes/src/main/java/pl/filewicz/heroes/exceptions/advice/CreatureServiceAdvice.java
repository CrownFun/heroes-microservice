package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.CreatureServiceException;

@RestControllerAdvice
public class CreatureServiceAdvice {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    public String creatureServiceHandler(CreatureServiceException e) {
        return e.getMessage();
    }
}
