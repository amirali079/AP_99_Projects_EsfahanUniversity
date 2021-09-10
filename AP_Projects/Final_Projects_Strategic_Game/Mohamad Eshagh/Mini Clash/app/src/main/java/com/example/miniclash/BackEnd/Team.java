package com.example.miniclash.BackEnd;

import com.example.miniclash.BackEnd.Castle.Castle;
import com.example.miniclash.BackEnd.Heroes.Hero;

import java.util.ArrayList;

public class Team {
    private ArrayList<Hero> heroes = new ArrayList<>();

    private Castle castle;

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public Castle getCastle() {
        return castle;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }
}
