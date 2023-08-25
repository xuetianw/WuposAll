package com.wupos.app.service;

import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> getCustomerDetails(GetCustomerDetailsRequest request);
}
