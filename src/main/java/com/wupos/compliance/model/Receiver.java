package com.wupos.compliance.model;

import com.wupos.compliance.model.CustomerDetails.Address;
import com.wupos.compliance.model.CustomerDetails.Name;
import com.wupos.compliance.model.CustomerDetails.Phone;
import jakarta.persistence.*;

@Entity
@Table(name = "Receiver")
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Phone phone;

    @Embedded
    private Address address;
    public ReceiverEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}