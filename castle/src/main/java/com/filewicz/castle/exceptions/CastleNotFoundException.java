package com.filewicz.castle.exceptions;

public class CastleNotFoundException extends RuntimeException {
    public CastleNotFoundException(String message) {
        super("Castle with name " + message +" +  not found ");
    }
}
