/**
 * Клас, що описує виняток, який виникає при невірному введенні оцінки
 */
public class InvalidGradeException extends IllegalArgumentException {
    public InvalidGradeException(String message) {
        super(message);
    }
}
