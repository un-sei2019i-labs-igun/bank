package com.example.bank_app.Controlers;

import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.Transaction;
import com.example.bank_app.dataAccess.repositories.AccountRepository;
import com.example.bank_app.dataAccess.repositories.TransactionRepository;

import java.util.Date;

public class TransferMoneyControler {

    public enum TransferMoneyResult{
        NOT_EXIST_SENDER, INSUFICIENT_BALANCE, NOT_EXIST_RECEPTOR, SUCCESS;
    }

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransferMoneyControler(AccountRepository accountRepository,
                                  TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public TransferMoneyResult transferMoney(long senderId, long receptorId, double value){

        // Verify Sender Existance
        Account verifiedSender = accountRepository.getById(senderId);
        if(verifiedSender == null) return TransferMoneyResult.NOT_EXIST_SENDER;

        // Verify Balance
        double newSenderBalance = verifiedSender.getBalance() - value;
        if(newSenderBalance < 0) return TransferMoneyResult.INSUFICIENT_BALANCE;

        // Verify Receptor Existance
        Account verifiedReceptor = accountRepository.getById(receptorId);
        if(verifiedReceptor == null) return TransferMoneyResult.NOT_EXIST_RECEPTOR;

        // Transaction Start
        verifiedSender.setBalance(newSenderBalance);
        verifiedReceptor.setBalance(verifiedReceptor.getBalance() + value);

        verifiedSender = accountRepository.update(verifiedSender);
        verifiedReceptor = accountRepository.update(verifiedReceptor);

        // Transaction Object Creation
        Transaction transaction = new Transaction();
        transaction.setDate(new Date());
        transaction.setSenderId(senderId);
        transaction.setReceptorId(receptorId);
        transaction.setValue(value);

        // Save Transaction Object
        transaction = transactionRepository.create(transaction);

        return TransferMoneyResult.SUCCESS;
    }

}
