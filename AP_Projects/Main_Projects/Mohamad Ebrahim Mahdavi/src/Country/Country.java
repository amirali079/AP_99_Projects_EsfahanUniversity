package Country;

import City.City;
import Exceptions.Incorrect_entry_exception;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable {
    public ArrayList<City>cities=new ArrayList<>();
    private final String name;

    public Country(String name) {
        this.name = name;
    }

    public void set_get_population()
    {
        int population = 0;
        for (City c:cities)
            population +=c.citizen.size();
        System.out.println("The total population of "+name+" is : "+ population);
    }

    public void set_get_total_capital()
    {
        double total_capital = 0;
        for (City c:cities)
            total_capital +=c.capital;
        System.out.println("The total capital of "+name+" is : "+ total_capital +"$");
    }
    public void add_city(String name) throws Incorrect_entry_exception
    {
        boolean f=false;
        for (City temp:cities)
            if (temp.get_name().equals(name))
            {
                f = true;
                break;
            }
        if (!f)
        {
            cities.add(new City(name));
            System.out.println(name + " city has been built successfully!");
        }
        else
            throw new Incorrect_entry_exception("This city has been built already!");
    }
    public void get_info()
    {
        System.out.println(cities.size()+" cities has been built in "+this.name);
        set_get_total_capital();
        set_get_population();
        for (City c:cities)
            c.get_info();
        System.out.println("_____________________________");
    }
    public City search_city(String name)
    {
        for (City temp:cities)
            if (temp.get_name().equals(name))
                return temp;
        return null;
    }
    public void destroy_city(String name)
    {
        City tr=search_city(name);
        if (tr!=null)
        {
            cities.remove(tr);
            System.out.println("City "+name+"destroyed successfully!");
        }
        else
            System.out.println("City not found!");
    }
    public void show_city_for_travel(City c)
    {
        for (City temp:cities)
            if (temp!=c)
                System.out.println(temp.get_name());
    }

}
