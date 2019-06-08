package com.example.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity()
public class Admin {
    @Id
    private long id;
    @NotNull
    private String password;

    public Admin(){
        password="";
    }

@Generated(hash = 1078872533)
public Admin(long id, @NotNull String password) {
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
