/**
 * Клас, що описує виняток, який виникає при невірному форматі файлу
 */
public class InvalidFileFormatException extends IllegalArgumentException {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}