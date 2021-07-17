package Main.Vehicles;

import java.io.Serializable;
import java.util.ArrayList;

public class Boat extends Sea_Vehicle implements Serializable {
    private String Boat_body_type;//جنس بدنه قایق
    private static final ArrayList<Boat>boats=new ArrayList<>();
    public Boat(int price, int capacity, int ID, String company_builder_name, String fuel_type, int minimum_depth_to_move, String boat_body_type) {
        super(price, capacity, ID, company_builder_name, fuel_type, minimum_depth_to_move);
        Boat_body_type = boat_body_type;
    }
    public void AddBoats(Boat boat){
        boats.add(boat);
    }

    public static ArrayList<Boat> getBoats() {
        return boats;
    }

    public String getBoat_body_type() {
        return Boat_body_type;
    }
    public void setBoat_body_type(String boat_body_type) {
        Boat_body_type = boat_body_type;
    }

    public static void ShowBoats(){
        System.out.println("\n*************************************************************SHOW BOATS*************************************************************");
        for(int i=0;i<boats.size();i++){
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Boat body type: %s ",i,boats.get(i).getPrice(),boats.get(i).getCapacity(),boats.get(i).getCompany_builder_name(),boats.get(i).getFuel_type(),boats.get(i).getMinimum_depth_to_move(),boats.get(i).getBoat_body_type());
            System.out.println();
        }
    }
}
