package com.example.bank_app.data.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.bank_app.data.data_access.UserContract;

import java.util.LinkedList;

public class User {
    private String userName;
    private String password;

    private User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , userName);
        values.put(UserContract.UserEntry.PASSWORD , password);

        return values;
    }

    public static User[] fromCursor(Cursor cursor){
        User[] users = new User[cursor.getCount()];

        String userName, password;

        for (int i = 0; cursor.moveToNext(); i++) {
            userName = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.USER_NAME));
            password = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.PASSWORD));

            users[i] = new User(userName, password);
        }

        return users;
    }


}
