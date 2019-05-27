package com.example.bank_app.data.model;

public class User {
    private String userName;
    private String password;

    public LoggedInUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
}
