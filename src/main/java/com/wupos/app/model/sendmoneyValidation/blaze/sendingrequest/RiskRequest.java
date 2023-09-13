package com.wupos.app.model.sendmoneyValidation.blaze.sendingrequest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RiskRequest {
    private Customer customer;
    private Receiver receiver;
    private PaymentDetails paymentDetails;
}
