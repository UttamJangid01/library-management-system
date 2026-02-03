package com.dto;

import java.util.UUID;

public class LoginResponse {
    private String message;
    private UUID userId;
    private String name;
    private boolean status = false;

    public LoginResponse(String message, UUID userId, String name, boolean status){
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getId() {
        return userId;
    }

    public void setId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse [message=" + message + ", userId=" + userId + ", name=" + name + ", status=" + status + "]";
    }

}
