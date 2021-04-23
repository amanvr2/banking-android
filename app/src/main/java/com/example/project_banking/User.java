package com.example.project_banking;

import java.math.BigInteger;

public class User {

    private String Name;
    private String username;
    private String password;
    private String contact;
    private Integer accountNo;
    private Integer currentBalance;

    public User(String name, String username, String password, String contact, Integer accountNo, Integer currentBalance) {
        Name = name;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.accountNo = accountNo;
        this.currentBalance = currentBalance;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }
}
