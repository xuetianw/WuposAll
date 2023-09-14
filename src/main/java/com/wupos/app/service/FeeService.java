package com.wupos.app.service;

import com.wupos.app.model.getFees.requestParcingModel.FeeRequest;
import com.wupos.app.model.getFees.returningParcingModel.Fee;

public interface FeeService {
    void checkCountry(FeeRequest feeRequest);

    Fee getFee(FeeRequest feeRequest);
}
