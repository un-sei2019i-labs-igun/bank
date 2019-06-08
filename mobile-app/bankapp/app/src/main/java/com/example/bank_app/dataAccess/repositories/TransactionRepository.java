package com.example.bank_app.dataAccess.repositories;

import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.Transaction;
import com.example.bank_app.dataAccess.models.TransactionDao;
import com.example.bank_app.dataAccess.models.UserDao;


public class TransactionRepository extends Repository{


     TransactionDao transactionDao;


    public TransactionRepository(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }


    public Transaction create(Transaction transaction){
       transactionDao.insert(transaction);
       return transaction;
    }

    public Transaction getById(long id){
      return  transactionDao.load(id);
    }

    public Transaction update(Transaction transaction){
        transactionDao.update(transaction);
        return transaction;
    }

}
