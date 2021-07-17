package Main.Buildings;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;

public class ShippingPort extends Terminal implements Serializable {
    private final ArrayList<Sea_Vehicle> sea_vehicles=new ArrayList<>();
    private int Number_of_dock;
    private static final ArrayList<ShippingPort> shippingports=new ArrayList<>();
    private boolean isConstructed;

    public ShippingPort(int cost_Construction, String city_name, String terminal_name, String address, int area, int number_of_vehicles, int number_of_dock) {
        super(cost_Construction, city_name, terminal_name, address, area, number_of_vehicles);
        Number_of_dock = number_of_dock;
        isConstructed=false;
    }
    public void AddShippingPorts(ShippingPort shippingPort){
        shippingports.add(shippingPort);
    }

    public static ArrayList<ShippingPort> getShippingports() {
        return shippingports;
    }

    public void AddShip(Ship ship){
        sea_vehicles.add(ship);
        setNumber_of_vehicles(getNumber_of_vehicles()+1);
    }
    public void AddBoat(Boat boat){
        sea_vehicles.add(boat);
        setNumber_of_vehicles(getNumber_of_vehicles()+1);

    }

    public ArrayList<Sea_Vehicle> getSea_vehicles() {
        return sea_vehicles;
    }

    public boolean isConstructed() {
        return isConstructed;
    }

    public int getNumber_of_dock() {
        return Number_of_dock;
    }

    public void setNumber_of_dock(int number_of_dock) {
        Number_of_dock = number_of_dock;
    }

    public void setConstructed(boolean constructed) {
        isConstructed = constructed;
    }

    public static void showShippingPort(ShippingPort shippingport){
        System.out.format("\nTerminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of dock: %d \n",shippingport.getTerminal_name(),shippingport.getCity_name(),shippingport.getAddress(),shippingport.getCost_Construction(),shippingport.getArea(),shippingport.getNumber_of_vehicles(),shippingport.Number_of_dock);

    }
    public static void ShowAllShippingPorts(){
        System.out.println("\n*************************************************************SHOW All SHIPPING PORTS*************************************************************");
        for(int i=0;i<shippingports.size();i++){
            System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of dock: %d , Constructed Situation: %s\n",i,shippingports.get(i).getTerminal_name(),shippingports.get(i).getCity_name(),shippingports.get(i).getAddress(),shippingports.get(i).getCost_Construction(),shippingports.get(i).getArea(),shippingports.get(i).getNumber_of_vehicles(),shippingports.get(i).Number_of_dock,shippingports.get(i).isConstructed);
            System.out.println();
        }
    }
    public static boolean ShowConstructedShippingPorts(){
        System.out.println("\n*************************************************************SHOW CONSTRUCTED SHIPPING PORTS*************************************************************");
        boolean a=false;
        for(int i=0;i<shippingports.size();i++){
            if (shippingports.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of dock: %d , Constructed Situation: %s\n", i, shippingports.get(i).getTerminal_name(), shippingports.get(i).getCity_name(), shippingports.get(i).getAddress(), shippingports.get(i).getCost_Construction(), shippingports.get(i).getArea(), shippingports.get(i).getNumber_of_vehicles(), shippingports.get(i).Number_of_dock,shippingports.get(i).isConstructed);
                System.out.println();
                a=true;
            }
        }
        return a;
    }
    public static void ShowNotConstructedShippingPorts() {
        System.out.println("\n*************************************************************SHOW NOT CONSTRUCTED SHIPPING PORTS*************************************************************");
        for (int i = 0; i < shippingports.size(); i++) {
            if (!shippingports.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of dock: %d , Constructed Situation: %s\n", i, shippingports.get(i).getTerminal_name(), shippingports.get(i).getCity_name(), shippingports.get(i).getAddress(), shippingports.get(i).getCost_Construction(), shippingports.get(i).getArea(), shippingports.get(i).getNumber_of_vehicles(), shippingports.get(i).Number_of_dock,shippingports.get(i).isConstructed);
                System.out.println();

            }
        }
    }
    public void ShowShips(){
        System.out.println("\n*************************************************************SHOW SHIPS*************************************************************");
        for(int i=0;i<sea_vehicles.size();i++){
            if (sea_vehicles.get(i) instanceof Ship){
                Ship ship=(Ship) sea_vehicles.get(i);
                System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Number Of lifeboat: %d  ,Number Of Crew: %d  ",i,ship.getPrice(),ship.getCapacity(),ship.getCompany_builder_name(),ship.getFuel_type(),ship.getMinimum_depth_to_move(),ship.getNumber_of_lifeboats(),ship.getNumber_of_crew());
                System.out.println();
            }
        }
    }
    public void ShowBoats(){
        System.out.println("\n*************************************************************SHOW BOATS*************************************************************");
        for(int i=0;i<sea_vehicles.size();i++){
            if (sea_vehicles.get(i) instanceof Boat){
                Boat boat=(Boat) sea_vehicles.get(i);
                System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Boat body type: %s ",i,boat.getPrice(),boat.getCapacity(),boat.getCompany_builder_name(),boat.getFuel_type(),boat.getMinimum_depth_to_move(),boat.getBoat_body_type());
                System.out.println();
            }
        }
    }
}
