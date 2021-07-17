package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.mohammad_es_faz4_gui.BackEnd.City;

import java.util.Objects;

public class AddCityActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button addCityBackBtu = findViewById(R.id.addCityBackButton);
        addCityBackBtu.setOnClickListener(view -> {
            onBackPressed();
        });

        Button addCityBtu = findViewById(R.id.addCityButton);
        addCityBtu.setOnClickListener(view -> {
            ProgressBar progressBar = findViewById(R.id.addCityProgressBar);
            progressBar.setVisibility(View.VISIBLE);

            new Thread(() -> {
                EditText editText = findViewById(R.id.editTextCityName);
                String cityName = editText.getText().toString();
                MainActivity.myCountry.getCities().add(new City(cityName));
                finish();
            }).start();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}