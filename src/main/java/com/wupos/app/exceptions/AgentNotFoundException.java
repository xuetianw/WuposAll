package com.wupos.app.exceptions;

public class AgentNotFoundException extends RuntimeException {
    public AgentNotFoundException(String message){
        super(message);
    }
}
