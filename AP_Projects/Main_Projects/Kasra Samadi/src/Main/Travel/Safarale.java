package Main.Travel;
import Main.Buildings.Terminal;
import Main.City;
import Main.Person;
import Main.Vehicles.Vehicle;
import java.util.ArrayList;

public interface Safarale {
    void Travel(City BeginningCity, City DestinationCity ,Terminal BeginningTerminal, Terminal DestinationTerminal, ArrayList<Person>passengers, Person driver, Vehicle vehicle, int ID, String Date, double TravelCost);
    void TravelSort();
    double CalculateTravelCost(ArrayList<Person>passengers,Vehicle vehicle);
    void TravelHistory();
}
