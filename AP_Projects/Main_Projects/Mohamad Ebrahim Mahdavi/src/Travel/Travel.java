package Travel;
import Main.Buildings.*;
import Main.Vehicles.*;
import Main.person;

import java.io.Serializable;
import java.util.ArrayList;

public class Travel implements Comparable<Travel>, Serializable {
    private final Terminal origin;
    private final Terminal destination;
    private final ArrayList<person>passengers;
    private final person driver;
    private final Vehicle vehicle;
    private final String id;
    private final String date;
    private final double price;

    public Travel(String id, String date, double price, Terminal origin_name, Terminal destination_name, Vehicle vehicle, person driver, ArrayList<person>passengers) {
        this.id = id;
        this.date = date;
        this.price = price;
        origin=origin_name;
        destination=destination_name;
        this.passengers=passengers;
        this.vehicle=vehicle;
        this.driver=driver;

    }
    public void print_info()
    {
        System.out.println("ID : "+id+"\nOrigin : "+origin.get_name()+"\nDestination : "+destination.get_name()+"\nVehicle : "+vehicle.getClass().getName()+"\nDriver : "+driver.getName()+"\nPassengers : "+passengers.size());
    }
    public void print_passengers_info()
    {
        for (person p:passengers)
            System.out.println("Passenger num "+(passengers.indexOf(p)+1)+"\nName : "+p.getName()+"\nFamily : "+p.getFamily()+"\nSalary : "+p.getSalary()+"\nProfession : "+p.getCareer());
    }
    @Override
    public int compareTo(Travel o)
    {
        int result=this.date.compareTo(o.date);
        if (result==0)
            return Double.compare(this.price,o.price);
        return result;
    }
}
