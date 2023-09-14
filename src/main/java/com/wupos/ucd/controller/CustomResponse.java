package com.wupos.ucd.controller;

public class CustomResponse {
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

        public long getPcp() {
            return pcp;
        }

        public void setPcp(long pcp) {
            this.pcp = pcp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
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
}
