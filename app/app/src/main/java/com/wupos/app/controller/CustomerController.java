package com.wupos.app.controller;

import com.wupos.app.model.returningParcingModel.User;
import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/getCustomerDetails")
    public ResponseEntity<?> getCustomerDetails(@RequestBody GetCustomerDetailsRequest request) {
        return customerService.getCustomerDetails(request);
    }

}
