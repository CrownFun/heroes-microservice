package pl.filewicz.heroes.exceptions;

public class CastleServiceException extends RuntimeException {
    public CastleServiceException(int message) {
        super("Nieprawidłowe żądanie - kod błędu" +message);
    }
}
