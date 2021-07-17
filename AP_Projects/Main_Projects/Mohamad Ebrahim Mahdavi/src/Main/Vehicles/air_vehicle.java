package Main.Vehicles;

public abstract class air_vehicle extends Vehicle{
    protected double max_altitude;
    protected double min_runway;
    protected double max_speed;
    protected String production_date;

    public air_vehicle(String id, String company_name, double price, int capacity, double max_altitude, double min_runway, double max_speed, String production_date) {
        super(id, company_name, price, capacity);
        this.max_altitude = max_altitude;
        this.min_runway = min_runway;
        this.max_speed = max_speed;
        this.production_date = production_date;
    }
}