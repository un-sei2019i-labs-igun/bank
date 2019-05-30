package com.example.bank_app.dataAccess.models;

import java.util.LinkedList;

public class Account extends Entity{

    private double balance;
    private User user;
    private LinkedList<Transaction> transactions;

    private Account(double balance, int databaseId){
        super(databaseId);
        this.balance = balance;
        transactions = new LinkedList<>();
    }

    private Account(){
        balance = -1;
        transactions = new LinkedList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction[] getTransactions() {
        return transactions.toArray(new Transaction[transactions.size()]);
    }

    public void addTransaction(Transaction transaction) {
        transactions.addLast(transaction);
    }
}
