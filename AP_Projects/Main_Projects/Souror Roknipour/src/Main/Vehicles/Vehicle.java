package Main.Vehicles;

import Main.Country;

import java.io.Serializable;

abstract public class Vehicle implements Serializable {

    private final double price;
    private final int ID;
    private final int Capacity;
    private final String company;

    public Vehicle(double price, int capacity, String company) {

        this.price = price;
        Country.country.inputCity.setInventory(price);
        Country.country.removeCountryInventory(price);
        this.ID = Country.country.getNumOfVehicles();
        Capacity = capacity;
        this.company = company;
        Country.country.save();
    }

    public int getID() {
        return ID;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

