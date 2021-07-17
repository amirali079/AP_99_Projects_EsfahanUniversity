package GameApp.Controller;

import GameApp.Castle.*;
import GameApp.Hero.*;
import GameApp.View.TypeView;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class TypeController {
    public static ArrayList<Hero> heroes = new ArrayList<>();
    public static Castle heroCastle;
    public static ArrayList<Hero> enemies = new ArrayList<>();
    public static Castle enemyCastle;
    public static Castle enemyFakeCastle;
    public static AnimationTimer timer;
    public static AnimationTimer newTimer;
    public static boolean change = false;
    public static double Chasing;
    private TypeView typeView;
    private BattlefieldController battlefieldController;

    public TypeController() {
        setTypeView(new TypeView());

        getTypeView().getWATER().setOnAction(event -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(createWaterBattleField()));
            stage.setWidth(1100);
            stage.setHeight(700);
            stage.show();
            getTypeView().getScene().getWindow().hide();
        });

        getTypeView().getAIR().setOnAction(event -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(createAirBattleField()));
            stage.setWidth(1100);
            stage.setHeight(700);
            stage.show();
            getTypeView().getScene().getWindow().hide();
        });

        getTypeView().getEARTH().setOnAction(event -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(createEarthBattleField()));
            stage.setWidth(1100);
            stage.setHeight(700);
            stage.show();
            getTypeView().getScene().getWindow().hide();
        });

        getTypeView().getFIRE().setOnAction(event -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(createFireBattleField()));
            stage.setWidth(1100);
            stage.setHeight(700);
            stage.show();
            getTypeView().getScene().getWindow().hide();
        });
    }

    public static void Read() {
        try {
            FileInputStream hero = new FileInputStream("HERO.txt");
            DataInputStream heroD = new DataInputStream(hero);
            int sizeHero = heroD.readInt();
            for (int i = 0; i < sizeHero; i++) {
                Hero H;
                char Type = heroD.readChar();
                if (Type == 'A') {
                    H = new AirHero();
                } else if (Type == 'W') {
                    H = new WaterHero();
                } else if (Type == 'F') {
                    H = new FireHero();
                } else {
                    H = new EarthHero();
                }
                H.Live = heroD.readInt();
                H.Score = heroD.readInt();
                H.HeroSample.setTranslateX(heroD.readDouble());
                H.HeroSample.setTranslateY(heroD.readDouble());
                TypeController.heroes.add(H);
            }
            heroD.close();
            hero.close();

            FileInputStream enemy = new FileInputStream("ENEMY.txt");
            DataInputStream enemyD = new DataInputStream(enemy);
            int sizeEnemy = enemyD.readInt();
            for (int i = 0; i < sizeEnemy; i++) {
                Hero H;
                char Type = enemyD.readChar();
                if (Type == 'A') {
                    H = new AirHero();
                } else if (Type == 'W') {
                    H = new WaterHero();
                } else if (Type == 'F') {
                    H = new FireHero();
                } else {
                    H = new EarthHero();
                }
                H.Live = enemyD.readInt();
                H.Score = enemyD.readInt();
                H.HeroSample.setTranslateX(enemyD.readDouble());
                H.HeroSample.setTranslateY(enemyD.readDouble());
                TypeController.enemies.add(H);
            }
            enemyD.close();
            enemy.close();

            FileInputStream enCastle = new FileInputStream("ENEMY_CASTLE.txt");
            DataInputStream enCastleD = new DataInputStream(enCastle);
            char Type = enCastleD.readChar();
            if (Type == 'A') {
                TypeController.enemyCastle = new AirCastle();
            } else if (Type == 'E') {
                TypeController.enemyCastle = new EarthCastle();
            } else if (Type == 'F') {
                TypeController.enemyCastle = new FireCastle();
            } else if (Type == 'W') {
                TypeController.enemyCastle = new WaterCastle();
            }
            TypeController.enemyCastle.Health = enCastleD.readInt();
            TypeController.enemyCastle.CastleSample.setTranslateX(enCastleD.readDouble());
            TypeController.enemyCastle.CastleSample.setTranslateY(enCastleD.readDouble());
            enCastleD.close();
            enCastle.close();

            FileInputStream enFakeCastle = new FileInputStream("ENEMY_FAKE_CASTLE.txt");
            DataInputStream enFakeCastleD = new DataInputStream(enFakeCastle);
            Type = enFakeCastleD.readChar();
            if (Type == 'A') {
                TypeController.enemyFakeCastle = new AirCastle();
            } else if (Type == 'E') {
                TypeController.enemyFakeCastle = new EarthCastle();
            } else if (Type == 'F') {
                TypeController.enemyFakeCastle = new FireCastle();
            } else if (Type == 'W') {
                TypeController.enemyFakeCastle = new WaterCastle();
            }
            TypeController.enemyFakeCastle.Health = enFakeCastleD.readInt();
            TypeController.enemyFakeCastle.CastleSample.setTranslateX(enFakeCastleD.readDouble());
            TypeController.enemyFakeCastle.CastleSample.setTranslateY(enFakeCastleD.readDouble());
            enFakeCastleD.close();
            enFakeCastle.close();

            FileInputStream heCastle = new FileInputStream("HERO_CASTLE.txt");
            DataInputStream heCastleD = new DataInputStream(heCastle);
            Type = heCastleD.readChar();
            if (Type == 'A') {
                TypeController.heroCastle = new AirCastle();
            } else if (Type == 'E') {
                TypeController.heroCastle = new EarthCastle();
            } else if (Type == 'F') {
                TypeController.heroCastle = new FireCastle();
            } else if (Type == 'W') {
                TypeController.heroCastle = new WaterCastle();
            }
            TypeController.heroCastle.Health = heCastleD.readInt();
            TypeController.heroCastle.CastleSample.setTranslateX(heCastleD.readDouble());
            TypeController.heroCastle.CastleSample.setTranslateY(heCastleD.readDouble());
            heCastleD.close();
            heCastle.close();

            FileInputStream Which = new FileInputStream("WHICH_CASTLE.txt");
            DataInputStream WhichD = new DataInputStream(Which);
            Chasing = WhichD.readDouble();
            WhichD.close();
            Which.close();
            TypeController typeController = new TypeController();
            typeController.Continue();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Hero> returnHeroes() {
        ArrayList<Hero> newHeroes = new ArrayList<>();
        for (Hero h : heroes) {
            if (h.isAlive()) {
                newHeroes.add(h);
            }
        }
        return newHeroes;
    }

    public static ArrayList<Hero> returnEnemies() {
        ArrayList<Hero> newHeroes = new ArrayList<>();
        for (Hero e : enemies) {
            if (e.isAlive()) {
                newHeroes.add(e);
            }
        }
        return newHeroes;
    }

    public void CreateEnemy() {
        double enemyType = Math.random();
        if (enemyType < 0.25) {
            enemyCastle = (new WaterCastle());
            enemyCastle.CastleSample.setTranslateX(200);
            enemyCastle.CastleSample.setTranslateY(10);
            enemyCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyCastle.CastleSample);

            enemyFakeCastle = (new WaterCastle());
            enemyFakeCastle.CastleSample.setTranslateX(700);
            enemyFakeCastle.CastleSample.setTranslateY(10);
            enemyFakeCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyFakeCastle.CastleSample);
            int x = 10;
            for (int i = 0; i < 20; i++) {
                WaterHero waterEnemy = new WaterHero();
                waterEnemy.HeroSample.setTranslateX(x);
                waterEnemy.HeroSample.setTranslateY(70);
                getBattlefieldController().getBattlefieldView().getChildren().add(waterEnemy.HeroSample);
                enemies.add(waterEnemy);
                x += 54;
            }
        } else if (enemyType >= 0.25 && enemyType < 0.5) {
            enemyCastle = (new AirCastle());
            enemyCastle.CastleSample.setTranslateX(200);
            enemyCastle.CastleSample.setTranslateY(10);
            enemyCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyCastle.CastleSample);

            enemyFakeCastle = (new AirCastle());
            enemyFakeCastle.CastleSample.setTranslateX(700);
            enemyFakeCastle.CastleSample.setTranslateY(10);
            enemyFakeCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyFakeCastle.CastleSample);
            int x = 10;
            for (int i = 0; i < 20; i++) {
                AirHero airEnemy = new AirHero();
                airEnemy.HeroSample.setTranslateX(x);
                airEnemy.HeroSample.setTranslateY(70);
                getBattlefieldController().getBattlefieldView().getChildren().add(airEnemy.HeroSample);
                enemies.add(airEnemy);
                x += 54;
            }
        } else if (enemyType >= 0.5 && enemyType < 0.75) {
            enemyCastle = (new EarthCastle());
            enemyCastle.CastleSample.setTranslateX(200);
            enemyCastle.CastleSample.setTranslateY(10);
            enemyCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyCastle.CastleSample);

            enemyFakeCastle = (new EarthCastle());
            enemyFakeCastle.CastleSample.setTranslateX(700);
            enemyFakeCastle.CastleSample.setTranslateY(10);
            enemyFakeCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyFakeCastle.CastleSample);
            int x = 10;
            for (int i = 0; i < 20; i++) {
                EarthHero earthEnemy = new EarthHero();
                earthEnemy.HeroSample.setTranslateX(x);
                earthEnemy.HeroSample.setTranslateY(70);
                earthEnemy.render(getBattlefieldController().getBattlefieldView().getContext());
                getBattlefieldController().getBattlefieldView().getChildren().add(earthEnemy.HeroSample);
                enemies.add(earthEnemy);
                x += 54;
            }
        } else if (enemyType >= 0.75) {
            enemyCastle = (new FireCastle());
            enemyCastle.CastleSample.setTranslateX(200);
            enemyCastle.CastleSample.setTranslateY(10);
            enemyCastle.render(getBattlefieldController().getBattlefieldView().getContext());

            enemyFakeCastle = (new FireCastle());
            enemyFakeCastle.CastleSample.setTranslateX(700);
            enemyFakeCastle.CastleSample.setTranslateY(10);
            enemyFakeCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(enemyFakeCastle.CastleSample);
            int x = 10;
            for (int i = 0; i < 20; i++) {
                FireHero fireEnemy = new FireHero();
                fireEnemy.HeroSample.setTranslateX(x);
                fireEnemy.HeroSample.setTranslateY(70);
                fireEnemy.render(getBattlefieldController().getBattlefieldView().getContext());
                getBattlefieldController().getBattlefieldView().getChildren().add(fireEnemy.HeroSample);
                enemies.add(fireEnemy);
                x += 54;
            }
        }
    }

    private Parent createWaterBattleField() {
        setBattlefieldController(new BattlefieldController());
        heroCastle = (new WaterCastle());
        heroCastle.CastleSample.setTranslateX(400);
        heroCastle.CastleSample.setTranslateY(580);
        heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
        getBattlefieldController().getBattlefieldView().getChildren().add(heroCastle.CastleSample);
        int x = 10;
        for (int i = 0; i < 20; i++) {
            WaterHero waterHero = new WaterHero();
            waterHero.HeroSample.setTranslateX(x);
            waterHero.HeroSample.setTranslateY(550);
            waterHero.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(waterHero.HeroSample);
            heroes.add(waterHero);
            x += 54;
        }
        CreateEnemy();

        Chasing = Math.random();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(Chasing);
            }
        };
        timer.start();
        return getBattlefieldController().getBattlefieldView();
    }

    private Parent createAirBattleField() {
        setBattlefieldController(new BattlefieldController());
        heroCastle = new AirCastle();
        heroCastle.CastleSample.setTranslateX(400);
        heroCastle.CastleSample.setTranslateY(580);
        heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
        getBattlefieldController().getBattlefieldView().getChildren().add(heroCastle.CastleSample);
        int x = 10;
        for (int i = 0; i < 20; i++) {
            AirHero airHero = new AirHero();
            airHero.HeroSample.setTranslateX(x);
            airHero.HeroSample.setTranslateY(550);
            airHero.render(getBattlefieldController().getBattlefieldView().getContext());
            getBattlefieldController().getBattlefieldView().getChildren().add(airHero.HeroSample);
            heroes.add(airHero);
            x += 54;
        }
        CreateEnemy();
        Chasing = Math.random();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(Chasing);
            }
        };
        timer.start();
        return getBattlefieldController().getBattlefieldView();
    }

    private Parent createEarthBattleField() {
        setBattlefieldController(new BattlefieldController());
        heroCastle = new EarthCastle();
        heroCastle.CastleSample.setTranslateX(400);
        heroCastle.CastleSample.setTranslateY(580);
        heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
        getBattlefieldController().getBattlefieldView().getChildren().add(heroCastle.CastleSample);
        int x = 10;
        for (int i = 0; i < 20; i++) {
            EarthHero earthHero = new EarthHero();
            earthHero.HeroSample.setTranslateX(x);
            earthHero.HeroSample.setTranslateY(550);
            getBattlefieldController().getBattlefieldView().getChildren().add(earthHero.HeroSample);
            heroes.add(earthHero);
            x += 54;
        }
        CreateEnemy();
        Chasing = Math.random();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(Chasing);
            }
        };
        timer.start();
        return getBattlefieldController().getBattlefieldView();
    }

    private Parent createFireBattleField() {
        setBattlefieldController(new BattlefieldController());
        heroCastle = new FireCastle();
        heroCastle.CastleSample.setTranslateX(400);
        heroCastle.CastleSample.setTranslateY(580);
        heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
        getBattlefieldController().getBattlefieldView().getChildren().add(heroCastle.CastleSample);

        int x = 10;
        for (int i = 0; i < 20; i++) {
            FireHero fireHero = new FireHero();
            fireHero.HeroSample.setTranslateX(x);
            fireHero.HeroSample.setTranslateY(550);
            getBattlefieldController().getBattlefieldView().getChildren().add(fireHero.HeroSample);
            heroes.add(fireHero);
            x += 54;
        }
        CreateEnemy();
        Chasing = Math.random();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(Chasing);
            }
        };
        timer.start();
        return getBattlefieldController().getBattlefieldView();
    }

    public Parent ContinuePreviousGame() {
        setBattlefieldController(new BattlefieldController());
        getBattlefieldController().getBattlefieldView().getChildren().add(heroCastle.CastleSample);
        getBattlefieldController().getBattlefieldView().getChildren().add(enemyCastle.CastleSample);
        getBattlefieldController().getBattlefieldView().getChildren().add(enemyFakeCastle.CastleSample);

        for (int i = 0; i < heroes.size(); i++) {
            getBattlefieldController().getBattlefieldView().getChildren().add(heroes.get(i).HeroSample);
        }
        for (int i = 0; i < enemies.size(); i++) {
            getBattlefieldController().getBattlefieldView().getChildren().add(enemies.get(i).HeroSample);
        }

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(Chasing);
            }
        };
        timer.start();
        return getBattlefieldController().getBattlefieldView();
    }

    private void Continue() {
        Stage stage = new Stage();
        stage.setScene(new Scene(ContinuePreviousGame()));
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.show();
    }

    private void update(double y) {
        if (y >= 0.5) {
            chasingRightCastle();
        } else {
            chasingWrongCastle();
        }
        enemyAttack();
        Fight();
        movingPictures();
    }

    private void Fight() {
        heroes = returnHeroes();
        enemies = returnEnemies();
        for (Hero H : heroes) {
            for (Hero E : enemies) {
                if (Math.abs(H.HeroSample.getTranslateX() - E.HeroSample.getTranslateX()) < 5 && Math.abs(H.HeroSample.getTranslateY() - E.HeroSample.getTranslateY()) < 5) {
                    HeroDeath(H, E);
                }
                movingPictures();
            }
        }
        TheEnd();
        movingPictures();
    }

    private void HeroDeath(Hero hero, Hero enemy) {
        new Thread(() -> {
            hero.Live -= enemy.Power;
            enemy.Live -= hero.Power;
            if (hero.Live <= 0) {
                enemy.Score++;
                if (enemy.Score % 10 == 0) {
                    enemy.Live++;
                }
                Platform.runLater(() -> {
                    getBattlefieldController().getBattlefieldView().getChildren().remove(hero.HeroSample);
                    movingPictures();
                });
            }
            if (enemy.Live <= 0) {
                hero.Score++;
                if (hero.Score % 10 == 0) {
                    hero.Live++;
                }
                Platform.runLater(() -> {
                    getBattlefieldController().getBattlefieldView().getChildren().remove(hero.HeroSample);
                    movingPictures();
                });
            }
        }).start();
    }

    public void TheEnd() {
        if (!TypeController.change) {
            if (enemyCastle.Health <= 0 || enemies.size() == 0) {
                timer.stop();
                String win = "YOU WIN";
                HBox hBox = new HBox();
                hBox.setTranslateX(470);
                hBox.setTranslateY(250);
                getBattlefieldController().getBattlefieldView().getChildren().add(hBox);

                for (int j = 0; j < win.length(); j++) {
                    char letter = win.charAt(j);
                    Text text = new Text(String.valueOf(letter));
                    text.setFont(Font.font(48));
                    text.setOpacity(0);
                    hBox.getChildren().add(text);
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.65), text);
                    ft.setToValue(1);
                    ft.setDelay(Duration.seconds(j * 0.15));
                    ft.play();
                }
            }
        } else {
            if (enemyCastle.Health <= 0 || enemies.size() == 0) {
                newTimer.stop();
                String win = "YOU WIN";
                HBox hBox = new HBox();
                hBox.setTranslateX(470);
                hBox.setTranslateY(250);
                getBattlefieldController().getBattlefieldView().getChildren().add(hBox);

                for (int j = 0; j < win.length(); j++) {
                    char letter = win.charAt(j);
                    Text text = new Text(String.valueOf(letter));
                    text.setFont(Font.font(48));
                    text.setOpacity(0);
                    hBox.getChildren().add(text);
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.65), text);
                    ft.setToValue(1);
                    ft.setDelay(Duration.seconds(j * 0.15));
                    ft.play();
                }
            }
        }

        if (!TypeController.change) {
            if (heroCastle.Health <= 0 || heroes.size() == 0) {
                timer.stop();
                heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
                heroCastle.LeftLife.setText("LIFE : " + 0);
                getBattlefieldController().getBattlefieldView().getContext().fillText(heroCastle.LeftLife.getText(), heroCastle.CastleSample.getTranslateX(), heroCastle.CastleSample.getTranslateY());
                getBattlefieldController().getBattlefieldView().getContext().strokeText(heroCastle.LeftLife.getText(), heroCastle.CastleSample.getTranslateX(), heroCastle.CastleSample.getTranslateY());

                String win = "GAME OVER";
                HBox hBox = new HBox();
                hBox.setTranslateX(470);
                hBox.setTranslateY(250);
                getBattlefieldController().getBattlefieldView().getChildren().add(hBox);

                for (int j = 0; j < win.length(); j++) {
                    char letter = win.charAt(j);
                    Text text = new Text(String.valueOf(letter));
                    text.setFont(Font.font(48));
                    text.setOpacity(0);
                    hBox.getChildren().add(text);
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.65), text);
                    ft.setToValue(1);
                    ft.setDelay(Duration.seconds(j * 0.15));
                    ft.play();
                }
            }
        } else {
            if (heroCastle.Health <= 0 || heroes.size() == 0) {
                newTimer.stop();
                heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
                heroCastle.LeftLife.setText("LIFE : " + 0);
                getBattlefieldController().getBattlefieldView().getContext().fillText(heroCastle.LeftLife.getText(), heroCastle.CastleSample.getTranslateX(), heroCastle.CastleSample.getTranslateY());
                getBattlefieldController().getBattlefieldView().getContext().strokeText(heroCastle.LeftLife.getText(), heroCastle.CastleSample.getTranslateX(), heroCastle.CastleSample.getTranslateY());

                String win = "GAME OVER";
                HBox hBox = new HBox();
                hBox.setTranslateX(470);
                hBox.setTranslateY(250);
                getBattlefieldController().getBattlefieldView().getChildren().add(hBox);

                for (int j = 0; j < win.length(); j++) {
                    char letter = win.charAt(j);
                    Text text = new Text(String.valueOf(letter));
                    text.setFont(Font.font(48));
                    text.setOpacity(0);
                    hBox.getChildren().add(text);
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.65), text);
                    ft.setToValue(1);
                    ft.setDelay(Duration.seconds(j * 0.15));
                    ft.play();
                }
            }
        }
    }

    private void chasingRightCastle() {
        heroes = returnHeroes();
        enemies = returnEnemies();
        for (int i = heroes.size() - 1; i >= 0; i--) {
            if (Math.abs(heroes.get(i).HeroSample.getTranslateX() - enemyCastle.CastleSample.getTranslateX()) >= Math.abs(heroes.get(i).HeroSample.getTranslateY() - enemyCastle.CastleSample.getTranslateY())) {
                if (heroes.get(i).HeroSample.getTranslateX() >= enemyCastle.CastleSample.getTranslateX()) {
                    heroes.get(i).HeroSample.setTranslateX(heroes.get(i).HeroSample.getTranslateX() - heroes.get(i).Velocity);
                } else {
                    heroes.get(i).HeroSample.setTranslateX(heroes.get(i).HeroSample.getTranslateX() + heroes.get(i).Velocity);
                }
            } else {
                heroes.get(i).HeroSample.setTranslateY(heroes.get(i).HeroSample.getTranslateY() - heroes.get(i).Velocity);
            }

            if (Math.abs(heroes.get(i).HeroSample.getTranslateY() - enemyCastle.CastleSample.getTranslateY()) < 10 && Math.abs(heroes.get(i).HeroSample.getTranslateX() - enemyCastle.CastleSample.getTranslateX()) < 10) {
                enemyCastle.Health -= heroes.get(i).Power;
                getBattlefieldController().getBattlefieldView().getChildren().remove(heroes.get(i).HeroSample);
                TheEnd();
            }
            movingPictures();
        }
    }

    private void chasingWrongCastle() {
        heroes = returnHeroes();
        enemies = returnEnemies();
        for (int i = heroes.size() - 1; i >= 0; i--) {
            if (Math.abs(heroes.get(i).HeroSample.getTranslateX() - enemyFakeCastle.CastleSample.getTranslateX()) >= Math.abs(heroes.get(i).HeroSample.getTranslateY() - enemyFakeCastle.CastleSample.getTranslateY())) {
                if (heroes.get(i).HeroSample.getTranslateX() >= enemyFakeCastle.CastleSample.getTranslateX()) {
                    heroes.get(i).HeroSample.setTranslateX(heroes.get(i).HeroSample.getTranslateX() - heroes.get(i).Velocity);
                } else {
                    heroes.get(i).HeroSample.setTranslateX(heroes.get(i).HeroSample.getTranslateX() + heroes.get(i).Velocity);
                }
            } else {
                heroes.get(i).HeroSample.setTranslateY(heroes.get(i).HeroSample.getTranslateY() - heroes.get(i).Velocity);
            }
            if (Math.abs(heroes.get(i).HeroSample.getTranslateY() - enemyFakeCastle.CastleSample.getTranslateY()) < 10 && Math.abs(heroes.get(i).HeroSample.getTranslateX() - enemyFakeCastle.CastleSample.getTranslateX()) < 10) {
                enemyFakeCastle.Health -= heroes.get(i).Power;
                getBattlefieldController().getBattlefieldView().getChildren().remove(heroes.get(i).HeroSample);

                if (enemyFakeCastle.Health <= 0) {
                    TypeController.change = true;
                    timer.stop();
                    newTimer = new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            update(1);
                        }
                    };
                    newTimer.start();
                }
            }
        }
        movingPictures();
    }

    private void enemyAttack() {
        heroes = returnHeroes();
        enemies = returnEnemies();
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (Math.abs(enemies.get(i).HeroSample.getTranslateX() - heroCastle.CastleSample.getTranslateX()) >= Math.abs(enemies.get(i).HeroSample.getTranslateY() - heroCastle.CastleSample.getTranslateY())) {
                if (enemies.get(i).HeroSample.getTranslateX() >= heroCastle.CastleSample.getTranslateX()) {
                    enemies.get(i).HeroSample.setTranslateX(enemies.get(i).HeroSample.getTranslateX() - enemies.get(i).Velocity);
                } else {
                    enemies.get(i).HeroSample.setTranslateX(enemies.get(i).HeroSample.getTranslateX() + enemies.get(i).Velocity);
                }
            } else {
                enemies.get(i).HeroSample.setTranslateY(enemies.get(i).HeroSample.getTranslateY() + enemies.get(i).Velocity);
            }
            if (Math.abs(enemies.get(i).HeroSample.getTranslateY() - heroCastle.CastleSample.getTranslateY()) < 10 && Math.abs(enemies.get(i).HeroSample.getTranslateX() - heroCastle.CastleSample.getTranslateX()) < 10) {
                heroCastle.Health -= enemies.get(i).Power;
                getBattlefieldController().getBattlefieldView().getChildren().remove(enemies.get(i).HeroSample);
                TheEnd();
            }
            movingPictures();
        }
    }

    public void movingPictures() {

        getBattlefieldController().getBattlefieldView().getContext().setFill(Color.LIGHTGREEN);
        getBattlefieldController().getBattlefieldView().getContext().fillRect(0, 0, 1100, 700);
        getBattlefieldController().getBattlefieldView().getContext().setStroke(Color.RED);
        for (Hero x : heroes) {
            x.render(getBattlefieldController().getBattlefieldView().getContext());
            x.LeftLife.setText("LIFE : " + x.Live);
            getBattlefieldController().getBattlefieldView().getContext().fillText(x.LeftLife.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY());
            getBattlefieldController().getBattlefieldView().getContext().strokeText(x.LeftLife.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY());

            x.ScoreText.setText("SCORE : " + x.Score);
            getBattlefieldController().getBattlefieldView().getContext().fillText(x.ScoreText.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY() - 12);
            getBattlefieldController().getBattlefieldView().getContext().strokeText(x.ScoreText.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY() - 12);
        }
        for (Hero x : enemies) {
            x.render(getBattlefieldController().getBattlefieldView().getContext());
            x.LeftLife.setText("LIFE : " + x.Live);
            getBattlefieldController().getBattlefieldView().getContext().fillText(x.LeftLife.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY());
            getBattlefieldController().getBattlefieldView().getContext().strokeText(x.LeftLife.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY());

            x.ScoreText.setText("SCORE : " + x.Score);
            getBattlefieldController().getBattlefieldView().getContext().fillText(x.ScoreText.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY() - 12);
            getBattlefieldController().getBattlefieldView().getContext().strokeText(x.ScoreText.getText(), x.HeroSample.getTranslateX(), x.HeroSample.getTranslateY() - 12);
        }

        enemyCastle.render(getBattlefieldController().getBattlefieldView().getContext());
        enemyCastle.LeftLife.setText("LIFE : " + enemyCastle.Health);
        getBattlefieldController().getBattlefieldView().getContext().fillText(enemyCastle.LeftLife.getText(), enemyCastle.CastleSample.getTranslateX(), enemyCastle.CastleSample.getTranslateY());
        getBattlefieldController().getBattlefieldView().getContext().strokeText(enemyCastle.LeftLife.getText(), enemyCastle.CastleSample.getTranslateX(), enemyCastle.CastleSample.getTranslateY());

        if (!TypeController.change) {
            enemyFakeCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            enemyFakeCastle.LeftLife.setText("LIFE : " + enemyFakeCastle.Health);
            getBattlefieldController().getBattlefieldView().getContext().fillText(enemyFakeCastle.LeftLife.getText(), enemyFakeCastle.CastleSample.getTranslateX(), enemyFakeCastle.CastleSample.getTranslateY());
            getBattlefieldController().getBattlefieldView().getContext().strokeText(enemyFakeCastle.LeftLife.getText(), enemyFakeCastle.CastleSample.getTranslateX(), enemyFakeCastle.CastleSample.getTranslateY());
        } else {
            enemyFakeCastle.render(getBattlefieldController().getBattlefieldView().getContext());
            enemyFakeCastle.LeftLife.setText("LIFE : " + 0);
            getBattlefieldController().getBattlefieldView().getContext().fillText(enemyFakeCastle.LeftLife.getText(), enemyFakeCastle.CastleSample.getTranslateX(), enemyFakeCastle.CastleSample.getTranslateY());
            getBattlefieldController().getBattlefieldView().getContext().strokeText(enemyFakeCastle.LeftLife.getText(), enemyFakeCastle.CastleSample.getTranslateX(), enemyFakeCastle.CastleSample.getTranslateY());

        }
        heroCastle.render(getBattlefieldController().getBattlefieldView().getContext());
        heroCastle.LeftLife.setText("LIFE : " + heroCastle.Health);
        getBattlefieldController().getBattlefieldView().getContext().fillText(heroCastle.LeftLife.getText(), heroCastle.CastleSample.getTranslateX(), heroCastle.CastleSample.getTranslateY());
        getBattlefieldController().getBattlefieldView().getContext().strokeText(heroCastle.LeftLife.getText(), heroCastle.CastleSample.getTranslateX(), heroCastle.CastleSample.getTranslateY());

    }

    public TypeView getTypeView() {
        return this.typeView;
    }

    public void setTypeView(TypeView typeView) {
        this.typeView = typeView;
    }

    public BattlefieldController getBattlefieldController() {
        return battlefieldController;
    }

    public void setBattlefieldController(BattlefieldController battlefieldController) {
        this.battlefieldController = battlefieldController;
    }
}
