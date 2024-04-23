/**
 * Клас, що реалізує виняток для некоректного автора
 */
public class InvalidAuthorException extends IllegalArgumentException {
    public InvalidAuthorException(String message) {
        super(message);
    }
}
