package com.example.bankapp.data_access.repositories;

import com.example.bankapp.data_access.models.Transaction;
import com.example.bankapp.data_access.models.TransactionDao;

public class TransactionRepository {
    private TransactionDao transactionDao;

    public TransactionRepository(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
        mockData();
    }

    private void mockData(){

    }


    public Transaction create(Transaction transaction){
        long id = transactionDao.insertWithoutSettingPk(transaction);
        transaction.setId(id);
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
