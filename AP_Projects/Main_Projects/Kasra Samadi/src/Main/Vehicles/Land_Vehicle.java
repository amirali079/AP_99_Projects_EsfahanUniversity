package Main.Vehicles;

import java.io.Serializable;

public abstract class Land_Vehicle extends Vehicle implements Serializable {
    private String Fuel_type;
    private int Ticket_price;

    public Land_Vehicle(int price, int capacity, int ID, String company_builder_name, String fuel_type, int ticket_price) {
        super(price, capacity, ID, company_builder_name);
        Fuel_type = fuel_type;
        Ticket_price = ticket_price;
    }

    public String getFuel_type() {
        return Fuel_type;
    }

    public int getTicket_price() {
        return Ticket_price;
    }

    public void setFuel_type(String fuel_type) {
        Fuel_type = fuel_type;
    }

    public void setTicket_price(int ticket_price) {
        Ticket_price = ticket_price;
    }
}
