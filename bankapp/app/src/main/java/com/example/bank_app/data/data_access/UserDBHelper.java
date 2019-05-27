package com.example.bank_app.data.data_access;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bank_app.data.model.User;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Bank.db";

    public static class InternalDatabaseException extends Exception {

        public InternalDatabaseException(String message){
            super(message);
        }


    }

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
        mockData(sqLiteDatabase);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase){
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

    public User getByUsername(String userName) {

        SQLiteDatabase db = getReadableDatabase();
        String selection = UserContract.UserEntry.TABLE_NAME + " LIKE ?";

        Cursor c = db.query(
                UserContract.UserEntry.TABLE_NAME,
                null,
                selection,
                new String[]{userName},
                null,
                null,
                null
        );

        User[] users = User.fromCursor(c);

        switch(users.length){
            case 0: return null;
            case 1: return users[0];
            default: return users[0];//throw new InternalDatabaseException("Database has 2 users with same UserName");
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }
}
