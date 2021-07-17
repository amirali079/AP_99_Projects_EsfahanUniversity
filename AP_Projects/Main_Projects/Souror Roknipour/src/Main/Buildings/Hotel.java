package Main.Buildings;
import Main.City;
import Main.Country;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private int room_counter = 0;
    private int ID;
    private final String name;
    private final String Address;
    private final double cost = City.Cost.Hotel.getCost();
    private int Number_of_rooms = 0;
    private final String Star;

    private String[] Stars = {"\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F"};


    private ArrayList<String> services = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();

    public Hotel(String name, String address, int star) {
        this.name = name;
        Address = address;
        Country.country.inputCity.setInventory(this.cost);
        Country.country.removeCountryInventory(this.cost);
        this.Star = Stars[star - 1];
        this.ID = Country.country.getNumOfHotels();
    }


    public void addServices(ArrayList<String> s) {
        services.addAll(s);
        Country.country.inputCity.setInventory(City.Cost.Hotelservices.getCost()*s.size());
        Country.country.removeCountryInventory(City.Cost.Hotelservices.getCost()*s.size());
        Country.country.save();
    }

    public void addRoom(int area, int numberOfBeds) {
        rooms.add(new Room(++this.room_counter, area,numberOfBeds));
        ++this.Number_of_rooms;
        Country.country.save();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getRoom_counter() {
        return room_counter;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return Address;
    }

    public double getCost() {
        return cost;
    }

    public int getNumber_of_rooms() {
        return Number_of_rooms;
    }

    public String getStar() {
        return Star;
    }

    public String[] getStars() {
        return Stars;
    }

    public ArrayList<String> getServices() {
        return services;
    }
}
