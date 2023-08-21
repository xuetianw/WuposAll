package com.wupos.compliance.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private  Customer customer;
    @OneToOne
    private PaymentDetails paymentDetails;
    @OneToOne
    private Receiver receiverEntity;

    private LocalDate dateAdded;

    private String PCP;

    public Customer getCustomer() {
        return customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerEntity(Customer customerEntity) {
        this.customer = customerEntity;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetailsEntity(PaymentDetails paymentDetailsEntity) {
        this.paymentDetails = paymentDetailsEntity;
    }

    public Receiver getReceiverEntity() {
        return receiverEntity;
    }

    public void setReceiverEntity(Receiver receiverEntity) {
        this.receiverEntity = receiverEntity;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
    public String getPCP() {
        return PCP;
    }

    public void setPcp(String PCP) {
        this.PCP = PCP;
    }
}
