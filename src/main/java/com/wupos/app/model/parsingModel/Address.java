package com.wupos.app.model.parsingModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Address {

    private String addressLine1;
    private String addressLine2;
    private String pincode;
    private String city;
    private String state;
    private String country;

}
