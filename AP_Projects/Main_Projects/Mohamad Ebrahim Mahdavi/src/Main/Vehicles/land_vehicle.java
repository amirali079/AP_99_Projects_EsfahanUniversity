package Main.Vehicles;

public abstract class land_vehicle extends Vehicle{
    protected double max_speed;
    protected double power;
    protected double fuel_capacity;
    protected String production_date;

    public land_vehicle(String id, String company_name, double price, int capacity, double max_speed, double power, double fuel_capacity, String production_date) {
        super(id, company_name, price, capacity);
        this.max_speed = max_speed;
        this.power = power;
        this.fuel_capacity = fuel_capacity;
        this.production_date = production_date;
    }

}
