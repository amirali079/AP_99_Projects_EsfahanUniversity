package com.example.mohammad_es_faz4_gui.BackEnd;
import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.*;
import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Bank;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    private final ArrayList<Person> people = new ArrayList<>();
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    private final ArrayList<Terminal> terminals = new ArrayList<>();
    private final ArrayList<Bank> banks = new ArrayList<>();

    private final String name;
    private static int numberOfCreatedCity = 0;
    private final int ID;
    private double money = 10000 - (500 * numberOfCreatedCity);
    private double allInvestedMoney = 0;

    public City(String name){
        this.name = name;
        ID = ++numberOfCreatedCity;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(name).append("\n---------------");
        sb.append("\nBudget : ").append(money);
        sb.append("\nNumber of people : ").append(people.size());

        sb.append("\nNumber of terminal : ").append(terminals.size());
        int numberOfDrivers = 0;
        int numberOfVehicles = 0;
        int numberOfIncomingTravel = 0;
        int numberOfOutBoundTravel = 0;
        for (Terminal terminal: terminals){
            numberOfDrivers += terminal.getDrivers().size();
            numberOfVehicles += terminal.getVehicles().size();
            numberOfIncomingTravel += terminal.getIncomingTravel().size();
            numberOfOutBoundTravel += terminal.getOutBoundTravel().size();
        }
        sb.append("\nNumber of drivers : ").append(numberOfDrivers);
        sb.append("\nNumber of vehicles : ").append(numberOfVehicles);
        sb.append("\nNumber of incoming travels : ").append(numberOfIncomingTravel);
        sb.append("\nNumber of outbound travels : ").append(numberOfOutBoundTravel);

        sb.append("\nNumber of hotels : ").append(hotels.size());
        int numberOfRooms = 0;
        for (Hotel hotel: hotels)
            numberOfRooms += hotel.getRooms().size();
        sb.append("\nNumber of rooms : ").append(numberOfRooms);

        return sb.toString();
    }

    public double getAllInvestedMoney() {
        allInvestedMoney = 0;
        for (Bank bank: this.getBanks())
            allInvestedMoney += bank.getAllMoney();
        return allInvestedMoney;
    }

    public String getName() {
            return name;
    }

    public ArrayList<Person> getPeople() {
            return people;
    }

    public ArrayList<Hotel> getHotels() {
            return hotels;
    }

    public ArrayList<Terminal> getTerminals() {
            return terminals;
    }

    public double getMoney() {
            return money;
    }

    public void setMoney(double money) {
            this.money = money;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}
