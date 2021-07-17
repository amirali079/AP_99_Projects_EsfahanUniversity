package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

final public class ShippingPort extends Terminal {
    private final LinkedList<Vehicle> marineVehicles = new LinkedList<>();
    private final int numberOfDocks;
    private static boolean isFirstShippingPort = true;

    public ShippingPort(City city, String name, String address, int orderNumber, int ID) throws IOException, NotEnoughMoneyException {
        super(city.getName(), name, address, ID);
        ArrayList<String> properties = Country.sellListReader("ShippingPort.csv", orderNumber);
        this.area = Double.parseDouble(properties.get(1));
        this.maxVehicle = Integer.parseInt(properties.get(2));
        this.numberOfDocks = Integer.parseInt(properties.get(3));
        this.constructionCost = Double.parseDouble(properties.get(4));
        this.constructionCost *=  (1 - (isFirstShippingPort ? 0.15 : 0));
        if (city.getMoney() < this.constructionCost)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.constructionCost);
        isFirstShippingPort = false;
    }
    public ShippingPort(City city, String name, String address, int orderNumber) throws IOException, NotEnoughMoneyException {
        this(city, name, address, orderNumber, numberOfCreatedTerminal++);
    }

        @Override
    public String toString(){
        return super.toString() +
                "\nNumber of docks : " + this.numberOfDocks +
                "\nNumber of vehicle : " + this.marineVehicles.size() +
                "\nConstruction cost : " + this.constructionCost;
    }

    @Override
    public LinkedList<Vehicle> getVehicles() {
        return marineVehicles;
    }

    public int getNumberOfDocks() {
        return numberOfDocks;
    }
}