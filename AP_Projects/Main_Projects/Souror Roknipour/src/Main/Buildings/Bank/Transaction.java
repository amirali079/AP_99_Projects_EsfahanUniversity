package Main.Buildings.Bank;

import Main.Country;

import javax.swing.text.DateFormatter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Transaction implements Serializable {
    private final double amount;
    private final String type;
    private final String date;
    private final String accountUser;
    private final String bank;
    private final String city;


    enum Type {
        Deposit, Withdrawal, Profit
    }

    public Transaction(double amount, Type type, BankAccount bankAccount) {
        this.amount = amount;
        this.type = type.toString();
        this.accountUser = bankAccount.getUsername();
        this.bank = bankAccount.getBank().getName();
        this.city = bankAccount.getBank().getCityName();

        LocalDateTime dateTime = Country.country.getTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        this.date = formatter.format(dateTime);
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public String getBank() {
        return bank;
    }

    public String getCity() {
        return city;
    }
}
