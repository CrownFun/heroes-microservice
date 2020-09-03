package pl.filewicz.heroes.exceptions;

public class WeaponNotFoundException extends RuntimeException{

    public WeaponNotFoundException(String message) {
        super("heroes module - Weapon with name " + message + " not found!");
    }
}
