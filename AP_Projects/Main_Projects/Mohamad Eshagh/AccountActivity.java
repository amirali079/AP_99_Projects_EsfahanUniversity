package com.example.mohammad_es_faz4_gui;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Account;

import java.util.Objects;

public class AccountActivity extends AppCompatActivity {

    public static Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Objects.requireNonNull(getSupportActionBar()).hide();

        int accountIndex = getIntent().getIntExtra("accountIndex", -1);
        account = BankActivity.bank.getAccounts().get(accountIndex);

        TextView accountToolbarText = findViewById(R.id.accountToolbarText);
        accountToolbarText.setText(account.getOwner().getFullName());

        Button accountBackButton = findViewById(R.id.accountBackButton);
        accountBackButton.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}