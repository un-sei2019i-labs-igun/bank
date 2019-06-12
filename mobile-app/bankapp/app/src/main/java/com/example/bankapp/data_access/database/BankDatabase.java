package com.example.bankapp.data_access.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankapp.data_access.models.AccountDao;
import com.example.bankapp.data_access.models.DaoMaster;
import com.example.bankapp.data_access.models.DaoSession;
import com.example.bankapp.data_access.models.TransactionDao;
import com.example.bankapp.data_access.models.UserDao;

public class BankDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Bank.db";

    private DaoSession daoSession;

    public BankDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.daoSession = new DaoMaster(this.getWritableDatabase()).newSession();
        init();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //init();
    }

    private void init(){
        //Drop tables
        UserDao.dropTable(daoSession.getDatabase(), true);
        AccountDao.dropTable(daoSession.getDatabase(), true);
        TransactionDao.dropTable(daoSession.getDatabase(), true);

        //Table creation
        UserDao.createTable(daoSession.getDatabase(), true);
        AccountDao.createTable(daoSession.getDatabase(), true);
        TransactionDao.createTable(daoSession.getDatabase(), true);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }
}
