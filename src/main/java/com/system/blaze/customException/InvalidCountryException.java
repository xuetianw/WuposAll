package com.system.blaze.customException;

public class InvalidCountryException extends RuntimeException {

    public InvalidCountryException() {
    }

    public InvalidCountryException(String message) {
        super(message);
    }
}
