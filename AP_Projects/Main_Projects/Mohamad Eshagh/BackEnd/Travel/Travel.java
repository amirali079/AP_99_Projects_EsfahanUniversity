package com.example.mohammad_es_faz4_gui.BackEnd.Travel;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Terminal;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Person;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

public class Travel implements Comparable<Travel>, Serializable {
    Terminal beginningTerminal, destinationTerminal;
    HashSet<Person> passengers;
    private final Person driver;
    private final Vehicle vehicle;
    private final int ID;
    private static int numberOfTravels = 0;
    private final Date date;
    private final double travelCost;

    public Travel(Terminal beginningTerminal, Terminal destinationTerminal, Person driver, Vehicle vehicle, Date date, double travelCost, HashSet<Person> passengers) {
        this.beginningTerminal = beginningTerminal;
        this.destinationTerminal = destinationTerminal;
        this.driver = driver;
        this.vehicle = vehicle;
        this.ID = ++numberOfTravels;
        this.date = date;
        this.travelCost = travelCost;
        this.passengers = passengers;
    }

    @Override
    public int compareTo(Travel that) {
        if (Math.abs(this.date.getTime() - that.date.getTime()) >= 86400000)
            return this.date.compareTo(that.date);
        else if (this.travelCost > that.travelCost)
            return 1;
        else if (this.travelCost < that.travelCost)
            return -1;
        else
            return this.ID > that.ID ? 1 : -1;
    }

    @Override
    public String toString(){
        return "Travel ID : #" + ID +
                "\nBeginning Terminal : " + beginningTerminal.getName() +
                "\nDestination Terminal : " + destinationTerminal.getName() +
                "\nDriver : " + driver.getFullName() +
                "\nVehicle\n---------\n" + vehicle.toString() +
                "\n---------\nTravel Cost : " + travelCost +
                "\nDate : " + Country.toStringDate(date);
    }
}