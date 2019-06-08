package com.example.bank_app.dataAccess.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bank_app.dataAccess.models.DaoMaster;
import com.example.bank_app.dataAccess.models.DaoSession;


public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Bank.db";

    private DaoSession daoSession;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.daoSession = new DaoMaster(this.getWritableDatabase()).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Table creation



        // Default Values
        //mockData(sqLiteDatabase);

    }

   /* private void mockData(SQLiteDatabase sqLiteDatabase){
        //USER1
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , "USER1");
        values.put(UserContract.UserEntry.PASSWORD , "0000");

        sqLiteDatabase.insert(UserContract.UserEntry.TABLE_NAME, null, values);

        //USER2
        values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , "USER2");
        values.put(UserContract.UserEntry.PASSWORD , "0000");

        sqLiteDatabase.insert(UserContract.UserEntry.TABLE_NAME, null, values);

        //USER3
        values = new ContentValues();
        values.put(UserContract.UserEntry.USER_NAME , "USER3");
        values.put(UserContract.UserEntry.PASSWORD , "0000");

        sqLiteDatabase.insert(UserContract.UserEntry.TABLE_NAME, null, values);
    }

   */



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }
}
