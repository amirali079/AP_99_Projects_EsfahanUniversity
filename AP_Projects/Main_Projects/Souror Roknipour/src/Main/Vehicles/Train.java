package Main.Vehicles;

import Main.City;
import Main.Country;
import Main.trip.Travel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Train extends Land_vehicles implements Serializable {

    private final int Number_of_wagons;
    private String[] Stars = {"\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F", "\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F"};
    private final String star;
    private final int ticketCost = Travel.ticketCost.Train.getTicketCost();
    private final ArrayList<String> services = new ArrayList<>();

    public Train(int capacity, String company, int max_speed, String fuel_type, int number_of_wagons, int star) {
        super(City.Cost.Train.getCost(), capacity, company, max_speed, fuel_type);
        Number_of_wagons = number_of_wagons;
        this.star = Stars[star - 1];
    }

    public void addServices(ArrayList<String> s) {
        services.addAll(s);
        Country.country.inputCity.setInventory((City.Cost.train_services.getCost())*s.size());
        Country.country.removeCountryInventory((City.Cost.train_services.getCost())*s.size());
    }


    public int getNumber_of_wagons() {
        return Number_of_wagons;
    }

    public ArrayList<String> getT_services() {
        return services;
    }

    public String getStar() {
        return star;
    }

    public int getTicketCost() {
        return ticketCost;
    }
}


