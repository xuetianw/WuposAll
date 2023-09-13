package com.wupos.app.controller;

import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.parsingModel.Name;
import com.wupos.app.model.parsingModel.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @Test
    void when_pcp_in_db_then_getCustomerDetails_returns_OK() {
        GetCustomerDetailsRequest gcdRequest = new GetCustomerDetailsRequest(new Name(), new Phone(), "1");
        assertDoesNotThrow(() -> customerController.getCustomerDetails(gcdRequest));

        ResponseEntity<?> response = customerController.getCustomerDetails(gcdRequest);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void when_pcp_not_in_db_then_getCustomerDetails_returns_NOT_FOUND() {
        GetCustomerDetailsRequest gcdRequest = new GetCustomerDetailsRequest(new Name(), new Phone(), "2");
        assertDoesNotThrow(() -> customerController.getCustomerDetails(gcdRequest));

        ResponseEntity<?> response = customerController.getCustomerDetails(gcdRequest);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void when_invalid_pcp_then_getCustomerDetails_returns_BAD_REQUEST() {
        GetCustomerDetailsRequest gcdRequest = new GetCustomerDetailsRequest(new Name(), new Phone(), "A");
        assertDoesNotThrow(() -> customerController.getCustomerDetails(gcdRequest));

        ResponseEntity<?> response = customerController.getCustomerDetails(gcdRequest);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
