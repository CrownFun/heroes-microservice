package com.filewicz.weapon.exception;

public class WeaponNotFoundException extends RuntimeException{

    public WeaponNotFoundException(String message) {
        super("Weapon with name " + message + " not found!");
    }
}
