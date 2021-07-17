package Main.Vehicles;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private int Price;
    private int Capacity;
    private int ID;
    private String Company_builder_name;

    public Vehicle(int price, int capacity, int ID, String company_builder_name) {
        Price = price;
        Capacity = capacity;
        this.ID = ID;
        Company_builder_name = company_builder_name;
    }

    public int getPrice() {
        return Price;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getID() {
        return ID;
    }

    public String getCompany_builder_name() {
        return Company_builder_name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCompany_builder_name(String company_builder_name) {
        Company_builder_name = company_builder_name;
    }
}

