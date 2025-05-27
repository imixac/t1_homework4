package ru.t1.javapro.exceptions;

public class IntegrationException extends RuntimeException {

    private final String statusCode;

    public IntegrationException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
