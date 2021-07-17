package Main.Safar;

import Main.Building.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;

public interface Safarable {

    void newJourney(Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price);
    ArrayList<Safar> sortJourneys(ArrayList<Safar> sa);
    int journeyPrice ( ArrayList<Person> passengerList , int ticketPrice);

    String journeyHistory( boolean startingTerminal , boolean destinationTerminal);

}
