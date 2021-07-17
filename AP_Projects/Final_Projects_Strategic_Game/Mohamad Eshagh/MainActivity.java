package com.example.miniclash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(v -> {
            switchToFirstTeamHeroes();
        });
    }

    @Override
    public void onResume() {
        SelectHeroesActivity.team1 = null;
        SelectHeroesActivity.team2 = null;
        super.onResume();
    }

    private void switchToFirstTeamHeroes() {
        Intent switchActivityIntent = new Intent(this, SelectHeroesActivity.class);
        startActivity(switchActivityIntent);
    }
}