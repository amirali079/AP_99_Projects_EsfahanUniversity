package Main.Buildings;

import Main.City;
import Main.Country;
import Main.Exceptions.ExistExc;
import Main.Exceptions.InvalidEmployment;
import Main.Exceptions.InvalidID;
import Main.Person;
import Main.Vehicles.Air_vehicles;
import Main.Vehicles.Cargo_plane;
import Main.Vehicles.Passenger_aircraft;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class Airport extends Terminal implements Serializable {
    private final int Number_of_runways;
    private final boolean international;
    private boolean haveCargo = false;
    private boolean havePassenger = false;

    private final ArrayList<Air_vehicles> air_vehicles = new ArrayList<>();

    public Airport(String name, City city_name, String address, int area, int number_of_runways, boolean international) {
        super(name, city_name, address, City.Cost.AirPort.getCost(), area);
        Number_of_runways = number_of_runways;
        this.international = international;
    }

    public int getNumber_of_runways() {
        return Number_of_runways;
    }

    public boolean isInternational() {
        return international;
    }

    public void addCargoPlane(String fuel_type, String cargo_type, int capacity, String company, int max_flight_Height, int landing_strip_len, int total_portable_weight) {
        Country.country.setNumOfVehicles();
        air_vehicles.add(new Cargo_plane(capacity, company, max_flight_Height, landing_strip_len, fuel_type, total_portable_weight, cargo_type));
        plusNumOfVehicles();
        haveCargo = true;
        Country.country.save();
    }

    public void addPassengerPlane(String fuel_type, String seatClass, int capacity, String company, int max_flight_Height, int landing_strip_len) {
        Country.country.setNumOfVehicles();
        air_vehicles.add(new Passenger_aircraft(capacity, company, max_flight_Height, landing_strip_len, fuel_type, seatClass));
        plusNumOfVehicles();
        havePassenger = true;
        Country.country.save();
    }

    @Override
    public void addLeaders(Person person) {
        if (!this.getLeaders().contains(person)) {
            if (person.getJob().equals(Person.Job.Pilot) || person.getJob().equals(Person.Job.Crew)) {
                getLeaders().add(person);
                Country.country.inputCity.setInventory(person.getEmployment_rights());
                Country.country.removeCountryInventory(person.getEmployment_rights());
                person.setHire();
                Country.country.save();
            } else throw new InvalidEmployment();
        } else throw new ExistExc();
        if (person.getJob().equals(Person.Job.Crew)) {
            Passenger_aircraft.setCrew_number();
        }
    }

    @Override
    public Vehicle getVehicle(int id) {
        for (Air_vehicles x : air_vehicles) {
            if (x.getID() == id) {
                return x;
            }
        }
        throw new InvalidID();
    }

    @Override
    public void showTerminalVehicles() {
        if (havePassenger) {
            System.out.println("Passenger AirCrafts :");
            System.out.println("✈ | ID | |  price  | | capacity | |    company    | |max_flight_Height| |landing_strip_len| |fuel_type| |   seatClass  | |Crew Number|");
            for (Air_vehicles x : air_vehicles) {
                if (x instanceof Passenger_aircraft) {
                    Passenger_aircraft x1 = (Passenger_aircraft) x;
                    System.out.printf("✈ |%-4d| |%-9.1f| |%-10d| |%-15s| |%-17.1f| |%-17.1f| |%-9s| |%-14s| |%-11d| \n", x1.getID(), x1.getPrice(), x1.getCapacity(), x1.getCompany(), x1.getMax_flight_Height(), x1.getLanding_strip_len(), x1.getFuel_type(), x1.getSeatClass(), Passenger_aircraft.getCrew_number());
                }
            }
        } else {
            System.out.println("Your Terminal does not have any Passenger Aircraft !");
        }

        if (haveCargo) {
            System.out.println("Cargo Planes :");
            System.out.println("✈ | ID | |  price  | | capacity | |    company    | |max_flight_Height| |landing_strip_len| |fuel_type| |total_portable_weight| |      cargo_type       | ");
            for (Air_vehicles x : air_vehicles) {
                if (x instanceof Cargo_plane) {
                    Cargo_plane x1 = (Cargo_plane) x;
                    System.out.printf("✈ |%-4d| |%-9.1f| |%-10d| |%-15s| |%-17.1f| |%-17.1f| |%-9s| |%-21.1f| |%-23s| \n", x1.getID(), x1.getPrice(), x1.getCapacity(), x1.getCompany(), x1.getMax_flight_Height(), x1.getLanding_strip_len(), x1.getFuel_type(), x1.getTotal_portable_weight(), x1.getCargo_type());

                }
            }
        } else {
            System.out.println("Your Terminal does not have any Cargo Plane !");
        }
    }

    public ArrayList<Air_vehicles> getAir_vehicles() {
        return air_vehicles;
    }
}
