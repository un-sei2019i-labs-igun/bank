package com.example.bankapp.data_access.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Transaction {

    @Id(autoincrement = true)
    private long id;
    @NotNull
    private double value;
    @NotNull
    private Date date;
    @NotNull
    private long senderId;
    @NotNull
    private long receptorId;


    public Transaction() {
        value = -1;
        date = new Date();
        senderId = -1;
        receptorId = -1;
    }


    @Generated(hash = 1420075435)
    public Transaction(long id, double value, @NotNull Date date, long senderId,
            long receptorId) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.senderId = senderId;
        this.receptorId = receptorId;
    }


    public long getId() {
        return this.id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public double getValue() {
        return this.value;
    }


    public void setValue(double value) {
        this.value = value;
    }


    public Date getDate() {
        return this.date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public long getSenderId() {
        return this.senderId;
    }


    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }


    public long getReceptorId() {
        return this.receptorId;
    }


    public void setReceptorId(long receptorId) {
        this.receptorId = receptorId;
    }
}
