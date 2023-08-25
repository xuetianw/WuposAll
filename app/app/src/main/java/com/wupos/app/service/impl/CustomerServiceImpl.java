package com.wupos.app.service.impl;

import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.returningParcingModel.User;
import com.wupos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    WebClient.Builder webClient;

    //TODO return error code + message in response body
    public ResponseEntity<?> getCustomerDetails(GetCustomerDetailsRequest request) {
        String pcp = request.getPCP();
        if (!isValidPCP(pcp)) {
            return new ResponseEntity<>("Invalid PCP ID", HttpStatus.BAD_REQUEST);
        }

        try {
            User returnedData = webClient.build()
                    .get()
                    .uri("http://localhost:8081/getUser/{pcp}", pcp.substring(3))
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();
            return new ResponseEntity<>(returnedData, HttpStatus.OK);
        } catch (WebClientResponseException e) {
            return new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    private boolean isValidPCP(String pcp) {
        if (pcp.length() < 4) {
            return false;
        }
        if (!pcp.substring(0,3).equalsIgnoreCase("ABB")) {
            return false;
        }
        try {
            Long.parseLong(pcp.substring(3));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
