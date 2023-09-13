package com.wupos.app.service;


import com.wupos.app.model.sendmoneyValidation.blaze.sendingrequest.RiskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface MoneySendingService {
    void checkRisk(RiskRequest riskRequest);

    String checkCompliance(RiskRequest transaction);


}
