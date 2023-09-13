package com.wupos.app.customResponse;

import com.wupos.app.model.UCDParsingModel.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCustomerDetailsResponse {
    private Customer customer;
    private String pcp;
}
