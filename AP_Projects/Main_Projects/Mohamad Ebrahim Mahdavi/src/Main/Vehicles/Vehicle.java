package Main.Vehicles;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Vehicle implements Serializable {
    protected String id;
    protected String company_name;
    protected double price;
    protected int capacity;
    protected ArrayList<welfare_services>ws=new ArrayList<>();
    public Vehicle(String id, String company_name, double price, int capacity) {
        this.id = id;
        this.company_name = company_name;
        this.price = price;
        this.capacity = capacity;
    }
    public boolean add_welfare_service(String name,double capital)
    {
        welfare_services[] ws1=welfare_services.values();
        boolean f=false;
        for (int i=0;i<8;i++)
        {
            if (name.equals(ws1[i].name()))
            {
                f=true;
                break;
            }
        }
        if (f)
        {
            if (!ws.contains(welfare_services.valueOf(name))&welfare_services.valueOf(name).price<=capital)
            {
                ws.add(welfare_services.valueOf(name));
                System.out.println("Service added successfully!");
                return true;
            }
            else if (!ws.contains(welfare_services.valueOf(name))&welfare_services.valueOf(name).price>capital)
            {
                System.out.println("Not enough capital!");
                return false;
            }
            System.out.println("This service has been already added");
        }
        else
        {
            System.out.println("This service is not available!\nChoose another services");
        }
        return false;
    }
    public boolean delete_welfare_service(String name)
    {
        welfare_services[] ws1=welfare_services.values();
        boolean f=false;
        for (int i=0;i<8;i++)
        {
            if (name.equals(ws1[i].name()))
            {
                f=true;
                break;
            }
        }
        if (f)
        {
            if (ws.contains(welfare_services.valueOf(name)))
            {
                ws.remove(welfare_services.valueOf(name));
                System.out.println("Service deleted successfully!");
                return true;
            }
            System.out.println("You don't have this service");
        }
        else
        {
            System.out.println("This service is not available!\nChoose another services");
        }
        return false;
    }
    public abstract void basic_info();
    public abstract void full_info();
    public static double get_service_price(String name)
    {
        return welfare_services.valueOf(name).price;
    }
    public abstract String get_id();
    public abstract double get_price();
    public int get_capacity()
    {
        return capacity;
    }
}

