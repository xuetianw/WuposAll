package com.wupos.app.model.UCDParsingModel;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Customer {

    private long pcp;
    private Name name;
    private PhoneNumber phoneNumber;
    private Address address;

    private Compliance compliance;


    @Override
    public String toString() {
        return "User{" +
                ", name=" + name +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", compliance=" + compliance +
                '}';
    }
}
