package Main.Vehicles;

import java.io.Serializable;
import java.util.ArrayList;

public class Ship extends Sea_Vehicle implements Serializable {
    private int Number_of_lifeboats;//تعداد قایق های نجات
    private int Number_of_crew;//تعداد خدمه
    private static final ArrayList<Ship>ships=new ArrayList<>();

    public Ship(int price, int capacity, int ID, String company_builder_name, String fuel_type, int minimum_depth_to_move, int number_of_lifeboats, int number_of_crew) {
        super(price, capacity, ID, company_builder_name, fuel_type, minimum_depth_to_move);
        Number_of_lifeboats = number_of_lifeboats;
        Number_of_crew = number_of_crew;
    }

    public void AddShips(Ship ship){
        ships.add(ship);

    }

    public static ArrayList<Ship> getShips() {
        return ships;
    }

    public int getNumber_of_lifeboats() {
        return Number_of_lifeboats;
    }

    public int getNumber_of_crew() {
        return Number_of_crew;
    }

    public void setNumber_of_lifeboats(int number_of_lifeboats) {
        Number_of_lifeboats = number_of_lifeboats;
    }

    public void setNumber_of_crew(int number_of_crew) {
        Number_of_crew = number_of_crew;
    }

    public static void ShowShips(){
        System.out.println("\n*************************************************************SHOW SHIPS*************************************************************");
        for(int i=0;i<ships.size();i++){
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Number Of lifeboat: %d  ,Number Of Crew: %d  ",i,ships.get(i).getPrice(),ships.get(i).getCapacity(),ships.get(i).getCompany_builder_name(),ships.get(i).getFuel_type(),ships.get(i).getMinimum_depth_to_move(),ships.get(i).getNumber_of_lifeboats(),ships.get(i).getNumber_of_crew());
            System.out.println();
        }
    }
}
