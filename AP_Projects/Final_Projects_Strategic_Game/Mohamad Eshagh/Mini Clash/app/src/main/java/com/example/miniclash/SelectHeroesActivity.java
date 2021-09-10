package com.example.miniclash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.miniclash.BackEnd.Heroes.FireHero;
import com.example.miniclash.BackEnd.Heroes.Hero;
import com.example.miniclash.BackEnd.Heroes.IceHero;
import com.example.miniclash.BackEnd.Heroes.SoilHero;
import com.example.miniclash.BackEnd.Heroes.WindHero;
import com.example.miniclash.BackEnd.Team;

import java.util.Objects;

import javax.net.ssl.HandshakeCompletedEvent;

public class SelectHeroesActivity extends AppCompatActivity {

    static Team team1;
    static Team team2;
    Hero[] heroes = new Hero[3];

    ImageButton selectedHeroesImg0;
    ImageButton selectedHeroesImg1;
    ImageButton selectedHeroesImg2;

    ImageButton deleteSelectedHero0;
    ImageButton deleteSelectedHero1;
    ImageButton deleteSelectedHero2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_heroes);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextView selectHeroesToolbarText = findViewById(R.id.selectHeroesToolbarText);
        selectHeroesToolbarText.setText("First Team Heroes");

        if (team1 != null) {
            team2 = new Team();
            selectHeroesToolbarText.setText("Second Team Heroes");
        }
        else
            team1 = new Team();

        selectedHeroesImg0 = findViewById(R.id.selectedHeroesImg0);
        selectedHeroesImg1 = findViewById(R.id.selectedHeroesImg1);
        selectedHeroesImg2 = findViewById(R.id.selectedHeroesImg2);

        ImageButton backButton = findViewById(R.id.selectHeroesToolbarBackButton);
        backButton.setOnClickListener(v -> onBackPressed());

        Button okButton = findViewById(R.id.selectHeroesOKButton);
        okButton.setOnClickListener(v -> {
            if (team2 == null) {
                team1.getHeroes().add(heroes[0]);
                team1.getHeroes().add(heroes[1]);
                team1.getHeroes().add(heroes[2]);
            }
            else {
                team2.getHeroes().add(heroes[0]);
                team2.getHeroes().add(heroes[1]);
                team2.getHeroes().add(heroes[2]);
            }
            switchToSelectCastle();
        });

        deleteSelectedHero0 = findViewById(R.id.deleteSelectedHero0);
        deleteSelectedHero0.setOnClickListener(v -> {
            selectedHeroesImg0.setImageDrawable(null);
            deleteSelectedHero0.setVisibility(View.INVISIBLE);
            okButton.setEnabled(false);
        });


        deleteSelectedHero1 = findViewById(R.id.deleteSelectedHero1);
        deleteSelectedHero1.setOnClickListener(v -> {
            selectedHeroesImg1.setImageDrawable(null);
            deleteSelectedHero1.setVisibility(View.INVISIBLE);
            okButton.setEnabled(false);
        });


        deleteSelectedHero2 = findViewById(R.id.deleteSelectedHero2);
        deleteSelectedHero2.setOnClickListener(v -> {
            selectedHeroesImg2.setImageDrawable(null);
            deleteSelectedHero2.setVisibility(View.INVISIBLE);
            okButton.setEnabled(false);
        });
    }


    public void selectHero(View view){
        ImageButton heroImage = (ImageButton) view;
        int heroTag = Integer.parseInt(String.valueOf(heroImage.getTag()));

        ImageButton selectedHero;
        if (selectedHeroesImg0.getDrawable() == null) {
            selectedHero = selectedHeroesImg0;
            deleteSelectedHero0.setVisibility(View.VISIBLE);
            if (selectedHeroesImg1.getDrawable() != null && selectedHeroesImg2.getDrawable() != null)
                enableOkButton();
        }

        else if (selectedHeroesImg1.getDrawable() == null) {
            selectedHero = selectedHeroesImg1;
            deleteSelectedHero1.setVisibility(View.VISIBLE);
            if (selectedHeroesImg0.getDrawable() != null && selectedHeroesImg2.getDrawable() != null)
                enableOkButton();
        }

        else if (selectedHeroesImg2.getDrawable() == null) {
            deleteSelectedHero2.setVisibility(View.VISIBLE);
            selectedHero = selectedHeroesImg2;
            if (selectedHeroesImg0.getDrawable() != null && selectedHeroesImg1.getDrawable() != null)
                enableOkButton();
        }
        else
            return;

        setSelectedHero(heroTag, selectedHero);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void setSelectedHero(int heroTag, ImageButton selectedHero){
        Team team = team2 == null ? team1 : team2;
        int selectedHeroTag = Integer.parseInt(String.valueOf(selectedHero.getTag()));
        Drawable drawable;
        switch (heroTag) {
            case 0 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ice_hero0, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new IceHero(75, 500, 1, drawable);
                break;
            case 1 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fire_hero0, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new FireHero(150, 350, 1, drawable);
                break;
            case 2 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wind_hero0, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new WindHero(75, 350, 2, drawable);
                break;
            case 3 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ice_hero1, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new IceHero(100, 600, 2, drawable);
                break;
            case 4 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fire_hero1, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new FireHero(250, 400, 2, drawable);
                break;
            case 5 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wind_hero1, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new WindHero(100, 400, 3, drawable);
                break;
            case 6 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.soil_hero0, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new SoilHero(100, 400, 1, drawable);
                break;
            case 7 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.soil_hero1, null);
                selectedHero.setImageDrawable(drawable);
                heroes[selectedHeroTag] = new SoilHero(150, 500, 2, drawable);
        }
        selectedHero.setVisibility(View.VISIBLE);
    }

    public void enableOkButton(){
        Button okButton = findViewById(R.id.selectHeroesOKButton);
        okButton.animate().alphaBy(2).setDuration(2000);
        okButton.setEnabled(true);
    }

    public void infoClicked(View view){
        ImageButton infoImageButton = (ImageButton) view;
        ImageButton heroImageButton;
        int infoTag = Integer.parseInt(String.valueOf(infoImageButton.getTag()));
        Drawable drawable;
        switch (infoTag) {
            case 0 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ice_hero0_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg0);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 1 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fire_hero0_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg1);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 2 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wind_hero0_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg2);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 3 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ice_hero1_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg3);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 4 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fire_hero1_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg4);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 5:
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wind_hero1_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg5);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 6 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.soil_hero0_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg6);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 7 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.soil_hero1_info, null);
                heroImageButton = findViewById(R.id.selectHeroesImg7);
                heroImageButton.setImageDrawable(drawable);
        }
        drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.delete_info, null);
        infoImageButton.animate().rotationX(360).setDuration(750);
        infoImageButton.setImageDrawable(drawable);
        infoImageButton.setOnClickListener(this::deleteInfoClicked);
    }

    private void deleteInfoClicked(View view){
        ImageButton infoImageButton = (ImageButton) view;
        ImageButton heroImageButton;
        int infoTag = Integer.parseInt(String.valueOf(infoImageButton.getTag()));
        Drawable drawable;
        switch (infoTag) {
            case 0 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ice_hero0, null);
                heroImageButton = findViewById(R.id.selectHeroesImg0);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 1 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fire_hero0, null);
                heroImageButton = findViewById(R.id.selectHeroesImg1);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 2 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wind_hero0, null);
                heroImageButton = findViewById(R.id.selectHeroesImg2);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 3 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ice_hero1, null);
                heroImageButton = findViewById(R.id.selectHeroesImg3);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 4 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fire_hero1, null);
                heroImageButton = findViewById(R.id.selectHeroesImg4);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 5:
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wind_hero1, null);
                heroImageButton = findViewById(R.id.selectHeroesImg5);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 6 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.soil_hero0, null);
                heroImageButton = findViewById(R.id.selectHeroesImg6);
                heroImageButton.setImageDrawable(drawable);
                break;
            case 7 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.soil_hero1, null);
                heroImageButton = findViewById(R.id.selectHeroesImg7);
                heroImageButton.setImageDrawable(drawable);
        }
        drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.info_icon2, null);
        infoImageButton.animate().rotationX(360).setDuration(750);
        infoImageButton.setImageDrawable(drawable);
        infoImageButton.setOnClickListener(this::infoClicked);
    }

    private void switchToSelectCastle() {
        Intent switchActivityIntent = new Intent(this, SelectCastleActivity.class);
        startActivity(switchActivityIntent);
    }

    @Override
    public void onBackPressed(){
        if (team2 != null)
            team2 = null;
        else
            team1 = null;
        finish();
    }
}