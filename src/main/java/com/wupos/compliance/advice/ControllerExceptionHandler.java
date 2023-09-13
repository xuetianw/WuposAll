package com.wupos.compliance.advice;

import com.wupos.compliance.exception.OverAmountLimitException;
import com.wupos.compliance.exception.OverMonthlyAmountLimitException;
import com.wupos.compliance.exception.OverMonthlyTransactionsLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(OverAmountLimitException.class)
    public ResponseEntity<CustomResponse> handleOverAmountLimitException(OverAmountLimitException e) {
        return new ResponseEntity<>(new CustomResponse("101", e.getMessage()), HttpStatus.OK);

    }

    @ExceptionHandler(OverMonthlyAmountLimitException.class)
    public ResponseEntity<CustomResponse> handleOverMonthlyAmountLimitException(OverMonthlyAmountLimitException e) {
        return new ResponseEntity<>(new CustomResponse("102", e.getMessage()), HttpStatus.OK);

    }

    @ExceptionHandler(OverMonthlyTransactionsLimitException.class)
    public ResponseEntity<CustomResponse> handleOverMonthlyTransactionsLimitException(
            OverMonthlyTransactionsLimitException e) {
        return new ResponseEntity<>(new CustomResponse("103", e.getMessage()), HttpStatus.OK);

    }
}
