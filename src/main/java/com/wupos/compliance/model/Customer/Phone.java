package com.wupos.compliance.model.Customer;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {
    private String countryCode;
    private String number;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}