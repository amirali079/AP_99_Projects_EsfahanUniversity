package Main.Buildings;
import City.City;
import Main.Vehicles.*;
import java.util.ArrayList;
import Main.*;
public class airport extends Terminal{
    protected ArrayList<air_vehicle> air_craft=new ArrayList<>();
    protected double runways;
    protected boolean airport_type;

    public airport(String city_name, String name, String address, double area, double runways, boolean airport_type) {
        super(1000, city_name, name, address, area);
        this.runways = runways;
        this.airport_type = airport_type;
    }

    @Override
    public int get_vehicle_num() {
        return air_craft.size();
    }

    @Override
    public void deliver_vehicle(String type, Vehicle target) {
        if (type.equals("arrival"))
            air_craft.add((air_vehicle) target);
        else
            air_craft.remove((air_vehicle) target);
    }

    public boolean check_airliner_existence()
    {
        boolean f=false;
        for (Vehicle temp:air_craft)
            if (temp instanceof airliner)
            {
                f = true;
                break;
            }
        return f;
    }

    @Override
    public double add_people(person p) {
        super.people.add(p);
        return p.getSalary();
    }

    @Override
    public void get_vehicle_info_for_travel()
    {
        System.out.println("Airliner id's:");
        for (air_vehicle temp:air_craft)
            if (temp instanceof airliner)
                System.out.println(temp.get_id());
    }

    public double add_airliner(String id, String company_name, String production_date, int staff_num, String classes)
    {
        airliner plane=new airliner(id,company_name,production_date,staff_num,classes);
        air_craft.add(plane);
        return plane.get_price();
    }
    public double add_cargo_plane(String id, String company_name, String production_date, double max_weight)
    {
        cargo_plane plane=new cargo_plane(id,company_name,production_date,max_weight);
        air_craft.add(plane);
        return plane.get_price();
    }
    public void basic_info()
    {
        System.out.println("The information of your airport :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"\nWelfare service :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.get_price()+"$");
        get_air_craft();
    }
    public void full_info()
    {
        System.out.println("The information of your airport :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"\narea : "+super.area+"\nprice : "+super.price+"\nrunways : "+runways+"\ninternational airport : "+airport_type);
    }
    public void get_air_craft()
    {
        System.out.println("You have "+air_craft.size()+" aircraft in this airport\n__________________________________");
        for (Vehicle a:air_craft)
        {
            a.basic_info();
        }
    }
    @Override
    public Vehicle search_vehicle(String id)
    {
        for (Vehicle t:air_craft)
            if (t.get_id().equals(id))
                return t;
        return null;
    }
    public double delete_airliner(String id, City esf)
    {
        air_vehicle air= (air_vehicle) search_vehicle(id);
        if (air!=null)
        {
            System.out.println("Airliner sold successfully!\nThe remaining capital is : "+esf.capital+"\n\n__________________________________\n");
            double price=get_price()/2;
            air_craft.remove(air);
            return price;
        }
        else
            System.out.println("Target not found!\n\n__________________________________\n");
        return 0;
    }
    public double delete_cargo_plane(String id, City esf)
    {
        air_vehicle air= (air_vehicle)search_vehicle(id);
        if (air!=null)
        {
            System.out.println("Cargo plane sold successfully!\nThe remaining capital is : "+esf.capital+"\n\n__________________________________\n");
            double price=get_price()/2;
            air_craft.remove(air);
            return price;
        }
        else
            System.out.println("Target not found!\n\n__________________________________\n");
        return 0;
    }
    public double get_price()
    {
        return super.price;
    }

    @Override
    public String get_name() {
        return super.name;
    }
}
