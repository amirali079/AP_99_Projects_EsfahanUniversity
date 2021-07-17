package Main.Vehicles;

import java.io.Serializable;

public abstract class Air_vehicles extends Vehicle implements Serializable {

    private final int Max_flight_Height;
    private final int Landing_strip_len;
    private final String  fuel_type;

    public Air_vehicles(double price, int capacity, String company, int max_flight_Height, int landing_strip_len, String fuel_type) {
        super(price, capacity, company);
        Max_flight_Height = max_flight_Height;
        Landing_strip_len = landing_strip_len;
        this.fuel_type = fuel_type;
    }


    public int getMax_flight_Height() {
        return Max_flight_Height;
    }

    public int getLanding_strip_len() {
        return Landing_strip_len;
    }

    public String  getFuel_type() {
        return fuel_type;
    }


}
