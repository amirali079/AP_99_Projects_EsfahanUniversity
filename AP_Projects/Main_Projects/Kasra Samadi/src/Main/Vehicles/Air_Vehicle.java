package Main.Vehicles;

import java.io.Serializable;

public abstract class Air_Vehicle extends Vehicle implements Serializable {
    private int Maximum_flight_altitude;// حداکثر ارتفاع پرواز
    private int Band_length_required_for_Landing;//طول باند مورد نیاز برای فرود

    public Air_Vehicle(int price, int capacity, int ID, String company_builder_name, int maximum_flight_altitude, int band_length_required_for_Landing) {
        super(price, capacity, ID, company_builder_name);
        Maximum_flight_altitude = maximum_flight_altitude;
        Band_length_required_for_Landing = band_length_required_for_Landing;
    }

    public int getMaximum_flight_altitude() {
        return Maximum_flight_altitude;
    }

    public int getBand_length_required_for_Landing() {
        return Band_length_required_for_Landing;
    }

    public void setMaximum_flight_altitude(int maximum_flight_altitude) {
        Maximum_flight_altitude = maximum_flight_altitude;
    }

    public void setBand_length_required_for_Landing(int band_length_required_for_Landing) {
        Band_length_required_for_Landing = band_length_required_for_Landing;
    }
}
