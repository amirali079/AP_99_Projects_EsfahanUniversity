package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Account;
import com.example.mohammad_es_faz4_gui.BackEnd.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateBankAccount extends AppCompatActivity {

    Context a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bank_account);
        Objects.requireNonNull(getSupportActionBar()).hide();
        a = this;
        Button createAccBackButton = findViewById(R.id.createAccBackButton);
        createAccBackButton.setOnClickListener(view -> {
            onBackPressed();
        });

        List<String> spinnerArray =  new ArrayList<>();
        for (Person person: CityActivity.city.getPeople())
            spinnerArray.add(person.getFullName() + " - ID : " + person.getID());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = findViewById(R.id.createAccSpinner);
        sItems.setAdapter(adapter);

        Button createAccButton = findViewById(R.id.createAccButton);

        createAccButton.setOnClickListener(v -> {
            ProgressBar createAccProgressBar = findViewById(R.id.createAccProgressBar);
            createAccProgressBar.setVisibility(View.VISIBLE);
            new Thread(() -> {
                Person person = CityActivity.city.getPeople().get(sItems.getSelectedItemPosition());
                EditText moneyEditText = findViewById(R.id.createAccMoneyEditText);
                double money = Double.parseDouble(String.valueOf(moneyEditText.getText()));
                EditText usernameEditText = findViewById(R.id.createAccUsernameEditText);
                String username = String.valueOf(usernameEditText.getText());
                EditText passwordEditText = findViewById(R.id.createAccPasswordEditText);
                String password = String.valueOf(passwordEditText.getText());
                Account account = new Account(person, username, password, money, BankActivity.bank);
                BankActivity.bank.getAccounts().add(account);
                finish();
            }).start();
        });

    }
}