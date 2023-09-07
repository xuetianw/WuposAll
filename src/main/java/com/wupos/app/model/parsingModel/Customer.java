package com.wupos.app.model.parsingModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {

    private Name name;
    private Phone phone;
    private Address address;
    private Compliance compliance;

}
