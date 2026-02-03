package com.dto;

public class SignupResponse {
    private String message;
    private String name;

    public SignupResponse(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SignResponse [message=" + message + ", name=" + name + "]";
    }

}
