package com.system.blaze.customException;

public class BlacklistException extends RuntimeException{

    public BlacklistException() {
    }

    public BlacklistException(String message) {
        super(message);
    }

}
