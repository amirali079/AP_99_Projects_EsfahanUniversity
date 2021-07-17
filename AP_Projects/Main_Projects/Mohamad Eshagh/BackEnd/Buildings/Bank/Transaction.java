package com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank;

import com.example.mohammad_es_faz4_gui.BackEnd.Country;

import java.util.Date;

public class Transaction{
    private double amount;
    private Date date;
    private final Type type;
    private final Account account;

    public Transaction(double amount, Type type, Account account){
        this.amount = amount;
        this.type = type;
        this.account = account;
        date = new Date(Country.gameDate(System.currentTimeMillis()));
    }

    @Override
    public String toString(){
        return "Amount : " + amount + " - Type : " + type + "\nDate : " + Country.toStringDate(date);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }
}