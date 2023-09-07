package com.system.blaze.service;

import com.system.blaze.customException.BlacklistException;
import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.impl.BlackListCheckServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlackListCheckServiceTest {

    @Value("${blaze.blackListedPeople.lastnames}")
    private Set<String> blackListedLastNames;

    @Autowired
    BlackListCheckServiceImp blackListCheckService;

    @Test
    void checkBlackedList_both_sender_receiver_are_not_in_blackListed_lists() {
        final String senderName = "Wu";
        final String receiverName = "Zhang";
        RiskRequest riskRequest = getRiskRequest(senderName, receiverName);
        assertDoesNotThrow(() -> blackListCheckService.checkBlackedList(riskRequest));
    }

    @Test
    void only_sender_is_in_blackListed_lists() {
        if (blackListedLastNames.isEmpty()) return;
        String receiverName = "Zhang";
        assert !blackListedLastNames.contains(receiverName);
        String senderName = blackListedLastNames.iterator().next();
        RiskRequest riskRequest = getRiskRequest(senderName, receiverName);
        Throwable throwable = assertThrows(BlacklistException.class, () -> blackListCheckService.checkBlackedList(riskRequest));
        assertEquals(String.format("sender %s has been blacklisted", senderName), throwable.getMessage()); ;
    }

    @Test
    void only_receiver_is_in_blackListed_lists() {
        if (blackListedLastNames.isEmpty()) return;
        String senderName = "Jason";
        assert !blackListedLastNames.contains(senderName);
        String receiverName = blackListedLastNames.iterator().next();
        RiskRequest riskRequest = getRiskRequest(senderName, receiverName);
        Throwable throwable = assertThrows(BlacklistException.class, () -> blackListCheckService.checkBlackedList(riskRequest));
        assertEquals(String.format("receiver %s has been blacklisted", receiverName), throwable.getMessage()); ;
    }


    private RiskRequest getRiskRequest(final String senderLastName, final String receiverLastName) {
        return RiskRequest.builder()
                .customer(Customer.builder().name(Name.builder().lastName(senderLastName).build()).build())
                .receiver(Receiver.builder().name(Name.builder().lastName(receiverLastName).build()).build())
                .build();
    }
}