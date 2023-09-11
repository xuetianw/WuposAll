package com.wupos.compliance.model;

import com.wupos.compliance.model.CustomerDetails.Address;
import com.wupos.compliance.model.CustomerDetails.Compliance;
import com.wupos.compliance.model.CustomerDetails.Name;
import com.wupos.compliance.model.CustomerDetails.Phone;
import jakarta.persistence.*;

@Embeddable
public class Customer {

    @Embedded
    private Compliance compliance;

    public Customer() {
    }

    public Compliance getCompliance() {
        return compliance;
    }

    public void setCompliance(Compliance compliance) {
        this.compliance = compliance;
    }
}