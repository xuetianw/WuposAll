package com.system.blaze.service;

import com.system.blaze.parsingModel.RiskRequest;
import org.springframework.http.ResponseEntity;

public interface BlazeService {
    ResponseEntity<?> checkRisk(RiskRequest riskRequest);
}
