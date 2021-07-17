package Main.Buildings;
import Main.Person;
import Main.Vehicles.Service;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private String Hotel_name;
    private int Cost_Construction;
    private String Address;
    private int Star_number;
    private int Number_of_rooms;
    private boolean isConstructed;
    private static final ArrayList<Hotel>hotels=new ArrayList<>();
    private final ArrayList<Service>servises=new ArrayList<>();
    private final ArrayList<Room>rooms=new ArrayList<>();
    private final ArrayList<Person>crews=new ArrayList<>();

    public Hotel(String hotel_name, int costConstruction, String address, int star_number, int number_of_rooms, Service service1) {
        Hotel_name = hotel_name;
        Cost_Construction = costConstruction;
        Address = address;
        Star_number = star_number;
        Number_of_rooms = number_of_rooms;
        servises.add(service1);

        isConstructed=false;
    }
    public Hotel(String hotel_name, int costConstruction, String address, int star_number, int number_of_rooms, Service service1, Service service2) {
        Hotel_name = hotel_name;
        Cost_Construction = costConstruction;
        Address = address;
        Star_number = star_number;
        Number_of_rooms = number_of_rooms;
        servises.add(service1);
        servises.add(service2);
        isConstructed=false;
    }
    public Hotel(String hotel_name, int costConstruction, String address, int star_number, int number_of_rooms, Service service1, Service service2, Service service3) {
        Hotel_name = hotel_name;
        Cost_Construction = costConstruction;
        Address = address;
        Star_number = star_number;
        Number_of_rooms = number_of_rooms;
        servises.add(service1);
        servises.add(service2);
        servises.add(service3);
        isConstructed=false;
    }
    public Hotel(String hotel_name, int costConstruction, String address, int star_number, int number_of_rooms, Service service1, Service service2, Service service3, Service service4) {
        Hotel_name = hotel_name;
        Cost_Construction = costConstruction;
        Address = address;
        Star_number = star_number;
        Number_of_rooms = number_of_rooms;
        servises.add(service1);
        servises.add(service2);
        servises.add(service3);
        servises.add(service4);
        isConstructed=false;
    }
    public Hotel(String hotel_name, int costConstruction, String address, int star_number, int number_of_rooms, Service service1, Service service2, Service service3, Service service4, Service service5) {
        Hotel_name = hotel_name;
        Cost_Construction = costConstruction;
        Address = address;
        Star_number = star_number;
        Number_of_rooms = number_of_rooms;
        servises.add(service1);
        servises.add(service2);
        servises.add(service3);
        servises.add(service4);
        servises.add(service5);
        isConstructed=false;
    }
    public void AddHotel(Hotel hotel){
        hotels.add(hotel);
    }
    public void AddRoom(Room room){
        rooms.add(room);
        setNumber_of_rooms(getNumber_of_rooms()+1);
    }
    public void AddCrew(Person person){
        crews.add(person);
    }

    public String getHotel_name() {
        return Hotel_name;
    }

    public int getCost_Construction() {
        return Cost_Construction;
    }

    public String getAddress() {
        return Address;
    }

    public int getStar_number() {
        return Star_number;
    }

    public int getNumber_of_rooms() {
        return Number_of_rooms;
    }

    public static ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<Service> getServises() {
        return servises;
    }

    public ArrayList<Person> getCrews() {
        return crews;
    }

    public boolean isConstructed() {
        return isConstructed;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setHotel_name(String hotel_name) {
        Hotel_name = hotel_name;
    }

    public void setCost_Construction(int cost_Construction) {
        Cost_Construction = cost_Construction;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setStar_number(int star_number) {
        Star_number = star_number;
    }

    public void setNumber_of_rooms(int number_of_rooms) {
        Number_of_rooms = number_of_rooms;
    }

    public void setConstructed(boolean constructed) {
        isConstructed = constructed;
    }

    public static void ShowHotel(Hotel hotel){
        System.out.format("Hotel name: %s , Construction cost: %d , Address: %s , Star number: %d , Number of rooms: %d , Constructed Situation: %s \n",hotel.getHotel_name(),hotel.getCost_Construction(),hotel.getAddress(),hotel.getStar_number(),hotel.getNumber_of_rooms(),hotel.isConstructed());
    }
    public static void ShowAllHotels(){
        System.out.println("\n*************************************************************SHOW HOTELS*************************************************************");
        for(int i=0;i<hotels.size();i++){
            System.out.format("\n(ID:%d) Hotel name: %s , Construction cost: %d , Address: %s , Star number: %d , Number of rooms: %d , Constructed Situation: %s , ",i,hotels.get(i).getHotel_name(),hotels.get(i).getCost_Construction(),hotels.get(i).getAddress(),hotels.get(i).getStar_number(),hotels.get(i).getNumber_of_rooms(),hotels.get(i).isConstructed());
            for (int j=0;j<hotels.get(i).getServises().size();j++){
                System.out.format(" [Services%d: %s]",j+1,hotels.get(i).getServises().get(j));
            }
            System.out.println();
        }
    }
    public static boolean ShowConstructedHotels(){
        System.out.println("\n*************************************************************SHOW CONSTRUCTED HOTELS*************************************************************");
        boolean a=false;
        for(int i=0;i<hotels.size();i++) {
            if (hotels.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Hotel name: %s , Construction cost: %d , Address: %s , Star number: %d , Number of rooms: %d , Constructed Situation: %s , ", i, hotels.get(i).getHotel_name(), hotels.get(i).getCost_Construction(), hotels.get(i).getAddress(), hotels.get(i).getStar_number(), hotels.get(i).getNumber_of_rooms(), hotels.get(i).isConstructed());
                for (int j = 0; j < hotels.get(i).getServises().size(); j++) {
                    System.out.format(" [Services%d: %s]", j + 1, hotels.get(i).getServises().get(j));
                }
                System.out.println();
                a=true;
            }
        }
        return a;
    }
    public static void ShowNotConstructedHotels(){
        System.out.println("\n*************************************************************SHOW NOT CONSTRUCTED HOTELS*************************************************************");
        for(int i=0;i<hotels.size();i++){
            if (!hotels.get(i).isConstructed) {
                System.out.format("\n(ID:%d) Hotel name: %s , Construction cost: %d , Address: %s , Star number: %d , Number of rooms: %d , Constructed Situation: %s , ", i, hotels.get(i).getHotel_name(), hotels.get(i).getCost_Construction(), hotels.get(i).getAddress(), hotels.get(i).getStar_number(), hotels.get(i).getNumber_of_rooms(), hotels.get(i).isConstructed());
                for (int j = 0; j < hotels.get(i).getServises().size(); j++) {
                    System.out.format(" [Services%d: %s]", j + 1, hotels.get(i).getServises().get(j));
                }
                System.out.println();
            }
        }
    }
}
