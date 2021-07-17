package Main;

import Main.Buildings.Bank.Bank;
import Main.Buildings.*;
import Main.Exceptions.InvalidID;
import Main.Exceptions.InvalidInput;
import Main.Exceptions.NoTerminal;
import Main.controller.mainPage;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {


    transient private mainPage cityPage;
    private final int cityID;
    private final String name;
    private int Inventory = 10000;
    private int population = 0;
    private int HotelSize;
    private int TerminalSize = 0;
    private int BankSize;
    private double totalMoney = 0;

    public void plusTotalMoney(double totalMoney) {
        this.totalMoney += totalMoney;
        if (cityPage != null) {
            cityPage.setBankMoney(this.totalMoney);
        }
    }

    public void removeTotalMoney(double totalMoney) {
        this.totalMoney -= totalMoney;
        if (cityPage != null) {
            cityPage.setBankMoney(this.totalMoney);
        }
    }

    public City(String name) {
        cityID = Country.country.getNumOfCities();
        this.name = name;
    }

    public void setCityPage(mainPage cityPage) {
        this.cityPage = cityPage;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public String getName() {
        return name;
    }

    public int getCityID() {
        return cityID;
    }

    public enum Cost {
        Locomotive_driver(50), Train(200), Railway(450), Pilot(60), CargoPlane(200), AirPort(450), Crew(20), PassengerPlane(300), Hotel(450), Bank(250),
        Sailor(40), Boat(60), ShippingPort(400), Bus_driver(30), Bus(100), BusTerminal(270), Ship(350), Room(50), Hotelservices(30), train_services(20);

        private final double cost;

        Cost(double cost) {
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }

    }

    private final ArrayList<Person> Citizens = new ArrayList<>();
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    private final ArrayList<Terminal> terminals = new ArrayList<>();
    private final ArrayList<Bank> Banks = new ArrayList<>();

    public int getPopulation() {
        return population;
    }

    public int getInventory() {
        return Inventory;
    }

    public mainPage getCityPage() {
        return cityPage;
    }

    public int getHotelSize() {
        return HotelSize;
    }

    public int getTerminalSize() {
        return TerminalSize;
    }

    public int getBankSize() {
        return BankSize;
    }

    public void addInventory(double get) {
        Inventory += get;
        if (cityPage != null) {
            cityPage.setInventory(this.Inventory);
        }
    }

    public void setInventory(double spent) {
        Inventory -= spent;
        if (cityPage != null) {
            cityPage.setInventory(this.Inventory);
        }
    }

    public ArrayList<Bank> getBanks() {
        return Banks;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<Terminal> getTerminals() {
        return terminals;
    }

    public ArrayList<Person> getCitizens() {
        return Citizens;
    }

    public void addBank(String name) {
        if (name.length() >= 4) {
            for (Bank x : this.Banks) {
                if (x.getName().equals(name)) throw new InvalidInput("Error !");
            }
            this.Banks.add(new Bank(name, this));
            this.BankSize = Banks.size();
            Country.country.save();
        } else throw new InvalidInput("Error !");
    }

    public void addPerson(Person person) {
        this.Citizens.add(person);
        population = this.Citizens.size();
    }

    public void removePerson(Person person) {
        this.Citizens.remove(person);
        population = this.Citizens.size();
    }

    public void addCitizens(ArrayList<Person> people) {
        this.Citizens.addAll(people);
        population = this.Citizens.size();
    }

    public void removeCitizens(ArrayList<Person> people) {
        this.Citizens.removeAll(people);
        population = this.Citizens.size();
    }

    public void addHotels(Hotel hotel) {
        Country.country.setNumOfHotels();
        this.hotels.add(hotel);
        this.HotelSize = hotels.size();
        Country.country.save();
    }


    public void addRailway_station(String name, String address, int area, int input_rails, int output_rails) {
        Country.country.setNumOfTerminals();
        terminals.add(new Railway_station(name, this, address, area, input_rails, output_rails));
        ++this.TerminalSize;
        Country.country.save();
    }

    public void addAirport(String name, String address, int area, int number_of_runways, boolean international) {
        Country.country.setNumOfTerminals();
        terminals.add(new Airport(name, this, address, area, number_of_runways, international));
        ++this.TerminalSize;
        Country.country.save();
    }

    public void addBus_Terminal(String name, String address, int area) {
        Country.country.setNumOfTerminals();
        terminals.add(new Bus_Terminal(name, this, address, area));
        ++this.TerminalSize;
        Country.country.save();
    }

    public void addShipping_port(String name, String address, int area, int piers) {
        Country.country.setNumOfTerminals();
        terminals.add(new Shipping_port(name, this, address, area, piers));
        ++this.TerminalSize;
        Country.country.save();
    }
}

