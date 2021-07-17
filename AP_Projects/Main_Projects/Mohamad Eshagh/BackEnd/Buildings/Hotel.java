package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;

import java.io.*;
import java.util.ArrayList;

final public class Hotel implements Serializable{

    private final ArrayList<Room> rooms = new ArrayList<>();
    private final ArrayList<String> selectedOptions = new ArrayList<>();

    private final String name, city, address;
    private static int numberOfCreatedHotel = 0;
    private final int ID;
    private int stars;
    private double constructionCost;
    private final double area;
    private static boolean isFirstHotel = true;

    public Hotel(City city, String name, String address, int orderNumber) throws IOException, NotEnoughMoneyException {
            this(city, name, address, orderNumber, numberOfCreatedHotel++);
        }

    public Hotel(City city, String name, String address, int orderNumber, int ID) throws IOException, NotEnoughMoneyException {
        this.city = city.getName();
        this.name = name;
        this.address = address;
        ArrayList<String> properties = Country.sellListReader("Hotel.csv", orderNumber);
        this.area = Double.parseDouble(properties.get(1));
        this.stars = Integer.parseInt(properties.get(2));
        this.constructionCost = Double.parseDouble(properties.get(3));
        this.constructionCost *=  (100 - discountPercent()) / 100.0;
        if (city.getMoney() < this.constructionCost)
            throw new NotEnoughMoneyException();
        city.setMoney(city.getMoney() - this.constructionCost);
        isFirstHotel = false;
        this.ID = ID;
    }

        private int discountPercent() {
        return isFirstHotel ? 20 : 0;
    }

    public static void insertOptions(City city, HotelOptions Option) throws NotEnoughMoneyException {
        if (city.getMoney() < 100)
            throw new NotEnoughMoneyException();
        city.getHotels().get(city.getHotels().size()-1).selectedOptions.add(Option.name());
        city.setMoney(city.getMoney()-100);
        if (city.getHotels().get(city.getHotels().size()-1).selectedOptions.size() == 2)
            city.getHotels().get(city.getHotels().size()-1).stars++;
    }

    @Override
    public String toString(){
        return "City : " + this.city +
                "\nHotel name : " + this.name +
                "\nAddress : " + this.address +
                "\nNumber of rooms : " + this.rooms.size() +
                "\nStars : " + this.stars +
                "\nArea : " + this.area +
                StringSelectedOptions() +
                "Construction cost : " + this.constructionCost;
    }

    public String StringSelectedOptions() {
        StringBuilder sb = new StringBuilder();
        for (String facility : this.selectedOptions)
            sb.append("\nOption : ").append(facility);
        return sb.toString();
    }

    public ArrayList<String> getSelectedOptions() {
        return selectedOptions;
    }

    public String summaryToString(){
        return this.name + " - Address : " + this.address;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getConstructionCost() {
        return constructionCost;
    }

    public int getStars() {
        return stars;
    }

    public double getArea() {
        return area;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getID() {
        return ID;
    }
}