package com.system.blaze.controller;

import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.impl.BlazeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlazeController {

    private BlazeServiceImpl blazeService;

    @Autowired
    public BlazeController(BlazeServiceImpl blazeService) {
        this.blazeService = blazeService;
    }

    @PostMapping(path = "/transactionRiskDecision")
    public ResponseEntity<?> getRisk(@RequestBody RiskRequest riskRequest) {
        return blazeService.checkRisk(riskRequest);
    }

    @PostMapping( "/sendMoneyValidation")
    public ResponseEntity<?> getRisk2(@RequestBody RiskRequest riskRequest) {
        System.out.println(riskRequest);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
