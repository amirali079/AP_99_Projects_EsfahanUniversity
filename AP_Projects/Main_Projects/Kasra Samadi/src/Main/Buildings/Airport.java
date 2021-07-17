package Main.Buildings;
import Main.Vehicles.Air_Vehicle;
import Main.Vehicles.Cargo_plane;
import Main.Vehicles.Passenger_plane;

import java.io.Serializable;
import java.util.ArrayList;

public class Airport extends Terminal implements Serializable {
    private final ArrayList<Air_Vehicle>air_vehicles=new ArrayList<>();
    private String Airport_Type;
    private int Number_of_runways;//تعداد باند پرواز
    private static final ArrayList<Airport>airports=new ArrayList<>();
    private boolean isConstructed;

    public Airport(int cost_Construction, String city_name, String terminal_name, String address, int area, int number_of_vehicles, String airport_Type, int number_of_runways) {
        super(cost_Construction, city_name, terminal_name, address, area, number_of_vehicles);
        Airport_Type = airport_Type;
        Number_of_runways = number_of_runways;
        isConstructed=false;
    }

    public void AddAirports(Airport airport){
        airports.add(airport);
    }
    public void AddPassenger_plane(Passenger_plane passenger_plane){
        air_vehicles.add(passenger_plane);
        setNumber_of_vehicles(getNumber_of_vehicles()+1);
    }

    public void AddCargo_plane(Cargo_plane cargo_plane){
        air_vehicles.add(cargo_plane);
        setNumber_of_vehicles(getNumber_of_vehicles()+1);
    }

    public ArrayList<Air_Vehicle> getAir_vehicles() {
        return air_vehicles;
    }

    public static ArrayList<Airport> getAirports() {
        return airports;
    }

    public String getAirport_Type() {
        return Airport_Type;
    }

    public int getNumber_of_runways() {
        return Number_of_runways;
    }

    public boolean isConstructed() {
        return isConstructed;
    }

    public void setAirport_Type(String airport_Type) {
        Airport_Type = airport_Type;
    }

    public void setNumber_of_runways(int number_of_runways) {
        Number_of_runways = number_of_runways;
    }

    public void setConstructed(boolean constructed) {
        isConstructed = constructed;
    }

    public static void ShowAirport(Airport airport){
        System.out.format("\nTerminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of runways: %d , Airport Type: %s , Constructed Situation: %s\n",airport.getTerminal_name(),airport.getCity_name(),airport.getAddress(),airport.getCost_Construction(),airport.getArea(),airport.getNumber_of_vehicles(),airport.Number_of_runways,airport.Airport_Type,airport.isConstructed());

    }
    public static void ShowAllAirports(){
        System.out.println("\n*************************************************************SHOW ALL AIRPORTS*************************************************************");
        for(int i=0;i<airports.size();i++){
            System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of runways: %d , Airport Type: %s , Constructed Situation: %s\n",i,airports.get(i).getTerminal_name(),airports.get(i).getCity_name(),airports.get(i).getAddress(),airports.get(i).getCost_Construction(),airports.get(i).getArea(),airports.get(i).getNumber_of_vehicles(),airports.get(i).Number_of_runways,airports.get(i).Airport_Type,airports.get(i).isConstructed());
            System.out.println();
        }
    }
    public static boolean ShowConstructedAirPorts(){
        System.out.println("\n*************************************************************SHOW CONSTRUCTED AIRPORTS*************************************************************");
        boolean a=false;
        for(int i=0;i<airports.size();i++){
            if (airports.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of runways: %d , Airport Type: %s , Constructed Situation: %s\n",i,airports.get(i).getTerminal_name(),airports.get(i).getCity_name(),airports.get(i).getAddress(),airports.get(i).getCost_Construction(),airports.get(i).getArea(),airports.get(i).getNumber_of_vehicles(),airports.get(i).Number_of_runways,airports.get(i).Airport_Type,airports.get(i).isConstructed());
                System.out.println();
                a=true;
            }
        }
        return a;
    }
    public static void ShowNotConstructedAirPorts() {
        System.out.println("\n*************************************************************SHOW NOT CONSTRUCTED AIRPORTS*************************************************************");
        for (int i = 0; i < airports.size(); i++) {
            if (!airports.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Terminal name: %s ,City name: %s , Address: %s, Cost Construction: %d , Area: %d , Number of vehicles: %d , Number of runways: %d , Airport Type: %s , Constructed Situation: %s\n",i,airports.get(i).getTerminal_name(),airports.get(i).getCity_name(),airports.get(i).getAddress(),airports.get(i).getCost_Construction(),airports.get(i).getArea(),airports.get(i).getNumber_of_vehicles(),airports.get(i).Number_of_runways,airports.get(i).Airport_Type,airports.get(i).isConstructed());
                System.out.println();

            }
        }
    }
    public void ShowPassengerPlanes(){
        System.out.println("\n*************************************************************SHOW PASSENGER PLANES*************************************************************");
        for(int i=0;i<air_vehicles.size();i++){
            if (air_vehicles.get(i) instanceof Passenger_plane){
                Passenger_plane passenger_plane=(Passenger_plane)air_vehicles.get(i);
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Number Of Crew: %d , Aircraft Classification Seats: %d ",i,passenger_plane.getPrice(),passenger_plane.getCapacity(),passenger_plane.getCompany_builder_name(),passenger_plane.getMaximum_flight_altitude(),passenger_plane.getBand_length_required_for_Landing(),passenger_plane.getNumber_of_crew(),passenger_plane.getAircraft_classification_seats());
            System.out.println();
        }
    }
    }
    public void ShowCargoPlanes(){
        System.out.println("\n*************************************************************SHOW CARGO PLANES*************************************************************");
        for(int i=0;i<air_vehicles.size();i++){
            if (air_vehicles.get(i) instanceof Cargo_plane){
                Cargo_plane cargo_plane=(Cargo_plane) air_vehicles.get(i);
                System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Total portable weight: %d  ",i,cargo_plane.getPrice(),cargo_plane.getCapacity(),cargo_plane.getCompany_builder_name(),cargo_plane.getMaximum_flight_altitude(),cargo_plane.getBand_length_required_for_Landing(),cargo_plane.getTotal_portable_weight());
                System.out.println();
            }
        }
    }
}

