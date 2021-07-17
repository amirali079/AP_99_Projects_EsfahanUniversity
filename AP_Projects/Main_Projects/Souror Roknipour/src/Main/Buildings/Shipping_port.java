package Main.Buildings;

import Main.City;
import Main.Country;
import Main.Exceptions.ExistExc;
import Main.Exceptions.InvalidEmployment;
import Main.Exceptions.InvalidID;
import Main.Person;
import Main.Vehicles.Marine_vehicles;
import Main.Vehicles.Ship;
import Main.Vehicles.Vehicle;
import Main.Vehicles.boat;

import java.io.Serializable;
import java.util.ArrayList;

public class Shipping_port extends Terminal implements Serializable {

    private final int piers;
    private boolean haveboat = false;
    private boolean haveShip = false;
    private ArrayList<Marine_vehicles> marine_vehicles = new ArrayList<>();

    public Shipping_port(String name, City city_name, String address, int area, int piers) {
        super(name, city_name, address, City.Cost.ShippingPort.getCost(), area);
        this.piers = piers;
    }

    public int getPiers() {
        return piers;
    }

    @Override
    public void addLeaders(Person person) {
        if (!this.getLeaders().contains(person)) {
            if (person.getJob().equals(Person.Job.Sailor)){
                getLeaders().add(person);
                Country.country.inputCity.setInventory(person.getEmployment_rights());
                Country.country.removeCountryInventory(person.getEmployment_rights());
                person.setHire();
                Country.country.save();
            }
            else throw new InvalidEmployment();
        } else throw new ExistExc();
    }

    public void addShips(String fuel_type, String ship_type, int capacity, String company, int min_movement_depth) {
        Country.country.setNumOfVehicles();
        marine_vehicles.add(new Ship(capacity, company, min_movement_depth, fuel_type, ship_type));
        plusNumOfVehicles();
        haveShip = true;
        Country.country.save();
    }

    public void addboats(String fuel_type, String boat_type, int capacity, String company, int min_movement_depth, int number_of_oars) {
        Country.country.setNumOfVehicles();
        marine_vehicles.add(new boat(capacity, company, min_movement_depth, fuel_type, boat_type, number_of_oars));
        plusNumOfVehicles();
        haveboat = true;
        Country.country.save();
    }

    @Override
    public void showTerminalVehicles() {
        if (haveboat) {
            System.out.println("Boats :");
            System.out.println("⚓ | ID | |  price  | | capacity | |    company    | |min_movement_depth| |fuel_type| |  boat_type  | |number_of_oars|");
            for (Marine_vehicles x : marine_vehicles) {
                if (x instanceof boat) {
                    boat x1 = (boat) x;
                    System.out.printf("⚓ |%-4d| |%-9.1f| |%-10d| |%-15s| |%-18.1f| |%-9s| |%-13s| |%-14d| \n", x1.getID(), x1.getPrice(), x1.getCapacity(), x1.getCompany(), x1.getMin_movement_depth(), x1.getFuel_type(), x1.getBoat_type(), x1.getNumber_of_oars());
                }
            }
        } else {
            System.out.println("Your Terminal does not have any Boat !");
        }
        if (haveShip) {
            System.out.println("Ships :");
            System.out.println("⚓ | ID | |  price  | | capacity | |    company    | |min_movement_depth| |fuel_type| |    Ship_Type    | ");
            for (Marine_vehicles x : marine_vehicles) {
                if (x instanceof Ship) {
                    Ship x1 = (Ship) x;
                    System.out.printf("⚓ |%-4d| |%-9.1f| |%-10d| |%-15s| |%-18.1f| |%-9s| |%-17s| \n", x1.getID(), x1.getPrice(), x1.getCapacity(), x1.getCompany(), x1.getMin_movement_depth(), x1.getFuel_type(), x1.getShip_type());
                }
            }
        } else {
            System.out.println("Your Terminal does not have any Ship !");
        }
    }

    public ArrayList<Marine_vehicles> getMarine_vehicles() {
        return marine_vehicles;
    }

    @Override
    public Vehicle getVehicle(int id) {
        for (Marine_vehicles x : marine_vehicles) {
            if (x.getID() == id) {
                return x;
            }
        }
        throw new InvalidID();
    }
}
