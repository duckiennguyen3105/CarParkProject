package com.fsoft.carparkproject.dto;

public class LoginDTO {
    private String account;
    private String password;

    public LoginDTO() {

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}