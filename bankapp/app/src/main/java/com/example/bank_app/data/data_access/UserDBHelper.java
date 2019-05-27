package com.example.bank_app.data.data_access;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Bank.db";

    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Table creation

        sqLiteDatabase.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserContract.UserEntry.USER_NAME + " TEXT NOT NULL,"
                + UserContract.UserEntry.PASSWORD + " TEXT NOT NULL,"
                + "UNIQUE (" + UserContract.UserEntry.USER_NAME + "))");

        // Default Values

        //USER1
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , "USER1");
        values.put(UserContract.UserEntry.PASSWORD , "0000");

        db.insert(UserContract.UserEntry.TABLE_NAME, null, values);

        //USER2
        values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , "USER2");
        values.put(UserContract.UserEntry.PASSWORD , "0000");

        db.insert(UserContract.UserEntry.TABLE_NAME, null, values);

        //USER3
        values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , "USER3");
        values.put(UserContract.UserEntry.PASSWORD , "0000");

        db.insert(UserContract.UserEntry.TABLE_NAME, null, values)
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }
}
