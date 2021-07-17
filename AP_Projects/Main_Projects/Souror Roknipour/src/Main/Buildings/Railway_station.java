package Main.Buildings;


import Main.City;
import Main.Country;
import Main.Exceptions.ExistExc;
import Main.Exceptions.InvalidEmployment;
import Main.Exceptions.InvalidID;
import Main.Person;
import Main.Vehicles.Land_vehicles;
import Main.Vehicles.Train;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class Railway_station extends Terminal implements Serializable {

    private final int input_rails;
    private final int output_rails;

    private ArrayList<Train> trains = new ArrayList<>();

    public Railway_station(String name, City city_name, String address, int area, int input_rails, int output_rails) {
        super(name, city_name, address, City.Cost.Railway.getCost(), area);
        this.input_rails = input_rails;
        this.output_rails = output_rails;
    }

    public int getInput_rails() {
        return input_rails;
    }

    public int getOutput_rails() {
        return output_rails;
    }


    public void addTrain(Train train) {
        Country.country.setNumOfVehicles();
        trains.add(train);
        plusNumOfVehicles();
        Country.country.save();
    }

    @Override
    public void addLeaders(Person person) {
        if (!this.getLeaders().contains(person)) {
            if (person.getJob().equals(Person.Job.Locomotive_driver)) {
                getLeaders().add(person);
                Country.country.inputCity.setInventory(person.getEmployment_rights());
                Country.country.removeCountryInventory(person.getEmployment_rights());
                person.setHire();
                Country.country.save();
            } else throw new InvalidEmployment();
        } else throw new ExistExc();
    }

    public Train getLastTrain() {
        return trains.get(trains.size() - 1);
    }

    @Override
    public Vehicle getVehicle(int id) {
        for (Train x : trains) {
            if (x.getID() == id) {
                return x;
            }
        }
        throw new InvalidID();
    }

    @Override
    public void showTerminalVehicles() {
        System.out.println("Trains :");
        System.out.println("\uD83D\uDE82 | ID | |  price  | | capacity | |    company    | |max_speed| |fuel_type| |number_of_wagons| |   Stars   | ");
        for (Train x : trains) {
            System.out.printf("\uD83D\uDE82 |%-4d| |%-9.1f| |%-10d| |%-15s| |%-9d| |%-9s| |%-16d| |%-11s| \n", x.getID(), x.getPrice(), x.getCapacity(), x.getCompany(), x.getMax_speed(), x.getFuel_type(), x.getNumber_of_wagons(), x.getStar());
        }
        System.out.println();
    }

    public void showTrainServices(int id) {
        for (Train x : trains) {
            if (x.getID() == id) {
                for (int i = 0; i < x.getT_services().size(); i++) {
                    System.out.print(" (" + (i + 1) + ") " + x.getT_services().get(i) + " | ");
                }
                System.out.println();
                break;
            }
        }
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }
}

