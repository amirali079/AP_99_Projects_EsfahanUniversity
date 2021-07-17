package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Airport;
import java.io.Serializable;

public abstract class AirVehicle extends Vehicle implements Serializable {
    protected static boolean isFirstAirplane = true;
    protected int requiredAirstripLength;

    public AirVehicle(int ID, int orderNumber) {
        super(ID, orderNumber);
    }

    public int discountPercent() {
        return isFirstAirplane ? 10 : 0;
    }

    @Override
    public String toString(){
        return super.toString() + "\nRequired airstrip length : " + this.requiredAirstripLength;
    }

    public int getRequiredAirstripLength() {
        return requiredAirstripLength;
    }
}
