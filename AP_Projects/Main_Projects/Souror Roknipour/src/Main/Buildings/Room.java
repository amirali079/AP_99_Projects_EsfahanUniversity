package Main.Buildings;

import Main.City;
import Main.Country;

import java.io.Serializable;

public class Room implements Serializable {

    private final int Area;
    private final int ID;
    private final int beds;
    private final double Room_price = City.Cost.Room.getCost();

    public Room(int ID, int area, int numberofbeds) {
        this.ID = ID;
        Area = area;
        this.beds = numberofbeds;
        Country.country.inputCity.setInventory(this.Room_price);
        Country.country.removeCountryInventory(this.Room_price);
    }

    public int getArea() {
        return Area;
    }

    public int getID() {
        return ID;
    }

    public int getBeds() {
        return beds;
    }

    public double getRoom_price() {
        return Room_price;
    }
}
