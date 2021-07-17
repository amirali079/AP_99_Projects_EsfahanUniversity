package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

final public class Airport extends Terminal implements Serializable {
    private final LinkedList<Vehicle> airVehicles = new LinkedList<>();

    private final int airstripLength;
    private static boolean isFirstAirport = true;
    private final boolean type;

    public Airport(City city, String name, String address, int orderNumber, int ID) throws IOException, NotEnoughMoneyException {
        super(city.getName(), name, address, ID);
        ArrayList<String> properties = Country.sellListReader("Airport.csv", orderNumber);
        this.type = properties.get(1).equals("International");
        this.area = Double.parseDouble(properties.get(2));
        this.maxVehicle = Integer.parseInt(properties.get(4));
        this.airstripLength = Integer.parseInt(properties.get(4));
        this.constructionCost = Double.parseDouble(properties.get(5));
        this.constructionCost *=  (1 - (isFirstAirport ? 0.25 : 0));
        if (city.getMoney() < this.constructionCost)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.constructionCost);
        isFirstAirport = false;
    }

    public Airport(City city, String name, String address, int orderNumber) throws IOException, NotEnoughMoneyException {
        this(city, name, address,orderNumber, numberOfCreatedTerminal++);
    }

    @Override
    public String toString(){
        return super.toString() +"\nAirstrip length: " + this.airstripLength +
                "\nNumber of vehicle: " + this.getVehicles().size() +
                "\nConstruction cost: " + this.constructionCost;
    }

    public int getAirstripLength() {
        return airstripLength;
    }

    public LinkedList<Vehicle> getVehicles() {
        return airVehicles;
    }

    public boolean isType() {
        return type;
    }
}
