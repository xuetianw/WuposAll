package com.system.blaze.customException;

public class AmountException extends RuntimeException{

    public AmountException() {
    }

    public AmountException(String message) {
        super(message);
    }
}
