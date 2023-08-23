package com.wupos.app.controller;

import com.wupos.app.parsingModel.Customer;
import com.wupos.app.parsingModel.GetCustomerDetailsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping(path = "/getCustomerDetails")
    public ResponseEntity<?> getCustomerDetails(@RequestBody GetCustomerDetailsRequest request) {
        //TODO Call UCD /getUser endpoint
         return new ResponseEntity<>(new Customer(), HttpStatus.OK);
    }

}
