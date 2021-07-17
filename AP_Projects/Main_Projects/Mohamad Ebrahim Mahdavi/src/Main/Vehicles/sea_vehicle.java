package Main.Vehicles;

public abstract class sea_vehicle extends Vehicle{
    protected String fuel_type;
    protected double min_depth;
    protected double max_speed;
    protected double fuel_capacity;
    protected String production_date;

    public sea_vehicle(String id, String company_name, double price, int capacity, String fuel_type, double min_depth, double max_speed, double fuel_capacity, String production_date) {
        super(id, company_name, price, capacity);
        this.fuel_type = fuel_type;
        this.min_depth = min_depth;
        this.max_speed = max_speed;
        this.fuel_capacity = fuel_capacity;
        this.production_date = production_date;
    }

}
