package com.example.bank_app.dataAccess.repositories;

import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.AccountDao;

public class AccountRepository extends Repository{


    private AccountDao accountDao;
    public AccountRepository(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    public Account create(Account account){
        accountDao.insert(account);
        return account;
    }

    public Account getById(long id){
        return accountDao.load(id);
    }

    public Account update(Account account){
        accountDao.update(account);
        return  account;
    }

}
