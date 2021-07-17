package Main.Vehicles;

import Main.Exception.ID_exception;
import Main.Exception.Vehicle_does_not_exists_Exception;

import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle {
    private int price ;
    private int capacity ;
    private String ID ;
    private String name_builder_company ;
    private static ArrayList<String> ID_list = new ArrayList<String>();
//    private static int ticketPrice = 0;
    private static ArrayList<Vehicle> vehiclesList = new ArrayList<>();

    //==================================================

    public Vehicle(){};

    Vehicle(int price , int capacity , String ID , String name_builder_company){
        Scanner sc = new Scanner(System.in);
        this.price = price ;
        this.capacity = capacity ;
        this.name_builder_company = name_builder_company ;

//        while (ID_list.contains(ID)){
//            System.out.print("This ID exists ! Please Set new ID for this vehicle : ");
//            ID = sc.nextLine();
//        }


        if (ID_list.contains(ID))
            throw new ID_exception("This ID Exists");

        this.ID = ID;
        ID_list.add(ID);

        vehiclesList.add(this);



    }

    public int getCapacity(){
        return capacity;
    }

    public static Vehicle getVehicleByID( String ID){
        for (Vehicle a : vehiclesList ){
            if (a.ID.equals(ID))
                return a;
        }

        throw new Vehicle_does_not_exists_Exception("No vehicle exist with this id ");
    }


    public String getVehicleType(){
        if (this instanceof Air_transport_vehicle)
            return "Air_transport_vehicle";

        else if ( this instanceof Train)
            return "Train";

        else if ( this instanceof  Bus)
            return "Bus";

        else
            return "Shipping_vehicle";
    }

    public String getID(){
        return this.ID;
    }

    public String getName_builder_company() {
        return name_builder_company;
    }


}
