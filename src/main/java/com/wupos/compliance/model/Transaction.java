package com.wupos.compliance.entity;

public class Transaction {
    private CustomerEntity customerEntity;
    private PaymentDetailsEntity paymentDetailsEntity;
    private ReceiverEntity receiverEntity;

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public PaymentDetailsEntity getPaymentDetailsEntity() {
        return paymentDetailsEntity;
    }

    public void setPaymentDetailsEntity(PaymentDetailsEntity paymentDetailsEntity) {
        this.paymentDetailsEntity = paymentDetailsEntity;
    }

    public ReceiverEntity getReceiverEntity() {
        return receiverEntity;
    }

    public void setReceiverEntity(ReceiverEntity receiverEntity) {
        this.receiverEntity = receiverEntity;
    }
}
