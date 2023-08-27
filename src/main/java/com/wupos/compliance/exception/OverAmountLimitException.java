package com.wupos.compliance.exception;

public class OverAmountLimitException extends RuntimeException{
    public  OverAmountLimitException(String message){
        super(message);
    }
}
