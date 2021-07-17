package Main.Buildings;
import Main.Vehicles.Bus;

import java.io.Serializable;
import java.util.ArrayList;

public class BusTerminal extends Terminal implements Serializable {
    private final ArrayList<Bus> buses=new ArrayList<>();
    private static final ArrayList<BusTerminal>busTerminals=new ArrayList<>();
    private boolean isConstructed;

    public BusTerminal(int cost_Construction, String city_name, String terminal_name, String address, int area, int number_of_vehicles) {
        super(cost_Construction, city_name, terminal_name, address, area, number_of_vehicles);
        isConstructed=false;
    }
    public void AddBusTerminal(BusTerminal busTerminal){
        busTerminals.add(busTerminal);
    }

    public void AddBus(Bus bus){
        buses.add(bus);
        setNumber_of_vehicles(getNumber_of_vehicles()+1);}

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public boolean isConstructed() {
        return isConstructed;
    }

    public static ArrayList<BusTerminal> getBusTerminals() {
        return busTerminals;
    }

    public void setConstructed(boolean constructed) {
        isConstructed = constructed;
    }

    public static void showBusTerminals(BusTerminal busTerminal){
        System.out.format("\nTerminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d ",busTerminal.getTerminal_name(),busTerminal.getCity_name(),busTerminal.getAddress(),busTerminal.getCost_Construction(),busTerminal.getArea(),busTerminal.getNumber_of_vehicles());
    }
    public static void ShowAllBusTerminals(){
        System.out.println("\n*************************************************************SHOW All BUS TERMINALS*************************************************************");
        for(int i=0;i<busTerminals.size();i++){
            System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Constructed Situation: %s",i,busTerminals.get(i).getTerminal_name(),busTerminals.get(i).getCity_name(),busTerminals.get(i).getAddress(),busTerminals.get(i).getCost_Construction(),busTerminals.get(i).getArea(),busTerminals.get(i).getNumber_of_vehicles(),busTerminals.get(i).isConstructed);
            System.out.println();
        }
    }
    public static boolean ShowConstructedBusTerminals(){
        System.out.println("\n*************************************************************SHOW CONSTRUCTED BUS TERMINALS*************************************************************");
        boolean a=false;
        for(int i=0;i<busTerminals.size();i++){
            if (busTerminals.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Constructed Situation: %s\n", i, busTerminals.get(i).getTerminal_name(), busTerminals.get(i).getCity_name(), busTerminals.get(i).getAddress(), busTerminals.get(i).getCost_Construction(), busTerminals.get(i).getArea(), busTerminals.get(i).getNumber_of_vehicles(), busTerminals.get(i).isConstructed);
                System.out.println();
                a=true;
            }
        }
        return a;
    }
    public static void ShowNotConstructedBusTerminals() {
        System.out.println("\n*************************************************************SHOW NOT CONSTRUCTED BUS TERMINALS*************************************************************");
        for (int i = 0; i < busTerminals.size(); i++) {
            if (!busTerminals.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Constructed Situation: %s\n", i, busTerminals.get(i).getTerminal_name(), busTerminals.get(i).getCity_name(), busTerminals.get(i).getAddress(), busTerminals.get(i).getCost_Construction(), busTerminals.get(i).getArea(), busTerminals.get(i).getNumber_of_vehicles(), busTerminals.get(i).isConstructed);
                System.out.println();

            }
        }
    }
    public void ShowBuses(){
        System.out.println("\n*************************************************************SHOW BUSES*************************************************************");
        for(int i=0;i<buses.size();i++){
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Ticket Price: %d , Pollutant production by PPM: %d , Fuel consumption per kilometer by lit: %d ",i,buses.get(i).getPrice(),buses.get(i).getCapacity(),buses.get(i).getCompany_builder_name(),buses.get(i).getFuel_type(),buses.get(i).getTicket_price(),buses.get(i).getPollutant_production_by_PPM(),buses.get(i).getFuel_consumption_per_kilometer_by_lit());
            System.out.println();
        }
    }
}
