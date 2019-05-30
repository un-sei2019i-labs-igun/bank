package com.example.bank_app.dataAccess.models;

import java.util.Date;

public class User extends Entity{

    private String fullName;
    private int idNumber;
    private Date lastPasswordChange;
    private Account account;


    public User(String fullName, int idNumber, Date lastPasswordChange, int databaseId){
        super(databaseId);
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.lastPasswordChange = lastPasswordChange;
    }

    public User(){
        fullName = "";
        idNumber = -1;
        lastPasswordChange = new Date();
    }

    public String getFullName() {
        return fullName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
