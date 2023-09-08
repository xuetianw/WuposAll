package com.wupos.app.service.impl;

import com.wupos.app.exceptions.AgentNotFoundException;
import com.wupos.app.exceptions.WrongPasswordException;
import com.wupos.app.model.agent.AgentCredentials;
import com.wupos.app.model.agent.AgentDetails;
import com.wupos.app.model.customerResponse.AddCustomer;
import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.returningParcingModel.User;
import com.wupos.app.repository.AgentCredentialsRepository;
import com.wupos.app.repository.AgentDetailsRepository;
import com.wupos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public ResponseEntity<?> addCustomer(User user) {
        try {
            AddCustomer response = webClient.build()
                .post()
                .uri("http://localhost:8081/addUser")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .bodyToMono(AddCustomer.class)
                .block();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>("Failure: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateCustomer(User user) {
        try {
            String response = webClient.build()
                .put()
                .uri("http://localhost:8081/addUser")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .bodyToMono(String.class)
                .block();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>("Failure: " + e.getMessage(), HttpStatus.BAD_REQUEST);
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
