/**
 * Клас, що реалізує виняток, який виникає при некоректному розмірі файлу.

 */
public class InvalidFileSizeException extends IllegalArgumentException {
    public InvalidFileSizeException(String message) {
        super(message);
    }
}
