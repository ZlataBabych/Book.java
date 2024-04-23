/**
 * Клас, що описує виняток, який виникає при невірному форматі файлу
 */
public class InvalidSubjectException extends IllegalArgumentException {
    public InvalidSubjectException(String message) {
        super(message);
    }
}
