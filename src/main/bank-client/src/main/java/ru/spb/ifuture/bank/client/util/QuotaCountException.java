package ru.spb.ifuture.bank.client.util;

public class QuotaCountException extends Exception {
    public QuotaCountException() {
        super();
    }

    public QuotaCountException(String message) {
        super(message);
    }

    public QuotaCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuotaCountException(Throwable cause) {
        super(cause);
    }
}
