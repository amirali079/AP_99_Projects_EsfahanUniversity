package Main.Buildings;
import City.City;
import Main.Vehicles.*;
import Main.*;

import java.util.ArrayList;

public class bus_station extends Terminal{
    protected ArrayList<bus>buses=new ArrayList<>();

    public bus_station(String city_name, String name, String address, double area) {
        super(500, city_name, name, address, area);
    }

    public boolean check_bus_existence()
    {
        return !buses.isEmpty();
    }

    @Override
    public int get_vehicle_num() {
        return buses.size();
    }

    @Override
    public void get_vehicle_info_for_travel()
    {
        System.out.println("Bus id's :");
        for (bus temp:buses)
            System.out.println(temp.get_id());
    }

    @Override
    public void deliver_vehicle(String type, Vehicle target) {
        if (type.equals("arrival"))
            buses.add((bus) target);
        else
            buses.remove((bus) target);
    }

    @Override
    public double add_people(person p) {
        super.people.add(p);
        return p.getSalary();
    }
    public String get_name()
    {
        return super.name;
    }

    public void basic_info()
    {
        System.out.println("The information of your bus station :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"Welfare service :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.get_price()+"$");
        get_bus();
    }
    public void full_info()
    {
        System.out.println("The information of your bus station :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"\narea : "+super.area+"\nprice : "+super.price);
    }
    public double add_bus(String id, String company_name, String production_date)
    {
        bus b=new bus(id,company_name,production_date);
        buses.add(b);
        return b.get_price();
    }
    public bus search_vehicle(String id)
    {
        for (bus t:buses)
            if (t.get_id().equals(id))
                return t;
        return null;
    }
    public double delete_vehicle(String id, City esf)
    {
        land_vehicle air= search_vehicle(id);
        if (air!=null)
        {
            System.out.println("Bus sold successfully!\nThe remaining capital is : "+esf.capital+"\n\n__________________________________\n");
            double price=get_price()/2;
            buses.remove(air);
            return price;
        }
        else
            System.out.println("Target not found!\n\n__________________________________\n");
        return 0;
    }
    public void get_bus()
    {
        System.out.println("You have "+buses.size()+" buses in this bus station");
        for (bus c:buses)
            c.basic_info();
    }
    public double get_price()
    {
        return super.price;
    }
}
