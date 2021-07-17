package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;
import com.example.mohammad_es_faz4_gui.BackEnd.*;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.*;
import com.example.mohammad_es_faz4_gui.BackEnd.Travel.Travel;
import com.example.mohammad_es_faz4_gui.BackEnd.Travel.BellTravel;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.*;

import java.util.*;

abstract public class Terminal implements BellTravel, Comparable<Terminal>{
    private final ArrayList<Person> drivers = new ArrayList<>();
    private final TreeSet<Travel> outBoundTravel = new TreeSet<>();
    private final TreeSet<Travel> incomingTravel = new TreeSet<>();

    private final String city, name, address;
    protected static int numberOfCreatedTerminal = 0;
    private final int ID;
    protected int maxVehicle;
    protected double area;
    protected double constructionCost;

    public Terminal(String city, String name, String address, int ID) {
        this.city = city;
        this.name = name;
        this.address = address;
        this.ID = ID;
    }

        @Override
    public  void newTrip(Terminal destinationTerminal, Person driver, Vehicle vehicle, Date date, City beginningCity, City destinationCity, HashSet<Person> passengers) throws UnauthorizedNumberOfPassengersException, NoRoomException, AirstripLengthMisMatchException{
        if (passengers.size() < vehicle.getCapacity() / 4)
            throw new UnauthorizedNumberOfPassengersException("Number of passenger must be at least 1/4 of vehicle capacity");
        if (passengers.size() > vehicle.getCapacity())
            throw new UnauthorizedNumberOfPassengersException("This vehicle does not have enough capacity for this numbers of passengers");
        if (destinationTerminal.getVehicles().size() >= destinationTerminal.getMaxVehicle())
            throw new NoRoomException("There is no room for adding new vehicle in destination terminal");
        if (vehicle instanceof AirVehicle)
            if (((AirVehicle) vehicle).getRequiredAirstripLength() > ((Airport) destinationTerminal).getAirstripLength())
                throw new AirstripLengthMisMatchException();
        double tripCost = calculateTripCost(passengers.size(), vehicle);
        Travel newTrip = new Travel(this, destinationTerminal, driver, vehicle, date, tripCost, passengers);
        this.outBoundTravel.add(newTrip);
        destinationTerminal.incomingTravel.add(newTrip);
        this.drivers.remove(driver);
        destinationTerminal.drivers.add(driver);
        this.getVehicles().remove(vehicle);
        destinationTerminal.getVehicles().add(vehicle);
        beginningCity.getPeople().removeAll(passengers);
        beginningCity.getPeople().remove(driver);
        destinationCity.getPeople().addAll(passengers);
        destinationCity.getPeople().add(driver);
        beginningCity.setMoney(beginningCity.getMoney() + tripCost);
    }

    @Override
    public double calculateTripCost(int numberOfPassenger, Vehicle vehicle) {
        double tripCost = numberOfPassenger;
        if (vehicle.getClassName().contains("Air"))
            tripCost += 50;
        else if (vehicle.getClassName().contains("Train"))
            tripCost += 40;
        else if (vehicle.getClassName().contains("Ship"))
            tripCost += 30;
        else if (vehicle.getClassName().contains("Boat"))
            tripCost += 20;
        else if (vehicle.getClassName().contains("Bus"))
            tripCost += 10;
        return tripCost;
    }

    @Override
    public String tripHistory(boolean incoming, boolean outBound) throws EmptyListException {
        StringBuilder SB = new StringBuilder();
        if (incoming && outBound && incomingTravel.isEmpty() && outBoundTravel.isEmpty())
            throw new EmptyListException("There is no travel");
        if (incoming){
            if (incomingTravel.isEmpty())
                if (!outBound)
                    throw new EmptyListException("There is no incoming travel");
            for (Travel travel : incomingTravel)
                SB.append(travel).append("\n----------------------------------------------------------\n");
        }
        if (outBound){
            if (outBoundTravel.isEmpty())
                if (!incoming)
                    throw new EmptyListException("There is no outbound travel");
            for (Travel travel : outBoundTravel)
                SB.append(travel).append("\n----------------------------------------------------------\n");
        }
        return SB.toString();
    }

    public String getClassName(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.reverse();
        sb.delete(sb.indexOf("."),sb.length());
        sb.reverse();
        return sb.toString();
    }

    public String getDriverType(){
        switch (getClassName()) {
            case "Airport":
                return "Pilot";
            case "BusTerminal":
                return "Bus driver";
            case "RailwayStation":
                return "Locomotive";
            default:
                return "Sailor";
        }
    }


    @Override
    public String toString(){
        return "\nCity : " + this.city +
                "\nTerminal Name : " + this.name +
                "\nAddress : " + this.address +
                "\nArea : " + this.area;
    }

    @Override
    public int compareTo(Terminal that) {
        return this.ID > that.ID ? 1 : -1;
    }


    public abstract LinkedList<Vehicle> getVehicles();

    public TreeSet<Travel> getOutBoundTravel() {
        return outBoundTravel;
    }

    public TreeSet<Travel> getIncomingTravel() {
        return incomingTravel;
    }

    public double getArea() {
        return area;
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

    public void setArea(double area) {
        this.area = area;
    }

    public int getMaxVehicle() {
        return maxVehicle;
    }

    public ArrayList<Person> getDrivers() {
        return drivers;
    }

    public int getID() {
        return ID;
    }
}
