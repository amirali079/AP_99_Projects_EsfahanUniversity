package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import java.io.Serializable;

abstract class LandVehicle extends Vehicle implements Serializable {
    protected static boolean isFirstLandVehicle = true;

    public LandVehicle(int ID, int orderNumber) {
        super(ID, orderNumber);
    }

    public int discountPercent() {
        return isFirstLandVehicle ? 10 : 0;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
