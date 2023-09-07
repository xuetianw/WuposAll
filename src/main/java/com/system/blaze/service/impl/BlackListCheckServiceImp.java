package com.system.blaze.service.impl;

import com.system.blaze.customException.BlacklistException;
import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.BlackListCheckService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BlackListCheckServiceImp implements BlackListCheckService {


    @Value("${blaze.blackListedPeople.lastnames}")
    private Set<String> blackListedLastNames;


    @Override
    public void checkBlackedList(RiskRequest riskRequest) {
        checkSender(riskRequest.getCustomer());
        checkReceiver(riskRequest.getReceiver());
    }


    @Override
    public void checkSender(Customer customer) {
        checkBlackListedLastName(customer.getName(), "sender");
    }


    @Override
    public void checkReceiver(Receiver receiver) {
        checkBlackListedLastName(receiver.getName(), "receiver");
    }


    @Override
    public void checkBlackListedLastName(Name name, String mes) {
        String lastName = name.getLastName();

        blackListedLastNames.forEach(n -> {
            if (n.equals(lastName)) {
                throw new BlacklistException(mes + " " + lastName + " has been blacklisted");
            }
        });
    }

}
