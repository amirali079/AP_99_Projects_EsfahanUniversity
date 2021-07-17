import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public abstract class Hero {

    private final int Power;
    private int Health;
    private final int Speed;
    public int x_pixel, y_pixel;
    private Image bg;
    private JProgressBar bar;

    public Hero(int power, int health, int speed, int x, int y , String address) {
        Power = power;
        Health = health;
        Speed = speed;
        x_pixel = x;
        y_pixel = y;
        bar = new JProgressBar(0 , Health);
        bar.setValue(Health);
        bar.setSize(30 , 10);
        bar.setLocation(x_pixel , y_pixel);
        bar.setForeground(Color.MAGENTA);
        bg = new ImageIcon(address).getImage();
    }

    public void changeScore(HashMap<Hero , String> players , ScorePage scorePage) {
        if (scorePage != null) {
            if (players.get(this).equals("t1")) {
                Game.T1Score += Power;
                scorePage.getT1LBL().setText("Team 1 : " + Game.T1Score);
                if (this instanceof Fire) {
                    Game.FireT1 += Power;
                    scorePage.getF1s().setText("SCORE : " + Game.FireT1);
                }
                if (this instanceof Earth) {
                    Game.EarthT1 += Power;
                    scorePage.getE1s().setText("SCORE : " + Game.EarthT1);
                }
                if (this instanceof Ice) {
                    Game.IceT1 += Power;
                    scorePage.getI1s().setText("SCORE : " + Game.IceT1);
                }
                if (this instanceof Wind) {
                    Game.WindT1 += Power;
                    scorePage.getW1s().setText("SCORE : " + Game.WindT1);
                }
            } else {
                Game.T2Score += Power;
                scorePage.getT2LBL().setText("Team 2 : " + Game.T2Score);
                if (this instanceof Fire) {
                    Game.FireT2 += Power;
                    scorePage.getF2s().setText("SCORE : " + Game.FireT2);
                }
                if (this instanceof Earth) {
                    Game.EarthT2 += Power;
                    scorePage.getE2s().setText("SCORE : " + Game.EarthT2);
                }
                if (this instanceof Ice) {
                    Game.IceT2 += Power;
                    scorePage.getI2s().setText("SCORE : " + Game.IceT2);
                }
                if (this instanceof Wind) {
                    Game.WindT2 += Power;
                    scorePage.getW2s().setText("SCORE : " + Game.WindT2);
                }
            }
        }
    }

    public JProgressBar getBar() {
        return bar;
    }

    public void paint(Graphics g) {
        g.drawImage(bg , x_pixel, y_pixel, 100, 100 , null);
    }

    public void startMove(Castle castle , HashMap<Hero , String> players , gamePage gPage) {
        new Thread(() -> {
            while (Health > 0 && Game.status) {
                gPage.getCanvas().add(bar);
                move(castle);
                bar.setLocation(x_pixel ,y_pixel);
                gPage.repaint();
                // check for fight and fight
                Hero temp = checkFight(players);
                if (temp != null && Game.status) {
                    fight(temp , players , gPage);
                    continue; // دور بعدی حلقه اصلی و انجام دادن حرکت رو به جلو
                }
                // if hero arrived to castle
                if (Math.abs(castle.getX() - x_pixel) < 70 && Math.abs(castle.getY() - y_pixel) < 70 && Health > 0 && Game.status) {
                    damageCastle(castle , players , gPage);
                }
                // sleep after every move
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Health <= 0) {
                bg = new ImageIcon("grave.png").getImage();
                bar.setLocation(2000 , 2000);
                gPage.repaint();
                players.remove(this);
            }
        }).start();
    }

    private void move(Castle castle) {
        if (Math.abs(castle.getX() - x_pixel) >= Math.abs(castle.getY() - y_pixel)) {
            if (Math.abs(castle.getX() - x_pixel) < 2) {
                if (castle.getX() >= x_pixel) x_pixel += 5;
                else x_pixel -= 5;
            }
            else {
                if (castle.getX() >= x_pixel) x_pixel += 5 * Speed;
                else x_pixel -= Speed * 5;
            }
        } else {
            if (Math.abs(castle.getY() - y_pixel) < 2) {
                if (castle.getY() >= y_pixel) y_pixel += 5;
                else y_pixel -= 5;
            }
            else {
                if (castle.getY() >= y_pixel) y_pixel += Speed * 5;
                else y_pixel -= Speed * 5;
            }
        }
    }

    private void fight(Hero temp ,HashMap<Hero , String> players , gamePage gPage) {
        while (Game.status) {
            // شرط خروج از حلقه مبارزه
            if (Health <= 0) break;
            if (temp == null || temp.getHealth() <= 0) break;
            // انجام مبارزه
            temp.setHealth(temp.getHealth() - Power);
            temp.getBar().setValue(temp.Health);
            changeScore(players , gPage.scorePage);
            // اضافه شدن امتیاز و اپدیت کردن ضفحه
            temp = checkFight(players);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void damageCastle(Castle castle , HashMap<Hero , String> players , gamePage gPage) {
        while (castle.getHealth() > 0 && Game.status) {
            castle.setHealth(castle.getHealth() - Power);
            castle.getBar().setValue(castle.getHealth());
            changeScore(players , gPage.scorePage);
            // اضافه شدن امتیاز و اپدیت کردن ضفحه
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (castle.getHealth() <= 0)
            Game.status = false;
    }

    private Hero checkFight(HashMap<Hero , String> players) {
        for (Hero x : players.keySet())
            if ((Math.abs(x.getX() - this.getX()) < 50 && Math.abs(x.getY() - this.getY()) < 50)
                    && x.getHealth() > 0 && !(players.get(x).equals(players.get(this))) )
                return x;
        return null;
    }

    synchronized public int getHealth() {
        return Health;
    }

    synchronized public void setHealth(int health) {
        Health = health;
    }

    public int getX() {
        return x_pixel;
    }

    public int getY() {
        return y_pixel;
    }
}