package com.system.blaze.customException;

public class MoneyLaunderingException extends RuntimeException {

    public MoneyLaunderingException() {
    }

    public MoneyLaunderingException(String message) {
        super(message);
    }
}
