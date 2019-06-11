package com.example.bank_app.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.bank_app.businessLogic.controlers.SendMoneyController;
import com.example.bank_app.dataAccess.database.BankDatabase;
import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.DaoSession;
import com.example.bank_app.dataAccess.repositories.AccountRepository;
import com.example.bank_app.dataAccess.repositories.TransactionRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        BankDatabase base = new BankDatabase(this.getApplicationContext());
        Log.i("EL PATH!!!", base.getReadableDatabase().getPath());
        DaoSession dao = base.getDaoSession();

        AccountRepository accountRepo = new AccountRepository(dao.getAccountDao());
        TransactionRepository transactionRepo = new TransactionRepository(dao.getTransactionDao());

        Account testAccount = new Account(1, -1, 100.0);
        Account testAccount2 = new Account(2, -1, 0.0);



        testAccount = accountRepo.create(testAccount);
        testAccount2 = accountRepo.create(testAccount2);

        Log.i("Test", "testAcoount balance: " + testAccount.getBalance() + "\ttestAccount2 balance: " + testAccount2.getBalance());


        SendMoneyController sendMoney = new SendMoneyController(accountRepo, transactionRepo);
        SendMoneyController.SendMoneyResult result = sendMoney.transferMoney(testAccount.getNCuenta(), testAccount2.getNCuenta(), 50);

        Log.i("Test", "Result " + result);
        Log.i("Test", "testAcoount balance: " + testAccount.getBalance() + "\ttestAccount2 balance: " + testAccount2.getBalance());


    }

}
