package com.wupos.app.customeException;

public class RtraException extends RuntimeException{
    public RtraException(String message) {
        super(message);
    }

    public RtraException(String code, String message) {
        super(code + "," + message);
    }
}
