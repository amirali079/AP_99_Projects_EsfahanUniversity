package Main.Buildings;
import Exceptions.*;
import Main.*;
import Main.Vehicles.Vehicle;
import Main.Vehicles.welfare_services;
import Travel.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Terminal implements I_travel, Serializable {
    protected double price;
    protected String city_name;
    protected String name;
    protected String address;
    protected double area;
    protected ArrayList<person>people=new ArrayList<>();
    protected ArrayList<welfare_services>ws=new ArrayList<>();
    protected ArrayList<Travel>arrivals=new ArrayList<>();
    protected ArrayList<Travel> departures=new ArrayList<>();
    protected static ArrayList<String>travel_id=new ArrayList<>();
    public Terminal(double price, String city_name, String name, String address, double area) {
        this.price = price;
        this.city_name = city_name;
        this.name = name;
        this.address = address;
        this.area = area;
    }
    public ArrayList<Travel>getArrivals()
    {
        return arrivals;
    }

    abstract public int get_vehicle_num();
    @Override
    public double add_travel(String id, String date, Terminal destination_name, Vehicle vehicle, person driver, ArrayList<person> passengers) throws Exception
    {
        if (travel_id.contains(id))
            throw new Incorrect_entry_exception("This id has been used already!\nTry again!");
        if (vehicle==null)
            throw new Incorrect_entry_exception("Vehicle not found!");
        if (vehicle.get_capacity()<passengers.size())
            throw new Max_capacity_exception();
        if (vehicle.get_capacity()/2>passengers.size())
            throw new Low_capacity_exception();
        if (destination_name == null)
            throw new Incorrect_entry_exception("Error!\nTerminal not found!");
        if (!this.getClass().getName().equals(destination_name.getClass().getName()))
            throw new Incompatible_terminal_exception();
        if (driver==null)
            throw new Incorrect_entry_exception("");
        for (int i=0;i<date.length();i++)
            if (!(((int)date.charAt(i)>=48&(int)date.charAt(i)<=57)|date.charAt(i)=='/'))
                throw new Incorrect_entry_exception("Date input not valid!\nDate should only contain number or /");
        System.out.println("Travel with "+id+" ID is totally valid!\nThe price will be added to your capital!");
        Travel temp=new Travel(id,date,calculate_price(vehicle, passengers.size()),this,destination_name,vehicle,driver,passengers);
        travel_id.add(id);
        departures.add(temp);
        destination_name.getArrivals().add(temp);
        return calculate_price(vehicle, passengers.size());
    }

    @Override
    public void sort_travel(@NotNull String a_or_d) throws Incorrect_entry_exception {
        switch (a_or_d)
        {
            case "arrival":
            {
                Collections.sort(arrivals);
                break;
            }
            case "departure":
            {
                Collections.sort(departures);
                break;
            }
            case "both":
            {
                Collections.sort(arrivals);
                Collections.sort(departures);
                break;
            }
            default:
                throw new Incorrect_entry_exception();
        }
        System.out.println("Travel list sorted successfully!");
    }

    @Override
    public double calculate_price(Vehicle vehicle, int passengers_num)
    {
        return vehicle.get_price()*((double) passengers_num/vehicle.get_capacity());
    }

    @Override
    public void travel_history(String a_or_d) throws Incorrect_entry_exception, Empty_list_exception {
        sort_travel(a_or_d);
        Scanner sc=new Scanner(System.in);
        switch (a_or_d)
        {
            case "arrival":
            {
                if (arrivals.isEmpty())
                    throw new Empty_list_exception();
                System.out.println("Arrivals :\n_____________________________");
                for (Travel temp:arrivals)
                    temp.print_info();
                System.out.println("For more information on passengers type (more)\nOtherwise type no");
                if (sc.nextLine().equals("more"))
                    for (Travel temp:arrivals)
                        temp.print_passengers_info();
                break;
            }
            case "departure":
            {
                if (departures.isEmpty())
                    throw new Empty_list_exception();
                System.out.println("Departures :\n_____________________________");
                for (Travel temp:departures)
                    temp.print_info();
                System.out.println("For more information on passengers type (more)\nOtherwise type no");
                if (sc.nextLine().equals("more"))
                    for (Travel temp:departures)
                        temp.print_passengers_info();
                break;
            }
            case "both":
            {
                if (arrivals.isEmpty()&departures.isEmpty())
                    throw new Empty_list_exception();
                System.out.println("Arrivals :\n_____________________________");
                for (Travel temp:arrivals)
                    temp.print_info();
                System.out.println("For more information on passengers type (more)\nOtherwise type no");
                if (sc.nextLine().equals("more"))
                    for (Travel temp:arrivals)
                        temp.print_passengers_info();
                System.out.println("Departures :\n_____________________________");
                for (Travel temp:departures)
                    temp.print_info();
                System.out.println("For more information on passengers type (more)\nOtherwise type no");
                if (sc.nextLine().equals("more"))
                    for (Travel temp:departures)
                        temp.print_passengers_info();
                break;
            }
        }
    }

    public abstract double add_people(person p);
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
    public abstract Vehicle search_vehicle(String id);
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
    public abstract String get_name();
    public abstract void get_vehicle_info_for_travel();
    public abstract void deliver_vehicle(String type,Vehicle target);
}
