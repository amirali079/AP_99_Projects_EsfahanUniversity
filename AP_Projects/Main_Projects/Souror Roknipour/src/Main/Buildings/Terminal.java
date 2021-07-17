package Main.Buildings;

import Main.City;
import Main.Country;
import Main.Exceptions.InvalidInput;
import Main.Person;
import Main.Vehicles.*;
import Main.trip.Safarebel;
import Main.trip.Travel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public abstract class Terminal implements Safarebel, Serializable {

    private final int ID;
    private final String name;
    private final City city;
    private final String City_name;
    private final String Address;
    private final double cost;
    private final String toString;
    private int Number_of_vehicles = 0;
    private final int Area;
    private final ArrayList<Person> Leaders = new ArrayList<>();
    private final ArrayList<Travel> Travels = new ArrayList<>();

    public Terminal(String name, City city, String address, double cost, int area) {

        this.ID = Country.country.getNumOfTerminals();
        this.name = name;
        this.city = city;
        City_name = city.getName();
        Address = address;
        this.cost = cost;
        Country.country.inputCity.setInventory(cost);
        Country.country.removeCountryInventory(cost);
        Area = area;
        this.toString = toString();
    }

    public int getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getCity_name() {
        return City_name;
    }

    public City getCity() {
        return city;
    }

    public String getAddress() {
        return Address;
    }

    public int getNumber_of_vehicles() {
        return Number_of_vehicles;
    }

    public int getArea() {
        return Area;
    }

    public ArrayList<Person> getLeaders() {
        return Leaders;
    }

    public abstract void addLeaders(Person person);


    public abstract Vehicle getVehicle(int id);

    public ArrayList<Travel> getTravels() {
        return Travels;
    }

    public void plusNumOfVehicles() {
        ++Number_of_vehicles;
    }

    public void removeNumOfVehicles() {
        --Number_of_vehicles;
    }

    public abstract void showTerminalVehicles();


    @Override
    public void travel(Terminal destination, Vehicle vehicle, Person driver, ArrayList<Person> passengers) {
        checkPassengers(passengers);
        Country.country.setNumOfTravels();
        int cost = travelCosts(vehicle, passengers);
        Country.country.inputCity.addInventory(cost);
        Country.country.plusCountryInventory(cost);
        this.getTravels().add(new Travel(true, cost, this, destination, vehicle, driver, passengers));
        destination.getTravels().add(new Travel(false, cost, this, destination, vehicle, driver, passengers));
        this.sort();
        destination.sort();
        passengerTransfer(passengers, driver, Country.country.inputCity, destination.getCity());
        vehicleTransfer(vehicle, driver, this, destination);
        Country.country.save();
    }

    @Override
    public int travelCosts(Vehicle vehicle, ArrayList<Person> passengers) {
        if (vehicle instanceof Train) {
            return passengers.size() * ((Train) vehicle).getTicketCost();
        } else if (vehicle instanceof Inter_city_bus) {
            return passengers.size() * ((Inter_city_bus) vehicle).getTicketCost();
        } else if (vehicle instanceof Ship) {
            return passengers.size() * ((Ship) vehicle).getTicketCost();
        } else if (vehicle instanceof boat) {
            return passengers.size() * ((boat) vehicle).getTicketCost();
        } else if (vehicle instanceof Passenger_aircraft) {
            return passengers.size() * ((Passenger_aircraft) vehicle).getTicketCost();
        } else {
            return passengers.size() * ((Cargo_plane) vehicle).getTicketCost();
        }
    }

    @Override
    public void sort() {
        Collections.sort(this.getTravels());
    }

    @Override
    public void travelHistory(Travel.Type type) {}



    public void passengerTransfer(ArrayList<Person> people, Person driver, City origin, City destination) {
        origin.removeCitizens(people);
        origin.removePerson(driver);
        destination.addCitizens(people);
        destination.addPerson(driver);
        Country.country.save();
    }

    public void vehicleTransfer(Vehicle vehicle, Person driver, Terminal origin, Terminal destination) {
        if (origin instanceof Railway_station) {
            ((Railway_station) origin).getTrains().remove(vehicle);
            ((Railway_station) destination).getTrains().add((Train) vehicle);

        } else if (origin instanceof Airport) {
            ((Airport) origin).getAir_vehicles().remove(vehicle);
            ((Airport) destination).getAir_vehicles().add((Air_vehicles) vehicle);
        } else if (origin instanceof Bus_Terminal) {
            ((Bus_Terminal) origin).getBuses().remove(vehicle);
            ((Bus_Terminal) destination).getBuses().add((Inter_city_bus) vehicle);
        } else if (origin instanceof Shipping_port) {
            ((Shipping_port) origin).getMarine_vehicles().remove(vehicle);
            ((Shipping_port) destination).getMarine_vehicles().add((Marine_vehicles) vehicle);
        }
        origin.getLeaders().remove(driver);
        destination.getLeaders().add(driver);
        origin.removeNumOfVehicles();
        destination.plusNumOfVehicles();
        Country.country.save();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [ " + this.getID() + " ] ";
    }

    public String getToString() {
        return toString;
    }

    public void checkPassengers(ArrayList<Person> people){
        for (Person x : people){
            if (!x.isNotHire()){
                throw new InvalidInput("Passengers Not Valid!");
            }
        }
    }
}
