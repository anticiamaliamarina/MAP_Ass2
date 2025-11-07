package exceptions;

public class NotMatchException extends RuntimeException {
    public NotMatchException(String message) {
        super(message);
    }
}
