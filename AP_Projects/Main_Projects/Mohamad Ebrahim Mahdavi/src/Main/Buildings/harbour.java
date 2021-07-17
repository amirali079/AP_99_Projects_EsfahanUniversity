package Main.Buildings;
import City.City;
import Main.Vehicles.*;
import Main.person;
import java.util.ArrayList;

public class harbour extends Terminal{
    protected ArrayList<sea_vehicle>watercraft=new ArrayList<>();
    protected int pier_num;

    public harbour(String city_name, String name, String address, double area, int pier_num) {
        super(600, city_name, name, address, area);
        this.pier_num = pier_num;
    }

    public boolean check_ship_existence()
    {
        boolean f=false;
        for (sea_vehicle temp:watercraft)
            if (temp instanceof ship)
            {
                f=true;
                break;
            }
        return f;
    }

    @Override
    public void deliver_vehicle(String type, Vehicle target) {
        if (type.equals("arrival"))
            watercraft.add((sea_vehicle) target);
        else
            watercraft.remove((sea_vehicle) target);
    }

    @Override
    public void get_vehicle_info_for_travel()
    {
        System.out.println("Ship id's :");
        for (sea_vehicle temp:watercraft)
            if (temp instanceof ship)
                temp.get_id();
    }

    public String get_name()
    {
        return super.name;
    }
    @Override
    public double add_people(person p) {
        super.people.add(p);
        return p.getSalary();
    }

    @Override
    public Vehicle search_vehicle(String id)
    {
        for (sea_vehicle a:watercraft)
        {
            if (a.get_id().equals(id))
                return a;
        }
        return null;
    }

    public void basic_info()
    {
        System.out.println("The information of your harbour :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"Welfare service :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.get_price()+"$");
        get_water_craft();
    }
    public void full_info()
    {
        System.out.println("The information of your cargo plane :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"\narea : "+super.area+"\nprice : "+super.price+"\npier number : "+pier_num);
    }

    public double add_boat(String id, String company_name, String production_date, String material)
    {
        boat b=new boat(id,company_name,production_date,material);
        watercraft.add(b);
        return b.get_price();
    }
    public double add_ship(String id, String company_name, String production_date, String material)
    {
        ship s=new ship(id,company_name,production_date,material);
        watercraft.add(s);
        return s.get_price();
    }

    public double delete_ship(String id, City esf)
    {
        sea_vehicle air= (sea_vehicle) search_vehicle(id);
        if (air!=null)
        {
            System.out.println("Bus sold successfully!\nThe remaining capital is : "+esf.capital+"\n\n__________________________________\n");
            double price=get_price()/2;
            watercraft.remove(air);
            return price;
        }
        else
            System.out.println("Target not found!\n\n__________________________________\n");
        return 0;
    }
    public double delete_boat(String id, City esf)
    {
        sea_vehicle air= (sea_vehicle) search_vehicle(id);
        if (air!=null)
        {
            System.out.println("Bus sold successfully!\nThe remaining capital is : "+esf.capital+"\n\n__________________________________\n");
            double price=get_price()/2;
            watercraft.remove(air);
            return price;
        }
        else
            System.out.println("Target not found!\n\n__________________________________\n");
        return 0;
    }
    public void get_water_craft()
    {
        System.out.println("You have "+watercraft.size()+" watercraft in this harbour");
        for (sea_vehicle c:watercraft)
            c.basic_info();
    }

    @Override
    public int get_vehicle_num() {
        return watercraft.size();
    }

    public double get_price()
    {
        return super.price;
    }
}
