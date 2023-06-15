package com.cashbook.entity;

public class User {
    private String mobileNumber;
    private String username;
    private String password;

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User [mobileNumber=" + mobileNumber + ",username=" + username + ",password=" + password + "]";
    }

    public User() {

    }

    public User(String username) {
        this.username = username;
        this.password = "";
        this.mobileNumber = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.mobileNumber = "";
    }

    public User(String username, String password, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

}
