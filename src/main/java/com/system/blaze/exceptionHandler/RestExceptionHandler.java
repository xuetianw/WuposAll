package com.system.blaze.exceptionHandler;

import com.system.blaze.customException.AmountException;
import com.system.blaze.customException.BlacklistException;
import com.system.blaze.customException.MoneyLaunderingException;
import com.system.blaze.customException.SanctionedCountryException;
import com.system.blaze.customRespond.CustomRespond;
import com.system.blaze.customException.*;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
@ConfigurationProperties("")
@Data
@Slf4j
public class RestExceptionHandler {

//    @Value("#{${errorcode}}")
    private HashMap<String, String> error_map;


    @PostConstruct
    void func() {
        error_map.forEach((k, y) -> log.debug("key " + k + " val " + y) );
        log.debug("" + error_map.size());
    }



    @ExceptionHandler
    public ResponseEntity<CustomRespond> respondResponseEntity(BlacklistException e) {
        CustomRespond customRespond =
                CustomRespond.builder().code(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customRespond, HttpStatus.OK);

    }


    @ExceptionHandler
    public ResponseEntity<CustomRespond> respondResponseEntity(MoneyLaunderingException e) {
        CustomRespond customRespond =
                CustomRespond.builder().code(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customRespond, HttpStatus.OK);
    }


    @ExceptionHandler
    public ResponseEntity<CustomRespond> respondResponseEntity(AmountException e) {
        CustomRespond customRespond =
                CustomRespond.builder().code(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customRespond, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<CustomRespond> respondResponseEntity(SanctionedCountryException e) {
        CustomRespond customRespond =
                CustomRespond.builder().code(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customRespond, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<CustomRespond> respondResponseEntity(InvalidCountryException e) {
        CustomRespond customErrorRespond =
                CustomRespond.builder().code(error_map.get(e.getClass().getName())).message(e.getMessage()).build();
        return new ResponseEntity<>(customErrorRespond, HttpStatus.OK);
    }
}
