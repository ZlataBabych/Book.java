/**
 * Клас, що реалізує виняток, який виникає при некоректному введенні кількості сторінок

 */
public class InvalidPageCountException extends IllegalArgumentException {
    public InvalidPageCountException(String message) {
        super(message);
    }
}
