package com.wupos.app.getFeeExceptions;

import com.wupos.app.model.getFees.exceptionReturn.CustomRespond;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class MoneyAmountExceptionHandler {

    @Value("#{${feeExceptions}}")
    private Map<String, String> map;

    @ExceptionHandler
    private ResponseEntity<?> MoneyAmountException(MoneyAmountException e) {
        String[] arr = e.getClass().getName().split("\\.");
        return ResponseEntity.ok(CustomRespond.builder().message(e.getMessage()).code(map.get(arr[arr.length - 1])).build());
    }
}
