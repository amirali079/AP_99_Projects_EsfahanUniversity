package Ragnargame;

import javax.swing.*;
import java.awt.*;

public class Hero extends JLabel {
    int Health;
    int Power;
    int Speed;
    String Team;
    int x;
    int y;
    ImageIcon img;
    int Score=0;
    public Hero(int Health, int Power, int Speed, String Team, int x, int y) {
        this.Health = Health;
        this.Power = Power;
        this.Speed = Speed;
        this.Team = Team;
        this.x = x;
        this.y = y;
    }
    
    public void attack(Hero enemy) {
        enemy.setHealth(enemy.getHealth() - this.getPower());
        Score++;
    }

    public void attack(Castle enemy) {
        enemy.setHealth(enemy.getHealth() - this.getPower());
        Score++;
    }

    public void moveTo(int x, int y) {

        int dx = this.x - x;
        int dy = this.y - y;

        int abs_dx = Math.abs(dx);
        int abs_dy = Math.abs(dy);

        if (abs_dx > abs_dy) {
            if (dx < 0) this.x += Speed;
            else this.x -= Speed;

        } else {
            if (dy < 0) this.y += Speed;
            else this.y -= Speed;
        }

    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public boolean catches(int x, int y) {
        return Math.abs(this.x - x) < 60 &&
                Math.abs(this.y - y )  < 60;
    }

    public boolean isEnemy(Hero hero) {
        return !this.Team.equals(hero.Team);
    }
    public int getScore(){
        return Score;
    }
    public void setScore(int Score){
        this.Score = Score;
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(img.getImage(), x, y, null);
    }
    

}