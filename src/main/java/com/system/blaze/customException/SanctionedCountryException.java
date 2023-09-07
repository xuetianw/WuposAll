package com.system.blaze.customException;

public class SanctionedCountryException extends RuntimeException{

    public SanctionedCountryException() {
    }

    public SanctionedCountryException(String message) {
        super(message);
    }
}
