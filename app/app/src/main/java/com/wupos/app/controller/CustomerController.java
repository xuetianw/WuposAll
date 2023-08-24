package com.wupos.app.controller;

import com.wupos.app.model.returningParcingModel.User;
import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
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
    WebClient.Builder webClient;

    @PostMapping(path = "/getCustomerDetails")
    public ResponseEntity<?> getCustomerDetails(@RequestBody GetCustomerDetailsRequest request) {
        //TODO Call UCD /getUser endpoint
        String pcp = request.getPCP();
        User returnedData = webClient.build()
                .get()
                .uri("http://localhost:8081/getUser/{pcp}", pcp)
                .retrieve()
                .bodyToMono(User.class)
                .block();
         return new ResponseEntity<>(returnedData, HttpStatus.OK);
    }

}
