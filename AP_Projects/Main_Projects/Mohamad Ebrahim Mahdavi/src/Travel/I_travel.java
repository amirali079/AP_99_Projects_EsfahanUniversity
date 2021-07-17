package Travel;
import Exceptions.Empty_list_exception;
import Exceptions.Incorrect_entry_exception;
import Main.Buildings.Terminal;
import Main.Vehicles.Vehicle;
import Main.person;

import java.util.ArrayList;

public interface I_travel {
    double add_travel(String id, String date, Terminal destination_name, Vehicle vehicle, person driver, ArrayList<person> passengers) throws Exception;

    void sort_travel(String a_or_d) throws Incorrect_entry_exception;
    double calculate_price(Vehicle vehicle,int passengers_num);
    void travel_history(String a_or_d) throws Incorrect_entry_exception, Empty_list_exception;
}
