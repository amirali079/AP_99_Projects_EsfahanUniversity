package com.example.mohammad_es_faz4_gui.BackEnd.Vehicles;

import java.io.Serializable;

public enum TrainOptions implements Serializable {
    restaurant, library;
    private final static TrainOptions[] allOptions = TrainOptions.values();
    public static TrainOptions[] getAllOptions() {
        return allOptions;
    }
}
