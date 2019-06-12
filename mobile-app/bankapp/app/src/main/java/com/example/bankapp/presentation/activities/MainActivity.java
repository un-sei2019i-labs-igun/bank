package com.example.bankapp.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bankapp.R;
import com.example.bankapp.business_logic.Constants;
import com.example.bankapp.business_logic.controlers.LogInController;
import com.example.bankapp.business_logic.controlers.SendMoneyController;
import com.example.bankapp.data_access.database.BankDatabase;
import com.example.bankapp.data_access.models.Account;
import com.example.bankapp.data_access.models.DaoSession;
import com.example.bankapp.data_access.repositories.AccountRepository;
import com.example.bankapp.data_access.repositories.TransactionRepository;
import com.example.bankapp.data_access.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {


    private LogInController logInController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Constants.base = new BankDatabase(this.getApplicationContext());
        DaoSession dao = Constants.base.getDaoSession();
        Constants.userRepository = new UserRepository(dao.getUserDao());
        Constants.accountRepository = new AccountRepository(dao.getAccountDao());
        Constants.transactionRepository = new TransactionRepository(dao.getTransactionDao());

        logInController = new LogInController(Constants.userRepository);

    }

    public void LogInClick(View view){

        long nDoc = Long.parseLong(((EditText)findViewById(R.id.noDoc)).getText().toString());
        Log.i("AAAAAAaaaaaaaa", "" + nDoc);

        String pass = ((EditText)findViewById(R.id.pass)).getText().toString();
        Log.i("AAAAAAaaaaaaaa", pass);

        LogInController.LogInControllerResult result = logInController.makeLogIn(nDoc, pass);

        String message;

        switch (result.result){
            case USER_NO_FOUND: message = "User no Found"; break;
            case INVALID_PASSWORD: message = "Invalid Password"; break;
            default: message = "Success";
        }

        ((TextView)findViewById(R.id.message)).setText(message);
    }

}
