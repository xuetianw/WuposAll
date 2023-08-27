package com.wupos.compliance.exception;

public class OverMonthlyAmountLimitException extends RuntimeException {
    public OverMonthlyAmountLimitException(String message){
        super(message);
    }
}
