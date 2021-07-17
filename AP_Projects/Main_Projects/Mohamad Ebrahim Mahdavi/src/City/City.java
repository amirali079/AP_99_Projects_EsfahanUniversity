package City;

import Exceptions.Empty_list_exception;
import Exceptions.Incorrect_entry_exception;
import Exceptions.Invalid_driver_exception;
import Main.Buildings.*;
import Main.Main;
import Main.Vehicles.Vehicle;
import Main.Vehicles.welfare_services;
import Main.person;
import Travel.I_travel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class City implements Serializable {
    int count = 6;
    public double capital = 10000;
    private final String name;
    public ArrayList<person> citizen = new ArrayList<>();
    public ArrayList<airport> airports = new ArrayList<>();
    public ArrayList<bus_station> bus_stations = new ArrayList<>();
    public ArrayList<harbour> harbours = new ArrayList<>();
    public ArrayList<train_station> train_stations = new ArrayList<>();
    public ArrayList<Hotel> hotels = new ArrayList<>();
    public ArrayList<Bank> banks = new ArrayList<>();
    public City(String name) {
        this.name = name;
    }
    //FUNCTIONS______________________
    public void create_bank(String name) throws Incorrect_entry_exception {
        try {
            search_bank(name);
            throw new Incorrect_entry_exception("This name has been already used!");
        } catch (Incorrect_entry_exception incorrect_entry_exception) {
            if (incorrect_entry_exception.getMessage().equals("This name has been already used!"))
                throw incorrect_entry_exception;
            banks.add(new Bank(name,this.name));
            System.out.println("Bank has been built!");
        }
    }

    public void show_banks() {
        for (Bank temp:banks)
            System.out.println((banks.indexOf(temp)+1)+"."+temp.name);
    }
    //????????????
    public void destroy_bank(String name) throws Incorrect_entry_exception {
        System.out.println("This process may take 30 seconds or less!");
        banks.remove(search_bank(name));
        System.gc();
        System.out.println("Bank destroyed!");
    }

    public Bank search_bank(String name) throws Incorrect_entry_exception {
        for (Bank b:banks)
            if (b.name.equals(name))
                return b;
            throw new Incorrect_entry_exception("Wrong name!");
    }

    public String vehicle_num()
    {
        int length=0;
        for (airport temp:airports)
            length+=temp.get_vehicle_num();
        for (train_station temp:train_stations)
            length+=temp.get_vehicle_num();
        for (bus_station temp:bus_stations)
            length+=temp.get_vehicle_num();
        for (harbour temp:harbours)
            length+=temp.get_vehicle_num();
        return String.valueOf(length);
    }
    public ArrayList<person>get_citizens()
    {
        return citizen;
    }
    public String get_name()
    {
        return name;
    }
    public void get_info()
    {
        System.out.println("Total information of "+name+" :\nCitizens : "+citizen.size()+"\nAirports : "+airports.size()+"\nBus stations : "+bus_stations.size()+"\nHarbours : "+harbours.size()+"\nTrain stations : "+train_stations.size()+"\nHotels : "+hotels.size()+"\nRemaining capital : "+capital);
    }
    public airport search_vehicle(String name, ArrayList<airport>a)
    {
        for (airport air:a)
        {
            if (air.get_name().equals(name))
                return air;
        }
        return null;
    }
    public train_station search_vehicle1(String name,ArrayList<train_station>a)
    {
        for (train_station air:a)
        {
            if (air.get_name().equals(name))
                return air;
        }
        return null;
    }
    public bus_station search_vehicle2(String name,ArrayList<bus_station>a)
    {
        for (bus_station air:a)
        {
            if (air.get_name().equals(name))
                return air;
        }
        return null;
    }
    public harbour search_vehicle3(String name,ArrayList<harbour>a)
    {
        for (harbour air:a)
        {
            if (air.get_name().equals(name))
                return air;
        }
        return null;
    }
    public Hotel search_hotel(String name,ArrayList<Hotel>h)
    {
        for (Hotel a:h)
            if (a.get_name().equals(name))
                return a;
        return null;
    }
    public person search_person(String name,ArrayList<person>citizen)
    {
        person target=null;
        for (person p:citizen)
        {
            if (p.getName().equals(name))
            {
                if (target == null)
                    target = p;
                else
                {
                    System.out.println("You have more than one match found with " + name + "\nEnter the family name :");
                    Scanner sc = new Scanner(System.in);
                    String family = sc.nextLine();
                    for (person q : citizen)
                        if (q.getFamily().equals(family))
                            return q;
                    System.out.println("Target not found!\n\n__________________________________\n");
                    return null;
                }
            }
            else if (target != null)
                return target;
        }
        System.out.println("Target not found!\n\n__________________________________\n");
        return null;
    }
    public void show_person(String name)
    {
        System.out.println("The options :");
        for (person c:citizen)
        {
            if (!c.working_status &(c.getCareer().equals(name)|c.getCareer().equals("staff")))
                System.out.println("\nName : "+c.getName()+"\nSalary :"+c.getSalary()+"\nJob : "+c.getCareer()+"\n\n__________________________________\n");
        }
        System.out.println("Enter the target name :");
    }
    public void hiring(String name,Terminal a)
    {
        person pe=search_person(name,citizen);
        if (pe != null)
        {
            if (pe.getSalary()<=capital)
            {
                capital-=a.add_people(pe);
                pe.working_status=true;
                System.out.println(pe.getName()+" hired successfully!\n\n__________________________________\n");
            }
            else
                Main.lack_capital(this);
        }
        else
            System.out.println("Target not found!\n\n__________________________________\n");
    }
    public void show_welfare_service()
    {
        System.out.println("Welfare services :");
        for (welfare_services ws3 : welfare_services.values())
            System.out.println((ws3.ordinal() + 1) + "." + ws3.name());
        System.out.println("Enter the target :");
    }
    public boolean add_welfare_service(String name,Terminal air)
    {
        if (!air.add_welfare_service(name, capital) & count >= 0) {
            System.out.println("Enter the target :");
            count--;
            return false;
        }
        if (count >= 0)
        {
            capital -= welfare_services.valueOf(name).get_price();
            System.out.println("\n\n__________________________________\n");
            count=6;
            return true;
        }
        return true;
    }
    public boolean delete_welfare_service(String name, Terminal air)
    {
        if (!air.delete_welfare_service(name) & count >= 0) {
            System.out.println("Enter the target :");
            count--;
            return false;
        }
        if (count >= 0)
        {
            capital -= welfare_services.valueOf(name).get_price();
            System.out.println("\n\n__________________________________\n");
            count=6;
            return true;
        }
        return true;
    }
    public boolean add_welfare_service2(String name, Vehicle air)
    {
        if (!air.add_welfare_service(name, capital) & count >= 0) {
            System.out.println("Enter the target :");
            count--;
            return false;
        }
        if (count >= 0)
        {
            capital -= welfare_services.valueOf(name).get_price();
            System.out.println("\n\n__________________________________\n");
            count=6;
            return true;
        }
        return true;
    }
    public boolean delete_welfare_service2(String name, Vehicle air)
    {
        if (!air.delete_welfare_service(name) & count >= 0) {
            System.out.println("Enter the target :");
            count--;
            return false;
        }
        if (count >= 0)
        {
            capital -= welfare_services.valueOf(name).get_price();
            System.out.println("\n\n__________________________________\n");
            count=6;
            return true;
        }
        return true;
    }
    public boolean add_welfare_service3(String name, Hotel air)
    {
        if (!air.add_welfare_service(name, capital) & count >= 0) {
            System.out.println("Enter the target :");
            count--;
            return false;
        }
        if (count >= 0)
        {
            capital -= welfare_services.valueOf(name).get_price();
            System.out.println("\n\n__________________________________\n");
            count=6;
            return true;
        }
        return true;
    }
    public boolean delete_welfare_service3(String name, Hotel air)
    {
        if (!air.delete_welfare_service(name) & count >= 0) {
            System.out.println("Enter the target :");
            count--;
            return false;
        }
        if (count >= 0)
        {
            capital -= welfare_services.valueOf(name).get_price();
            System.out.println("\n\n__________________________________\n");
            count=6;
            return true;
        }
        return true;
    }
    public void show_terminal_info(String name)
    {
        for (airport t:airports)
            if (t.get_name().equals(name))
            {
                t.basic_info();
                System.out.println("The full info for airport :");
                t.full_info();
            }
        for (train_station t:train_stations)
            if (t.get_name().equals(name))
            {
                t.basic_info();
                System.out.println("The full info for airport :");
                t.full_info();
            }
        for (bus_station t:bus_stations)
            if (t.get_name().equals(name))
            {
                t.basic_info();
                System.out.println("The full info for airport :");
                t.full_info();
            }
        for (harbour t:harbours)
            if (t.get_name().equals(name))
            {
                t.basic_info();
                System.out.println("The full info for airport :");
                t.full_info();
            }
    }
    public void make_travel(String id, String date, String origin_name, String destination_name, String vehicle, person driver, ArrayList<person> passengers, City dc, int cursor) throws Exception
    {
        if (dc==null)
            throw new Incorrect_entry_exception("City not found!\nTry again!");
        Terminal t=search_terminal_departure(origin_name,cursor);
        capital+=t.add_travel(id,date,dc.search_terminal_arrival(destination_name,cursor),t.search_vehicle(vehicle),driver,passengers);
        Terminal t2=dc.search_terminal_arrival(destination_name,cursor);
        t2.deliver_vehicle("arrival",t.search_vehicle(vehicle));
        t.deliver_vehicle("departure",t.search_vehicle(vehicle));
        dc.get_citizens().add(driver);
        citizen.remove(driver);
        dc.get_citizens().addAll(passengers);
        citizen.removeAll(passengers);
        System.out.println("Your request has been done!\nThis travel made"+t.calculate_price(t.search_vehicle(vehicle), passengers.size())+"$ for you!");
    }
    public Terminal search_terminal_arrival(String name,int cursor)
    {
        switch (cursor)
        {
            case 1:
            {
                return search_vehicle(name,airports);
            }
            case 2:
            {
                return search_vehicle1(name,train_stations);
            }
            case 3:
            {
                return search_vehicle2(name,bus_stations);
            }
            case 4:
            {
                return search_vehicle3(name,harbours);
            }
        }
        return null;
    }
    public Terminal search_terminal_departure(String name,int cursor)
    {
        switch (cursor)
        {
            case 1:
            {
                airport temp=search_vehicle(name,airports);
                if (temp != null && temp.check_airliner_existence())
                    return temp;
            }
            case 2:
            {
                train_station temp=search_vehicle1(name,train_stations);
                if (temp != null && temp.check_train_existence())
                return temp;
            }
            case 3:
            {
                bus_station temp=search_vehicle2(name,bus_stations);
                if (temp != null && temp.check_bus_existence())
                return temp;
            }
            case 4:
            {
                harbour temp=search_vehicle3(name,harbours);
                if (temp != null && temp.check_ship_existence())
                return temp;
            }
        }
        return null;
    }
    public void show_terminal_for_travel(int courser)
    {
        switch (courser)
        {
            case 1:
            {
                System.out.println("Airports :");
                for (airport t:airports)
                    System.out.println(t.get_name());
            }
            case 2:
            {
                System.out.println("Train stations :");
                for (train_station t:train_stations)
                    System.out.println(t.get_name());
            }
            case 3:
            {
                System.out.println("Bus stations ;");
                for (bus_station t:bus_stations)
                    System.out.println(t.get_name());
            }
            case 4:
            {
                System.out.println("Harbours :");
                for (harbour t:harbours)
                    System.out.println(t.get_name());
            }
        }
    }
    public void show_driver(int cs)
    {
        switch (cs)
        {
            case 1:
            {
                System.out.println("Pilots :");
                for (person p:citizen)
                    if (p.working_status&p.getCareer().equals("pilot"))
                        System.out.println(p.getName()+" "+p.getFamily());
                break;
            }
            case 2:
            {
                System.out.println("lukomotorans :");
                for (person p:citizen)
                    if (p.working_status&p.getCareer().equals("lukomotoran"))
                        System.out.println(p.getName()+" "+p.getFamily());
                break;
            }
            case 3:
            {
                System.out.println("Bus drivers :");
                for (person p:citizen)
                    if (p.working_status&p.getCareer().equals("driver"))
                        System.out.println(p.getName()+" "+p.getFamily());
                break;
            }
            case 4:
            {
                System.out.println("sailors :");
                for (person p:citizen)
                    if (p.working_status&p.getCareer().equals("sailor"))
                        System.out.println(p.getName()+" "+p.getFamily());
                break;
            }
        }
    }
    public void show_passengers()
    {
        System.out.println("Options :");
        for (person p:citizen)
            if (!p.working_status)
                System.out.println(p.getName()+" "+p.getFamily()+"\nJob : "+p.getCareer());
        System.out.println("Enter the target :");
    }
    public void show_travel_history(int cs,String type) throws Incorrect_entry_exception, Empty_list_exception {
        switch (cs)
        {
            case 1:
            {
                for (I_travel t:airports)
                    t.travel_history(type);
                break;
            }
            case 2:
            {
                for (I_travel t:train_stations)
                    t.travel_history(type);
                break;
            }
            case 3:
            {
                for (I_travel t:bus_stations)
                    t.travel_history(type);
                break;
            }
            case 4:
            {
                for (I_travel t:harbours)
                    t.travel_history(type);
                break;
            }
            default:
            {
                throw new Incorrect_entry_exception("Wrong courser!\nTry again");
            }
        }
    }
    public void check_driver(int cs,person dr) throws Invalid_driver_exception {
        if (cs==1&!dr.getCareer().equals("pilot"))
            throw new Invalid_driver_exception();
        if (cs==2&!dr.getCareer().equals("lukomotoran"))
            throw new Invalid_driver_exception();
        if (cs==3&!dr.getCareer().equals("driver"))
            throw new Invalid_driver_exception();
        if (cs==4&!dr.getCareer().equals("sailor"))
            throw new Invalid_driver_exception();
    }
}