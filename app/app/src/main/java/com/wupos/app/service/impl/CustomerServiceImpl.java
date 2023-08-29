package com.wupos.app.service.impl;

import com.wupos.app.customResponse.CustomResponse;
import com.wupos.app.customResponse.GetCustomerDetailsResponse;
import com.wupos.app.model.parsingModel.GetCustomerDetailsRequest;
import com.wupos.app.model.UCDParsingModel.User;
import com.wupos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Map;

@Service
//@ConfigurationProperties("")
public class CustomerServiceImpl implements CustomerService {

    @Value("#{${responseCodes}}")
    private Map<String, String> responseCodes;

    @Autowired
    WebClient.Builder webClient;

    public ResponseEntity<?> getCustomerDetails(GetCustomerDetailsRequest request) {
        String pcp = request.getPCP();
        if (!isValidPCP(pcp)) {
            CustomResponse response = new CustomResponse(responseCodes.get("invalidPCP"), "Invalid PCP");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            User customer = webClient.build()
                    .get()
                    .uri("http://localhost:8081/getUser/{pcp}", pcp)
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();
            return new ResponseEntity<>(GetCustomerDetailsResponse.builder().customer(customer).pcp(pcp).build(),
                    HttpStatus.OK);
        } catch (WebClientResponseException.NotFound e) {
            CustomResponse response =
                    new CustomResponse(responseCodes.get("userNotFound"), e.getResponseBodyAsString());
            return new ResponseEntity<>(response, e.getStatusCode());
        } catch (WebClientResponseException.BadRequest e) {
            CustomResponse response =
                    new CustomResponse(responseCodes.get("internalServerError"), e.getResponseBodyAsString());
            return new ResponseEntity<>(response, e.getStatusCode());
        }
    }

    private boolean isValidPCP(String pcp) {
//        if (pcp.length() < 4) {
//            return false;
//        }
//        if (!pcp.substring(0,3).equalsIgnoreCase("ABB")) {
//            return false;
//        }
        try {
            Long.parseLong(pcp);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
