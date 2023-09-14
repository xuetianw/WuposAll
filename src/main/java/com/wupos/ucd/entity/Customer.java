package com.wupos.ucd.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcp")
    private long pcp;
    @Embedded
    private Name name;
    @Embedded
    private PhoneNumber phoneNumber;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compliance_id")
    private Compliance compliance;

    public Customer() {
    }

    public Customer(Name name, PhoneNumber phoneNumber, Address address, Compliance compliance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.compliance = compliance;
    }

    @Override
    public String toString() {
        return "User{" +
                "pcp='" + pcp + '\'' +
                ", name=" + name +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", compliance=" + compliance +
                '}';
    }
}
