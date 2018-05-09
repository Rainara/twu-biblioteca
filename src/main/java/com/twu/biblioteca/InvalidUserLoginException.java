package com.twu.biblioteca;

public class InvalidUserLoginException extends Exception {
    public InvalidUserLoginException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
