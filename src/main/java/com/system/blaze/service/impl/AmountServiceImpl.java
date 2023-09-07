package com.system.blaze.service.impl;

import com.system.blaze.customException.AmountException;
import com.system.blaze.parsingModel.PaymentDetails;
import com.system.blaze.service.AmountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmountServiceImpl implements AmountService {

    @Value("${blaze.sendAmountLimit}")
    private double limit;

    public void checkAmount(PaymentDetails paymentDetails) {
        double sendAmount = paymentDetails.getSendAmount();
        if (sendAmount > limit) {
            throw new AmountException("Send amount of $" + MoneyFormatService.format(sendAmount)
                    + " exceeds $" + MoneyFormatService.format(limit) + " limit");
        }
    }
}
