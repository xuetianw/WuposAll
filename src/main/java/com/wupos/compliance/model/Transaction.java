package com.wupos.compliance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Transaction")
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PaymentDetails paymentDetails;
    @ManyToOne
    private Receiver receiverEntity;


    private LocalDate dateAdded;

    private String PCP;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
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
    @JsonProperty("PCP")
    public String getPCP() {
        return PCP;
    }

    public void setPCP(String PCP) {
        this.PCP = PCP;
    }
}
