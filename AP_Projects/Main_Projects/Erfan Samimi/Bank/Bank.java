package Main.Bank;

import java.util.ArrayList;

public class Bank {

    ArrayList<BankAccount> accounts = new ArrayList<>();
    private String name ;
    private double totalMoney = getTotalMoney();
    private int activeAccounts = getActiveAccounts();


    public Bank(String name){
        this.name = name;
    }




    public int  getActiveAccounts(){
        int counter =0;

        for (BankAccount a : this.accounts){
            if (a.accountBalance != 0)
                counter ++;
        }


        return counter;
    }

    public double getTotalMoney(){

        double money = 0;
        for(BankAccount a : this.accounts)
            money += a.accountBalance;

        return money;
    }

    //========================================

    public String getName(){
        return this.name;
    }

    public void addAccount( BankAccount account ){
        this.accounts.add(account);
    }

    public ArrayList<BankAccount> getAccounts(){
        return this.accounts;
    }
}
