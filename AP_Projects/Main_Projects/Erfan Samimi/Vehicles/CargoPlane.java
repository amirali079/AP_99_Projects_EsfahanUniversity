package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CargoPlane extends Air_transport_vehicle {
    private int total_weight ;
    private static ArrayList<CargoPlane> cargoPlanesList = new ArrayList<CargoPlane>();

    public CargoPlane(int total_weight, int max_flight_height, int runway_length, int capacity, String ID, String companyName){
        super(max_flight_height , runway_length , 700 , capacity , ID ,companyName);
        this.total_weight = total_weight ;
        cargoPlanesList.add(this) ;
    }

    public static ArrayList<CargoPlane> getCargoPlanesList(){
        return cargoPlanesList;
    }

    //======================================================================================= Saving cargo planes


    private static String address = "/home/erfan/Projects/Java/Files/CityGame/cargoPlanes.csv" ;
    public static boolean append = false;

    public void saveCargoPlane() throws IOException {

        FileOutputStream fout = new FileOutputStream( address , append);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%d,%d,%d,%d,%s,%s\n" , this.total_weight , this.max_flight_height , this.runway_length ,this.getCapacity() , this.getID() ,this.getName_builder_company() );
        append = true;
        pw.close();
        fout.close();
    }

    public static void restoreCargoPlane() throws IOException {

        FileInputStream fin = new FileInputStream(address );
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] cargoPlane = sc.nextLine().split(",");

            CargoPlane newCargoPlane = new CargoPlane( Integer.parseInt(cargoPlane[0]) ,  Integer.parseInt(cargoPlane[1]) ,  Integer.parseInt(cargoPlane[2])  ,  Integer.parseInt(cargoPlane[3]) , cargoPlane[4] , cargoPlane[5] );

        }

        fin.close();
    }
}
