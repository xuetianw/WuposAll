package com.wupos.app.service.impl;

import com.wupos.app.customeException.BlazeException;
import com.wupos.app.model.sendmoneyValidation.blaze.returning.CustomRespond;
import com.wupos.app.model.sendmoneyValidation.blaze.sendingrequest.Customer;
import com.wupos.app.model.sendmoneyValidation.blaze.sendingrequest.RiskRequest;
import com.wupos.app.service.MoneySendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class MoneySendingServiceImpl implements MoneySendingService {

    @Autowired
    WebClient.Builder webclient;

    @Override
    public void checkRisk(RiskRequest riskRequest) {
        CustomRespond customRespond = webclient.build()
                .post()
                .uri("http://localhost:8082/transactionRiskDecision")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(riskRequest))
                .retrieve()
                .bodyToMono(CustomRespond.class)
                .block();
        if (!customRespond.getCode().equals("0000")) {
            throw new BlazeException("error");
        }
//        return null;
    }
}
