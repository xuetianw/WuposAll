package com.wupos.compliance.advice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    private String code;
    private String message;

    public CustomResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
