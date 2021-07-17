package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.ShippingPort;
import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NoRoomException;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final public class Boat extends MarineVehicle implements Serializable {
    public Boat(City city, int orderNumber, ShippingPort shippingPort, int ID) throws IOException, NotEnoughMoneyException, NoRoomException {
        super(ID, orderNumber);
        ArrayList<String> properties = Country.sellListReader("Boat.csv",orderNumber);
        this.capacity = Integer.parseInt(properties.get(1));
        this.company = properties.get(2);
        this.minDepth = properties.get(3);
        this.fuelType = properties.get(4);
        this.price = Double.parseDouble(properties.get(5));
        this.price *=  (100 - discountPercent()) / 100.0;
        if (city.getMoney() < this.price)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.price);
        if (shippingPort.getVehicles().size() >= shippingPort.getMaxVehicle())
            throw new NoRoomException("There is no room for adding new boat");
        isFirstMarineVehicle = false;
    }
    public Boat(City city, int orderNumber, ShippingPort shippingPort) throws IOException, NotEnoughMoneyException, NoRoomException {
        this(city, orderNumber, shippingPort, numberOFCreatedVehicle);
    }

        @Override
    public String toString(){
        return super.toString() + "\nPrice: " + this.price;
    }
}