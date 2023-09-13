package com.wupos.app.model.sendmoneyValidation.rtra;


import com.wupos.app.model.sendmoneyValidation.rtra.CustomerDetails.Compliance;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

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