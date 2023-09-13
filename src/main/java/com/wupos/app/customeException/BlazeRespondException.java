package com.wupos.app.customeException;

public class BlazeRespondException extends RuntimeException{
    public BlazeRespondException(String message) {
        super(message);
    }

    public BlazeRespondException(String code, String message) {
        super(code + "," + message);
    }

}
