package Main.Buildings;
import Main.Vehicles.Train;

import java.io.Serializable;
import java.util.ArrayList;

public class RailwayStation extends Terminal implements Serializable {
    private final ArrayList<Train> trains=new ArrayList<>();
    private int Number_of_input_rails;
    private int Number_of_output_rails;
    private static final ArrayList<RailwayStation> railwayStations=new ArrayList<>();
    private boolean isConstructed;

    public RailwayStation(int cost_Construction, String city_name, String terminal_name, String address, int area, int number_of_vehicles, int number_of_input_rails, int number_of_output_rails) {
        super(cost_Construction, city_name, terminal_name, address, area, number_of_vehicles);
        Number_of_input_rails = number_of_input_rails;
        Number_of_output_rails = number_of_output_rails;
        isConstructed=false;
    }

    public void AddRailwayStation(RailwayStation railwayStation){
        railwayStations.add(railwayStation);
    }

    public static ArrayList<RailwayStation> getRailwayStations() {
        return railwayStations;
    }

    public void AddTrains(Train train){
        trains.add(train);
        setNumber_of_vehicles(getNumber_of_vehicles()+1);    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public int getNumber_of_input_rails() {
        return Number_of_input_rails;
    }

    public int getNumber_of_output_rails() {
        return Number_of_output_rails;
    }

    public boolean isConstructed() {
        return isConstructed;
    }

    public void setNumber_of_input_rails(int number_of_input_rails) {
        Number_of_input_rails = number_of_input_rails;
    }

    public void setNumber_of_output_rails(int number_of_output_rails) {
        Number_of_output_rails = number_of_output_rails;
    }

    public void setConstructed(boolean constructed) {
        isConstructed = constructed;
    }

    public static void showRailwayStation(RailwayStation railwayStation){
        System.out.format("City Name: %s , Terminal Name: %s , Address: %s , Cost Construction: %d ,Number Of Vehicles: %s , Area: %s , Number Of Input Rails: %d , Number Of Output Rails: %d\n",railwayStation.getCity_name(),railwayStation.getTerminal_name(),railwayStation.getAddress(),railwayStation.getCost_Construction(),railwayStation.getNumber_of_vehicles(),railwayStation.getArea(),railwayStation.getNumber_of_input_rails(),railwayStation.getNumber_of_output_rails());

    }
    public static void ShowAllRailwayStations(){
        System.out.println("\n*************************************************************SHOW ALL RAILWAY STATIONS*************************************************************");
        for(int i=0;i<railwayStations.size();i++){
            System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of input rails: %d , Number of output rails: %d , Constructed Situation: %s\n",i,railwayStations.get(i).getTerminal_name(),railwayStations.get(i).getCity_name(),railwayStations.get(i).getAddress(),railwayStations.get(i).getCost_Construction(),railwayStations.get(i).getArea(),railwayStations.get(i).getNumber_of_vehicles(),railwayStations.get(i).getNumber_of_input_rails(),railwayStations.get(i).getNumber_of_output_rails(),railwayStations.get(i).isConstructed());
            System.out.println();
        }
    }
    public static boolean ShowConstructedRailwayStations(){
        System.out.println("\n*************************************************************SHOW CONSTRUCTED RAILWAY STATIONS*************************************************************");
        boolean a=false;
        for(int i=0;i<railwayStations.size();i++){
            if (railwayStations.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of input rails: %d , Number of output rails: %d , Constructed Situation: %s\n",i,railwayStations.get(i).getTerminal_name(),railwayStations.get(i).getCity_name(),railwayStations.get(i).getAddress(),railwayStations.get(i).getCost_Construction(),railwayStations.get(i).getArea(),railwayStations.get(i).getNumber_of_vehicles(),railwayStations.get(i).getNumber_of_input_rails(),railwayStations.get(i).getNumber_of_output_rails(),railwayStations.get(i).isConstructed());
                System.out.println();
                a=true;
            }
        }
        return a;
    }
    public static void ShowNotConstructedRailwayStations(){
        System.out.println("\n*************************************************************SHOW NOT CONSTRUCTED RAILWAY STATIONS*************************************************************");
        for (int i = 0; i < railwayStations.size(); i++) {
            if (!railwayStations.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of input rails: %d , Number of output rails: %d , Constructed Situation: %s\n",i,railwayStations.get(i).getTerminal_name(),railwayStations.get(i).getCity_name(),railwayStations.get(i).getAddress(),railwayStations.get(i).getCost_Construction(),railwayStations.get(i).getArea(),railwayStations.get(i).getNumber_of_vehicles(),railwayStations.get(i).getNumber_of_input_rails(),railwayStations.get(i).getNumber_of_output_rails(),railwayStations.get(i).isConstructed());
                System.out.println();

            }
        }
    }
    public void ShowTrains(){
        System.out.println("\n*************************************************************SHOW TRAINS*************************************************************");
        for(int i=0;i<trains.size();i++){
            System.out.format("\n(ID:%d) Price: %d , Capacity: %d , Company Builder Name: %s , Fuel Type: %s , Ticket Price: %d , Number of wagons: %d , Number of stars: %d ",i,trains.get(i).getPrice(),trains.get(i).getCapacity(),trains.get(i).getCompany_builder_name(),trains.get(i).getFuel_type(),trains.get(i).getTicket_price(),trains.get(i).getNumber_of_wagons(),trains.get(i).getNumber_of_stars());

            for (int j=0;j<trains.get(i).getServises().size();j++){
                System.out.format(" [Services%d: %s]",j+1,trains.get(i).getServises().get(j));
            }
            System.out.println();
        }
    }
}
