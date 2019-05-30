package com.example.bank_app.dataAccess.repositories;

import com.example.bank_app.dataAccess.models.Account;

public class AccountRepository extends Repository{


    public static abstract class AccountEntry{

        public static final String TABLE_NAME ="account";

        public static final String BALANCE = "balance";
        public static final String ID = "id";
        public static final String USER_ID = "user_id";
    }

    public Account create(){
        return null;
    }

    public Account getById(){
        return null;
    }

    public Account update(){
        return null;
    }

    public Account delete(){
        return null;
    }

}
