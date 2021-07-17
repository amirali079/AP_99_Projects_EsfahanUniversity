package GameApp.Controller;

import GameApp.Castle.AirCastle;
import GameApp.Castle.EarthCastle;
import GameApp.Castle.FireCastle;
import GameApp.Castle.WaterCastle;
import GameApp.Hero.*;
import GameApp.View.BattlefieldView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;
import java.util.ArrayList;

public class BattlefieldController {
    private BattlefieldView battlefieldView;

    public BattlefieldController() {
        setBattlefieldView(new BattlefieldView());
        battlefieldView.getSaveGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Save();
                battlefieldView.getScene().getWindow().hide();
            }
        });
    }

    public void Save() {
        if (!TypeController.change) {
            TypeController.timer.stop();
        } else {
            TypeController.newTimer.stop();
        }
        try {
            ArrayList<Hero> heroes = TypeController.returnHeroes();
            FileOutputStream Hero = new FileOutputStream("HERO.txt", true);
            DataOutputStream HeroD = new DataOutputStream(Hero);
            if (new File("HERO.txt").length() != 0) {
                new PrintWriter("HERO.txt").close();
            }
            HeroD.writeInt(heroes.size());
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i) instanceof FireHero) {
                    HeroD.writeChar('F');
                } else if (heroes.get(i) instanceof AirHero) {
                    HeroD.writeChar('A');
                } else if (heroes.get(i) instanceof WaterHero) {
                    HeroD.writeChar('W');
                } else if (heroes.get(i) instanceof EarthHero) {
                    HeroD.writeChar('E');
                }
                HeroD.writeInt(heroes.get(i).Live);
                HeroD.writeInt(heroes.get(i).Score);
                HeroD.writeDouble(heroes.get(i).HeroSample.getTranslateX());
                HeroD.writeDouble(heroes.get(i).HeroSample.getTranslateY());
            }
            HeroD.close();
            Hero.close();

            FileOutputStream Enemy = new FileOutputStream("ENEMY.txt", true);
            DataOutputStream EnemyD = new DataOutputStream(Enemy);
            ArrayList<Hero> enemies = TypeController.returnEnemies();
            if (new File("ENEMY.txt").length() != 0) {
                new PrintWriter("ENEMY.txt").close();
            }
            EnemyD.writeInt(enemies.size());
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i) instanceof FireHero) {
                    EnemyD.writeChar('F');
                } else if (enemies.get(i) instanceof AirHero) {
                    EnemyD.writeChar('A');
                } else if (enemies.get(i) instanceof WaterHero) {
                    EnemyD.writeChar('W');
                } else if (enemies.get(i) instanceof EarthHero) {
                    EnemyD.writeChar('E');
                }
                EnemyD.writeInt(enemies.get(i).Live);
                EnemyD.writeInt(enemies.get(i).Score);
                EnemyD.writeDouble(enemies.get(i).HeroSample.getTranslateX());
                EnemyD.writeDouble(enemies.get(i).HeroSample.getTranslateY());
            }
            EnemyD.close();
            Enemy.close();

            FileOutputStream enCastle = new FileOutputStream("ENEMY_CASTLE.txt", true);
            DataOutputStream enCastleD = new DataOutputStream(enCastle);
            if (new File("ENEMY_CASTLE.txt").length() != 0) {
                new PrintWriter("ENEMY_CASTLE.txt").close();
            }
            if (TypeController.enemyCastle instanceof AirCastle) {
                enCastleD.writeChar('A');
            } else if (TypeController.enemyCastle instanceof WaterCastle) {
                enCastleD.writeChar('W');
            } else if (TypeController.enemyCastle instanceof FireCastle) {
                enCastleD.writeChar('F');
            } else if (TypeController.enemyCastle instanceof EarthCastle) {
                enCastleD.writeChar('E');
            }
            enCastleD.writeInt(TypeController.enemyCastle.Health);
            enCastleD.writeDouble(TypeController.enemyCastle.CastleSample.getTranslateX());
            enCastleD.writeDouble(TypeController.enemyCastle.CastleSample.getTranslateY());
            enCastleD.close();
            enCastle.close();

            FileOutputStream enFakeCastle = new FileOutputStream("ENEMY_FAKE_CASTLE.txt", true);
            DataOutputStream enFakeCastleD = new DataOutputStream(enFakeCastle);
            if (new File("ENEMY_FAKE_CASTLE.txt").length() != 0) {
                new PrintWriter("ENEMY_FAKE_CASTLE.txt").close();
            }
            if (TypeController.enemyFakeCastle instanceof AirCastle) {
                enFakeCastleD.writeChar('A');
            } else if (TypeController.enemyFakeCastle instanceof WaterCastle) {
                enFakeCastleD.writeChar('W');
            } else if (TypeController.enemyFakeCastle instanceof FireCastle) {
                enFakeCastleD.writeChar('F');
            } else if (TypeController.enemyFakeCastle instanceof EarthCastle) {
                enFakeCastleD.writeChar('E');
            }
            enFakeCastleD.writeInt(TypeController.enemyFakeCastle.Health);
            enFakeCastleD.writeDouble(TypeController.enemyFakeCastle.CastleSample.getTranslateX());
            enFakeCastleD.writeDouble(TypeController.enemyFakeCastle.CastleSample.getTranslateY());
            enFakeCastleD.close();
            enFakeCastle.close();

            FileOutputStream heCastle = new FileOutputStream("HERO_CASTLE.txt", true);
            DataOutputStream heCastleD = new DataOutputStream(heCastle);
            if (new File("HERO_CASTLE.txt").length() != 0) {
                new PrintWriter("HERO_CASTLE.txt").close();
            }
            if (TypeController.heroCastle instanceof AirCastle) {
                heCastleD.writeChar('A');
            } else if (TypeController.heroCastle instanceof WaterCastle) {
                heCastleD.writeChar('W');
            } else if (TypeController.heroCastle instanceof FireCastle) {
                heCastleD.writeChar('F');
            } else if (TypeController.heroCastle instanceof EarthCastle) {
                heCastleD.writeChar('E');
            }
            heCastleD.writeInt(TypeController.heroCastle.Health);
            heCastleD.writeDouble(TypeController.heroCastle.CastleSample.getTranslateX());
            heCastleD.writeDouble(TypeController.heroCastle.CastleSample.getTranslateY());
            heCastleD.close();
            heCastle.close();

            FileOutputStream Which = new FileOutputStream("WHICH_CASTLE.txt", true);
            DataOutputStream WhichD = new DataOutputStream(Which);
            if (new File("WHICH_CASTLE.txt").length() != 0) {
                new PrintWriter("WHICH_CASTLE.txt").close();
            }
            WhichD.writeDouble(TypeController.Chasing);
            WhichD.close();
            Which.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BattlefieldView getBattlefieldView() {
        return battlefieldView;
    }

    public void setBattlefieldView(BattlefieldView battlefieldView) {
        this.battlefieldView = battlefieldView;
    }
}
