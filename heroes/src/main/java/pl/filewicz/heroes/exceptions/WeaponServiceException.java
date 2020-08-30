package pl.filewicz.heroes.exceptions;

public class WeaponServiceException extends RuntimeException {
    public WeaponServiceException(int message) {
        super("Bład zapytania " +message);
    }
}
