package Main.Buildings.Bank;

import Main.*;
import Main.Exceptions.*;

import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount implements Serializable {
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private String password;
    private String username;
    private final String owner;
    private double Inventory;
    private int remainTime;    //Remaining time to profitability
    private final Bank Bank;
    private final String bankName;
    private Boolean Active = false;

    public BankAccount(String password, String username, Person owner, double inventory, Bank bank) {
        this.password = password;
        this.username = username;
        this.owner = owner.getName() + " " + owner.getFamily();
        this.Inventory = inventory;
        this.Bank = bank;
        this.bankName = bank.getName();
        Operation();
    }

    public Bank getBank() {
        return Bank;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getOwner() {
        return owner;
    }

    public double getInventory() {
        return Inventory;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public String getBankName() {
        return bankName;
    }

    public void activate() {
        this.Active = true;
    }

    public void deActivate() {
        this.Active = false;
    }

    public Boolean getActive() {
        return Active;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.Inventory += amount;
            this.Bank.increaseTotalMoney(amount);
            this.Bank.getCity().plusTotalMoney(amount);
            Transaction tr = new Transaction(amount, Transaction.Type.Deposit, this);
            this.transactions.add(tr);
            Country.country.addTransaction(tr);
            add(tr);
            Country.country.save();
        } else throw new InvalidInput("Error : Invalid request!");
    }

    public void withdrawal(double amount) {
        if (amount <= this.Inventory) {
            this.Inventory -= amount;
            this.Bank.decreaseTotalMoney(amount);
            this.Bank.getCity().removeTotalMoney(amount);
            Transaction tr = new Transaction(amount, Transaction.Type.Withdrawal, this);
            this.transactions.add(tr);
            Country.country.addTransaction(tr);
            add(tr);
            Country.country.save();
        } else throw new InvalidInput("Error : Invalid request!");
    }


    public void Operation() {

        new Thread(() -> {
            while (true) {
                try {
                    this.remainTime = 60;
                    for (int i = 0; i < 60; i++) {
                        --this.remainTime;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                if (this.Inventory > 0) {
                    this.activate();
                    double profit = this.Inventory * 0.18;
                    Transaction tr = new Transaction(profit, Transaction.Type.Profit, this);
                    this.transactions.add(tr);
                    this.Inventory += profit;
                    this.Bank.increaseTotalMoney(profit);
                    this.Bank.getCity().plusTotalMoney(profit);
                    add(tr);
                    Country.country.save();
                }else {
                    this.deActivate();
                }
                this.Bank.getActiveAccount();
            }
        }).start();
    }


    public void add(Transaction tr){
        if (Country.country.getManage() != null){
            Country.country.getManage().addTransaction(tr);
        }
    }
}
