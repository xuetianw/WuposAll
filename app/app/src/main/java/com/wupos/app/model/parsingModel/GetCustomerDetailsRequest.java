package com.wupos.app.model.parsingModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCustomerDetailsRequest {

    private Name name;
    private Phone phone;
    private String PCP;

}
