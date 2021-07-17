package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.RailwayStation;
import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NoRoomException;
import com.example.mohammad_es_faz4_gui.BackEnd.Exceptions.NotEnoughMoneyException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final public class Train extends LandVehicle implements Serializable {
    private final ArrayList<String> selectedOptions = new ArrayList<>();
    private final int wagons, star;

    public Train(City city,int orderNumber, RailwayStation railwayStation, int ID) throws IOException, NotEnoughMoneyException, NoRoomException {
        super(ID, orderNumber);
        ArrayList<String> properties = Country.sellListReader("Train.csv", orderNumber);
        this.capacity = Integer.parseInt(properties.get(1));
        this.wagons = Integer.parseInt(properties.get(2));
        this.star = Integer.parseInt(properties.get(3));
        this.price = Double.parseDouble(properties.get(4));
        this.price *=  (100 - discountPercent()) / 100.0;
        if (city.getMoney() < this.price)
            throw new NotEnoughMoneyException("There is no room for adding new train");
        city.setMoney(city.getMoney() - this.price);
        if (railwayStation.getVehicles().size() >= railwayStation.getMaxVehicle())
            throw new NoRoomException();
        isFirstLandVehicle = false;
    }
    public Train(City city,int orderNumber, RailwayStation railwayStation) throws IOException, NotEnoughMoneyException, NoRoomException {
        this(city,orderNumber, railwayStation, numberOFCreatedVehicle);
    }

        public static void insertOptions(City city, TrainOptions welfareService, RailwayStation railwayStation){
        if (city.getMoney() < 100)
            throw new NotEnoughMoneyException();
        ((Train)railwayStation.getVehicles().get(railwayStation.getVehicles().size()-1)).selectedOptions.add(welfareService.name());
        city.setMoney(city.getMoney()-100);
    }

    @Override
    public String toString(){
        return super.toString() + "\nStar: " + this.star + "\nWagon : " + this.wagons + "\nPrice: " + this.price;
    }

    public ArrayList<String> getSelectedOptions() {
        return selectedOptions;
    }

    public int getWagons() {
        return wagons;
    }

    public int getStar() {
        return star;
    }

}