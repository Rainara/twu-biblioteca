package com.twu.biblioteca;

public class InvalidProductCodeException extends Exception{

    public InvalidProductCodeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
