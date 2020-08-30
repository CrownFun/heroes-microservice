package pl.filewicz.heroes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WeaponNotFoundAdvice {

    @ExceptionHandler(WeaponNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String weaponNotFoundHandler(WeaponNotFoundException e){
        return e.getMessage();
    }

}