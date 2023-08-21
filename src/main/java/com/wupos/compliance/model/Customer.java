package com.wupos.compliance.model;

import com.wupos.compliance.model.CustomerDetails.Address;
import com.wupos.compliance.model.CustomerDetails.Compliance;
import com.wupos.compliance.model.CustomerDetails.Name;
import com.wupos.compliance.model.CustomerDetails.Phone;
import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
@Embeddable
public class Customer {

    @Id
    @Column(name = "PCP")
    private String PCP;
    @Embedded
    private Name name;

    @Embedded
    private Phone phone;

    @Embedded
    private Address address;

    @Embedded
    private Compliance compliance;


    public String getPCP() {
        return PCP;
    }

    public void setPCP(String PCP) {
        this.PCP = PCP;
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