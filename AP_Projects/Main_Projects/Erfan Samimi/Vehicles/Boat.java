package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Boat extends Shipping_vehicle{
    private int max_distance ;

    private static ArrayList<Boat> boatsList = new ArrayList<Boat>() ;


    public Boat(int max_distance, String fuel_type, int min_depth, int capacity, String ID, String companyName){
        super(fuel_type , min_depth , 300 , capacity , ID , companyName);
        this.max_distance = max_distance;
        boatsList.add(this);
    }


    public static ArrayList<Boat> getBoatsList() { return boatsList; }
    public void showInfo(){
        System.out.println("max distance " + max_distance);
        System.out.println("fuel  " + fuel_type);
        System.out.println("min depth " + min_depth);

    }


    //==================================================================================== Saving boats

    private static String address = "/home/erfan/Projects/Java/Files/CityGame/boats.csv";
    public static boolean append = false;

    public void saveBoat() throws IOException {

        FileOutputStream fout = new FileOutputStream(address, append);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%d,%s,%d,%d,%s,%s\n"  , this.max_distance , this.fuel_type , this.min_depth , this.getCapacity() , this.getID() , this.getName_builder_company());
        append =true;
        pw.close();
        fout.close();
    }

    public static void restoreBoats() throws IOException {

        FileInputStream fin = new FileInputStream(address );
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] boat = sc.nextLine().split(",");

            Boat newBoat = new Boat(Integer.parseInt(boat[0])  , boat[1] , Integer.parseInt(boat[2])  ,  Integer.parseInt(boat[3]) , boat[4] , boat[5] );
        }

        fin.close();
    }
}

