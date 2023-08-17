package com.wupos.compliance.model;

import java.util.Date;

public class Transaction {

    private Long id;
    private  CustomerEntity customerEntity;
    private PaymentDetailsEntity paymentDetailsEntity;
    private ReceiverEntity receiverEntity;

    private Date dateAdded;

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
