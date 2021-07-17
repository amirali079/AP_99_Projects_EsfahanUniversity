package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Passenger_airplane extends Air_transport_vehicle {

    private int number_of_flightAttendants;
    private String classType ;     // business class , economy class


    private static ArrayList<Passenger_airplane> passenger_airplanesList = new ArrayList<Passenger_airplane>() ;

    public Passenger_airplane(int number_of_flightAttendants, String classType, int max_flight_height, int runway_length
            , int capacity, String ID, String companyName){

        super(max_flight_height ,runway_length , 800 ,capacity ,ID ,companyName);
        this.number_of_flightAttendants = number_of_flightAttendants ;
        this.classType = classType;
        passenger_airplanesList.add(this);

    }
    public static ArrayList<Passenger_airplane> getPassenger_airplanesList(){
        return passenger_airplanesList;
    }



    //======================================================================================= Saving Passenger airplanes


    private static String address = "/home/erfan/Projects/Java/Files/CityGame/passenger_airplanes.csv" ;
    public static boolean append = false;



    public void savePassenger_airplane() throws IOException {

        FileOutputStream fout = new FileOutputStream(address , append);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%d,%s,%d,%d,%d,%s,%s\n" , this.number_of_flightAttendants , this.classType , this.max_flight_height , this.runway_length , this.getCapacity() , this.getID() , this.getName_builder_company()  );
        append = true;
        pw.close();
        fout.close();
    }

    public static void  restorePassenger_airplane() throws IOException {

        FileInputStream fin = new FileInputStream( address );
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] airplane = sc.nextLine().split(",");


            Passenger_airplane newAirplane = new Passenger_airplane( Integer.parseInt(airplane[0])  , airplane[1] ,  Integer.parseInt(airplane[2]) ,  Integer.parseInt(airplane[3]) ,  Integer.parseInt(airplane[4]) ,
                    airplane[5] , airplane[6] );

        }

        fin.close();
    }
}


