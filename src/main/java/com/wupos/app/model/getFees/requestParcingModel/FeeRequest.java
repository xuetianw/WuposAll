package com.wupos.app.model.getFees.requestParcingModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeRequest {
    String senderCountry;
    String ReceiverCountry;
    double amount;
    String payIn;
    String payOut;
}
