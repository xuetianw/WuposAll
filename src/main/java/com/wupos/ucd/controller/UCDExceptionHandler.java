package com.wupos.ucd.controller;

import com.wupos.ucd.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UCDExceptionHandler {

    @ExceptionHandler(MissingNameException.class)
    public ResponseEntity<CustomResponse.ErrorResponse> handleMissingFirstNameException(MissingNameException e) {
        return new ResponseEntity<>(new CustomResponse.ErrorResponse(9001, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingPhoneNumberException.class)
    public ResponseEntity<CustomResponse.ErrorResponse> handleMissingPhoneNumberException(MissingPhoneNumberException e) {
        return new ResponseEntity<>(new CustomResponse.ErrorResponse(9002, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingAddressException.class)
    public ResponseEntity<CustomResponse.ErrorResponse> handleMissingAddressException(MissingAddressException e) {
        return new ResponseEntity<>(new CustomResponse.ErrorResponse(9003, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingComplianceException.class)
    public ResponseEntity<CustomResponse.ErrorResponse> handleMissingComplianceException(MissingComplianceException e) {
        return new ResponseEntity<>(new CustomResponse.ErrorResponse(9004, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPcpException.class)
    public ResponseEntity<CustomResponse.ErrorResponse> handleInvalidPcpException(InvalidPcpException e) {
        return new ResponseEntity<>(new CustomResponse.ErrorResponse(9005, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
