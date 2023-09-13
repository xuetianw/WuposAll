package com.wupos.app.model.customerResponse;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomer {
    private long pcp;
    private String message;
}
