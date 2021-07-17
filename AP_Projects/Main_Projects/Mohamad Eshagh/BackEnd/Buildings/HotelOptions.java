package com.example.mohammad_es_faz4_gui.BackEnd.Buildings;

public enum HotelOptions{
    restaurant, WIFI;
    private final static HotelOptions[] allOptions = HotelOptions.values();
    public static HotelOptions[] getAllOptions() {
        return allOptions;
    }
}
