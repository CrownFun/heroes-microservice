package pl.filewicz.heroes.exceptions;

public class CreatureServiceException extends RuntimeException {
    public CreatureServiceException(int message) {
        super("Nieprawidłowe żądanie - kod błędu" +message);
    }
}
