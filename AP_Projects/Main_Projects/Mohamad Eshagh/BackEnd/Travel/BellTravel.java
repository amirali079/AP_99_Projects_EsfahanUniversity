package com.example.mohammad_es_faz4_gui.BackEnd.Travel;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Terminal;
import com.example.mohammad_es_faz4_gui.BackEnd.City;
import com.example.mohammad_es_faz4_gui.BackEnd.Person;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

public interface BellTravel extends Serializable {
    void newTrip(Terminal destinationTerminal, Person Driver, Vehicle vehicle, Date date, City beginningCity, City destinationCity, HashSet<Person> passengers);
   //  void sortTrip(); We have a TreeSet :)
    double calculateTripCost(int passengers, Vehicle vehicle);
    String tripHistory(boolean incomingTravel, boolean outBoundTravel);
}
