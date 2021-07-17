package Main.Vehicles;


import java.io.Serializable;

public abstract class Land_vehicles extends Vehicle implements Serializable {
    private final int Max_speed;
    private final String fuel_type;


    public Land_vehicles(double price, int capacity, String name_of_manufacturer, int maximum_speed, String fuel_type) {
        super(price, capacity, name_of_manufacturer);
        Max_speed = maximum_speed;
        this.fuel_type = fuel_type;
    }

    public int getMax_speed() {
        return Max_speed;
    }

    public String  getFuel_type() {
        return fuel_type;
    }

}
