package Main.Building;

import Main.City;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;
import Main.Vehicles.Bus;

import java.io.*;
import java.util.ArrayList;

public class Bus_Terminal extends Terminal{


    private static ArrayList<Bus_Terminal> bus_terminals_list = new ArrayList<Bus_Terminal>();


    //=======================================================================

    public Bus_Terminal(City city, String terminalName, String address, int area, int number_of_vehicles, int number_of_employees){
        super(600 + number_of_employees*30,  city,terminalName ,address , area ,number_of_vehicles , number_of_employees);
        bus_terminals_list.add(this) ;
    }

    //=======================================================================
    public static ArrayList<Bus_Terminal> getBus_terminals_list(){
        return bus_terminals_list ;
    }





    public String showInfo(){


        String str = "\nCity name : " + getCity().getCityName() + "\nAirport name : " + terminalName + "\nAddress : " + super.address + "\nArea : " + area +
                "\nMaximum number of vehicles : " + number_of_vehicles + "\nNumber of available vehicles : " + getNumber_of_bought_vehicles() +
                "\nMax number of  employees : " + number_of_employees + "\nNumber of hired employees : " + number_of_hired_employees() +
                "\nNumber of drivers : " + number_of_hired_drivers() ;

        return str ;

    }


    //=============================================================================================== Saving Airport




    public static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/busTerminals.txt";

    public void saveBusTerminal() throws IOException {

        this.makeReadyForSaving();


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

//        this.startingPointIDs.removeAll(startingPointIDs);
//        this.destinationPointIDs.removeAll(destinationPointIDs);
//        this.driverIDs.removeAll(driverIDs);
//        this.employeeIDs.removeAll(employeeIDs);
//        this.vehicleIDs.removeAll(vehicleIDs);

        this.startingPointIDs = new ArrayList<>();
        this.destinationPointIDs = new ArrayList<>();
        this.driverIDs = new ArrayList<>();
        this.employeeIDs = new ArrayList<>();
        this.vehicleIDs = new ArrayList<>();


    }


    public static void restoreBusTerminals() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){

                Bus_Terminal newTerminal = (Bus_Terminal) obIn.readObject();



                newTerminal.restoreTerminal();

                bus_terminals_list.add( newTerminal );

            }
        }
        catch (EOFException | NullPointerException  ex){}


        fin.close();

    }

}
