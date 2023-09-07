package com.system.blaze.service.impl;

import com.system.blaze.customRespond.CustomRespond;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlazeServiceImpl implements BlazeService {

    private MoneyLaunderingService moneyLaunderingService;
    private AmountService amountService;
    private BlackListCheckService blackListCheckService;
    private CountryService countryService;

    @Value("${successCode}")
    private String successCode;

    @Value("${successMessage}")
    private String successMessage;

    @Autowired
    public BlazeServiceImpl(MoneyLaunderingService moneyLaunderingService,
                            AmountService amountService,
                            BlackListCheckService blackListCheckService,
                            CountryService countryService) {
        this.moneyLaunderingService = moneyLaunderingService;
        this.amountService = amountService;
        this.blackListCheckService = blackListCheckService;
        this.countryService = countryService;
    }

    public ResponseEntity<?> checkRisk(RiskRequest riskRequest) {
        blackListCheckService.checkBlackedList(riskRequest);
        moneyLaunderingService.check(riskRequest);
        amountService.checkAmount(riskRequest.getPaymentDetails());
        countryService.check(riskRequest);

        return ResponseEntity.ok(CustomRespond.builder().message(successMessage).code(successCode).build());
    }
}
