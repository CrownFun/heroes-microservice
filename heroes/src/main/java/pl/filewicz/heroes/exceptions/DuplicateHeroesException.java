package pl.filewicz.heroes.exceptions;

public class DuplicateHeroesException extends RuntimeException {

    public DuplicateHeroesException(String message) {
        super("Heroes with name " + message + " already exists! - use unique name");
    }

    public DuplicateHeroesException() {
    }
}
