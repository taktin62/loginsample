package com.example.demo.domain;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }

    UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    UserNotFoundException(Throwable cause) {
        super(cause);
    }

    UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
