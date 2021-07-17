package Main.Vehicles;

import Main.City;
import Main.trip.Travel;

import java.io.Serializable;


public class Inter_city_bus extends Land_vehicles implements Serializable {

    private final int ticketCost = Travel.ticketCost.Bus.getTicketCost();
    private final String bus_type;

    public Inter_city_bus(int capacity, String company, int max_speed,String fuel_type,String bus_type) {
        super(City.Cost.Bus.getCost(), capacity, company, max_speed, fuel_type);

        this.bus_type = bus_type;
    }

    public int getTicketCost() {
        return ticketCost;
    }

    public String getBus_type() {
        return bus_type;
    }

}
