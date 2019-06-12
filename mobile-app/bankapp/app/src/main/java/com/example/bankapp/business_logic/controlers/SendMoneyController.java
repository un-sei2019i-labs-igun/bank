package com.example.bankapp.business_logic.controlers;

import com.example.bankapp.data_access.models.Account;
import com.example.bankapp.data_access.models.Transaction;
import com.example.bankapp.data_access.repositories.AccountRepository;
import com.example.bankapp.data_access.repositories.TransactionRepository;

import java.util.Date;

public class SendMoneyController {
    public enum SendMoneyResult{
        NOT_EXIST_SENDER, INSUFICIENT_BALANCE, NOT_EXIST_RECEPTOR, SUCCESS;
    }

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public SendMoneyController(AccountRepository accountRepository,
                               TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public SendMoneyResult transferMoney(long senderId, long receptorId, double value){

        // Verify Sender Existance
        Account verifiedSender = accountRepository.getById(senderId);
        if(verifiedSender == null) return SendMoneyResult.NOT_EXIST_SENDER;

        // Verify Balance
        double newSenderBalance = verifiedSender.getBalance() - value;
        if(newSenderBalance < 0) return SendMoneyResult.INSUFICIENT_BALANCE;

        // Verify Receptor Existance
        Account verifiedReceptor = accountRepository.getById(receptorId);
        if(verifiedReceptor == null) return SendMoneyResult.NOT_EXIST_RECEPTOR;

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

        return SendMoneyResult.SUCCESS;
    }
}
