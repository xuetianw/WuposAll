package com.wupos.app.model.returningParcingModel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private long pcp;
    private Name name;
    private PhoneNumber phone;
    private Address address;

    private Compliance compliance;


    @Override
    public String toString() {
        return "User{" +
                "pcp='" + pcp + '\'' +
                ", name=" + name +
                ", phoneNumber=" + phone +
                ", address=" + address +
                ", compliance=" + compliance +
                '}';
    }
}
