package com.wupos.app.advices;

import com.wupos.app.exceptions.AgentNotFoundException;
import com.wupos.app.exceptions.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AgentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAgentNotFoundException(AgentNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(101, e.getMessage()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorResponse> handleWrongPasswordException(WrongPasswordException e) {
        return new ResponseEntity<>(new ErrorResponse(102, e.getMessage()), HttpStatus.UNAUTHORIZED);

    }
}
