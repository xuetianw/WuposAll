package com.wupos.app.MoneySendingControllerExceptionHandler;

import com.wupos.app.customeException.BlazeException;
import com.wupos.app.customeException.BlazeRespondException;
import com.wupos.app.model.sendmoneyValidation.blaze.returning.CustomRespond;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class MoneySendingExceptionHandler {
    @Value("${internalErrorCode}")
    private String internalErrorCode;

    @ExceptionHandler
    private ResponseEntity<?> responseEntity(BlazeRespondException e) {
        String[] mgs = e.getMessage().split(",");
        return ResponseEntity.ok(CustomRespond.builder().code(mgs[0]).message(mgs[1]).build());
    }
    @ExceptionHandler
    private ResponseEntity<?> responseEntity(Exception e) {
        return ResponseEntity.ok(CustomRespond.builder().code(internalErrorCode).message(e.getMessage()).build());
    }

}
