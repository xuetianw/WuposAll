package com.wupos.compliance.exception;

public class OverMonthlyTransactionsLimitException extends RuntimeException{
    public OverMonthlyTransactionsLimitException(String message){
        super(message);
    }
}
