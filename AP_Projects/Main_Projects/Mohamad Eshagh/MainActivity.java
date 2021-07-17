package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;

import com.example.mohammad_es_faz4_gui.BackEnd.Country;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    public static Country myCountry = new Country(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       loadGame();

        Button citiesButton = findViewById(R.id.citiesButton);
        citiesButton.setOnClickListener(v -> switchToCities());

        Button financialManagementButton = findViewById(R.id.financialManagementButton);
        financialManagementButton.setOnClickListener(v -> switchToFinancialManagement());

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> {
            saveGame();
            finishAndRemoveTask();
        });
        
    }

    private void switchToCities() {
        Intent switchActivityIntent = new Intent(this, CitiesActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchToFinancialManagement() {
        Intent switchActivityIntent = new Intent(this, FinancialManagementActivity.class);
        startActivity(switchActivityIntent);
    }

    private void loadGame(){
        try {
            FileInputStream fileInputStream = new FileInputStream("Android\\data\\com.example.mohammad_es_faz4_gui\\country.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            myCountry = (Country) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveGame(){
        try {
            new File("Android\\data\\com.example.mohammad_es_faz4_gui").mkdir();
            FileOutputStream fileOutputStream = new FileOutputStream("Android\\data\\com.example.mohammad_es_faz4_gui\\country.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myCountry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}