package Main.Buildings;
import Main.Vehicles.*;

import java.util.ArrayList;

public class Hotel {
    double price;
    String name;
    String address;
    int star;
    ArrayList<welfare_services>ws=new ArrayList<>();
    int room_num;
    ArrayList<room>rooms=new ArrayList<>();

    public Hotel(String name, String address, int star, int room_num) {
        this.price = 700;
        this.name = name;
        this.address = address;
        this.star = star;
        this.room_num = room_num;
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
            if (!ws.contains(welfare_services.valueOf(name))&welfare_services.valueOf(name).get_price()<=capital)
            {
                ws.add(welfare_services.valueOf(name));
                System.out.println("Service added successfully!");
                return true;
            }
            else if (!ws.contains(welfare_services.valueOf(name))&welfare_services.valueOf(name).get_price()>capital)
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
            System.out.println("You don't have this service in your hotel");
        }
        else
        {
            System.out.println("This service is not available!\nChoose another services");
        }
        return false;
    }
    public double add_room(int room_num, int bed_num, double area)
    {
        room r=new room(room_num,bed_num,area);
        rooms.add(r);
        return r.price;
    }
    public double get_price()
    {
        return price;
    }
    public double delete_room(int room_num)
    {
        room r=search_room(room_num);
        if (r!=null)
        {
            double price=r.price;
            rooms.remove(r);
            System.out.println("Room removed successfully!\nThe cost will be return with 50% reduction!");
            return price/2;
        }
        else
        {
            System.out.println("Room not found!");
            return 0;
        }
    }
    public room search_room(int room_num)
    {
        for (room r:rooms)
            if (r.room_num==room_num)
                return r;
            return null;
    }
    public String get_name()
    {
        return name;
    }
    public void basic_info()
    {
        System.out.println("The information of your cargo plane :\nname : "+name+"\naddress : "+address+"\nstar : "+star);
    }
    public void get_room()
    {
        System.out.println("You have "+rooms.size()+" room in this hotel");
    }
}
class room{
    int room_num;
    int bed_num;
    double area;
    double price;

    public room(int room_num, int bed_num, double area) {
        this.room_num = room_num;
        this.bed_num = bed_num;
        this.area = area;
        this.price = 50;
    }
}