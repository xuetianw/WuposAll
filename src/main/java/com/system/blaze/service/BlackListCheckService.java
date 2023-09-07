package com.system.blaze.service;

import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.parsingModel.RiskRequest;

public interface BlackListCheckService {
    void checkBlackedList(RiskRequest riskRequest);

    void checkSender(Customer customer);

    void checkReceiver(Receiver receiver);

    void checkBlackListedLastName(Name name, String mes);
}
