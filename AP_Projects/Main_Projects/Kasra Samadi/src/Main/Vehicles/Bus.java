package Main.Vehicles;

import java.io.Serializable;
import java.util.ArrayList;

public class Bus extends Land_Vehicle implements Serializable {
    private int Pollutant_production_by_PPM;//تولید آلاینده بر حسب PPM
    private int Fuel_consumption_per_kilometer_by_lit;// مصرف سوخت در هر کیلومتر بر حسب لیتر
    private static final ArrayList<Bus>buses=new ArrayList<>();

    public Bus(int price, int capacity, int ID, String company_builder_name, String fuel_type, int ticket_price, int pollutant_production_by_PPM, int fuel_consumption_per_kilometer_by_lit) {
        super(price, capacity, ID, company_builder_name, fuel_type, ticket_price);
        Pollutant_production_by_PPM = pollutant_production_by_PPM;
        Fuel_consumption_per_kilometer_by_lit = fuel_consumption_per_kilometer_by_lit;
    }

    public int getPollutant_production_by_PPM() {
        return Pollutant_production_by_PPM;
    }

    public int getFuel_consumption_per_kilometer_by_lit() {
        return Fuel_consumption_per_kilometer_by_lit;
    }

    public void AddBuses(Bus bus){
        buses.add(bus);
    }

    public static ArrayList<Bus> getBuses() {
        return buses;
    }

    public void setPollutant_production_by_PPM(int pollutant_production_by_PPM) {
        Pollutant_production_by_PPM = pollutant_production_by_PPM;
    }

    public void setFuel_consumption_per_kilometer_by_lit(int fuel_consumption_per_kilometer_by_lit) {
        Fuel_consumption_per_kilometer_by_lit = fuel_consumption_per_kilometer_by_lit;
    }
    public static void ShowBuses(){
        System.out.println("\n*************************************************************SHOW BUSES*************************************************************");
        for(int i=0;i<buses.size();i++){
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Ticket Price: %d , Pollutant production by PPM: %d , Fuel consumption per kilometer by lit: %d ",i,buses.get(i).getPrice(),buses.get(i).getCapacity(),buses.get(i).getCompany_builder_name(),buses.get(i).getFuel_type(),buses.get(i).getTicket_price(),buses.get(i).getPollutant_production_by_PPM(),buses.get(i).getFuel_consumption_per_kilometer_by_lit());
            System.out.println();
        }
    }
}
