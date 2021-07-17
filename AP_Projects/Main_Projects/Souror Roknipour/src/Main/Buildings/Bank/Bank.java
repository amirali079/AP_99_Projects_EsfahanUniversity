package Main.Buildings.Bank;

import Main.City;
import Main.Country;
import Main.Exceptions.InvalidInput;
import Main.Person;
import Main.controller.mainPage;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {

    private final String name;
    private final City City;
    private final String CityName;
    private double totalMoney = 0;
    private int activeAccounts;

    private final ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Bank(String name, City city) {
        this.name = name;
        this.City = city;
        this.CityName = this.City.getName();
        getActiveAccount();
    }

    public void createAccount(String password, String username, Person owner, double inventory) {
        if (inventory == 0.0) throw new InvalidInput("amount can not be 0!");
        if (username.length() >= 4 && password.length() >= 6) {
            for (BankAccount x : this.bankAccounts) {
                if (x.getUsername().equals(username)) {
                    throw new InvalidInput("This user Already taken by another one!");
                }
            }
            BankAccount account = new BankAccount(password, username, owner, inventory, this);
            this.bankAccounts.add(account);
            account.activate();
            this.increaseTotalMoney(inventory);
            this.getCity().plusTotalMoney(inventory);
            Country.country.save();
        } else throw new InvalidInput("Error : user must have 4 & pass must have 6 Character !");
    }

    public BankAccount getBankAccount(String user, String pass) {
        for (BankAccount x : this.bankAccounts) {
            if (x.getPassword().equals(pass) && x.getUsername().equals(user)) {
                return x;
            }
        }
        throw new InvalidInput("Error : wrong username or password !");
    }

    public void getActiveAccount() {
        int num = 0;
        for (BankAccount x : bankAccounts) {
            if (x.getActive()) {
                ++num;
            }
        }
        this.activeAccounts = num;
    }


    public String getName() {
        return name;
    }

    public String getCityName() {
        return CityName;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public int getActiveAccounts() {
        return activeAccounts;
    }

    public void increaseTotalMoney(double amount) {
        this.totalMoney += amount;
    }

    public void decreaseTotalMoney(double amount) {
        this.totalMoney -= amount;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public City getCity() {
        return City;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
