package Main.Vehicles;

import java.io.Serializable;

public abstract class Sea_Vehicle extends Vehicle implements Serializable {
    private String Fuel_type;//نوع سوخت
    private int Minimum_depth_to_move;// حداقل عمق برای حرکت

    public Sea_Vehicle(int price, int capacity, int ID, String company_builder_name, String fuel_type, int minimum_depth_to_move) {
        super(price, capacity, ID, company_builder_name);
        Fuel_type = fuel_type;
        Minimum_depth_to_move = minimum_depth_to_move;
    }

    public String getFuel_type() {
        return Fuel_type;
    }

    public int getMinimum_depth_to_move() {
        return Minimum_depth_to_move;
    }

    public void setFuel_type(String fuel_type) {
        Fuel_type = fuel_type;
    }

    public void setMinimum_depth_to_move(int minimum_depth_to_move) {
        Minimum_depth_to_move = minimum_depth_to_move;
    }
}
