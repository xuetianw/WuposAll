package com.wupos.ucd.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PhoneNumber {
    private String countryCode;

    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "countryCode='" + countryCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
