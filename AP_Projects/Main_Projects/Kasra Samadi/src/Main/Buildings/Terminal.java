package Main.Buildings;
import Main.City;
import Main.ConsoleColors;
import Main.Person;
import Main.Travel.Safarale;
import Main.Travel.Travel;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Terminal implements Safarale , Serializable {
    private int Cost_Construction;//هزینه ساخت
    private String City_name;
    private String Terminal_name;
    private String Address;
    private int Area;
    private int Number_of_vehicles;
    private final ArrayList<Person>Leaders= new ArrayList<>();
    private final ArrayList<Travel>TravelsInput= new ArrayList<>();
    private final ArrayList<Travel>TravelsOutput= new ArrayList<>();


    public Terminal(int cost_Construction, String city_name, String terminal_name, String address, int area, int number_of_vehicles) {
        Cost_Construction = cost_Construction;
        City_name = city_name;
        Terminal_name = terminal_name;
        Address = address;
        Area = area;
        Number_of_vehicles = number_of_vehicles;
    }

    public void Add_Leaders(Person person){
        Leaders.add(person);
    }

    public int getCost_Construction() {
        return Cost_Construction;
    }

    public String getCity_name() {
        return City_name;
    }

    public String getTerminal_name() {
        return Terminal_name;
    }

    public String getAddress() {
        return Address;
    }

    public int getArea() {
        return Area;
    }

    public int getNumber_of_vehicles() {
        return Number_of_vehicles;
    }

    public ArrayList<Person> getLeaders() {
        return Leaders;
    }

    public void setCost_Construction(int cost_Construction) {
        Cost_Construction = cost_Construction;
    }

    public void setCity_name(String city_name) {
        City_name = city_name;
    }

    public void setTerminal_name(String terminal_name) {
        Terminal_name = terminal_name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setArea(int area) {
        Area = area;
    }

    public void setNumber_of_vehicles(int number_of_vehicles) {
        Number_of_vehicles = number_of_vehicles;
    }


    @Override
    public void Travel(City BeginningCity,City DestinationCity ,Terminal BeginningTerminal, Terminal DestinationTerminal, ArrayList<Person> passengers, Person driver, Vehicle vehicle, int ID, String Date, double TravelCost) {

        Travel travel=new Travel(BeginningTerminal,DestinationTerminal,passengers,driver,vehicle,ID,Date,TravelCost);

        BeginningTerminal.TravelsOutput.add(travel);
        DestinationTerminal.TravelsInput.add(travel);
        BeginningTerminal.Leaders.remove(driver);
        DestinationTerminal.Leaders.add(driver);
        if(BeginningTerminal instanceof Airport){
            Airport BeginningAirport=(Airport) BeginningTerminal;
            Airport DestinationAirport=(Airport) DestinationTerminal;
            BeginningAirport.getAir_vehicles().remove((Passenger_plane)vehicle);
            BeginningAirport.setNumber_of_vehicles(BeginningAirport.getNumber_of_vehicles()-1);
            DestinationAirport.AddPassenger_plane((Passenger_plane)vehicle);
        }else if(BeginningTerminal instanceof RailwayStation){
            RailwayStation BeginningRailwayStation=(RailwayStation) BeginningTerminal;
            RailwayStation DestinationRailwayStation=(RailwayStation) DestinationTerminal;
            BeginningRailwayStation.getTrains().remove((Train) vehicle);
            BeginningRailwayStation.setNumber_of_vehicles(BeginningRailwayStation.getNumber_of_vehicles()-1);
            DestinationRailwayStation.AddTrains((Train)vehicle);
        }else if(BeginningTerminal instanceof ShippingPort){
            ShippingPort BeginningShippingPort=(ShippingPort) BeginningTerminal;
            ShippingPort DestinationShippingPort=(ShippingPort) DestinationTerminal;
            if(vehicle instanceof Ship){
                BeginningShippingPort.getSea_vehicles().remove((Ship)vehicle);
                BeginningShippingPort.setNumber_of_vehicles(BeginningShippingPort.getNumber_of_vehicles()-1);
                DestinationShippingPort.AddShip((Ship)vehicle);
            }else if (vehicle instanceof Boat){
                BeginningShippingPort.getSea_vehicles().remove((Boat)vehicle);
                BeginningShippingPort.setNumber_of_vehicles(BeginningShippingPort.getNumber_of_vehicles()-1);
                DestinationShippingPort.AddBoat((Boat)vehicle);
            }
        }else if(BeginningTerminal instanceof BusTerminal){
            BusTerminal BeginningBusTerminal=(BusTerminal) BeginningTerminal;
            BusTerminal DestinationBusTerminal=(BusTerminal) DestinationTerminal;
            BeginningBusTerminal.getBuses().remove((Bus)vehicle);
            BeginningBusTerminal.setNumber_of_vehicles(BeginningBusTerminal.getNumber_of_vehicles()-1);
            DestinationBusTerminal.AddBus((Bus)vehicle);
        }
       for (int i=0;i<passengers.size();i++){
           BeginningCity.RemovePerson(passengers.get(i));
           DestinationCity.AddPerson(passengers.get(i));
       }
        BeginningCity.increaseMoney(TravelCost);

    }

    @Override
    public void TravelSort() {
        Collections.sort(TravelsInput);
        Collections.sort(TravelsOutput);

    }

    @Override
    public double CalculateTravelCost(ArrayList<Person> passengers, Vehicle vehicle) {
        if(vehicle instanceof Passenger_plane)
            return passengers.size()*50;
        else if(vehicle instanceof Bus)
            return passengers.size()*10;
        else if (vehicle instanceof Train)
            return passengers.size()*20;
        else if(vehicle instanceof Ship)
            return passengers.size()*30;
        else if(vehicle instanceof Boat)
            return passengers.size()*5;
        else return 0;

    }

    @Override
    public void TravelHistory() {
        TravelSort();
        System.out.println(ConsoleColors.PURPLE_BRIGHT +"TRAVELS INPUT:"+ConsoleColors.RESET);
        if (TravelsInput.size()!=0){
            for (int i=0;i<TravelsInput.size();i++){
                System.out.println(TravelsInput.get(i).toString());
            }
        }else System.out.println("There isn't anything to Show!");
        System.out.println(ConsoleColors.PURPLE_BRIGHT +"TRAVELS OUTPUT:"+ConsoleColors.RESET);
        if (TravelsOutput.size()!=0){
            for (int i=0;i<TravelsOutput.size();i++){
                System.out.println(TravelsOutput.get(i).toString());
            }
        }else System.out.println("There isn't anything to Show!");
    }
}
