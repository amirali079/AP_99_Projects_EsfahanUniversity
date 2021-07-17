package Main;

import Main.Bank.Bank;
import Main.Building.*;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Vehicles.*;

import java.io.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class City implements Serializable{

    private int budget;
    private String cityName;
    private ArrayList<Integer> peopleIDs = new ArrayList<>();
    private ArrayList<String>  airportsNames = new ArrayList<>();
    private ArrayList<String>  busTerminalsNames = new ArrayList<>();
    private ArrayList<String>  shippingPortsNames = new ArrayList<>();
    private ArrayList<String>   trainStationNames = new ArrayList<>();
    private ArrayList<String>  hotelNames = new ArrayList<>();


    //=================================================================================

    transient private ArrayList<Bank> banks = new ArrayList<>();
    private static ArrayList<City> citiesList = new ArrayList<City>();

    transient private ArrayList<Person> personList = new ArrayList<>();
    transient private ArrayList<Airport> cityAirportList = new ArrayList<Airport>();
    transient private ArrayList<Bus_Terminal> cityBusTerminalList = new ArrayList<Bus_Terminal>();
    transient private ArrayList<Hotel> cityHotelList = new ArrayList<Hotel>();
    transient private ArrayList<ShippingPort> cityShippingPortList = new ArrayList<ShippingPort>();
    transient private ArrayList<TrainStation> cityTrainStationList = new ArrayList<TrainStation>();


    //=================================================================================

    public City(String cityName, int budget){
        this.budget = budget;
        this.cityName = cityName ;

        if (citiesList.size() == 0)
            addFirstPopulation();
        
        citiesList.add(this);
    }

//=================================================================================


    void addFirstPopulation (){

        addPeople(2 , "pilot" , 70);
        addPeople(3 , "pilot" , 80);
        addPeople( 4 , "driver" , 50);
        addPeople( 4 , "driver" , 55);
        addPeople(6 , "sailor" , 70);
        addPeople(2 , "sailor" , 74);
        addPeople(3 , "locomotive driver" , 70);
        addPeople(3 , "flight attendant" , 35);
        addPeople(2 , "flight attendant" , 40);
        addPeople( 20 , "employee" , 30);

        //=================================================================================


    }


    void addPeople(int number_of_people , String job , int salary ){

        for (int i=0 ; i< number_of_people ; i++){

            Random rand = new Random();
            int ID = rand.nextInt(701);
            while (!Person.uniqID(ID)) {
                ID = rand.nextInt(701);
            }
            Person newPerson = new Person(job, salary, ID);
            this.personList.add(newPerson);
        }
    }

    //=================================================================================

    public void addAirport (Airport a){
        this.cityAirportList.add(a);
    }

    public void addBusTerminal (Bus_Terminal b){
        this.cityBusTerminalList.add(b);
    }

    public void addHotel (Hotel h){
        this.cityHotelList.add(h);
    }

    public void addShippingPort (ShippingPort sh){
        this.cityShippingPortList.add(sh);
    }

    public void addTrainStation (TrainStation t){
        this.cityTrainStationList.add(t);
    }

    ArrayList<Terminal> getTerminalList(){
        ArrayList<Terminal> terminalList = new ArrayList<>();
        terminalList.addAll(getCityBusTerminalList());
        terminalList.addAll(getCityAirportList());
        terminalList.addAll(getCityShippingPortList());
        terminalList.addAll(getCityTrainStationList());

        return terminalList;
    }

//=================================================================================

    public void addBank(Bank bank){
        this.banks.add(bank);
    }

    public static ArrayList<City> getCitiesList (){
        return citiesList;
    }

    public static City getCity_by_name(String name){
        for (City c : citiesList){
            if (c.cityName.equals(name))
                return c;
        }
        return null;
    }

    public int getPopulation(){
        return this.personList.size();
    }

    public ArrayList<Person> getPersonList(){
        return this.personList;
    }

    public int getBudget(){
        return this.budget;
    }

    public void addBudget( int value ){
        this.budget += value ;
    }

    public void setBudget(int value){
        this.budget = value;
    }

    public void withdrawalBudget(int value){
        this.budget -=value;
    }

    public String getCityName(){
        return this.cityName;
    }

    //=================================================================================

    public ArrayList<Airport> getCityAirportList(){
        return this.cityAirportList;
    }

    public ArrayList<ShippingPort> getCityShippingPortList (){
        return this.cityShippingPortList;
    }

    public ArrayList<Bus_Terminal> getCityBusTerminalList(){
        return cityBusTerminalList;
    }

    public ArrayList<TrainStation> getCityTrainStationList(){
        return cityTrainStationList;
    }

    public ArrayList<Hotel> getCityHotelList(){
        return cityHotelList;
    }

    public ArrayList<Bank> getBanks(){
        return this.banks;
    }

    public ArrayList<Terminal> getAllTerminals(){

        ArrayList<Terminal> terminals = new ArrayList<>();
        terminals.addAll(getCityAirportList());
        terminals.addAll(getCityShippingPortList());
        terminals.addAll(getCityBusTerminalList());
        terminals.addAll(getCityTrainStationList());

        return terminals;
    }


    //=================================================================================

    public ArrayList<Boat> getBoatsList(){
        ArrayList <Boat> boats = new ArrayList<>();
        for ( ShippingPort a : this.cityShippingPortList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Boat)
                    boats.add((Boat) b);
            }
        }

        return boats;
    }

    public ArrayList<Bus> getBusesList(){
        ArrayList <Bus> buses = new ArrayList<>();
        for ( Bus_Terminal a : this.cityBusTerminalList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Bus)
                    buses.add((Bus) b);
            }
        }

        return buses;
    }

    public ArrayList<CargoPlane> getCargoPlanesList(){

        ArrayList <CargoPlane> cargoPlanes = new ArrayList<>();
        for ( Airport a : this.cityAirportList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof CargoPlane)
                    cargoPlanes.add((CargoPlane) b);
            }
        }

        return cargoPlanes ;
    }

    public ArrayList<Passenger_airplane> getPassenger_airplanesList(){

        ArrayList <Passenger_airplane> passenger_airplanes = new ArrayList<>();
        for ( Airport a : this.cityAirportList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Passenger_airplane)
                    passenger_airplanes.add((Passenger_airplane) b);
            }
        }

        return passenger_airplanes ;
    }

    public ArrayList<Ship> getShipsList(){

        ArrayList <Ship> ships = new ArrayList<>();
        for ( ShippingPort a : this.cityShippingPortList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Ship)
                    ships.add((Ship) b);
            }
        }

        return ships ;
    }

    public ArrayList<Train> getTrainsList(){

        ArrayList <Train> trains = new ArrayList<>();
        for ( TrainStation a : this.cityTrainStationList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Train)
                    trains.add((Train) b);
            }
        }

        return trains;
    }


    void showInfo(){
        System.out.println("City name : " + this.cityName);
        System.out.println("City budget : " + this.budget);
        System.out.println("Population : " + this.personList.size());
        //TODO  Complete show info method in City.java


        System.out.println("\n-------------------------\n");
    }


    //================================================================================== Saving part

    void completePeopleIDs(){
        for (Person a : this.personList)
            peopleIDs.add(a.getID());
    }

    void completeAirportNames(){
        for (Airport a : this.cityAirportList)
            airportsNames.add(a.getTerminalName());
    }

    void completeBusTerminalNames(){
        for (Bus_Terminal a : this.cityBusTerminalList)
            busTerminalsNames.add(a.getTerminalName());
    }

    void completeShippingPortNames(){
        for (ShippingPort a : this.cityShippingPortList)
            shippingPortsNames.add(a.getTerminalName());
    }

    void completeTrainStationNames(){
        for (TrainStation a : this.cityTrainStationList)
            trainStationNames.add(a.getTerminalName());
    }

    void completeHotelNames(){
        for (Hotel a : this.cityHotelList)
            hotelNames.add(a.getHotelName());
    }

    static void restoreCityPeople(City city){
        for (int id : city.peopleIDs)
            city.personList.add(Person.find_Person_from_ID(id));
    }

     static <T extends Terminal> void restoreCityTerminals( ArrayList<String> terminalNames , ArrayList<T> cityTerminalList ){
        for (String name : terminalNames)
            cityTerminalList.add( (T) T.getTerminalByName(name) );
     }

     static void restoreCityHotels(City city){
        for (String name : city.hotelNames)
            city.cityHotelList.add(Hotel.get_Hotel_ByName(name));
     }


    static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/cities.txt";

    public void saveCity() throws IOException {

        try{
            completePeopleIDs();
            completeAirportNames();
            completeBusTerminalNames();
            completeShippingPortNames();
            completeTrainStationNames();
            completeHotelNames();
        }
        catch (NullPointerException ex){

        }
        //----------------------------


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

        this.peopleIDs.removeAll(peopleIDs);
        this.airportsNames.removeAll(airportsNames);
        this.busTerminalsNames.removeAll(busTerminalsNames);
        this.hotelNames.removeAll(hotelNames);
        this.shippingPortsNames.removeAll(shippingPortsNames);
        this.trainStationNames.removeAll(trainStationNames);



    }

    //------------------------------------------------------------------

    public static void restoreCity() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){


                City newCity = (City) obIn.readObject();

                newCity.banks = new ArrayList<>();
                newCity.personList = new ArrayList<>();
                newCity.cityAirportList = new ArrayList<>();
                newCity.cityBusTerminalList = new ArrayList<>();
                newCity.cityHotelList = new ArrayList<>();
                newCity.cityShippingPortList = new ArrayList<>();
                newCity.cityTrainStationList = new ArrayList<>();





                try{
                    restoreCityPeople(newCity);
                    restoreCityTerminals(newCity.airportsNames, newCity.cityAirportList);
                    restoreCityTerminals(newCity.busTerminalsNames, newCity.cityBusTerminalList);
                    restoreCityTerminals(newCity.shippingPortsNames, newCity.cityShippingPortList);
                    restoreCityTerminals(newCity.trainStationNames, newCity.cityTrainStationList);
                    restoreCityHotels(newCity);
                }
                catch (NullPointerException ex){
                    ex.printStackTrace();
                }

                citiesList.add(newCity);
            }
        }
        catch (EOFException ex){}


        fin.close();

    }



}

