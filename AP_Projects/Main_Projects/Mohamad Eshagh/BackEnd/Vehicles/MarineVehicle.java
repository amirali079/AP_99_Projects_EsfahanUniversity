package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import java.io.Serializable;

public abstract class MarineVehicle extends Vehicle implements Serializable {
    protected String fuelType, minDepth;
    protected static boolean isFirstMarineVehicle = true;

    MarineVehicle(int ID, int orderNumber) {
        super(ID, orderNumber);
    }

    public int discountPercent() {
        return isFirstMarineVehicle ? 10 :0;
    }
    @Override
    public String toString(){
        return super.toString() + "\nFuel type: " + this.fuelType + "\nMin depth: " + this.minDepth;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getMinDepth() {
        return minDepth;
    }

}

