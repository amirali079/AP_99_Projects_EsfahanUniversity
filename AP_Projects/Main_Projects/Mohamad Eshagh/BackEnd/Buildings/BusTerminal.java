package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

final public class BusTerminal extends Terminal implements Serializable {
    private final LinkedList<Vehicle> buses = new LinkedList<>();
    private final int facilityLevel;
    private static boolean isFirstBusTerminal = true;

    public BusTerminal(City city, String name, String address, int orderNumber, int ID) throws IOException, NotEnoughMoneyException {
        super(city.getName(), name, address, ID);
        ArrayList<String> properties = Country.sellListReader("BusTerminal.csv", orderNumber);
        this.area = Double.parseDouble(properties.get(1));
        this.maxVehicle = Integer.parseInt(properties.get(2));
        this.facilityLevel = Integer.parseInt(properties.get(4));
        this.constructionCost = Double.parseDouble(properties.get(4));
        this.constructionCost *=  (1 - (isFirstBusTerminal ? 0.10 : 0));
        if (city.getMoney() < this.constructionCost)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.constructionCost);
        isFirstBusTerminal = false;
    }
    public BusTerminal(City city, String name, String address, int orderNumber) throws IOException, NotEnoughMoneyException {
        this(city, name, address, orderNumber, numberOfCreatedTerminal++);
    }

        @Override
    public String toString(){
        return super.toString() +
                "\nFacility level : " + this.facilityLevel +
                "\nNumber of vehicle : " + this.getVehicles().size() +
                "\nConstruction cost: " + this.constructionCost;
    }

    @Override
    public LinkedList<Vehicle> getVehicles() {
        return buses;
    }

    public int getFacilityLevel() {
        return facilityLevel;
    }


}