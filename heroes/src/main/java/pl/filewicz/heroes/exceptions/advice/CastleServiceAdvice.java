package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.CastleServiceException;

@RestControllerAdvice
public class CastleServiceAdvice {

    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    @ExceptionHandler
    public String castleServiceHandler(CastleServiceException e) {
        return e.getMessage();
    }
}
