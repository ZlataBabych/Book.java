/**
 * Клас, що відповідає за обробку помилок, пов'язаних з некоректним введенням числа

 */
public class InvalidNumberFormatException extends IllegalArgumentException {
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}