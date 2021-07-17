package Main.Vehicles;

import Main.City;
import Main.trip.Travel;

import java.io.Serializable;

public class Passenger_aircraft extends Air_vehicles implements Serializable {

    private static int crew_number = 0;
    private final String seatClass;
    private final int ticketCost = Travel.ticketCost.PassengerPlane.getTicketCost();


    public Passenger_aircraft(int capacity, String company, int max_flight_Height, int landing_strip_len, String fuel_type, String seatClass) {
        super(City.Cost.PassengerPlane.getCost(), capacity, company, max_flight_Height, landing_strip_len, fuel_type);
        this.seatClass = seatClass;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public static int getCrew_number() {
        return crew_number;
    }

    public static void setCrew_number() {
        ++Passenger_aircraft.crew_number;
    }

    public int getTicketCost() {
        return ticketCost;
    }
}


