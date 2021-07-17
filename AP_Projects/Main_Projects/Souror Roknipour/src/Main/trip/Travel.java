package Main.trip;

import Main.Buildings.Terminal;
import Main.ColorText;
import Main.Country;
import Main.Person;
import Main.Vehicles.Vehicle;
import com.sun.source.tree.CompilationUnitTree;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Travel implements Comparable<Travel>, Serializable {

    private final Terminal Origin;
    private final String originT;
    private final Terminal Destination;
    private final String desT;
    private final Vehicle Vehicle;
    private final String vehicleID;
    private final Person Driver;
    private final String desCity;
    private final int cost;
    private final int ID;
    private final String date;
    private final boolean outGoing;
    private final ArrayList<Person> passengers = new ArrayList<>();
    private static final ArrayList<String> dates = new ArrayList<>();

    public enum Type {
        Incoming, Outgoing, Both
    }

    public enum ticketCost {

        Train(35), Bus(20), CargoPlane(55), PassengerPlane(60), Ship(45), Boat(15);

        private final int ticketCost;

        ticketCost(int cost) {
            ticketCost = cost;
        }

        public int getTicketCost() {
            return ticketCost;
        }
    }

    public Travel(boolean outGoingTrip, int cost, Terminal origin, Terminal destination, Vehicle vehicle, Person driver, ArrayList<Person> passengers) {
        ID = Country.country.getNumOfTravels();
        LocalDateTime dateTime = Country.country.getTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.date = formatter.format(dateTime);
        this.Driver = driver;
        this.Vehicle = vehicle;
        this.Destination = destination;
        this.Origin = origin;
        this.passengers.addAll(passengers);
        this.outGoing = outGoingTrip;
        this.cost = cost;
        this.originT = origin.toString() + "[" + origin.getID() + "]";
        this.desT = destination.toString() + "[" + destination.getID() + "]";
        this.vehicleID = vehicle.toString() + "[" + vehicle.getID() + "]";
        this.desCity = destination.getCity().getName();
    }

    public static ArrayList<String> getDates() {
        return dates;
    }

    public Terminal getOrigin() {
        return Origin;
    }

    public Terminal getDestination() {
        return Destination;
    }

    public int getCost() {
        return cost;
    }

    public int getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public Main.Vehicles.Vehicle getVehicle() {
        return Vehicle;
    }

    public boolean isOutGoing() {
        return outGoing;
    }

    public String getDesT() {
        return desT;
    }

    public String getOriginT() {
        return originT;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public Person getDriver() {
        return Driver;
    }

    public ArrayList<Person> getPassengers() {
        return passengers;
    }

    public String getDesCity() {
        return desCity;
    }

    @Override
    public int compareTo(Travel t) {
        String[] d1 = this.date.toString().split("\\s+");
        String[] d2 = t.date.toString().split("\\s+");
        if (d1[0].compareTo(d2[0]) > 0) {
            return 1;
        } else if (d1[0].compareTo(d2[0]) < 0) {
            return -1;
        } else {
            if (this.cost > t.cost) {
                return 1;
            } else return -1;
        }
    }


}
