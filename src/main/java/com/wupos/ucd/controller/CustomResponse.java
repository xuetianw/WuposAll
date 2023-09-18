package com.wupos.ucd.controller;

import lombok.Getter;
import lombok.Setter;

public class CustomResponse {
    @Getter
    @Setter
    public static class UserResponse {
        private long pcp;
        private String message;

        public UserResponse() {
        }

        public UserResponse(String message) {
            this.message = message;
        }

        public UserResponse(long pcp, String message) {
            this.pcp = pcp;
            this.message = message;
        }

        @Override
        public String toString() {
            return "AddUserResponse{" +
                "pcp='" + pcp + '\'' +
                ", message='" + message + '\'' +
                '}';         
        }
    }

    @Getter
    @Setter
    public static class ErrorResponse {
        private int code;
        private String message;

        public ErrorResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String toString() {
            return "ErrorResponse{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
