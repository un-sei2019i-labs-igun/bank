package com.example.bankapp.data_access.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Administrator {

    @Id
    private long id;
    @NotNull
    private String password;

    public Administrator(){
        password="";
    }

    @Generated(hash = 2070757056)
    public Administrator(long id, @NotNull String password) {
        this.id = id;
        this.password = password;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
