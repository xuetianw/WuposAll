package com.wupos.app.service;

import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.UCDParsingModel.Customer;

import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> getCustomerDetails(GetCustomerDetailsRequest request);
    ResponseEntity<?> addCustomer(Customer user);
    ResponseEntity<?> updateCustomer(Customer user);
}
