package com.example.miniclash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miniclash.BackEnd.Team;

import java.util.Objects;

public class SelectPositionActivity extends AppCompatActivity {

    TextView selectPositionText;
    Team team;
    Group heroesGroup;
    Group castleGroup;
    int clickedNumber = 0;
    ImageView mainImg;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_position);
        Objects.requireNonNull(getSupportActionBar()).hide();

        selectPositionText = findViewById(R.id.selectPositionText);

        TextView toolbarText = findViewById(R.id.selectPositionToolbarText);
        mainImg = findViewById(R.id.selectPositionMainImg);
        if ( SelectHeroesActivity.team2 == null) {
            toolbarText.setText("First team select position");
            castleGroup = findViewById(R.id.team1CastleGroup);
            heroesGroup = findViewById(R.id.team1HeroesGroup);
            team = SelectHeroesActivity.team1;
        }
        else {
            toolbarText.setText("Second team select position");
            castleGroup = findViewById(R.id.team2CastleGroup);
            heroesGroup = findViewById(R.id.team2HeroesGroup);
            team = SelectHeroesActivity.team2;
        }
        mainImg.setImageDrawable(team.getCastle().getImg());

        castleGroup.setVisibility(View.VISIBLE);

        ImageButton imageButton = findViewById(R.id.selectPositionToolbarBackButton);
        imageButton.setOnClickListener(v -> onBackPressed());

        Button positionOKButton = findViewById(R.id.selectPositionOKButton);
        positionOKButton.setOnClickListener(v -> {
            if (SelectHeroesActivity.team2 == null)
                switchToSelectHeroes();
            else
                switchToGameActivity();
        });
    }

    public void positionClicked(View view) {
        clickedNumber++;
        setTeam1Positions((ImageButton) view);
    }

    @SuppressLint("SetTextI18n")
    private void setTeam1Positions(ImageButton imageButton){
        switch (clickedNumber){
            case 1 :
                imageButton.setImageDrawable(team.getCastle().getImg());
                selectPositionText.setText("Select your first hero position");
                castleGroup.removeView(imageButton);
                heroesGroup.removeView(imageButton);
                heroesGroup.setVisibility(View.VISIBLE);
                mainImg.setImageDrawable(team.getHeroes().get(0).getImg());
                team.getCastle().setPosition(Integer.parseInt(String.valueOf(imageButton.getTag())));
                break;
            case 2:
                imageButton.setImageDrawable(team.getHeroes().get(0).getImg());
                selectPositionText.setText("Select your second hero position");
                heroesGroup.removeView(imageButton);
                mainImg.setImageDrawable(team.getHeroes().get(1).getImg());
                team.getHeroes().get(0).setPosition(Integer.parseInt(String.valueOf(imageButton.getTag())));
                break;
            case 3 :
                imageButton.setImageDrawable(team.getHeroes().get(1).getImg());
                selectPositionText.setText("Select your third hero position");
                heroesGroup.removeView(imageButton);
                mainImg.setImageDrawable(team.getHeroes().get(2).getImg());
                team.getHeroes().get(1).setPosition(Integer.parseInt(String.valueOf(imageButton.getTag())));
                break;
            case 4 :
                imageButton.setImageDrawable(team.getHeroes().get(2).getImg());
                selectPositionText.setText("");
                mainImg.setVisibility(View.INVISIBLE);
                Button button = findViewById(R.id.selectPositionOKButton);
                button.setVisibility(View.VISIBLE);
                heroesGroup.removeView(imageButton);
                heroesGroup.setVisibility(View.INVISIBLE);
                team.getHeroes().get(2).setPosition(Integer.parseInt(String.valueOf(imageButton.getTag())));
        }
        imageButton.setEnabled(false);
        imageButton.setOnClickListener(null);
    }

    private void switchToSelectHeroes() {
        Intent switchActivityIntent = new Intent(this, SelectHeroesActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchToGameActivity() {
        Intent switchActivityIntent = new Intent(this, BattleActivity.class);
        startActivity(switchActivityIntent);
    }
}