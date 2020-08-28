package pl.filewicz.heroes.exceptions;

public class HeroesNotFoundException extends RuntimeException {
    public HeroesNotFoundException(String message) {
        super("Heroes with name " + message + " not found");
     }
}
