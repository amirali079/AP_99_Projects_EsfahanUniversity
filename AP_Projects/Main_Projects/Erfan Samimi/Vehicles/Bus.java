package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus extends Land_transport_vehicle{
    private String class_type ; //business class , economy class
    private int KPL ;  //kilometer per liter
    private static ArrayList<Bus> busesList = new ArrayList<Bus>() ;


    public Bus(String class_type, int KPL, int fuel_capacity, String fuel_type, int speed, int passenger_capacity, String name_company, String ID){
        super(fuel_capacity , fuel_type , speed , 200 , passenger_capacity , name_company , ID);
        this.class_type = class_type;
        this.KPL = KPL ;
        busesList.add(this);
    }
    public static ArrayList<Bus> getBusesList(){
        return busesList;
    }


    // ========================================================================================== Saving bus

    private static String address = "/home/erfan/Projects/Java/Files/CityGame/buses.csv" ;
    public static boolean append = false;

    public void saveBus() throws IOException {

        FileOutputStream fout = new FileOutputStream(address, append);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%s,%d,%d,%s,%d,%d,%s,%s\n" , this.class_type , this.KPL , this.fuel_capacity , this.class_type , this.speed , this.getCapacity() , this.getName_builder_company() , this.getID() );
        append = true;
        pw.close();
        fout.close();
    }



    public static void restoreBuses() throws IOException {

        FileInputStream fin = new FileInputStream(address);
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] bus = sc.nextLine().split(",");

            Bus newBus = new Bus(bus[0]  ,  Integer.parseInt(bus[1]) , Integer.parseInt(bus[2])  , bus[3]  ,  Integer.parseInt(bus[4]) , Integer.parseInt(bus[5]) , bus[6] , bus[7]  );

        }

        fin.close();
    }


}
