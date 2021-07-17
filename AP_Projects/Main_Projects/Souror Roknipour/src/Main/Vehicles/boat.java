package Main.Vehicles;

import Main.City;
import Main.trip.Travel;

import java.io.Serializable;

public class boat extends Marine_vehicles implements Serializable {
    private final String boat_type;
    private final int Number_of_oars;
    private final int ticketCost = Travel.ticketCost.Boat.getTicketCost();
    public enum Boat_Type {
        Fishing_Boats, Bowriders, Cuddy_Cabins, Deck_Boats, Dinghies
    }


    public boat(int capacity, String company, int min_movement_depth, String fuel_type, String  boat_type, int number_of_oars) {
        super(City.Cost.Boat.getCost(), capacity, company, min_movement_depth, fuel_type);
        this.boat_type = boat_type;
        Number_of_oars = number_of_oars;
    }

    public String getBoat_type() {
        return boat_type;
    }

    public int getNumber_of_oars() {
        return Number_of_oars;
    }

    public int getTicketCost() {
        return ticketCost;
    }
}

