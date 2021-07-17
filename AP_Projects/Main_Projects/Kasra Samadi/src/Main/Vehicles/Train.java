package Main.Vehicles;

import java.io.Serializable;
import java.util.ArrayList;

public class Train extends Land_Vehicle implements Serializable {
    private int Number_of_wagons;
    private int Number_of_stars;
    private static final ArrayList<Train>trains=new ArrayList<>();
    private final ArrayList<Service>servises=new ArrayList<>();

    public Train(int price, int capacity, int ID, String company_builder_name, String fuel_type,Service service1,Service service2,int ticket_price, int number_of_wagons, int number_of_stars) {
        super(price, capacity, ID, company_builder_name, fuel_type, ticket_price);
        servises.add(service1);
        servises.add(service2);
        Number_of_wagons = number_of_wagons;
        Number_of_stars = number_of_stars;
    }
    public Train(int price, int capacity, int ID, String company_builder_name, String fuel_type,Service service1,Service service2,Service service3 ,int ticket_price, int number_of_wagons, int number_of_stars) {
        super(price, capacity, ID, company_builder_name, fuel_type, ticket_price);
        servises.add(service1);
        servises.add(service2);
        servises.add(service3);
        Number_of_wagons = number_of_wagons;
        Number_of_stars = number_of_stars;
    }
    public void AddTrains(Train train){
        trains.add(train);
    }

    public static ArrayList<Train> getTrains() {
        return trains;
    }

    public ArrayList<Service> getServises() {
        return servises;
    }

    public int getNumber_of_wagons() {
        return Number_of_wagons;
    }

    public int getNumber_of_stars() {
        return Number_of_stars;
    }

    public void setNumber_of_wagons(int number_of_wagons) {
        Number_of_wagons = number_of_wagons;
    }

    public void setNumber_of_stars(int number_of_stars) {
        Number_of_stars = number_of_stars;
    }

    public static void ShowTrains(){
        System.out.println("\n*************************************************************SHOW TRAINS*************************************************************");
        for(int i=0;i<trains.size();i++){
            System.out.format("\n(ID:%d) Price: %d , Capacity: %d , Company Builder Name: %s , Fuel Type: %s , Ticket Price: %d , Number of wagons: %d , Number of stars: %d ",i,trains.get(i).getPrice(),trains.get(i).getCapacity(),trains.get(i).getCompany_builder_name(),trains.get(i).getFuel_type(),trains.get(i).getTicket_price(),trains.get(i).getNumber_of_wagons(),trains.get(i).getNumber_of_stars());

            for (int j=0;j<trains.get(i).getServises().size();j++){
                System.out.format(" [Services%d: %s]",j+1,trains.get(i).getServises().get(j));
           }
            System.out.println();
        }
    }
}
