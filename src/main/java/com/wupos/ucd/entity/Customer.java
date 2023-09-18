package com.wupos.ucd.entity;

import com.wupos.ucd.exception.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Getter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcp")
    private long pcp;

    @Getter(AccessLevel.NONE)
    @Embedded
    private Name name;

    @Getter(AccessLevel.NONE)
    @Embedded
    private PhoneNumber phoneNumber;

    @Getter(AccessLevel.NONE)
    @Embedded
    private Address address;

    @Getter(AccessLevel.NONE)
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
        if (pcp < 0) throw new InvalidPcpException("PCP cannot be less than zero.");
        return pcp;
    }

    public Name getName() {
        if (name == null || name.getFirstName() == null || name.getLastName() == null) throw new MissingNameException(
                "Name is missing. Please add a name.");
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        if (phoneNumber == null || phoneNumber.getCountryCode() == null || phoneNumber.getNumber() == null) throw new MissingPhoneNumberException(
                "Phone number is missing. Please add a phone number.");
        return phoneNumber;
    }

    public Address getAddress() {
        if (address == null
                || address.getAddressLine1() == null
                || address.getPincode() == null
                || address.getCity() == null
                || address.getState() == null
                || address.getCountry() == null
        ) {
            throw new MissingAddressException("Address is missing. Please add an address.");
        }
        return address;
    }

    public Compliance getCompliance() {
        if (compliance == null
                || compliance.getIdNumber() == null
                || compliance.getIdType() == null
                || compliance.getIdIssueDate() == null
                || compliance.getIdExpiryDate() == null
        ) {
            throw new MissingComplianceException("Compliance is missing. Please add ID details");
        }
        return compliance;
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
