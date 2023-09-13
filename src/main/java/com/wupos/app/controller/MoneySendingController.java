package com.wupos.app.controller;

import com.wupos.app.model.sendmoneyValidation.blaze.returning.CustomRespond;
import com.wupos.app.model.sendmoneyValidation.blaze.sendingrequest.RiskRequest;
import com.wupos.app.service.MoneySendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneySendingController {

    MoneySendingService moneySendingService;

    @Autowired
    public MoneySendingController(MoneySendingService moneySendingService) {
        this.moneySendingService = moneySendingService;
    }

    @PostMapping("/sendMoneyValidation")
    public ResponseEntity<?> updateCustomer(@RequestBody RiskRequest riskRequest) {
        moneySendingService.checkRisk(riskRequest);
        String mtcn = moneySendingService.checkCompliance(riskRequest);
        return new ResponseEntity<>(new CustomRespond(mtcn, "Transaction Success"), HttpStatus.OK);    }

}
