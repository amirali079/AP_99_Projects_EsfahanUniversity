package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;


import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.BusTerminal;
import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NoRoomException;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final public class IntercityBus extends LandVehicle implements Serializable {
    private final boolean VIP;
    public IntercityBus(City city, int orderNumber, BusTerminal busTerminal, int ID) throws IOException, NotEnoughMoneyException, NoRoomException {
        super(ID, orderNumber);
        ArrayList<String> properties = Country.sellListReader("InterCityBus.csv", orderNumber);
        this.capacity = Integer.parseInt(properties.get(1));
        this.company = properties.get(2);
        this.VIP = Boolean.parseBoolean(properties.get(3));
        this.price = Double.parseDouble(properties.get(4));
        this.price *= (100 - discountPercent()) / 100.0;
        if (city.getMoney() < this.price)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.price);
        if (busTerminal.getVehicles().size() >= busTerminal.getMaxVehicle())
            throw new NoRoomException("There is no room for adding new cargo intercity bus");
        isFirstLandVehicle = false;
    }
    public IntercityBus(City city, int orderNumber, BusTerminal busTerminal) throws IOException, NotEnoughMoneyException, NoRoomException {
        this(city, orderNumber, busTerminal, numberOFCreatedVehicle);
    }

        @Override
    public String toString(){
        return super.toString() + "\nVIP : " + this.isVIP() + "\nPrice: " + this.price;
    }

    public boolean isVIP() {
        return VIP;
    }
}