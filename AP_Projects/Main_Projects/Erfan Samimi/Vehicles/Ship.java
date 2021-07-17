package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ship extends Shipping_vehicle {
    private String classType ;
    private int shipLength ;
    private static ArrayList<Ship> shipsList = new ArrayList<Ship>();


    public Ship(String classType, int shipLength, String fuel_type, int min_depth, int capacity, String ID, String companyName){
        super(fuel_type , min_depth , 600 ,capacity ,ID ,companyName);
        this.classType = classType ;
        this.shipLength = shipLength;
        shipsList.add(this);
    }
    public static ArrayList<Ship> getShipsList(){
        return shipsList;
    }



    //======================================================================================= Saving  Ships


    private static String address = "/home/erfan/Projects/Java/Files/CityGame/ships.csv"  ;
    public static boolean append = false;


    public void saveShip() throws IOException {

        FileOutputStream fout = new FileOutputStream(address, append);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%s,%d,%s,%d,%d,%s,%s\n" , this.classType , this.shipLength , this.fuel_type , this.min_depth , this.getCapacity() , this.getID() , this.getName_builder_company() );
        append = true;
        pw.close();
        fout.close();
    }

    public static void restoreShips() throws IOException {

        FileInputStream fin = new FileInputStream(address );
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] ship = sc.nextLine().split(",");

            Ship newShip = new Ship( ship[0] , Integer.parseInt(ship[1])  , ship[2] ,  Integer.parseInt(ship[3]) ,  Integer.parseInt(ship[4]) , ship[5] , ship[6] ) ;

        }

        fin.close();
    }

}
