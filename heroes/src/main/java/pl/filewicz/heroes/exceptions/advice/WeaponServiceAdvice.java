package pl.filewicz.heroes.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filewicz.heroes.exceptions.WeaponNotFoundException;
import pl.filewicz.heroes.exceptions.WeaponServiceException;

@RestControllerAdvice
public class WeaponServiceAdvice {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    public String weaponServiceHandler(WeaponServiceException e){
        return e.getMessage();
    }

}