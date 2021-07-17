package Main.Bank;

import Main.ConsoleColors;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Bank implements Serializable {
    private final ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private String BankName;
    private double Total_money_in_circulation_bank;
    private int Number_of_active_bank_accounts;

    public Bank(String bankName) {
        BankName = bankName;

    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public String getBankName() {
        return BankName;
    }

    public double getTotal_money_in_circulation_bank() {
        return Total_money_in_circulation_bank;
    }

    public int getNumber_of_active_bank_accounts() {
        return Number_of_active_bank_accounts;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public void setTotal_money_in_circulation_bank(double total_money_in_circulation_bank) {
        Total_money_in_circulation_bank = total_money_in_circulation_bank;
    }

    public void setNumber_of_active_bank_accounts(int number_of_active_bank_accounts) {
        Number_of_active_bank_accounts = number_of_active_bank_accounts;
    }

    public void AddBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
        Total_money_in_circulation_bank+=bankAccount.getAccountBalance();
    }

    public BankAccount validateBankAccount(String username,String password){
        BankAccount bankAccount=null;
        boolean found=false;
        for (int i=0;i<bankAccounts.size();i++){
            if (bankAccounts.get(i).getUsername().equals(username)&&bankAccounts.get(i).getPassword().equals(password)){
                bankAccount= bankAccounts.get(i);
                found=true;

            }
        }
        if (!found){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"ERROR : WRONG INFORMATION! PLEASE TRY AGAIN LATER"+ConsoleColors.RESET);
            Toolkit.getDefaultToolkit().beep();
        }
        return bankAccount;
    }
    public double calculateTotal_money_in_circulation_bank(){
        Total_money_in_circulation_bank=0;
        for (int i=0;i<bankAccounts.size();i++){
            Total_money_in_circulation_bank+=bankAccounts.get(i).getAccountBalance();
        }
        return Total_money_in_circulation_bank;
    }
    public int calculateNumber_of_active_bank_accounts(){
        int count=0;
        for (int i=0;i<bankAccounts.size();i++){
            if (bankAccounts.get(i).isThreadAlive()){
                count++;
            }
            Number_of_active_bank_accounts=count;
        }
        return count;
    }
    public String bankInfo(){

        return String.format(ConsoleColors.RED_BRIGHT+"BankName : %s , Total money in circulation bank : %f , Number of active bank accounts : %d\n"+ConsoleColors.RESET,getBankName(),calculateTotal_money_in_circulation_bank(),calculateNumber_of_active_bank_accounts());

    }

}
