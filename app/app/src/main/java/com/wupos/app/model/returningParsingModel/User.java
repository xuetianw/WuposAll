package com.wupos.app.model.returningParsingModel;

import lombok.*;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
//    public final static String PREFIX = "ABB";
//    public final static DecimalFormat df = new DecimalFormat("00000");
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
