package com.wupos.app.controller;

import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.UCDParsingModel.Customer;
import com.wupos.app.model.UCDParsingModel.CustomerPayload;
import com.wupos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/getCustomerDetails")
    public ResponseEntity<?> getCustomerDetails(@RequestBody GetCustomerDetailsRequest request) {
        return customerService.getCustomerDetails(request);
    }

    @PostMapping(path = "/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerPayload request) {
        return customerService.addCustomer(request.getCustomer());
    }

    @PutMapping(path = "/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerPayload request) {
        return customerService.updateCustomer(request.getCustomer());
    }

}
