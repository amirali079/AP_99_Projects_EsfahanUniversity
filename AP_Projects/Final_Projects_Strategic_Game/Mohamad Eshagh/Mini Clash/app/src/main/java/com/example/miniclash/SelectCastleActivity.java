package com.example.miniclash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.miniclash.BackEnd.Castle.Castle;
import com.example.miniclash.BackEnd.Team;

import java.util.Objects;

public class SelectCastleActivity extends AppCompatActivity {

    ImageButton selectedCastleImg0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_castle);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextView selectHeroesToolbarText = findViewById(R.id.selectCastleToolbarText);

        if (SelectHeroesActivity.team2 == null)
            selectHeroesToolbarText.setText("First Team Heroes");
        else
            selectHeroesToolbarText.setText("Second Team Heroes");

        selectedCastleImg0 = findViewById(R.id.selectedCastleImg0);

        ImageButton backButton = findViewById(R.id.selectCastleToolbarBackButton);
        backButton.setOnClickListener(v -> onBackPressed());

        Button okButton = findViewById(R.id.selectCastleOKButton);
        okButton.setOnClickListener(v -> {
            switchToPositionActivity();
        });

        ImageButton deleteSelectedCastle0 = findViewById(R.id.deleteSelectedCastle0);
        deleteSelectedCastle0.setOnClickListener(v -> {
            selectedCastleImg0.setImageDrawable(null);
            deleteSelectedCastle0.setVisibility(View.INVISIBLE);
            okButton.setEnabled(false);
        });

    }

    @SuppressLint("SetTextI18n")
    public void selectCastle(View view){
        ImageButton castleImage = (ImageButton) view;
        int castleTag = Integer.parseInt(String.valueOf(castleImage.getTag()));

        if (selectedCastleImg0.getDrawable() != null)
            return;

        setSelectedCastle(castleTag);

        ImageButton deleteSelectedCastle0 = findViewById(R.id.deleteSelectedCastle0);
        deleteSelectedCastle0.setVisibility(View.VISIBLE);

        Button okButton = findViewById(R.id.selectCastleOKButton);
        okButton.animate().alphaBy(2).setDuration(2000);
        okButton.setEnabled(true);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void setSelectedCastle(int castleTag){
        Team team = SelectHeroesActivity.team2 == null ? SelectHeroesActivity.team1 : SelectHeroesActivity.team2;
        Drawable drawable;
        switch (castleTag) {
            case 0 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle0, null);
                selectedCastleImg0.setImageDrawable(drawable);
                team.setCastle(new Castle(3000, 50, drawable));
                break;
            case 1 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle1, null);
                selectedCastleImg0.setImageDrawable(drawable);
                team.setCastle(new Castle(2600, 100, drawable));
                break;
            case 2 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle2, null);
                selectedCastleImg0.setImageDrawable(drawable);
                team.setCastle(new Castle(2000, 175, drawable));
        }
    }

    public void infoClicked(View view){
        ImageButton infoImageButton = (ImageButton) view;
        ImageButton castleImageButton;
        Drawable drawable;
        int infoTag = Integer.parseInt(String.valueOf(infoImageButton.getTag()));
        switch (infoTag) {
            case 0 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle0_info, null);
                castleImageButton = findViewById(R.id.selectCastleImg0);
                castleImageButton.setImageDrawable(drawable);
                break;
            case 1 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle1_info, null);
                castleImageButton = findViewById(R.id.selectCastleImg1);
                castleImageButton.setImageDrawable(drawable);
                break;
            case 2 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle2_info, null);
                castleImageButton = findViewById(R.id.selectCastleImg2);
                castleImageButton.setImageDrawable(drawable);
        }
        drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.delete_info, null);
        infoImageButton.animate().rotationX(360).setDuration(750);
        infoImageButton.setImageDrawable(drawable);
        infoImageButton.setOnClickListener(this::deleteInfoClicked);
    }

    public void deleteInfoClicked(View view){
        ImageButton infoImageButton = (ImageButton) view;
        ImageButton castleImageButton;
        int infoTag = Integer.parseInt(String.valueOf(infoImageButton.getTag()));
        Drawable drawable;
        switch (infoTag) {
            case 0 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle0, null);
                castleImageButton = findViewById(R.id.selectCastleImg0);
                castleImageButton.setImageDrawable(drawable);
                break;
            case 1 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle1, null);
                castleImageButton = findViewById(R.id.selectCastleImg1);
                castleImageButton.setImageDrawable(drawable);
                break;
            case 2 :
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.castle2, null);
                castleImageButton = findViewById(R.id.selectCastleImg2);
                castleImageButton.setImageDrawable(drawable);
        }
        drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.info_icon2, null);
        infoImageButton.animate().rotationX(360).setDuration(750);
        infoImageButton.setImageDrawable(drawable);
        infoImageButton.setOnClickListener(this::infoClicked);
    }

    private void switchToPositionActivity() {
        Intent switchActivityIntent = new Intent(this, SelectPositionActivity.class);
        startActivity(switchActivityIntent);
    }

    @Override
    public void onBackPressed(){
        if (SelectHeroesActivity.team2 != null)
            SelectHeroesActivity.team2.setCastle(null);
        else
            SelectHeroesActivity.team1.setCastle(null);
        finish();
    }
}