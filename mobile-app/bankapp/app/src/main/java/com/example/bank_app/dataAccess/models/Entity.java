package com.example.bank_app.dataAccess.models;

public class Entity {


    private int databaseId;

    public Entity(int databaseId){
        this.databaseId = databaseId;
    }

    public Entity(){
        databaseId = -1;
    }

    public int getDatabaseId(){
        return databaseId;
    }

}
