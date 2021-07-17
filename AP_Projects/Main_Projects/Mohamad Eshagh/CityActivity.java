package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Person;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class CityActivity extends AppCompatActivity {

    public static City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent thisStaticIntent = getIntent();
        int cityIndex = thisStaticIntent.getIntExtra("cityIndex", -1);
        city = MainActivity.myCountry.getCities().get(cityIndex);

        ArrayList<Person> unemployed = city.getPeople();
        unemployed.add(new Person("Abbas", "Aliyari", "Tabriz", "Male", "Pilot", "1357", 10.25));
        unemployed.add(new Person("Mohmammad", "Rahmanpor", "Rasht", "Male", "Pilot", "1368", 7.5));
        unemployed.add(new Person("Reza", "Rostami", "Zanjan", "Male", "Bus driver", "1365", 7.25));
        unemployed.add(new Person("Nazanin", "Bayati", "Ardebil", "Female", "Bus driver", "1369", 6.25));
        unemployed.add(new Person("Morteza", "Mohseni", "Ghom", "Male", "Bus driver", "1373", 5.25));
        unemployed.add(new Person("Mehrdad", "Daii", "Oromiyeh", "Male", "Locomotive", "1361", 10.25));
        unemployed.add(new Person("Mehrshad", "Mataji", "Nowshahr", "Male", "Locomotive", "1378", 7));
        unemployed.add(new Person("Ali", "Ahamadi", "Mashhad", "Male", "Sailor", "1360", 10));
        unemployed.add(new Person("Ahamd", "Moradi", "Tehran", "Male", "Sailor", "1372", 7.25));
        unemployed.add(new Person("Zahra", "Parvane", "Shiraz", "Female", "Crew", "1361", 4.75));
        unemployed.add(new Person("Nilofar", "Alimardani", "Sari", "Female", "Crew", "1380", 3.25));
        unemployed.add(new Person("Farhad", "Bakhshi", "Ahvaz", "Male", "Crew", "1364", 4.25));
        unemployed.add(new Person("Bahram", "Majidi", "Shahre Kord", "Male", "Crew", "1358", 5.25));

        TextView textView = findViewById(R.id.cityTextView);
        textView.setText(city.getName());

        Button addCityBackBtu = findViewById(R.id.cityBackButton);
        addCityBackBtu.setOnClickListener(view -> {
            onBackPressed();
        });

        FragmentContainerView bankFragmentContainerView = findViewById(R.id.bankFragmentContainer);
        FragmentContainerView terminalFragmentContainerView = findViewById(R.id.terminalFragmentContainer);

        TabLayout guiTabs;
        guiTabs = findViewById(R.id.cityTabLayout);

        guiTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        bankFragmentContainerView.setVisibility(View.VISIBLE);
                        terminalFragmentContainerView.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                    case 2:
                        bankFragmentContainerView.setVisibility(View.INVISIBLE);
                        terminalFragmentContainerView.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}