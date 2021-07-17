package Main.Vehicles;

import Main.City;
import Main.trip.Travel;

import java.io.Serializable;

public class Cargo_plane extends Air_vehicles implements Serializable {
    private final int Total_portable_weight;
    private String cargo_type;
    private final int ticketCost = Travel.ticketCost.CargoPlane.getTicketCost();

    public Cargo_plane(int capacity, String company, int max_flight_Height, int landing_strip_len,String  fuel_type, int total_portable_weight,String cargo_type) {
        super(City.Cost.CargoPlane.getCost(), capacity, company, max_flight_Height, landing_strip_len, fuel_type);
        Total_portable_weight = total_portable_weight;
        this.cargo_type = cargo_type;
    }

    public double getTotal_portable_weight() {
        return Total_portable_weight;
    }

    public String  getCargo_type() {
        return cargo_type;
    }

    public int getTicketCost() {
        return ticketCost;
    }
}


