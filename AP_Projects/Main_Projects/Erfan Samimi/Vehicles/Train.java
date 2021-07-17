package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Train extends Land_transport_vehicle{


    enum Services {
        Restaurant , Breakfast , Lunch , Dinner
    }
    private  static ArrayList<Train> trainsList = new ArrayList<Train>();
    private int number_of_wagons ;
    private int stars ;

    public Train(int number_of_wagons, int stars, int fuel_capacity, String fuel_type, int speed, int passenger_capacity, String name_company, String ID){
        super(fuel_capacity , fuel_type ,speed ,500 ,passenger_capacity ,name_company , ID);
        this.number_of_wagons = number_of_wagons ;
        this.stars = stars ;
        trainsList.add(this);
    }

    public static ArrayList<Train> getTrainsList(){
        return trainsList;
    }




    //======================================================================================= Saving  Ships


    private static String address = "/home/erfan/Projects/Java/Files/CityGame/trains.csv"  ;
    public static boolean append = false;



    public void saveTrain() throws IOException {

        FileOutputStream fout = new FileOutputStream( address, append);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%d,%d,%d,%s,%d,%d,%s,%s\n" , this.number_of_wagons ,this.stars , this.fuel_capacity ,this.fuel_type ,this.speed , this.getCapacity() ,this.getName_builder_company() ,this.getID());
        append = true;
        pw.close();
        fout.close();
    }


    public static void restoreTrains() throws IOException {

        FileInputStream fin = new FileInputStream( address );
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] train =sc.nextLine().split(",");

            Train newTrain = new Train( Integer.parseInt(train[0]) ,  Integer.parseInt(train[1])  ,  Integer.parseInt(train[2])  , train[3] ,  Integer.parseInt(train[4]) ,  Integer.parseInt(train[5]) , train[6] , train[7]);

        }

        fin.close();
    }


}


