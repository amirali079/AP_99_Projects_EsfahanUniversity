package Main;

import Main.Building.*;
import Main.Safar.Safar;
import Main.Vehicles.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class SavingGame implements Runnable {

    static void restoreGame() throws IOException, ClassNotFoundException {

        Person.restorePeople();
//        System.out.println("people restored");

        //-------------------------

        Boat.restoreBoats();
//        System.out.println("boats restored");
        Bus.restoreBuses();
//        System.out.println("bus restored");
        CargoPlane.restoreCargoPlane();
//        System.out.println("cargo plane restored");
        Passenger_airplane.restorePassenger_airplane();
//        System.out.println("passenger airplane restored");
        Ship.restoreShips();
//        System.out.println("ships restored");
        Train.restoreTrains();
//        System.out.println("trains restored");

        //-------------------------

        Hotel.restoreHotel();
//        System.out.println("hotel restored");
        Airport.restoreAirports();
//        System.out.println("Airports restored");
        Bus_Terminal.restoreBusTerminals();
//        System.out.println("Bus terminal restored");
        ShippingPort.restoreShippingPorts();
//        System.out.println("shipping port restored");
        TrainStation.restoreTrainStations();
//        System.out.println("train station restored");

        //-------------------------

        Safar.restoreSafars();
//        System.out.println("safars restored");

        //-------------------------

        City.restoreCity();
//        System.out.println("city restored");
//        System.out.println("*-*-*-* Finished");

        //-------------------------

        for (Bus_Terminal b : Bus_Terminal.getBus_terminals_list())
            b.restoreTerminalOfJourneys();
        for (Airport a : Airport.getAirportsList())
            a.restoreTerminalOfJourneys();
        for (ShippingPort s : ShippingPort.getShippingPortsList())
            s.restoreTerminalOfJourneys();
        for (TrainStation t : TrainStation.getTrainStationsList())
            t.restoreTerminalOfJourneys();

    }

    public static void clearAllFiles()   {
        try {
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/people.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/trainStations.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/shippingPorts.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/hotels.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/cities.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/busTerminals.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/airports.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/safarIDs.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/trains.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/ships.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/buses.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/boats.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/cargoPlanes.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/passenger_airplanes.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/safars.txt");
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    static void clear_a_file(String address) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(address);
        pw.close();

    }


    static void saveGame() throws IOException, InterruptedException {

        for (City c : City.getCitiesList())
            c.saveCity();
        City.firstObjectSave = true;

        //-----------------------------

        for (Safar s : Safar.getSafars())
            s.saveSafar();
        Safar.firstObjectSave = true;

        //-----------------------------

        for (Airport a : Airport.getAirportsList())
            a.saveAirport();
        Airport.firstObjectSave = true;


        for (Bus_Terminal b : Bus_Terminal.getBus_terminals_list())
            b.saveBusTerminal();
        Bus_Terminal.firstObjectSave = true;


        for (ShippingPort s : ShippingPort.getShippingPortsList())
            s.saveShippingPort();
        ShippingPort.firstObjectSave = true;


        for (TrainStation t : TrainStation.getTrainStationsList())
            t.saveTrainStation();
        TrainStation.firstObjectSave = true;


        for (Hotel h : Hotel.getHotelsList())
            h.saveHotel();
        Hotel.firstObjectSave = true;


        //-----------------------------

        for (Boat b : Boat.getBoatsList())
            b.saveBoat();
        Boat.append = false;

        for (Bus b : Bus.getBusesList())
            b.saveBus();
        Bus.append = false;

        for (CargoPlane c : CargoPlane.getCargoPlanesList())
            c.saveCargoPlane();
        CargoPlane.append = false;

        for (Passenger_airplane p : Passenger_airplane.getPassenger_airplanesList())
            p.savePassenger_airplane();
        Passenger_airplane.append = false;

        for (Ship s : Ship.getShipsList())
            s.saveShip();
        Ship.append = false;

        for (Train t : Train.getTrainsList())
            t.saveTrain();
        Train.append = false;


        //-----------------------------

        for (Person p : Person.getPeopleList())
            p.savePerson();
        Person.append = false;

    }

    void runSaveGame() throws InterruptedException, IOException {
        while (true){
            Thread.sleep(2000);
            saveGame();
        }
    }


    @Override
    public void run(){

        try {
            runSaveGame();
        }
        catch (InterruptedException | IOException ex){
            ex.printStackTrace();
        }

    }


}
