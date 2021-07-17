package Main.Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Travel implements Comparable<Travel> , Serializable {

    Terminal BeginningTerminal;
    Terminal DestinationTerminal;
    ArrayList<Person>passengers=new ArrayList<>();
    Person driver;
    Vehicle vehicle;
    int ID;
    String Date;
    double TravelCost;

    public Travel(Terminal beginningTerminal, Terminal destinationTerminal, ArrayList<Person> passengers, Person driver, Vehicle vehicle, int ID, String date, double travelCost) {
        BeginningTerminal = beginningTerminal;
        DestinationTerminal = destinationTerminal;
        this.passengers = passengers;
        this.driver = driver;
        this.vehicle = vehicle;
        this.ID = ID;
        Date = date;
        TravelCost = travelCost;
    }

    @Override
    public int compareTo(Travel o) {

        if(this.Date.compareTo(o.Date)>0)
            return +1;
        else if (this.Date.compareTo(o.Date)<0)
            return -1;
        else
        {
            if (this.TravelCost>o.TravelCost)
                return +1;
            else if (this.TravelCost<o.TravelCost)
                return -1;
            else return 0;
        }
    }
    public String ShowPassengers(){
        StringBuilder s=new StringBuilder();
        for (int i=0;i<passengers.size();i++){

            s.append(String.format("\nName: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n",passengers.get(i).getName(),passengers.get(i).getFamily(),passengers.get(i).getYear_of_Birth(),passengers.get(i).getPlace_of_Birth(),passengers.get(i).getJob(),passengers.get(i).getGender(),passengers.get(i).getEmployment_salary(),passengers.get(i).isEmployment_situation()));

        }
        return s.toString();
    }
    public String ShowDriver(){
        return String.format("\nName: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n",driver.getName(),driver.getFamily(),driver.getYear_of_Birth(),driver.getPlace_of_Birth(),driver.getJob(),driver.getGender(),driver.getEmployment_salary(),driver.isEmployment_situation());

    }
    public String ShowVehicle(){
        if (vehicle instanceof Passenger_plane){
            Passenger_plane passenger_plane=((Passenger_plane)vehicle);
            return String.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Number Of Crew: %d , Aircraft Classification Seats: %d\n ",passenger_plane.getPrice(),passenger_plane.getCapacity(),passenger_plane.getCompany_builder_name(),passenger_plane.getMaximum_flight_altitude(),passenger_plane.getBand_length_required_for_Landing(),passenger_plane.getNumber_of_crew(),passenger_plane.getAircraft_classification_seats());
        }else if(vehicle instanceof Train) {
            Train train = (Train) vehicle;
            String train1 = String.format("Price: %d , Capacity: %d , Company Builder Name: %s , Fuel Type: %s , Ticket Price: %d , Number of wagons: %d , Number of stars: %d ", train.getPrice(), train.getCapacity(), train.getCompany_builder_name(), train.getFuel_type(), train.getTicket_price(), train.getNumber_of_wagons(), train.getNumber_of_stars());
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < train.getServises().size(); j++) {
                stringBuilder.append(String.format(" [Services%d: %s]", j + 1, train.getServises().get(j)));
            }
            return String.format("%s %s",train1,stringBuilder.toString());
        }else if(vehicle instanceof Bus){
            Bus bus=(Bus)vehicle;
            return String.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Ticket Price: %d , Pollutant production by PPM: %d , Fuel consumption per kilometer by lit: %d ",bus.getPrice(),bus.getCapacity(),bus.getCompany_builder_name(),bus.getFuel_type(),bus.getTicket_price(),bus.getPollutant_production_by_PPM(),bus.getFuel_consumption_per_kilometer_by_lit());

        }else if(vehicle instanceof Ship){
            Ship ship=(Ship) vehicle;
            return String.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Number Of lifeboat: %d  ,Number Of Crew: %d  ",ship.getPrice(),ship.getCapacity(),ship.getCompany_builder_name(),ship.getFuel_type(),ship.getMinimum_depth_to_move(),ship.getNumber_of_lifeboats(),ship.getNumber_of_crew());
        }else if (vehicle instanceof Boat){
            Boat boat=(Boat) vehicle;
            return String.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Boat body type: %s ",boat.getPrice(),boat.getCapacity(),boat.getCompany_builder_name(),boat.getFuel_type(),boat.getMinimum_depth_to_move(),boat.getBoat_body_type());
        }
        else return "";
    }

    @Override
    public String toString() {
        return
                "\nBeginningTerminal: " + BeginningTerminal.getTerminal_name() +
                "\nDestinationTerminal: " + DestinationTerminal.getTerminal_name() +
                "\n\nPASSENGERS:\n" + ShowPassengers()+
                "\nDRIVER:" + ShowDriver()+
                "\nVEHICLE:\n" + ShowVehicle() +
                "\nID=" + ID +
                "\nDate=" + Date  +
                "\nTRAVEL COST=" + TravelCost+"$\n" ;
    }
}
