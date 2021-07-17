package Main.Building;

import Main.City;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;
import Main.Vehicles.Boat;
import Main.Vehicles.Ship;
import Main.Vehicles.Shipping_vehicle;
import Main.Vehicles.Vehicle;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ShippingPort extends  Terminal {

    private static ArrayList<ShippingPort> shippingPortsList = new ArrayList<ShippingPort>();
    private int number_of_waterfront ;

    //==========================================
     public ShippingPort (int number_of_waterfront , City city, String terminalName , String address , int area , int number_of_vehicles , int number_of_employees){
         super( 1000 + number_of_employees*30 , city , terminalName , address , area , number_of_vehicles , number_of_employees);
         this.number_of_waterfront = number_of_waterfront ;
         shippingPortsList.add(this);
     }

     //==========================================

    public static ArrayList<ShippingPort> getShippingPortsList(){
        return shippingPortsList ;
    }

    ArrayList<Boat> boatList(){

         ArrayList<Boat> boats = new ArrayList<Boat>();
         for (Vehicle vc : this.getVehiclesList()){
             if (vc instanceof Boat)
                 boats.add((Boat) vc);
         }

         return boats;
    }

    ArrayList<Ship> shipList(){

        ArrayList<Ship> ships = new ArrayList<Ship>();
        for (Vehicle vc : this.getVehiclesList()){
            if (vc instanceof Ship)
                ships.add((Ship) vc);
        }

        return ships;
    }

     public String showInfo(){

         String str = "\nNumber of waterfronts :  " + number_of_waterfront + "\nCity name : " + getCity().getCityName() + "\nAirport name : " + terminalName +
                 "\nAddress : " + super.address + "\nArea : " + area + "\nMaximum number of vehicles : " + number_of_vehicles + "\nNumber of bought vehicles : " + getNumber_of_bought_vehicles() +
                 "\nNumber of ships : " + shipList().size() + "\nNumber of boats : " + boatList().size() + "\nMaximum number of  employees : " + number_of_employees + "\nNumber of hired employees : " + number_of_hired_employees() +
                 "\nNumber of sailors : " + number_of_hired_drivers() ;


         return str ;



     }




    //=============================================================================================== Saving Airport




    public static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/shippingPorts.txt";

    public void saveShippingPort() throws IOException {

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
        this.startingPointIDs.removeAll(startingPointIDs);
        this.destinationPointIDs.removeAll(destinationPointIDs);
        this.driverIDs.removeAll(driverIDs);
        this.employeeIDs.removeAll(employeeIDs);
        this.vehicleIDs.removeAll(vehicleIDs);


    }


    public static void restoreShippingPorts() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){
                ShippingPort newSippingPort = (ShippingPort) obIn.readObject();


                newSippingPort.restoreTerminal();

                shippingPortsList.add(newSippingPort);

            }
        }
        catch (EOFException ex){}


        fin.close();

    }

}
