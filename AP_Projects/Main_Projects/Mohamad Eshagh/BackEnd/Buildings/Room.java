package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NoRoomException;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final public class Room implements Serializable {
    private static int numberOfCreatedRooms = 1;
    private final int ID;
    private final int beds;
    private final double area, costPerNight, constructionCost;

    public Room(City city, int orderNumber, Hotel hotel, int ID) throws IOException, NotEnoughMoneyException, NoRoomException {
        this.ID = ID;
        ArrayList<String> properties = Country.sellListReader("Room.csv", orderNumber);
        this.beds = Integer.parseInt(properties.get(1));
        this.area = Double.parseDouble(properties.get(2));
        this.costPerNight = Double.parseDouble(properties.get(3));
        this.constructionCost = Double.parseDouble(properties.get(4));
        if (city.getMoney() < this.constructionCost)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.constructionCost);
        if (!areaCheck(hotel, this.area))
            throw new NoRoomException();
    }
    public Room(City city, int orderNumber, Hotel hotel) throws IOException, NotEnoughMoneyException, NoRoomException {
        this(city, orderNumber, hotel, numberOfCreatedRooms++);
    }
        private static boolean areaCheck(Hotel hotel, double newRoomArea){
        double sumOfRoomsArea = newRoomArea;
        for (Room room:hotel.getRooms())
            sumOfRoomsArea += room.area;
        return hotel.getArea() >= sumOfRoomsArea;
    }

    @Override
    public String toString(){
        return "Room number " + this.ID +
                "\nNumber of beds : " + this.beds +
                "\nArea : " + this.area +
                "\nCost per night : " + this.costPerNight +
                "\nConstruction cost : " + this.constructionCost;
    }

    public double getConstructionCost() {
        return constructionCost;
    }

    public int getID() {
        return ID;
    }

    public int getBeds() {
        return beds;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public double getArea() {
        return area;
    }

}