package com.system.blaze.service.impl;

import com.system.blaze.customException.MoneyLaunderingException;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.MoneyLaunderingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.Set;


@Service
public class MoneyLaunderingImp implements MoneyLaunderingService {

    @Value("${blaze.MoneyLaundering.lastnames}")
    private Set<String> moneyLaunderingNames;

    public MoneyLaunderingImp() {
    }


    @Override
    public void check(RiskRequest riskRequest) {
        String senderLastName = riskRequest.getCustomer().getName().getLastName();

//
        String receiverLastname = riskRequest.getReceiver().getName().getLastName();
        checkLastName(senderLastName, "sender");
        checkLastName(receiverLastname, "receiver");

    }
    private void checkLastName(String lastName, String msg) {
        moneyLaunderingNames.forEach(n -> {
                    if (n.equals(lastName)){
                        throw new MoneyLaunderingException(msg + " " + lastName + " is in the MoneyLaundering list");
                    }
                }
        );
    }

}
