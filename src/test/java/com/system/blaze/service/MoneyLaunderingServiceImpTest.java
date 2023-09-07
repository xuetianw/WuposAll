package com.system.blaze.service;

import com.system.blaze.customException.MoneyLaunderingException;
import com.system.blaze.parsingModel.Customer;
import com.system.blaze.parsingModel.Name;
import com.system.blaze.parsingModel.Receiver;
import com.system.blaze.parsingModel.RiskRequest;
import com.system.blaze.service.impl.MoneyLaunderingImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoneyLaunderingServiceImpTest {


    @Value("${blaze.MoneyLaundering.lastnames}")
    private Set<String> moneyLaunderingNames;

    @Autowired
    MoneyLaunderingImp moneyLaunderingImp;

    @Test
    void both_sender_receiver_not_in_moneyLaunderingNames() {
        String senderLastName = "Tom";
        String receiverLastName = "Jason";

        assert !moneyLaunderingNames.contains(senderLastName) && !moneyLaunderingNames.contains(receiverLastName);

        RiskRequest riskRequest = getRiskRequest(senderLastName, receiverLastName);

        assertDoesNotThrow(() -> moneyLaunderingImp.check(riskRequest));
    }


    @Test
    void only_sender_in_moneyLaunderingNames(){
        String senderLastName = moneyLaunderingNames.iterator().next();

        String receiverLastName = "Wu";

        if (moneyLaunderingNames.isEmpty()) return;


        assert !moneyLaunderingNames.contains(receiverLastName);

        RiskRequest riskRequest = getRiskRequest(senderLastName, receiverLastName);

        Throwable throwable = Assertions.assertThrows(MoneyLaunderingException.class, () -> moneyLaunderingImp.check(riskRequest));

        assertEquals(String.format("sender %s is in the MoneyLaundering list", senderLastName) ,throwable.getMessage());

    }



    @Test
    void only_receiver_in_moneyLaunderingNames(){
        String receiverLastName = moneyLaunderingNames.iterator().next();

        String senderLastName = "Wu";

        if (moneyLaunderingNames.isEmpty()) return;


        assert !moneyLaunderingNames.contains(senderLastName);

        RiskRequest riskRequest = getRiskRequest(senderLastName, receiverLastName);

        Throwable throwable = Assertions.assertThrows(MoneyLaunderingException.class, () -> moneyLaunderingImp.check(riskRequest));

        assertEquals(String.format("receiver %s is in the MoneyLaundering list", receiverLastName) ,throwable.getMessage());

    }

    private RiskRequest getRiskRequest(String senderName, String receiverName) {
        return RiskRequest.builder()
                .customer(Customer.builder().name(Name.builder().lastName(senderName).build()).build())
                .receiver(Receiver.builder().name(Name.builder().lastName(receiverName).build()).build())
                .build();
    }

}