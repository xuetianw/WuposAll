package com.wupos.compliance.advice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    private int code;
    private String message;

    public CustomResponse(int code, String message){
        this.code = code;
        this.message = message;
    }
}
