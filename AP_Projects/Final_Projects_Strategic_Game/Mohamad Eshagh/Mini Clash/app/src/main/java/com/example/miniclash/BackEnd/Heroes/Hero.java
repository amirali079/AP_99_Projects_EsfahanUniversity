package com.example.miniclash.BackEnd.Heroes;

import android.graphics.drawable.Drawable;

abstract public class Hero {
    protected int power, health, speed;

    protected int position;

    protected Drawable img;

    public Hero(int power, int health, int speed, Drawable img) {
        this.power = power;
        this.health = health;
        this.speed = speed;
        this.img = img;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public Drawable getImg() {
        return img;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
