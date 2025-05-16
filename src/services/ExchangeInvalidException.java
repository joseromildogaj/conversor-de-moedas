package services;

public class ExchangeInvalidException extends RuntimeException {
    public ExchangeInvalidException(String message) {
        super(message);
    }
}
