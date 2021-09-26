package com.example.miniclash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniclash.BackEnd.Castle.Castle;
import com.example.miniclash.BackEnd.Heroes.Hero;
import com.example.miniclash.BackEnd.Team;

import java.util.ArrayList;
import java.util.Objects;

public class BattleActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;

    ImageView[] imageViews = new ImageView[50];
    TextView winGameTextView;

    Team team1 = SelectHeroesActivity.team1;
    Team team2 = SelectHeroesActivity.team2;

    Castle team1Castle;
    Castle team2Castle;

    Hero team1Hero0;
    Hero team1Hero1;
    Hero team1Hero2;

    Hero team2Hero0;
    Hero team2Hero1;
    Hero team2Hero2;

    boolean gameEnded = true;

    boolean isGameEnded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        Objects.requireNonNull(getSupportActionBar()).hide();

        gameEnded = false;

        constraintLayout = findViewById(R.id.selectConstraintLayout);

        for (int i = 0; i < constraintLayout.getChildCount(); i++)
            if (constraintLayout.getChildAt(i) instanceof ImageView) {
                ImageView imageView = (ImageView) constraintLayout.getChildAt(i);
                if (imageView.getTag() != null)
                    imageViews[(Integer.parseInt(String.valueOf(imageView.getTag())))] = imageView;
            }

        team1Castle = team1.getCastle();
        team1Hero0 = team1.getHeroes().get(0);
        team1Hero1 = team1.getHeroes().get(1);
        team1Hero2 = team1.getHeroes().get(2);

        team2Castle = team2.getCastle();
        team2Hero0 = team2.getHeroes().get(0);
        team2Hero1 = team2.getHeroes().get(1);
        team2Hero2 = team2.getHeroes().get(2);

        winGameTextView = findViewById(R.id.winGameTextView);

        setImages();

        Handler handler = new Handler();


        final Runnable team1Hero0Run = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                Castle enemyCastle = team2Castle;
                Hero samePositionEnemyHero;
                if (team1Hero0.getPosition() == enemyCastle.getPosition()){
                    enemyCastle.setHealth(enemyCastle.getHealth() - team1Hero0.getPower());
                    if (enemyCastle.getHealth() <= 0){
                        winGameTextView.setText("✨ First team win the game! ✨");
                        endGame(enemyCastle);
                    }
                    team1Hero0.setHealth(team1Hero0.getHealth() - enemyCastle.getPower());
                    if (team1Hero0.getHealth() <= 0) {
                        team1.getHeroes().remove(team1Hero0);
                    }
                } else if ( (samePositionEnemyHero = searchForTeam2SamePositionHero(team1Hero0)) != null) {
                    samePositionEnemyHero.setHealth(samePositionEnemyHero.getHealth() - team1Hero0.getPower());
                    if (samePositionEnemyHero.getHealth() <= 0) {
                        team2.getHeroes().remove(samePositionEnemyHero);
                    }
                } else
                    moveHero(team1Hero0, team2Castle);

                if ( (team1.getHeroes().size() + team2.getHeroes().size()) == 0 && !gameEnded){
                    winGameTextView.setText("✨ Draw! ✨");
                    endGame(enemyCastle);
                }
                if (!gameEnded)
                    handler.postDelayed(this, 1750);
            }
        };

        final Runnable team1Hero1Run = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                Castle enemyCastle = team2Castle;
                Hero samePositionEnemyHero;
                if (team1Hero1.getPosition() == enemyCastle.getPosition()){
                    enemyCastle.setHealth(enemyCastle.getHealth() - team1Hero1.getPower());
                    if (enemyCastle.getHealth() <= 0) {
                        winGameTextView.setText("✨ First team win the game! ✨");
                        endGame(enemyCastle);
                    }
                    team1Hero1.setHealth(team1Hero1.getHealth() - enemyCastle.getPower());
                    if (team1Hero1.getHealth() <= 0) {
                        team1.getHeroes().remove(team1Hero1);
                        
                    }
                } else if ( (samePositionEnemyHero = searchForTeam2SamePositionHero(team1Hero1)) != null) {
                    samePositionEnemyHero.setHealth(samePositionEnemyHero.getHealth() - team1Hero1.getPower());
                    if (samePositionEnemyHero.getHealth() <= 0) {
                        team2.getHeroes().remove(samePositionEnemyHero);
                        
                    }
                } else
                    moveHero(team1Hero1, team2Castle);
                if ( (team1.getHeroes().size() + team2.getHeroes().size()) == 0 && !gameEnded){
                    if (team1Castle.getHealth() > team2Castle.getHealth())
                        winGameTextView.setText("✨ First team win the game! ✨");
                    else if (team2Castle.getHealth() > team1Castle.getHealth())
                        winGameTextView.setText("✨ Second team win the game! ✨");
                    else
                        winGameTextView.setText("✨ Draw! ✨");
                    endGame(enemyCastle);
                }
                if (!gameEnded)
                    handler.postDelayed(this, 1750);
            }
        };

        final Runnable team1Hero2Run = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                Castle enemyCastle = team2Castle;
                Hero samePositionEnemyHero;
                if (team1Hero2.getPosition() == enemyCastle.getPosition()){
                    enemyCastle.setHealth(enemyCastle.getHealth() - team1Hero2.getPower());
                    if (enemyCastle.getHealth() <= 0){
                        winGameTextView.setText("✨ First team win the game! ✨");
                        endGame(enemyCastle);
                    }
                    team1Hero2.setHealth(team1Hero2.getHealth() - enemyCastle.getPower());
                    if (team1Hero2.getHealth() <= 0) {
                        team1.getHeroes().remove(team1Hero2);
                        
                    }
                } else if ( (samePositionEnemyHero = searchForTeam2SamePositionHero(team1Hero2)) != null) {
                    samePositionEnemyHero.setHealth(samePositionEnemyHero.getHealth() - team1Hero2.getPower());
                    if (samePositionEnemyHero.getHealth() <= 0) {
                        team2.getHeroes().remove(samePositionEnemyHero);
                        
                    }
                } else
                    moveHero(team1Hero2, team2Castle);
                if ( (team1.getHeroes().size() + team2.getHeroes().size()) == 0 && !gameEnded){
                    if (team1Castle.getHealth() > team2Castle.getHealth())
                        winGameTextView.setText("✨ First team win the game! ✨");
                    else if (team2Castle.getHealth() > team1Castle.getHealth())
                        winGameTextView.setText("✨ Second team win the game! ✨");
                    else
                        winGameTextView.setText("✨ Draw! ✨");
                    endGame(enemyCastle);
                }
                if (!gameEnded)
                    handler.postDelayed(this, 1750);
            }
        };


        final Runnable team2Hero0Run = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                Castle enemyCastle = team1Castle;
                Hero samePositionEnemyHero;
                if (team2Hero0.getPosition() == enemyCastle.getPosition()){
                    enemyCastle.setHealth(enemyCastle.getHealth() - team2Hero0.getPower());
                    if (enemyCastle.getHealth() <= 0){
                        winGameTextView.setText("✨ Second team win the game! ✨");
                        endGame(enemyCastle);
                    }
                    team2Hero0.setHealth(team2Hero0.getHealth() - enemyCastle.getPower());
                    if (team2Hero0.getHealth() <= 0) {
                        team2.getHeroes().remove(team2Hero0);
                        
                    }
                } else if ( (samePositionEnemyHero = searchForTeam1SamePositionHero(team2Hero0)) != null) {
                    samePositionEnemyHero.setHealth(samePositionEnemyHero.getHealth() - team2Hero0.getPower());
                    if (samePositionEnemyHero.getHealth() <= 0) {
                        team1.getHeroes().remove(samePositionEnemyHero);
                    }
                } else
                    moveHero(team2Hero0, team1Castle);
                if ( (team1.getHeroes().size() + team2.getHeroes().size()) == 0 && !gameEnded){
                    if (team1Castle.getHealth() > team2Castle.getHealth())
                        winGameTextView.setText("✨ First team win the game! ✨");
                    else if (team2Castle.getHealth() > team1Castle.getHealth())
                        winGameTextView.setText("✨ Second team win the game! ✨");
                    else
                        winGameTextView.setText("✨ Draw! ✨");
                    endGame(enemyCastle);
                }
                if (!gameEnded)
                    handler.postDelayed(this, 1750);
            }
        };

        final Runnable team2Hero1Run = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                Castle enemyCastle = team1Castle;
                Hero samePositionEnemyHero;
                if (team2Hero1.getPosition() == enemyCastle.getPosition()){
                    enemyCastle.setHealth(enemyCastle.getHealth() - team2Hero1.getPower());
                    if (enemyCastle.getHealth() <= 0){
                        winGameTextView.setText("✨ Second team win the game! ✨");
                        endGame(enemyCastle);
                    }
                    team2Hero1.setHealth(team2Hero1.getHealth() - enemyCastle.getPower());
                    if (team2Hero1.getHealth() <= 0) {
                        team2.getHeroes().remove(team2Hero1);
                    }
                } else if ( (samePositionEnemyHero = searchForTeam1SamePositionHero(team2Hero1)) != null) {
                    samePositionEnemyHero.setHealth(samePositionEnemyHero.getHealth() - team2Hero1.getPower());
                    if (samePositionEnemyHero.getHealth() <= 0) {
                        team1.getHeroes().remove(samePositionEnemyHero);
                    }
                } else
                    moveHero(team2Hero1, team1Castle);
                if ( (team1.getHeroes().size() + team2.getHeroes().size()) == 0 && !gameEnded){
                    if (team1Castle.getHealth() > team2Castle.getHealth())
                        winGameTextView.setText("✨ First team win the game! ✨");
                    else if (team2Castle.getHealth() > team1Castle.getHealth())
                        winGameTextView.setText("✨ Second team win the game! ✨");
                    else
                        winGameTextView.setText("✨ Draw! ✨");
                    endGame(enemyCastle);
                }
                if (!gameEnded)
                    handler.postDelayed(this, 1750);
            }
        };

        final Runnable team2Hero2Run = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                Castle enemyCastle = team1Castle;
                Hero samePositionEnemyHero;
                if (team2Hero2.getPosition() == enemyCastle.getPosition()){
                    enemyCastle.setHealth(enemyCastle.getHealth() - team2Hero2.getPower());
                    if (enemyCastle.getHealth() <= 0){
                        winGameTextView.setText("✨ Second team win the game! ✨");
                        endGame(enemyCastle);
                    }
                    team2Hero2.setHealth(team2Hero2.getHealth() - enemyCastle.getPower());
                    if (team2Hero2.getHealth() <= 0) {
                        team2.getHeroes().remove(team2Hero2);
                    }
                } else if ( (samePositionEnemyHero = searchForTeam1SamePositionHero(team2Hero2)) != null) {
                    samePositionEnemyHero.setHealth(samePositionEnemyHero.getHealth() - team2Hero2.getPower());
                    if (samePositionEnemyHero.getHealth() <= 0) {
                        team1.getHeroes().remove(samePositionEnemyHero);
                        
                    }
                } else
                    moveHero(team2Hero2, team1Castle);
                if ( (team1.getHeroes().size() + team2.getHeroes().size()) == 0 && !gameEnded){
                    if (team1Castle.getHealth() > team2Castle.getHealth())
                        winGameTextView.setText("✨ First team win the game! ✨");
                    else if (team2Castle.getHealth() > team1Castle.getHealth())
                        winGameTextView.setText("✨ Second team win the game! ✨");
                    else
                        winGameTextView.setText("✨ Draw! ✨");
                    endGame(enemyCastle);
                }
                if (!gameEnded)
                    handler.postDelayed(this, 1750);
            }
        };

        final Runnable uiRun = new Runnable() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    setImages();
                });
                if (!gameEnded)
                    handler.postDelayed(this, 1770);
            }
        };

        if (!gameEnded){
            handler.postDelayed(team1Hero0Run, 1750);
            handler.postDelayed(team1Hero1Run, 1750);
            handler.postDelayed(team1Hero2Run, 1750);
            handler.postDelayed(team2Hero0Run, 1750);
            handler.postDelayed(team2Hero1Run, 1750);
            handler.postDelayed(team2Hero2Run, 1750);
            handler.postDelayed(uiRun, 1770);
        }
    }

    @SuppressLint("RtlHardcoded")
    private Drawable combineTwoDrawable(Drawable img1, Drawable img2){
        LayerDrawable finalDrawable = new LayerDrawable(new Drawable[] {img1, img2});
        finalDrawable.setLayerInsetRight(0, img2.getIntrinsicHeight());
        finalDrawable.setLayerGravity(1, Gravity.RIGHT | Gravity.LEFT);
        return finalDrawable;
    }

    private void moveHero(Hero hero, Castle enemyCastle){
        int heroPosition = hero.getPosition();
        int heroXPosition = heroPosition % 5;
        int heroYPosition = heroPosition / 5;
        int enemyCastlePosition = enemyCastle.getPosition();
        int enemyCastleXPosition = enemyCastlePosition % 5;
        int enemyCastleYPosition = enemyCastlePosition / 5;
        int movement;

        if (Math.abs(heroXPosition - enemyCastleXPosition) >= Math.abs(heroYPosition - enemyCastleYPosition)) {
            movement = Math.min(hero.getSpeed(), Math.abs(heroXPosition - enemyCastleXPosition));
           if (heroXPosition > enemyCastleXPosition)
               hero.setPosition(heroPosition - movement);
           else
               hero.setPosition(heroPosition + movement);
        }

        else {
            movement = Math.min(hero.getSpeed(), Math.abs(heroYPosition - enemyCastleYPosition)) * 5;
            if (heroYPosition > enemyCastleYPosition)
                hero.setPosition(heroPosition - movement);
            else
                hero.setPosition(heroPosition + movement);
        }
    }

    private void setImages(){
        for (ImageView imageView: imageViews)
            imageView.setImageDrawable(null);

        if (team1 != null)
            for (Hero hero: team1.getHeroes()){
                    setHeroImg(hero);
            }

        if (team2 != null)
        for (Hero hero: team2.getHeroes()){
                setHeroImg(hero);
        }

        setCastleImg(team1Castle);
        setCastleImg(team2Castle);
    }

    private void setHeroImg(Hero hero){
        ImageView imageView;
        imageView = imageViews[hero.getPosition()];
        if (imageView.getDrawable() == null)
            imageView.setImageDrawable(hero.getImg());
        else
            imageView.setImageDrawable(combineTwoDrawable(imageView.getDrawable(), hero.getImg()));
    }

    private void setCastleImg(Castle castle){
        ImageView imageView;
        imageView = imageViews[castle.getPosition()];
        if (imageView.getDrawable() == null)
            imageView.setImageDrawable(castle.getImg());
        else
            imageView.setImageDrawable(combineTwoDrawable(castle.getImg() ,imageView.getDrawable()));
    }

    private Hero searchForTeam1SamePositionHero(Hero thisHero){
        for (Hero hero: team1.getHeroes())
            if (thisHero.getPosition() == hero.getPosition())
                if (thisHero != hero)
                    return hero;
        return null;
    }

    private Hero searchForTeam2SamePositionHero(Hero thisHero){
        for (Hero hero: team2.getHeroes())
            if (thisHero.getPosition() == hero.getPosition())
                if (thisHero != hero)
                    return hero;
        return null;
    }

    private void endGame(Castle destroyedCastle){
        gameEnded = true;
        Handler handler = new Handler();
        if (isGameEnded)
            return;
        isGameEnded = true;
        handler.postDelayed(this::switchToMainActivity, 3500);
    }

    private void switchToMainActivity() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}