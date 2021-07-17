package Main.Bank;
import Main.City;
import Main.ConsoleColors;
import Main.Country;
import Main.Graphics.FinancialManagement;
import Main.Person;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;



public class BankAccount implements Serializable {
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private double AccountBalance;
    private Person TheAccountHolder;
    private String Username;
    private String Password;
    private long Time_Left_until_the_next_profitability_of_the_account;
    private String Gmail;
    private boolean isThreadAlive=true;
    public static boolean isEntered=false;
    String cityName;
    Bank bank;

    public BankAccount(double accountBalance, Person theAccountHolder, String username, String password,String Gmail,String cityName,Bank bank) {
        AccountBalance = accountBalance;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction=new Transaction(accountBalance,dtf.format(now),TypeOfTransaction.Deposit);
        transactions.add(transaction);
        TheAccountHolder = theAccountHolder;
        Username = username;
        Password = password;
        Country.Total_money_of_all_accounts+=accountBalance;
        this.Gmail=Gmail;
        this.cityName=cityName;
        this.bank=bank;
        this.bank.AddBankAccount(this);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public Person getTheAccountHolder() {
        return TheAccountHolder;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public long getTime_Left_until_the_next_profitability_of_the_account() {
        return Time_Left_until_the_next_profitability_of_the_account;
    }

    public String getGmail() {
        return Gmail;
    }

    public boolean isThreadAlive() {
        return isThreadAlive;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public void setTheAccountHolder(Person theAccountHolder) {
        TheAccountHolder = theAccountHolder;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setTime_Left_until_the_next_profitability_of_the_account(long time_Left_until_the_next_profitability_of_the_account) {
        Time_Left_until_the_next_profitability_of_the_account = time_Left_until_the_next_profitability_of_the_account;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public void setThreadAlive(boolean threadAlive) {
        isThreadAlive = threadAlive;
    }

    public void profitCalculate(){
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    while (isThreadAlive) {
                            Time_Left_until_the_next_profitability_of_the_account = 60;
                        try {
                            for (int i = 0; i < 60; i++) {
                                Thread.sleep(1000);
                                Time_Left_until_the_next_profitability_of_the_account--;
                            }
                            double previousMoney=AccountBalance;
                            double profit = 0.18 * AccountBalance;
                            AccountBalance += profit;
                            Country.Total_money_of_all_accounts += profit;

                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();

                            Transaction transaction = new Transaction(profit, dtf.format(now), TypeOfTransaction.BankInterest);
                            transactions.add(transaction);
                            setTime_Left_until_the_next_profitability_of_the_account(60);

                            if (BankAccount.isEntered){
                                String info=String.format("Name : %s %s , Bank : %s , City : %s , Previous Money : %f , Account Balance : %f , %s",getTheAccountHolder().getName(),getTheAccountHolder().getFamily(),bank.getBankName(),cityName,previousMoney,AccountBalance,transaction.toString());
                                FinancialManagement.holdTransactionInfo.add(info);
                            }
                        } catch (Exception exception) {
                        }
                    }
                }
            }
        });
        thread.start();
    }
    public void sendGmail(){
        String recepient=Gmail;
        Properties p=new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");

        String myAccountEmail="electroniccityproject@gmail.com";
        String password="ElectronicCityProject1234";

        Session session = Session.getInstance(p,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        } );
        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Bank Account Password Restoration");
            message.setText("Hi Dear "+TheAccountHolder.getName()+" "+TheAccountHolder.getFamily()+"\nUsername : "+getUsername()+" , Password : "+getPassword());
            Transport.send(message);

        }catch(Exception e){
            e.printStackTrace();
        }
        try{
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

