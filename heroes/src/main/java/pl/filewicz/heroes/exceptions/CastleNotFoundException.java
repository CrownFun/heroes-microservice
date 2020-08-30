package pl.filewicz.heroes.exceptions;

public class CastleNotFoundException extends RuntimeException {
    public CastleNotFoundException(String message) {
        super("Castle with name " + message +" +  not found ");
    }
}
