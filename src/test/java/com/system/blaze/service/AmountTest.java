package com.system.blaze.service;

import com.system.blaze.customException.AmountException;
import com.system.blaze.parsingModel.PaymentDetails;
import com.system.blaze.service.impl.MoneyFormatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AmountTest {

    @Value("${blaze.sendAmountLimit}")
    private double limit;

    @Autowired
    private AmountService amountService;

    @Test
    public void when_within_limit_then_checkAmount_does_not_throw() {
        PaymentDetails paymentDetails = new PaymentDetails(limit);

        assertDoesNotThrow(() -> amountService.checkAmount(paymentDetails));
    }

    @Test
    public void when_over_limit_then_checkAmount_throws_AmountException() {
        double n = limit + 1;
        PaymentDetails paymentDetails = new PaymentDetails(n);

        Exception e = assertThrows(AmountException.class, () -> amountService.checkAmount(paymentDetails));

        assertEquals("Send amount of $" + MoneyFormatService.format(n) + " exceeds $"
                + MoneyFormatService.format(limit) + " limit", e.getMessage());
    }
}
