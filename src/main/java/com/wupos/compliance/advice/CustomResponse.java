package com.wupos.compliance.advice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    private Long code;
    private String message;

    public CustomResponse(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
