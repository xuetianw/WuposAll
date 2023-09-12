package com.wupos.app.service.impl;


import com.wupos.app.getFeeExceptions.MoneyAmountException;
import com.wupos.app.model.getFees.requestParcingModel.FeeRequest;
import com.wupos.app.model.getFees.returningParcingModel.Fee;
import com.wupos.app.service.FeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class FeeServiceImp implements FeeService {
    @Value("${feeRange}")
    double[] feeRange;

    @Value("${percentage}")
    double[] percentages;

    @Override
    public void checkCountry(FeeRequest feeRequest) {

    }

    @PostConstruct
    void func() {

    }

    @Override
    public Fee getFee(FeeRequest feeRequest) {
        double amount = feeRequest.getAmount();
        if (amount < feeRange[0]) {
            throw new MoneyAmountException(amount / 100 + " is below the threshold");
        }

        double total = 0;
        for (int i = 0; i < feeRange.length - 1; i++) {
            if (i == feeRange.length - 1) {
                total += (amount - feeRange[i]) * percentages[i] / 100;
                break;
            }
            if (amount < feeRange[i + 1]) {
                total += (amount - feeRange[i]) * percentages[i] / 100;
                break;
            } else {
                total += (feeRange[i + 1] - feeRange[i]) * percentages[i] / 100;
            }
        }
        return Fee.builder().fees((int)(total) + "").build();
    }
}
