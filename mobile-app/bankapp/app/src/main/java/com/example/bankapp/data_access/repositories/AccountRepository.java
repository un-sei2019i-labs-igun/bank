package com.example.bankapp.data_access.repositories;

import com.example.bankapp.data_access.models.Account;
import com.example.bankapp.data_access.models.AccountDao;

public class AccountRepository {
    private AccountDao accountDao;
    public AccountRepository(AccountDao accountDao){
        this.accountDao = accountDao;
        mockData();
    }

    private void mockData(){
        Account testAccount = new Account(10, -1, 100);
        Account testAccount2 = new Account(11, -1, 0);

        create(testAccount);
        create(testAccount2);
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
