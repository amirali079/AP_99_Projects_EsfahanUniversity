package Main.Vehicles;

import Main.City;
import Main.trip.Travel;

import java.io.Serializable;

public class Ship extends Marine_vehicles implements Serializable {

    private final String ship_type;
    private final int ticketCost = Travel.ticketCost.Ship.getTicketCost();

    public Ship(int capacity, String company, int min_movement_depth, String fuel_type, String ship_type) {
        super(City.Cost.Ship.getCost(), capacity, company, min_movement_depth, fuel_type);
        this.ship_type = ship_type;
    }

    public String getShip_type() {
        return ship_type;
    }

    public int getTicketCost() {
        return ticketCost;
    }
}
