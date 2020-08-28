package com.filewicz.creature.exceptions;

public class CreatureNotFoundException extends RuntimeException {

    public CreatureNotFoundException(String message) {
        super("Creature with given name " + message + " not found!" );
    }
}
