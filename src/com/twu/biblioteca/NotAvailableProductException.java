package com.twu.biblioteca;

public class NotAvailableProductException extends Exception {
    public NotAvailableProductException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
