package com.wupos.app.service;

import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.returningParcingModel.User;

import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> getCustomerDetails(GetCustomerDetailsRequest request);
    ResponseEntity<?> addCustomer(User user);
    ResponseEntity<?> updateCustomer(User user);

}
