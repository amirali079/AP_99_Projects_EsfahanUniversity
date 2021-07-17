package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Airport;
import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.AirstripLengthMisMatchException;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NoRoomException;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final public class PassengerAirPlane extends AirVehicle implements Serializable {
    private final String airplaneClass;

    public PassengerAirPlane(City city,int orderNumber, Airport airport, int ID) throws IOException, NotEnoughMoneyException, NoRoomException, AirstripLengthMisMatchException {
        super(ID, orderNumber);
        ArrayList<String> properties = Country.sellListReader("PassengerAirplane.csv", orderNumber);
        this.capacity = Integer.parseInt(properties.get(1));
        this.company = properties.get(2);
        this.requiredAirstripLength = Integer.parseInt(properties.get(3));
        this.airplaneClass = properties.get(4);
        this.price = Double.parseDouble(properties.get(5));
        this.price *= (100 - discountPercent()) / 100.0;
        if (city.getMoney() < this.price)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.price);
        if (airport.getVehicles().size() >= airport.getMaxVehicle())
            throw new NoRoomException("There is no room for adding new passenger airplane");
        if (airport.getAirstripLength() < this.requiredAirstripLength)
            throw new AirstripLengthMisMatchException();
        isFirstAirplane = false;
    }
    public PassengerAirPlane(City city,int orderNumber, Airport airport) throws IOException, NotEnoughMoneyException, NoRoomException, AirstripLengthMisMatchException {
        this(city,orderNumber, airport, numberOFCreatedVehicle);
    }

        @Override
    public String toString(){
        return super.toString() + "\n" + this.airplaneClass + " class" + "\nPrice: " + this.price;
    }
    
    public String getAirplaneClass() {
        return airplaneClass;
    }
}