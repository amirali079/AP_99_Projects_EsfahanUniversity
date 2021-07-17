package com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank;

import com.example.mohammad_es_faz4_gui.BackEnd.City;

import java.util.ArrayList;

public class Bank{
    private final ArrayList<Account> accounts = new ArrayList<>();
    private final City city;
    private final String name;
    private double allMoney;
    protected static int numberOfCreatedBank = 0;
    private final int ID;

    public Bank(City city, String name) {
        this.city = city;
        this.name = name;
        this.ID = ++numberOfCreatedBank;
    }

    @Override
    public String toString(){
        return "\nCity : " + this.city +
                "\nBank Name : " + this.name +
                "\nAll money : " + this.allMoney;
    }

    public int getID() {
        return ID;
    }

    public City getCity() {
        return city;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public double getAllMoney() {
        allMoney = 0;
        for (Account bank : accounts)
            allMoney += bank.getBalance();
        return allMoney;
    }
}