import javax.swing.*;

public class Hero {
    private int health;
    private final int speed, power;
    private int x, y;
    public boolean define;
    JButton jb;
    int team;

    public Hero(int health, int speed, int power, int x, int y, boolean a, Icon icn, int v) {
        this.health = health;
        this.speed = speed;
        this.power = power;
        this.x = x;
        this.y = y;
        this.define = a;
        jb = new JButton(icn);
        this.team = v;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x;
    }

    public void setX2(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y += y;
    }

    public void setY2(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public void setHealth2(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }

    public void stop() {

    }
}
