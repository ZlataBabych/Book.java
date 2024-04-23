/**
 * Клас, що описує виняток, який виникає при невірному форматі файлу
 */
public class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String message) {
        super(message);
    }
}
