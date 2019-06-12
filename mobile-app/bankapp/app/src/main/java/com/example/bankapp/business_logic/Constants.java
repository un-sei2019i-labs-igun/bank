package com.example.bankapp.business_logic;

import com.example.bankapp.data_access.database.BankDatabase;
import com.example.bankapp.data_access.models.User;
import com.example.bankapp.data_access.repositories.AccountRepository;
import com.example.bankapp.data_access.repositories.TransactionRepository;
import com.example.bankapp.data_access.repositories.UserRepository;

public abstract class Constants {

    public static BankDatabase base;
    public static UserRepository userRepository;
    public static AccountRepository accountRepository;
    public static TransactionRepository transactionRepository;
    public static User currentUser;
}
