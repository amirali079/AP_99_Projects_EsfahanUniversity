package com.example.miniclash.BackEnd.Castle;

import android.graphics.drawable.Drawable;

public class Castle {
    protected int health, power, position;

    protected Drawable img;

    public Castle(int health, int power, Drawable img) {
        this.health = health;
        this.power = power;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
