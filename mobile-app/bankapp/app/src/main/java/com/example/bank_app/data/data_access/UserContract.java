package com.example.bank_app.data.data_access;

import android.provider.BaseColumns;

public class UserContract {
    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME ="user";

        public static final String USER_NAME = "name";
        public static final String PASSWORD = "password";
    }
}
