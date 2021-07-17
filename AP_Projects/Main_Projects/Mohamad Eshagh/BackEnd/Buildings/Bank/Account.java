package com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank;    

import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Person;
import com.example.mohammad_es_faz4_gui.R;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

public class Account {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    private static ArrayList<Transaction> liveTransactions = new ArrayList<>();

    private final Person owner;

    private String username;
    private String password;
    private double balance;
    private final Bank bank;
    private long untilProfit;
    public Account(Person owner, String username, String password, double balance, Bank bank) {
        this.owner = owner;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.bank = bank;
        bank.getCity().setMoney(bank.getCity().getMoney() - balance);
        new Thread(this::profit).start();
    }
    public void profit(){
        while (true) {
            long monthSecondsInReal = 2592000;
            long monthMillisInGame = (monthSecondsInReal / Country.TIME_CHANGE_COEFFICIENT) * 1000;
            try {
                Thread.sleep(monthMillisInGame);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double profitAmount = (balance * 0.18) / 12;
            Transaction transaction = new Transaction(profitAmount,Type.PROFIT , this);
            transactions.add(transaction);
            if (Country.isTransactionsShown())
                liveTransactions.add(transaction);
            balance += profitAmount;
        }
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static void setLiveTransactions(ArrayList<Transaction> liveTransactions) {
        Account.liveTransactions = liveTransactions;
    }

    public static ArrayList<Transaction> getLiveTransactions() {
        return liveTransactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Bank getBank() {
        return bank;
    }

    public Person getOwner() {
        return owner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwords) {
        this.password = passwords;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double deposit){
        this.balance += deposit;
        bank.getCity().setMoney(bank.getCity().getMoney() - deposit);
        this.transactions.add(new Transaction(deposit, Type.DEPOSIT, this));
    }

    public void withdraw(double withdraw){
        this.balance -= withdraw;
        bank.getCity().setMoney(bank.getCity().getMoney() + withdraw);
        this.transactions.add(new Transaction(withdraw, Type.WITHDRAW, this));
    }

    public long getUntilProfit() {
        return untilProfit;
    }

    public void setUntilProfit(long untilProfit) {
        this.untilProfit = untilProfit;
    }
}