package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.DuplicateHeroesException;

@RestControllerAdvice
public class DuplicateHeroesAdvice {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public String duplicateHeroesHandler(DuplicateHeroesException e) {
        return e.getMessage();
    }
}
