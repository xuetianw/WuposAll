package com.wupos.ucd.entity;

import jakarta.persistence.*;

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

    public long getPcp() {
        return pcp;
    }

    public void setPcp(long pcp) {
        this.pcp = pcp;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Compliance getCompliance() {
        return compliance;
    }

    public void setCompliance(Compliance compliance) {
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
