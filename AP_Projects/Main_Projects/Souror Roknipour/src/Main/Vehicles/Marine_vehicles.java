package Main.Vehicles;

import java.io.Serializable;

public abstract class Marine_vehicles extends Vehicle implements Serializable {
    private final int Min_movement_depth;
    private final String fuel_type;

    public enum Marine_fuel_type {
        HFO, LSMGO, LSHFO, MGO, Petrol
    }

    public Marine_vehicles(double price, int capacity, String company, int min_movement_depth, String fuel_type) {
        super(price, capacity, company);
        this.Min_movement_depth = min_movement_depth;
        this.fuel_type = fuel_type;
    }

    public double getMin_movement_depth() {
        return Min_movement_depth;
    }

    public String getFuel_type() {
        return fuel_type;
    }

}
