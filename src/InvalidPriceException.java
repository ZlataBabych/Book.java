/**
 * Клас, що реалізує виняток для некоректно введеної ціни

 */
public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException(String message) {
        super(message);
    }
}
