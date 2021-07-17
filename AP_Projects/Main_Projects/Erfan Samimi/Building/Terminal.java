package Main.Building;

import Main.City;
import Main.Exception.Invalid_TerminalName;
import Main.Person;
import Main.Safar.Safar;
import Main.Safar.Safarable;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

abstract public class Terminal implements Safarable , Serializable {
    int build_price ;
    String cityName;
    String terminalName ;
    String address ;
    int area ;
    int number_of_vehicles ;
    int number_of_employees ;
     ArrayList<String> startingPointIDs = new ArrayList<>();           //safar ids that this terminal is the starting point of journey
     ArrayList<String> destinationPointIDs = new ArrayList<>();          //safar ids that this terminal is the destination point of journey


     ArrayList<Integer> employeeIDs = new ArrayList<Integer>();
     ArrayList<String> vehicleIDs = new ArrayList<String>();
    ArrayList<Integer> driverIDs = new ArrayList<Integer>();
//================================================

    static ArrayList<Terminal> totalTerminals = new ArrayList<Terminal>();
    transient  ArrayList<Person> employees = new ArrayList<Person>();
    transient  ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
    transient  ArrayList<Person> driversList = new ArrayList<Person>();

    transient  ArrayList<Safar> startingTerminalOfJourneys = new ArrayList<Safar>();
    transient  ArrayList<Safar> destinationTerminalOfJourneys = new ArrayList<Safar>();



    //=============================================================================================

    Terminal(int build_price , City city, String terminalName , String address , int area , int number_of_vehicles , int number_of_employees){
        this.build_price = build_price ;
        this.number_of_employees = number_of_employees ;
        this.cityName = city.getCityName();
        this.terminalName = terminalName ;
        this.address = address ;
        this.area = area ;
        this.number_of_vehicles = number_of_vehicles ;
        totalTerminals.add(this);
    }

    //==============================================================================================

    public static ArrayList<Terminal> getTotalTerminals(){
        return totalTerminals;
    }

    public City getCity(){

        return  City.getCity_by_name(this.cityName);
    }

    public void addEmployees(Person empl){
        employees.add(empl);
    }

    public int max_number_of_employees(){
        return number_of_employees;
    }

    public int number_of_hired_employees(){
        return employees.size();
    }

    public ArrayList<Vehicle> getVehiclesList(){
        return this.vehiclesList;
    }

    public String getTerminalName(){
        return terminalName ;
    }

    public int max_number_of_vehicle (){
        return this.number_of_vehicles;
    }

    public int getNumber_of_bought_vehicles(){
        return vehiclesList.size();
    }

    public int number_of_hired_drivers(){
        return this.driversList.size();
    }

    public void add_Driver(Person pr){
        this.driversList.add(pr);
    }

    public void addVehicle ( Vehicle vehicle){
        this.vehiclesList.add( vehicle );
    }

    public static Terminal getTerminalByName(String name ){
        for (Terminal a : totalTerminals){
            if (a.terminalName.equals(name))
                return a;
        }

        throw new Invalid_TerminalName(name + " Terminal does not exists");
    }

    public String getTerminalType( ){
        if (this instanceof Airport)
            return "Airport";
        else if (this instanceof Bus_Terminal)
            return "BusTerminal";
        else if ( this instanceof ShippingPort)
            return "ShippingPort";
        else
            return "TrainStation";
    }

    public ArrayList<Person> getDriversList(){
        return driversList;
    }

    public String  showInfo(){
        return "";
    };

//============================================================================================== Save and restore Terminals

    public void restoreTerminalOfJourneys(){
        ArrayList<Safar> safars = new ArrayList<>();

        for (String id : this.startingPointIDs)
            safars.add(Safar.getSafarByID(id));

        this.startingTerminalOfJourneys = safars;

        //-----------------------------------

        ArrayList<Safar> safars2 = new ArrayList<>();

        for (String id : this.destinationPointIDs)
            safars2.add(Safar.getSafarByID(id));

        this.destinationTerminalOfJourneys = safars2;
    }


    private void completeJourneyIDs (ArrayList<Safar> safars , ArrayList<String> ids){
        for (Safar s : safars )
            ids.add(s.getJourneyID());
    }

    private void completePeopleIDs (ArrayList<Person> people , ArrayList<Integer> ids){
        for (Person a : people)
            ids.add(a.getID());
    }

    private void completeVehicleIDs (){
        for (Vehicle v : this.vehiclesList)
            this.vehicleIDs.add(v.getID());
    }

    public void makeReadyForSaving() {

        completeJourneyIDs(this.startingTerminalOfJourneys , this.startingPointIDs);
        completeJourneyIDs( this.destinationTerminalOfJourneys , this.destinationPointIDs);
        completePeopleIDs(this.driversList , driverIDs);
        completePeopleIDs(this.employees , this.employeeIDs);
        completeVehicleIDs();

    }

    public  void restoreTerminal(){

        this.employees = new ArrayList<Person>();
        this.vehiclesList = new ArrayList<Vehicle>();
        this.driversList = new ArrayList<Person>();
        this.startingTerminalOfJourneys = new ArrayList<Safar>();
        this.destinationTerminalOfJourneys = new ArrayList<Safar>();

        for (int id : this.employeeIDs)
            this.employees.add( Person.find_Person_from_ID(id));

        for (int id : this.driverIDs)
            this.driversList.add( Person.find_Person_from_ID(id));

        for (String id : this.vehicleIDs)
            this.vehiclesList.add( Vehicle.getVehicleByID(id));

        totalTerminals.add(this);

    }

//==============================================================================================



    @Override
    public void newJourney(Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price){

        Safar newSafar = new Safar(startingTerminal , destinationTerminal , passengerList ,driver , vehicle ,journeyID , journeyDay , journeyMonth , price);
//        this.safarList.add(newSafar);

        startingTerminal.driversList.remove(driver);
//        destinationTerminal.driversList.add(driver);

        startingTerminal.vehiclesList.remove(vehicle);
        destinationTerminal.vehiclesList.add(vehicle);

        startingTerminal.startingTerminalOfJourneys.add(newSafar);
        destinationTerminal.destinationTerminalOfJourneys.add(newSafar);


        startingTerminal.getCity().getPersonList().remove(driver);
        destinationTerminal.getCity().getPersonList().add(driver);
        destinationTerminal.add_Driver(driver);


        for ( Person a : passengerList){

                startingTerminal.getCity().getPersonList().remove(a);
                destinationTerminal.getCity().getPersonList().add(a);

        }

        System.out.println(journeyPrice(passengerList , price));
        startingTerminal.getCity().addBudget( journeyPrice( passengerList , price) );



    }

    @Override
    public ArrayList<Safar> sortJourneys(ArrayList<Safar> sa){
        Collections.sort(sa);
        return sa;
    }

    @Override
    public String journeyHistory(boolean startingTerminal , boolean destinationTerminal){

        String str = "";

        if(startingTerminal){

            ArrayList<Safar> safar = sortJourneys(startingTerminalOfJourneys);
////            System.out.println("-*-*-*-*-*-* " + safar.size());
//            for (Safar sa : safar)
//                sa.printINFO();


            for (Safar a : safar)
                str += a.printINFO();



        }

        System.out.println("********************************************************************************");

        if( destinationTerminal){
            ArrayList<Safar> safar = sortJourneys(destinationTerminalOfJourneys);

//            for (Safar sa : safar)
//                sa.printINFO();

            for (Safar a : safar)
                str += a.printINFO();



        }

        return str ;
    }

    @Override
    public int journeyPrice ( ArrayList<Person> passengerList , int ticketPrice ){

        int total_journey_price = 0 ;
        for ( Person a : passengerList){

            if ( ! a.getHired() )
                total_journey_price +=ticketPrice;

        }

        return total_journey_price;
    }





}
