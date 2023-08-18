package com.wupos.compliance.model;

import com.wupos.compliance.model.Customer.Address;
import com.wupos.compliance.model.Customer.Compliance;
import com.wupos.compliance.model.Customer.Name;
import com.wupos.compliance.model.Customer.Phone;
import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
@Embeddable
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    private Name name;

    @Embedded
    private Phone phone;

    @Embedded
    private Address address;

    @Embedded
    private Compliance compliance;

    public CustomerEntity(){

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

    public Compliance getCompliance() {
        return compliance;
    }

    public void setCompliance(Compliance compliance) {
        this.compliance = compliance;
    }
}