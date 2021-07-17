package Main.Buildings;
import City.City;
import Main.Vehicles.*;
import java.util.ArrayList;
import Main.*;
public class train_station extends Terminal{
    protected double incoming_railways;
    protected double outgoing_railways;
    protected ArrayList<land_vehicle>trains=new ArrayList<>();

    public train_station(String city_name, String name, String address, double area, double incoming_railways, double outgoing_railways) {
        super(750, city_name, name, address, area);
        this.incoming_railways = incoming_railways;
        this.outgoing_railways = outgoing_railways;
    }

    @Override
    public int get_vehicle_num() {
        return trains.size();
    }

    @Override
    public void deliver_vehicle(String type, Vehicle target) {
        if (type.equals("arrival"))
            trains.add((land_vehicle) target);
        else
            trains.remove((land_vehicle) target);
    }

    @Override
    public void get_vehicle_info_for_travel()
    {
        System.out.println("Train id's :");
        for (land_vehicle temp:trains)
            temp.get_id();
    }

    public boolean check_train_existence()
    {
        return !trains.isEmpty();
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
        System.out.println("The information of your train station :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"Welfare service :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.get_price()+"$");
        get_train();
    }
    public void full_info()
    {
        System.out.println("The information of your train station :\nname : "+super.name+"\naddress : "+super.address+"\ncity name : "+super.city_name+"\narea : "+super.area+"\nprice : "+super.price+"\nincoming railways : "+incoming_railways+"\noutgoing railways : "+outgoing_railways);
    }
    public double add_train(String id, String company_name, String production_date,int wagon_num,int star)
    {
        train t=new train(id,company_name,production_date,wagon_num,star);
        trains.add(t);
        return t.get_price();
    }
    public void get_train()
    {
        System.out.println("You have "+trains.size()+" trains in this station");
        for (land_vehicle t:trains)
            t.basic_info();
    }

    @Override
    public land_vehicle search_vehicle(String id)
    {
        for (land_vehicle t:trains)
            if (t.get_id().equals(id))
                return t;
            return null;
    }

    public double delete_vehicle(String id, City esf)
    {
        land_vehicle air= search_vehicle(id);
        if (air!=null)
        {
            System.out.println("Train sold successfully!\nThe remaining capital is : "+esf.capital+"\n\n__________________________________\n");
            double price=get_price()/2;
            trains.remove(air);
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
}
