package Main.Vehicles;

import Main.Buildings.Airport;

import java.io.Serializable;
import java.util.ArrayList;

public class Passenger_plane extends Air_Vehicle implements Serializable {
    private int Number_of_crew;//تعداد خدمه
    private int Aircraft_classification_seats;//رده بندی صندلی های هواپیما
    private static final ArrayList<Passenger_plane> passenger_planes=new ArrayList<>();

    public Passenger_plane(int price, int capacity, int ID, String company_builder_name, int maximum_flight_altitude, int band_length_required_for_Landing, int number_of_crew, int aircraft_classification_seats) {
        super(price, capacity, ID, company_builder_name, maximum_flight_altitude, band_length_required_for_Landing);
        Number_of_crew = number_of_crew;
        Aircraft_classification_seats = aircraft_classification_seats;
    }

    public void AddPassengerPlanes(Passenger_plane passenger_plane){
        passenger_planes.add(passenger_plane);
    }

    public int getNumber_of_crew() {
        return Number_of_crew;
    }

    public int getAircraft_classification_seats() {
        return Aircraft_classification_seats;
    }

    public static ArrayList<Passenger_plane> getPassenger_planes() {
        return passenger_planes;
    }

    public void setNumber_of_crew(int number_of_crew) {
        Number_of_crew = number_of_crew;
    }

    public void setAircraft_classification_seats(int aircraft_classification_seats) {
        Aircraft_classification_seats = aircraft_classification_seats;
    }
    public static void ShowPassengerPlanes(){
        System.out.println("\n*************************************************************SHOW PASSENGER PLANE*************************************************************");
        for(int i=0;i<passenger_planes.size();i++){
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Number Of Crew: %d , Aircraft Classification Seats: %d ",i,passenger_planes.get(i).getPrice(),passenger_planes.get(i).getCapacity(),passenger_planes.get(i).getCompany_builder_name(),passenger_planes.get(i).getMaximum_flight_altitude(),passenger_planes.get(i).getBand_length_required_for_Landing(),passenger_planes.get(i).getNumber_of_crew(),passenger_planes.get(i).getAircraft_classification_seats());
            System.out.println();
        }
    }
}
