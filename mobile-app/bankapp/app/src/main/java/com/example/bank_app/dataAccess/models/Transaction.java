package com.example.bank_app.dataAccess.models;

import java.util.Date;

public class Transaction extends  Entity{

    private double value;
    private Date date;
    private User senderOReceptor;
    private boolean sender; //True si el usuario asociado a la cuenta de la transacción fue el que envio el dinero

    public Transaction(double value, Date date, User senderOReceptor, boolean sender , int databaseId){
        super(databaseId);
        this.value = value;
        this.date = date;
        this.senderOReceptor = senderOReceptor;
        this.sender = sender;
    }

    public Transaction(){
        value = -1;
        date = new Date(0);
    }


    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public User getSenderOReceptor() {
        return senderOReceptor;
    }

    public boolean isSender() {
        return sender;
    }
}
