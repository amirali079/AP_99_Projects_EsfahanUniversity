package Main.Building;

import Main.City;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;
import Main.Vehicles.Air_transport_vehicle;
import Main.Vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class Airport extends Terminal {



    private ArrayList<Integer> flightAttendantsIDs = new ArrayList<>();
    private boolean international_Airport ;
    private int number_of_runways ;

    transient private ArrayList<Person> flightAttendants = new ArrayList<Person>();
    private static ArrayList <Airport> airportsList = new ArrayList<Airport>();
    //====================================================================

    public Airport(boolean international_Airport, int number_of_runways, City city, String terminalName, String address, int area, int number_of_vehicles, int number_of_employees){
        super(1400 + number_of_employees*30 ,city ,terminalName ,address , area ,number_of_vehicles, number_of_employees);
        this.international_Airport = international_Airport ;
        this.number_of_runways = number_of_runways ;
        airportsList.add(this);
    }

    //======================================================================

    public static ArrayList<Airport> getAirportsList(){
        return airportsList ;
    }

    public int numberOfHiredFlightAttendants(){
        return flightAttendants.size();
    }

    public void addFlightAttendant(Person flight_attendant){
        flightAttendants.add(flight_attendant);
    }

    public String  showInfo(){


        String str = "International : " + international_Airport + "\nRunways : " + number_of_runways + "\nCity name : " + getCity().getCityName() +
                "\nAirport name : " + terminalName + "\nAddress : " + super.address + "\nArea : " + area +"\nMaximum number of vehicles : " + number_of_vehicles +
                "\nNumber of available vehicles : "  + getNumber_of_bought_vehicles() + "\nMaximum number of  employees : " + number_of_employees +
                "\nNumber of hired employees : " + super.number_of_hired_employees() + "\nNumber of pilots : " + number_of_hired_drivers() +
                "\nNumber of flight attendants : " + flightAttendants.size() ;

        return str;

//        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }


    //=============================================================================================== Saving Airport

    void completeFlightAttendantsIDs(){
        for (Person p : this.flightAttendants)
            this.flightAttendantsIDs.add(p.getID());
    }
    private static void restoreFlightAttendants(Airport airport){
        for (int id : airport.flightAttendantsIDs)
            airport.flightAttendants.add( Person.find_Person_from_ID(id));
    }

    public static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/airports.txt";

    public void saveAirport() throws IOException {

        this.makeReadyForSaving();
        completeFlightAttendantsIDs();

        //---------------


        if (firstObjectSave){
            FileOutputStream fout = new FileOutputStream(address );
            ObjectOutputStream obOut = new ObjectOutputStream(fout);
            obOut.writeObject(this);
            firstObjectSave = false;
            obOut.close();
            fout.close();
        }

        else{
            FileOutputStream fout = new FileOutputStream(address , true);
            CustomObjectOutputClass obOut = new CustomObjectOutputClass(fout);
            obOut.writeObject(this);
            obOut.close();
            fout.close();
        }

        this.flightAttendantsIDs.removeAll(flightAttendants);
        this.startingPointIDs.removeAll(startingPointIDs);
        this.destinationPointIDs.removeAll(destinationPointIDs);
        this.driverIDs.removeAll(driverIDs);
        this.employeeIDs.removeAll(employeeIDs);
        this.vehicleIDs.removeAll(vehicleIDs);


    }


    public static void restoreAirports() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){
                Airport newAirport = (Airport)obIn.readObject();

                newAirport.flightAttendants = new ArrayList<>();

                restoreFlightAttendants(newAirport);
                newAirport.restoreTerminal();

                airportsList.add(newAirport);

            }
        }
        catch (EOFException ex){}


        fin.close();

    }

}
