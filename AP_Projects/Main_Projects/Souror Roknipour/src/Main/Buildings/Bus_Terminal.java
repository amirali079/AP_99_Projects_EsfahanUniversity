package Main.Buildings;

import Main.City;
import Main.Country;
import Main.Exceptions.ExistExc;
import Main.Exceptions.InvalidEmployment;
import Main.Exceptions.InvalidID;
import Main.Person;
import Main.Vehicles.Inter_city_bus;
import Main.Vehicles.Land_vehicles;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class Bus_Terminal extends Terminal implements Serializable {
    private final ArrayList<Inter_city_bus> buses = new ArrayList<>();

    public Bus_Terminal(String name, City city_name, String address, int area) {
        super(name, city_name, address, City.Cost.BusTerminal.getCost(), area);
    }

    public void addBuses(int capacity, String company, int max_speed, String fuel_type, String bus_type) {
        Country.country.setNumOfVehicles();
        buses.add(new Inter_city_bus(capacity, company, max_speed, fuel_type, bus_type));
        plusNumOfVehicles();
        Country.country.save();
    }

    @Override
    public void addLeaders(Person person) {
        if (!this.getLeaders().contains(person)) {
            if (person.getJob().equals(Person.Job.Bus_driver)) {
                getLeaders().add(person);
                Country.country.inputCity.setInventory(person.getEmployment_rights());
                Country.country.removeCountryInventory(person.getEmployment_rights());
                person.setHire();
                Country.country.save();
            } else throw new InvalidEmployment();
        } else throw new ExistExc();
    }


    @Override
    public Vehicle getVehicle(int id) {
        for (Inter_city_bus x : buses) {
            if (x.getID() == id) {
                return x;
            }
        }
        throw new InvalidID();
    }

    @Override
    public void showTerminalVehicles() {
        System.out.println("Buses : ");
        System.out.println("\uD83D\uDE8C | ID | |  price  | | capacity | |    company    | |max_speed| |fuel_type| |ticket_Cost| |Bus_Type| ");
        for (Inter_city_bus x : buses) {
            System.out.printf("\uD83D\uDE8C  |%-4d| |%-9.1f| |%-10d| |%-15s| |%-9d| |%-9s| |%-11d| |%-8s| \n", x.getID(), x.getPrice(), x.getCapacity(), x.getCompany(), x.getMax_speed(), x.getFuel_type(), x.getTicketCost(), x.getBus_type());
        }
        System.out.println();
    }

    public ArrayList<Inter_city_bus> getBuses() {
        return buses;
    }
}
