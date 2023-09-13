package com.wupos.app.service.impl;

import com.wupos.app.customeException.BlazeException;
import com.wupos.app.customeException.BlazeRespondException;
import com.wupos.app.customeException.RtraException;
import com.wupos.app.model.sendmoneyValidation.blaze.returning.CustomRespond;
import com.wupos.app.model.sendmoneyValidation.blaze.sendingrequest.RiskRequest;
import com.wupos.app.service.MoneySendingService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;


@Service
public class MoneySendingServiceImpl implements MoneySendingService {

    @Value("#{${BlazeErrorCodes}}")
    private Map<String, String> map;

    @Value("${successCode}")
    private String successCode;

    @Autowired
    WebClient.Builder webclient;

    @Override
    public void checkRisk(RiskRequest riskRequest) {
//        try {
            CustomRespond customRespond = webclient.build()
                    .post()
                    .uri("http://localhost:8082/transactionRiskDecision")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(riskRequest))
                    .retrieve()
                    .bodyToMono(CustomRespond.class)
                    .block();
            if (!customRespond.getCode().equals(successCode)) {
                throw new BlazeRespondException(map.get(customRespond.getCode()), customRespond.getMessage());
            }
//        } catch (Exception e) {
//            throw new BlazeException(e.getMessage());
//        }
    }

    @PostConstruct
    void func() {
        if (map == null) return;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + "value " + entry.getValue());
        }
    }

    @Override
    public String checkCompliance(RiskRequest transaction) {
        try {
            CustomRespond customRespond = webclient.build()
                    .post()
                    .uri("http://localhost:8083/sendMoney")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(transaction))
                    .retrieve()
                    .bodyToMono(CustomRespond.class)
                    .block();
            if (!customRespond.getCode().equals(successCode)) {
                throw new RtraException(map.get(customRespond.getCode()), customRespond.getMessage());
            }
            return customRespond.getMessage();
        } catch (Exception e) {
            throw new RtraException(e.getMessage());
        }
    }
}
