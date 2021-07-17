package Main;

import Main.Buildings.Bank.Transaction;
import Main.Exceptions.InvalidID;
import Main.Exceptions.InvalidInput;
import Main.Exceptions.InvalidName;
import Main.controller.CountryPage;
import Main.controller.Manage;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


public class Country implements Serializable {

    transient private CountryPage countryPage;
    transient private Manage manage;
    private final ArrayList<City> cities = new ArrayList<>();
    private final ArrayList<Person> Citizens = new ArrayList<>();
    private Transaction transaction;
    public static Country country;
    private LocalDateTime Time;
    public City inputCity;
    private int NumOfCities = 0;
    private int NumOfVehicles = 0;
    private int NumOfHotels = 0;
    private int NumOfTerminals = 0;
    private int NumOfTravels = 0;
    private int Inventory = 0;
    private int population = 0;
    private File data;

    public LocalDateTime getTime() {
        return Time;
    }

    public Country(File data) {
        this.data = data;
        this.Time = LocalDateTime.now();
        StartTime();
    }

    public void addPerson(String name, String family, String birthplace, Person.Job job, int birthYear, double employment_rights, Person.Gender gender) {
        Citizens.add(new Person(name, family, birthplace, job, birthYear, employment_rights, gender));
    }

    public void addTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void addCity(String cityName) {
        if (cityName.length() < 4) throw new InvalidName();
        ++NumOfCities;
        cities.add(new City(cityName));
        this.Inventory += 10000;
        if (countryPage != null) {
            countryPage.setInventory();
        }
        this.save();
    }

    public City getCities(int id) {
        for (City x : cities) {
            if (x.getCityID() == id) {
                return x;
            }
        }
        throw new InvalidID();
    }

    public City getCities(String name) {
        for (City x : cities) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        throw new InvalidInput("City name Not Valid!");
    }

    public void setPopulation() {
        ++population;
    }

    public void setCountryPage(CountryPage countryPage) {
        this.countryPage = countryPage;
    }

    public CountryPage getCountryPage() {
        return countryPage;
    }

    public int getInventory() {
        return Inventory;
    }

    public int getPopulation() {
        return population;
    }

    public int getNumOfCities() {
        return NumOfCities;
    }

    public int getNumOfVehicles() {
        return NumOfVehicles;
    }

    public int getNumOfHotels() {
        return NumOfHotels;
    }

    public int getNumOfTerminals() {
        return NumOfTerminals;
    }

    public int getNumOfTravels() {
        return NumOfTravels;
    }

    public void setNumOfVehicles() {
        ++NumOfVehicles;
    }

    public void setNumOfHotels() {
        ++NumOfHotels;
    }

    public void setNumOfTerminals() {
        ++NumOfTerminals;
    }

    public void setNumOfTravels() {
        ++NumOfTravels;
    }

    public Manage getManage() {
        return manage;
    }

    public void setManage(Manage manage) {
        this.manage = manage;
    }

    public ArrayList<Person> getCitizens() {
        return Citizens;
    }

    public void plusCountryInventory(double inventory) {
        this.Inventory += inventory;
        if (countryPage != null) {
            countryPage.setInventory();
        }
    }

    public void removeCountryInventory(double inventory) {
        this.Inventory -= inventory;
        if (countryPage != null) {
            countryPage.setInventory();
        }
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public synchronized void save() {
        try {
            ObjectOutputStream Ob = new ObjectOutputStream(new FileOutputStream(data.getAbsolutePath()));
            Ob.writeObject(this);
            Ob.close();
        } catch (IOException ioException) {
            ioException.getStackTrace();
        }
    }

    public void StartTime() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                Time = Time.plusDays(1).plusSeconds(1);
            }
        }).start();
    }

}


