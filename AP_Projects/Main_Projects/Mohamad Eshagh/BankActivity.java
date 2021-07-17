package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Account;
import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Bank;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class BankActivity extends AppCompatActivity {

    public static Bank bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        Objects.requireNonNull(getSupportActionBar()).hide();

        int bankIndex = getIntent().getIntExtra("bankIndex", -1);
        bank = CityActivity.city.getBanks().get(bankIndex);

        TextView textView = findViewById(R.id.bankToolBarText);
        textView.setText(bank.getName());

        Button addCityBackBtu = findViewById(R.id.bankBackButton);
        addCityBackBtu.setOnClickListener(view -> {
            onBackPressed();
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.floatCreateAccButton);
        floatingActionButton.setOnClickListener(v -> switchToCreateAccount());


        EditText bankPasswordEditText = findViewById(R.id.bankPasswordEditText);
        CheckBox bankLoginCheckBox = findViewById(R.id.bankLoginCheckBox);
        int type = bankLoginCheckBox.getInputType();
        bankLoginCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (bankLoginCheckBox.isChecked())
                bankPasswordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            else {
                bankPasswordEditText.setInputType(type); //TODO can you make it?
            }
        });

        Button bankLoginButton = findViewById(R.id.bankLoginButton);
        bankLoginButton.setOnClickListener(v -> {
            ProgressBar progressBar = findViewById(R.id.bankLoginProgressBar);
            progressBar.setVisibility(View.VISIBLE);
            final boolean[] userExist = {false};
            new Thread(() -> {
                EditText bankUsernameEditText = findViewById(R.id.bankUsernameEditText);
                String username = String.valueOf(bankUsernameEditText.getText());
                String password = String.valueOf(bankPasswordEditText.getText());
                ArrayList<Account> accounts = bank.getAccounts();
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getUsername().equals(username)) {
                        if (accounts.get(i).getPassword().equals(password)){
                            switchToAccount(i);
                            userExist[0] = true;
                        }
                    }
                }
            }).start();
            progressBar.setVisibility(View.INVISIBLE);
            if (!userExist[0])
                Toast.makeText(this, "NOT FOUND", Toast.LENGTH_LONG).show();
        });

    }

    private void switchToCreateAccount(){
        Intent switchActivityIntent = new Intent(this, CreateBankAccount.class);
        startActivity(switchActivityIntent);
    }

    private void switchToAccount(int accountIndex){
        Intent switchActivityIntent = new Intent(this, AccountActivity.class);
        switchActivityIntent.putExtra("accountIndex", accountIndex);
        startActivity(switchActivityIntent);
    }
}