package com.wupos.compliance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Transaction")
@NoArgsConstructor
public class Transaction {

    @Id
    @SequenceGenerator(name = "mctnSequence", initialValue = 1111111111)
    @GeneratedValue(generator = "mctnSequence")
    private Long id;

    @Embedded
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetails paymentDetails;

    private LocalDate dateAdded;

    private String PCP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
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
