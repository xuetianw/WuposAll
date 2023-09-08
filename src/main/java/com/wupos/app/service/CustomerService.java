package com.wupos.app.service;

import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.returningParcingModel.Customer;

import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> getCustomerDetails(GetCustomerDetailsRequest request);
    ResponseEntity<?> addCustomer(Customer user);
    ResponseEntity<?> updateCustomer(Customer user);
}
