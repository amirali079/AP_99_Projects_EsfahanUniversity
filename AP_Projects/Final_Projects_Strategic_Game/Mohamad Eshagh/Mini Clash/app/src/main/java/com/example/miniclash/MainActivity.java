package com.example.miniclash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioPlaybackConfiguration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.URI;


public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;


        Button startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(v -> {
            switchToFirstTeamHeroes();
        });

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> finishAndRemoveTask());
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