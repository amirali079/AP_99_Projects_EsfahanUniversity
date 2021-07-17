package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Bank;

import java.util.Objects;

public class AddBankActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button addCityBackBtu = findViewById(R.id.addBankBackButton);
        addCityBackBtu.setOnClickListener(view -> {
            onBackPressed();
        });

        Button addBankButton = findViewById(R.id.addBankButton);
        addBankButton.setOnClickListener(view -> {
            ProgressBar progressBar = findViewById(R.id.addBankProgressBar);
            progressBar.setVisibility(View.VISIBLE);

            new Thread(() -> {
                EditText editText = findViewById(R.id.addBankEditText);
                String bankName = editText.getText().toString();
                CityActivity.city.getBanks().add(new Bank(CityActivity.city, bankName));
                finish();
            }).start();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}