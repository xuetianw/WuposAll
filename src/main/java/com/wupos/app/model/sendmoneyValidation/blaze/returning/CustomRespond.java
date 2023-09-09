package com.wupos.app.model.sendmoneyValidation.blaze.returning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomRespond {
    private String code;
    private String message;
}
