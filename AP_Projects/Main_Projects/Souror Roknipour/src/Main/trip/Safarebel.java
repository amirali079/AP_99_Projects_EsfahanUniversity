package Main.trip;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Date;

public interface Safarebel {

    void travel(Terminal destination, Vehicle vehicle, Person driver, ArrayList<Person> passengers);

    int travelCosts(Vehicle vehicle, ArrayList<Person> passengers);

    void sort();

    void travelHistory(Travel.Type type);

}
