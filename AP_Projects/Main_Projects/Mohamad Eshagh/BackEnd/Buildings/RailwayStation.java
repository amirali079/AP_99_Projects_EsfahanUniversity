package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

final public class RailwayStation extends Terminal implements Serializable {
    protected final LinkedList<Vehicle> trains = new LinkedList<>();
    private final int numberOfInputRails, numberOfOutputRails;
    private static boolean isFirstRailway = true;

    public RailwayStation(City city, String name, String address, int orderNumber, int ID) throws IOException, NotEnoughMoneyException {
        super(city.getName(), name, address, ID);
        ArrayList<String> properties = Country.sellListReader("RailwayStation.csv", orderNumber);
        this.area = Double.parseDouble(properties.get(1));
        this.maxVehicle = Integer.parseInt(properties.get(2));
        this.numberOfInputRails = Integer.parseInt(properties.get(3));
        this.numberOfOutputRails = Integer.parseInt(properties.get(4));
        this.constructionCost = Double.parseDouble(properties.get(5));
        this.constructionCost *=  (1 - (isFirstRailway ? 0.20 : 0));
        if (city.getMoney() < this.constructionCost)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.constructionCost);
        isFirstRailway = false;
    }
    public RailwayStation(City city, String name, String address, int orderNumber) throws IOException, NotEnoughMoneyException {
        this(city, name, address, orderNumber, numberOfCreatedTerminal++);
    }

        @Override
    public String toString(){
        return super.toString() + "\nNumber of input rails : " + this.numberOfInputRails + "\nNumber of output rails : " + this.numberOfOutputRails +
                "\nNumber of vehicle : " + this.getVehicles().size();
    }

    @Override
    public LinkedList<Vehicle> getVehicles() {
        return trains;
    }

    public int getNumberOfInputRails() {
        return numberOfInputRails;
    }

    public int getNumberOfOutputRails() {
        return numberOfOutputRails;
    }

}