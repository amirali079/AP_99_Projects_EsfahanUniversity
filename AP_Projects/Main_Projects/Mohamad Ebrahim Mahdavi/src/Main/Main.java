package Main;

import Country.Country;
import Exceptions.Incorrect_entry_exception;
import Exceptions.Non_profit_account_exception;
import Main.Buildings.*;
import Main.Vehicles.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import City.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import Main.Graphics.*;
public class Main {
    static final Object so =new Object();
    static FileWriter cities_info2;
    static FileOutputStream cities_obj2;
    static FileOutputStream country_obj2;
    static ObjectOutputStream cio2;
    static ObjectOutputStream cuo2;
    public static ArrayList<transaction>transactions = new ArrayList<>();
    public static boolean n_transaction = false;
    public static boolean fn_end = false;
    public static main_page mp;

    static {
        try {
            mp = new main_page();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Scanner sc=new Scanner(System.in);
        Country iran;
        City esf;
        boolean flag=false;
        boolean flag0=false;
        Main alaki = new Main();
        //Bank.t_main = alaki;
        FileReader cities_info;
        FileInputStream cities_obj;
        FileInputStream country_obj;
        ObjectInputStream cio;
        ObjectInputStream cuo;
        try {
            System.out.println("Try reading last saved file!\n_____________________________");
            cities_obj=new FileInputStream("D:\\project faze3\\cities obj.txt");
            country_obj=new FileInputStream("D:\\project faze3\\country obj.txt");
            cio=new ObjectInputStream(cities_obj);
            cuo=new ObjectInputStream(country_obj);
            iran=(Country) cuo.readObject();
            Thread.sleep(2000);
            for (City c: iran.cities)
                for (Bank b:c.banks)
                    b.start();
            System.out.println("Last file loaded successfully!\n_____________________________");
            cio.close();
            cuo.close();
            country_obj.close();
            cities_obj.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading file!\nThis is the first time you are using this program or you might not have been saved your last changes to this program!\n");
            iran=new Country("IRAN");

        }
        mp.setVisible(true);
        System.out.println("_____________________________Welcome to the IRAN_____________________________\n");
        while (!flag0)
        {
            System.out.println("1.Build a city\n2.Enter a city\n3.Destroy a city\n4.Show info\n5.Update info\n6.Financial management\n7.Exit\n_____________________________");
            int courser0=sc.nextInt();
            sc.nextLine();
            switch (courser0)
            {
                case 1:
                {
                    System.out.println("Enter the name of city:");
                    try
                    {
                        String name=sc.nextLine();
                        iran.add_city(name);
                        esf= iran.search_city(name);
                        person p = new person("mohammad", "mahdavi", "1381/1/15", name, 30, "male", "pilot");
                        esf.citizen.add(p);
                        p = new person("reza", "mahdavi", "1382/4/15", name, 25, "male", "driver");
                        esf.citizen.add(p);
                        p = new person("ahmad", "mahdavi", "1380/3/15", name, 15, "male", "staff");
                        esf.citizen.add(p);
                        p = new person("mohammad", "ahmadi", "1371/2/15", name, 20, "male", "sailor");
                        esf.citizen.add(p);
                        p = new person("sara", "ahmadi", "1371/2/15", name, 20, "female", "lukomotoran");
                        esf.citizen.add(p);
                    }
                    catch (Incorrect_entry_exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the city name:");
                    esf= iran.search_city(sc.nextLine());
                    if (esf!=null)
                    {
                        System.out.println("Welcome to "+esf.get_name()+"!\nIt is an honor having you as our mayor\n\n_____________________________");
                        while (!flag) {
                            System.out.println("\n1.Building & selling a Terminal\n2.Investing on a Terminal\n3.Building & investing on Hotels\n4.Show info\n5.Make a travel\n6.Show travel history\n7.Make a citizen\n8.Bank\n9.Exit");
                            int courser = sc.nextInt();
                            sc.nextLine();
                            switch (courser) {
                                case 1: {
                                    System.out.println("_________________Building a Terminal_________________");
                                    boolean flag2 = false;
                                    while (!flag2) {
                                        System.out.println("\n1.Airport\n2.Train station\n3.Bus station\n4.Harbour\n5.Sell\n6.Exit");
                                        int courser2 = sc.nextInt();
                                        sc.nextLine();
                                        switch (courser2) {
                                            case 1: {
                                                if (esf.capital >= 1000) {
                                                    System.out.println("Enter the name of airport :");
                                                    String name = sc.nextLine();
                                                    System.out.println("Enter the address :");
                                                    String address = sc.nextLine();
                                                    System.out.println("Enter the area :");
                                                    double area = sc.nextDouble();
                                                    System.out.println("Enter the runways number :");
                                                    double runways = sc.nextDouble();
                                                    System.out.println("Enter the type of airport :\n1.International\n2.Internal");
                                                    int f = sc.nextInt();
                                                    boolean airport_type;
                                                    airport_type = f == 1;
                                                    airport a = new airport("Esfahan", name, address, area, runways, airport_type);
                                                    esf.airports.add(a);
                                                    esf.capital -= a.get_price();
                                                    System.out.println("Airport added successfully!\nThe remaining capital is : " + esf.capital + "\n\n__________________________________\n");
                                                } else
                                                    lack_capital(esf);
                                                break;
                                            }
                                            case 2: {
                                                if (esf.capital >= 750) {
                                                    System.out.println("Enter the name of train station :");
                                                    String name = sc.nextLine();
                                                    System.out.println("Enter the address :");
                                                    String address = sc.nextLine();
                                                    System.out.println("Enter the area :");
                                                    double area = sc.nextDouble();
                                                    System.out.println("Enter the number of incoming railways");
                                                    double incoming_railways = sc.nextDouble();
                                                    System.out.println("Enter the number of outgoing railways");
                                                    double outgoing_railways = sc.nextDouble();
                                                    train_station a = new train_station("Esfahan", name, address, area, incoming_railways, outgoing_railways);
                                                    esf.train_stations.add(a);
                                                    esf.capital -= a.get_price();
                                                    System.out.println("Train station added successfully!\nThe remaining capital is : " + esf.capital + "\n\n__________________________________\n");
                                                } else
                                                    lack_capital(esf);
                                                break;
                                            }
                                            case 3: {
                                                if (esf.capital >= 500) {
                                                    System.out.println("Enter the name of Bus station :");
                                                    String name = sc.nextLine();
                                                    System.out.println("Enter the address :");
                                                    String address = sc.nextLine();
                                                    System.out.println("Enter the area :");
                                                    double area = sc.nextDouble();
                                                    bus_station a = new bus_station("Esfahan", name, address, area);
                                                    esf.bus_stations.add(a);
                                                    esf.capital -= a.get_price();
                                                    System.out.println("Bus station added successfully!\nThe remaining capital is : " + esf.capital + "\n\n__________________________________\n");
                                                } else
                                                    lack_capital(esf);
                                                break;
                                            }
                                            case 4: {
                                                if (esf.capital >= 600) {
                                                    System.out.println("Enter the name of Harbour :");
                                                    String name = sc.nextLine();
                                                    System.out.println("Enter the address :");
                                                    String address = sc.nextLine();
                                                    System.out.println("Enter the area :");
                                                    double area = sc.nextDouble();
                                                    System.out.println("Enter the pier number :");
                                                    int pier_num = sc.nextInt();
                                                    harbour a = new harbour("Esfahan", name, address, area, pier_num);
                                                    esf.harbours.add(a);
                                                    esf.capital -= a.get_price();
                                                    System.out.println("Harbour added successfully!\nThe remaining capital is : " + esf.capital + "\n\n__________________________________\n");
                                                } else
                                                    lack_capital(esf);
                                                break;
                                            }
                                            case 5: {
                                                System.out.println("\n_________________SELLING_________________\n1.Airport\n2.Train station\n3.Bus station\n4.Harbour");
                                                int courser3 = sc.nextInt();
                                                sc.nextLine();
                                                switch (courser3) {
                                                    case 1: {
                                                        System.out.println("Enter the name of target :");
                                                        String target = sc.nextLine();
                                                        airport target2 = esf.search_vehicle(target, esf.airports);
                                                        if (target2 != null) {
                                                            esf.capital += target2.get_price() / 2;
                                                            System.out.println("Airport sold successfully!\nYou money is refunded with 50% reduction!\nRemaining capital : " + esf.capital + "\n\n__________________________________\n");
                                                        } else
                                                            target_not_found();
                                                        break;
                                                    }
                                                    case 2: {
                                                        System.out.println("Enter the name of target :");
                                                        String target = sc.nextLine();
                                                        train_station target2 = esf.search_vehicle1(target, esf.train_stations);
                                                        if (target2 != null) {
                                                            esf.capital += target2.get_price() / 2;
                                                            System.out.println("Train station sold successfully!\nYou money is refunded with 50% reduction!\nRemaining capital : " + esf.capital + "\n\n__________________________________\n");
                                                        } else
                                                            target_not_found();
                                                        break;
                                                    }
                                                    case 3: {
                                                        System.out.println("Enter the name of target :");
                                                        String target = sc.nextLine();
                                                        bus_station target2 = esf.search_vehicle2(target, esf.bus_stations);
                                                        if (target2 != null) {
                                                            esf.capital += target2.get_price() / 2;
                                                            System.out.println("Bus station sold successfully!\nYou money is refunded with 50% reduction!\nRemaining capital : " + esf.capital + "\n\n__________________________________\n");
                                                        } else
                                                            target_not_found();
                                                        break;
                                                    }
                                                    case 4: {
                                                        System.out.println("Enter the name of target :");
                                                        String target = sc.nextLine();
                                                        harbour target2 = esf.search_vehicle3(target, esf.harbours);
                                                        if (target2 != null) {
                                                            esf.capital += target2.get_price() / 2;
                                                            System.out.println("Harbour sold successfully!\nYou money is refunded with 50% reduction!\nRemaining capital : " + esf.capital + "\n\n__________________________________\n");
                                                        } else
                                                            target_not_found();
                                                        break;
                                                    }
                                                    default: {
                                                        System.out.println("Wrong choice!\nTry again\n\n__________________________________\n");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            case 6: {
                                                flag2 = true;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Wrong choice!\nTry again\n\n__________________________________\n");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("_________________Investing on a Terminal_________________");
                                    boolean flag2 = false;
                                    while (!flag2) {
                                        System.out.println("\n1.Airport\n2.Train station\n3.Bus station\n4.Harbour\n5.Exit");
                                        int courser2 = sc.nextInt();
                                        sc.nextLine();
                                        switch (courser2) {
                                            case 1: {
                                                System.out.println("Enter the name of airport :");
                                                airport a = esf.search_vehicle(sc.nextLine(), esf.airports);
                                                if (a != null) {
                                                    System.out.println("_________________Airport_________________\n1.Add airliner\n2.Add cargo plane\n3.Sell airliner\n4.Sell cargo plane\n5.Hire\n6.Invest on airliners\n7.Welfare service\n8.Exit");
                                                    int courser3 = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (courser3) {
                                                        case 1: {
                                                            if (esf.capital >= 250) {
                                                                System.out.println("Enter the id :");
                                                                String id = sc.nextLine();
                                                                System.out.println("Enter the company name :");
                                                                String company_name = sc.nextLine();
                                                                System.out.println("Enter the production date :");
                                                                String production_date = sc.nextLine();
                                                                System.out.println("Enter the staff number :");
                                                                int staff_num = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Enter the class of airliner :");
                                                                String classes = sc.nextLine();
                                                                esf.capital -= a.add_airliner(id, company_name, production_date, staff_num, classes);
                                                                System.out.println("Airliner added successfully!\n\n__________________________________\n");
                                                            } else
                                                                lack_capital(esf);
                                                            break;
                                                        }
                                                        case 2: {
                                                            if (esf.capital >= 200) {
                                                                System.out.println("Enter the id :");
                                                                String id = sc.nextLine();
                                                                System.out.println("Enter the company name :");
                                                                String company_name = sc.nextLine();
                                                                System.out.println("Enter the production date :");
                                                                String production_date = sc.nextLine();
                                                                System.out.println("Enter the max weight :");
                                                                double max_weight = sc.nextDouble();
                                                                sc.nextLine();
                                                                esf.capital -= a.add_cargo_plane(id, company_name, production_date, max_weight);
                                                                System.out.println("Cargo plane added successfully!\n\n__________________________________\n");
                                                            } else
                                                                lack_capital(esf);
                                                            break;
                                                        }
                                                        case 3: {
                                                            System.out.println("Enter the id of target :");
                                                            esf.capital += a.delete_airliner(sc.nextLine(), esf);
                                                            break;
                                                        }
                                                        case 4: {
                                                            System.out.println("Enter the id of target :");
                                                            esf.capital += a.delete_cargo_plane(sc.nextLine(), esf);
                                                            break;
                                                        }
                                                        case 5: {
                                                            esf.show_person("pilot");
                                                            esf.hiring(sc.nextLine(), a);
                                                            break;
                                                        }
                                                        case 6: {
                                                            System.out.println("Enter the id of target :");
                                                            airliner air = (airliner) a.search_vehicle(sc.nextLine());
                                                            if (air != null) {
                                                                System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                                int count2 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (count2 == 1) {

                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.add_welfare_service2(name, air)) {
                                                                        name = sc.nextLine();
                                                                    }
                                                                } else if (count2 == 2) {
                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.delete_welfare_service2(name, air)) {
                                                                        name = sc.nextLine();
                                                                    }

                                                                } else
                                                                    System.out.println("Wrong choice!\nTry again");
                                                            } else
                                                                System.out.println("Target not found!\n\n__________________________________\n");
                                                            break;
                                                        }
                                                        case 7: {
                                                            System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                            int count2 = sc.nextInt();
                                                            sc.nextLine();
                                                            if (count2 == 1) {

                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.add_welfare_service(name, a)) {
                                                                    name = sc.nextLine();
                                                                }
                                                            } else if (count2 == 2) {
                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.delete_welfare_service(name, a)) {
                                                                    name = sc.nextLine();
                                                                }

                                                            } else
                                                                System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                        case 8: {
                                                            break;
                                                        }
                                                        default: {
                                                            System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                    }
                                                } else
                                                    System.out.println("Airport not found\n\n__________________________________\n");
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Enter the name of train station :");
                                                String target = sc.nextLine();
                                                train_station t = esf.search_vehicle1(target, esf.train_stations);
                                                if (t != null) {
                                                    System.out.println("_________________Train station_________________\n1.Add train\n2.Sell train\n3.Invest on a train\n4.Hire\n5.Welfare service\n6.Exit");
                                                    int courser3 = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (courser3) {
                                                        case 1: {
                                                            if (esf.capital >= 300) {
                                                                System.out.println("Enter the id :");
                                                                String id = sc.nextLine();
                                                                System.out.println("Enter the company name :");
                                                                String company_name = sc.nextLine();
                                                                System.out.println("Enter the production date :");
                                                                String production_date = sc.nextLine();
                                                                System.out.println("Enter the wagon number :");
                                                                int wagon_num = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Enter the star of train :");
                                                                int star = sc.nextInt();
                                                                sc.nextLine();
                                                                esf.capital -= t.add_train(id, company_name, production_date, wagon_num, star);
                                                                System.out.println("Train added successfully!\n\n__________________________________\n");
                                                            } else
                                                                lack_capital(esf);
                                                            break;
                                                        }
                                                        case 2: {
                                                            System.out.println("Enter the id of target :");
                                                            esf.capital += t.delete_vehicle(sc.nextLine(), esf);
                                                            break;
                                                        }
                                                        case 3: {
                                                            System.out.println("Enter the id of target :");
                                                            train air = (train) t.search_vehicle(sc.nextLine());
                                                            if (air != null) {
                                                                System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                                int count2 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (count2 == 1) {

                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.add_welfare_service2(name, air)) {
                                                                        name = sc.nextLine();
                                                                    }
                                                                } else if (count2 == 2) {
                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.delete_welfare_service2(name, air)) {
                                                                        name = sc.nextLine();
                                                                    }

                                                                } else
                                                                    System.out.println("Wrong choice!\nTry again");
                                                            } else
                                                                System.out.println("Target not found!\n\n__________________________________\n");
                                                            break;
                                                        }
                                                        case 4: {
                                                            esf.show_person("lukomotoran");
                                                            esf.hiring(sc.nextLine(), t);
                                                            break;
                                                        }
                                                        case 5: {
                                                            System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                            int count2 = sc.nextInt();
                                                            sc.nextLine();
                                                            if (count2 == 1) {

                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.add_welfare_service(name, t)) {
                                                                    name = sc.nextLine();
                                                                }
                                                            } else if (count2 == 2) {
                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.delete_welfare_service(name, t)) {
                                                                    name = sc.nextLine();
                                                                }

                                                            } else
                                                                System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                        case 6: {
                                                            break;
                                                        }
                                                        default: {
                                                            System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                    }
                                                } else
                                                    System.out.println("Train station not found\n\n__________________________________\n");
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("Enter the name of bus station :");
                                                String target = sc.nextLine();
                                                bus_station t = esf.search_vehicle2(target, esf.bus_stations);
                                                if (t != null) {
                                                    System.out.println("_________________Bus station_________________\n1.Add bus\n2.Sell bus\n3.Hire\n4.Welfare service\n5.Exit");
                                                    int courser3 = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (courser3) {
                                                        case 1: {
                                                            if (esf.capital >= 100) {
                                                                System.out.println("Enter the id :");
                                                                String id = sc.nextLine();
                                                                System.out.println("Enter the company name :");
                                                                String company_name = sc.nextLine();
                                                                System.out.println("Enter the production date :");
                                                                String production_date = sc.nextLine();
                                                                esf.capital -= t.add_bus(id, company_name, production_date);
                                                                System.out.println("Bus added successfully!\n\n__________________________________\n");
                                                            } else
                                                                System.out.println("The remaining capital is : " + esf.capital + "\nYou lack money!\nSorry\n\n__________________________________\n");
                                                            break;
                                                        }
                                                        case 2: {
                                                            System.out.println("Enter the id of target :");
                                                            esf.capital += t.delete_vehicle(sc.nextLine(), esf);
                                                            break;
                                                        }
                                                        case 3: {
                                                            esf.show_person("driver");
                                                            esf.hiring(sc.nextLine(), t);
                                                            break;
                                                        }
                                                        case 4: {
                                                            System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                            int count2 = sc.nextInt();
                                                            sc.nextLine();
                                                            if (count2 == 1) {

                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.add_welfare_service(name, t)) {
                                                                    name = sc.nextLine();
                                                                }
                                                            } else if (count2 == 2) {
                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.delete_welfare_service(name, t)) {
                                                                    name = sc.nextLine();
                                                                }

                                                            } else
                                                                System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                        case 5: {
                                                            break;
                                                        }
                                                        default: {
                                                            System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                    }
                                                } else
                                                    System.out.println("Bus station not found\n\n__________________________________\n");
                                                break;
                                            }
                                            case 4: {
                                                System.out.println("Enter the name of harbour :");
                                                String target = sc.nextLine();
                                                harbour a = esf.search_vehicle3(target, esf.harbours);
                                                if (a != null) {
                                                    System.out.println("_________________Harbour_________________\n1.Add ship\n2.Add boat\n3.Sell ship\n4.Sell boat\n5.Hire\n6.Invest on ships\n7.Welfare service\n8.Exit");
                                                    int courser3 = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (courser3) {
                                                        case 1: {
                                                            if (esf.capital >= 600) {
                                                                System.out.println("Enter the id :");
                                                                String id = sc.nextLine();
                                                                System.out.println("Enter the company name :");
                                                                String company_name = sc.nextLine();
                                                                System.out.println("Enter the production date :");
                                                                String production_date = sc.nextLine();
                                                                System.out.println("Enter the material name :");
                                                                String material = sc.nextLine();
                                                                esf.capital -= a.add_ship(id, company_name, production_date, material);
                                                                System.out.println("Ship added successfully!\n\n__________________________________\n");
                                                            } else
                                                                System.out.println("The remaining capital is : " + esf.capital + "\nYou lack money!\nSorry\n\n__________________________________\n");
                                                            break;
                                                        }
                                                        case 2: {
                                                            if (esf.capital >= 75) {
                                                                System.out.println("Enter the id :");
                                                                String id = sc.nextLine();
                                                                System.out.println("Enter the company name :");
                                                                String company_name = sc.nextLine();
                                                                System.out.println("Enter the production date :");
                                                                String production_date = sc.nextLine();
                                                                System.out.println("Enter the material name :");
                                                                String material = sc.nextLine();
                                                                esf.capital -= a.add_boat(id, company_name, production_date, material);
                                                                System.out.println("Boat added successfully!\n\n__________________________________\n");
                                                            } else
                                                                System.out.println("The remaining capital is : " + esf.capital + "\nYou lack money!\nSorry\n\n__________________________________\n");
                                                            break;
                                                        }
                                                        case 3: {
                                                            System.out.println("Enter the id of target :");
                                                            esf.capital += a.delete_ship(sc.nextLine(), esf);
                                                            break;
                                                        }
                                                        case 4: {
                                                            System.out.println("Enter the id of target :");
                                                            esf.capital += a.delete_boat(sc.nextLine(), esf);
                                                            break;
                                                        }
                                                        case 5: {
                                                            esf.show_person("sailor");
                                                            esf.hiring(sc.nextLine(), a);
                                                            break;
                                                        }
                                                        case 6: {
                                                            System.out.println("Enter the id of target :");
                                                            ship air = (ship) a.search_vehicle(sc.nextLine());
                                                            if (air != null) {
                                                                System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                                int count2 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (count2 == 1) {

                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.add_welfare_service2(name, air)) {
                                                                        name = sc.nextLine();
                                                                    }
                                                                } else if (count2 == 2) {
                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.delete_welfare_service2(name, air)) {
                                                                        name = sc.nextLine();
                                                                    }

                                                                } else
                                                                    System.out.println("Wrong choice!\nTry again");
                                                            } else
                                                                System.out.println("Target not found!\n\n__________________________________\n");
                                                            break;
                                                        }
                                                        case 7: {
                                                            System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                            int count2 = sc.nextInt();
                                                            sc.nextLine();
                                                            if (count2 == 1) {

                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.add_welfare_service(name, a)) {
                                                                    name = sc.nextLine();
                                                                }
                                                            } else if (count2 == 2) {
                                                                esf.show_welfare_service();
                                                                String name = sc.nextLine();
                                                                while (!esf.delete_welfare_service(name, a)) {
                                                                    name = sc.nextLine();
                                                                }

                                                            } else
                                                                System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                        case 8: {
                                                            break;
                                                        }
                                                        default: {
                                                            System.out.println("Wrong choice!\nTry again");
                                                            break;
                                                        }
                                                    }
                                                } else
                                                    System.out.println("Harbour not found\n\n__________________________________\n");
                                                break;
                                            }
                                            case 5: {
                                                flag2 = true;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Wrong choice\nTry again");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 3: {
                                    System.out.println("_________________Building & investing on Hotels_________________");
                                    boolean flag2 = false;
                                    while (!flag2) {
                                        System.out.println("\n1.Building a Hotel\n2.Investing\n3.Sell\n4.Exit");
                                        int courser2 = sc.nextInt();
                                        sc.nextLine();
                                        switch (courser2) {
                                            case 1: {
                                                if (esf.capital >= 700) {
                                                    System.out.println("Enter the name of hotel :");
                                                    String name = sc.nextLine();
                                                    System.out.println("Enter the address :");
                                                    String address = sc.nextLine();
                                                    System.out.println("Enter the star :");
                                                    int star = sc.nextInt();
                                                    System.out.println("Enter the number of rooms :");
                                                    int room_num = sc.nextInt();
                                                    sc.nextLine();
                                                    Hotel h = new Hotel(name, address, star, room_num);
                                                    esf.hotels.add(h);
                                                    System.out.println("Hotel built successfully!\n\n__________________________________\n");
                                                } else
                                                    System.out.println("The remaining capital is : " + esf.capital + "\nYou lack money!\nSorry\n\n__________________________________\n");
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Enter the name of the hotel :");
                                                String name1 = sc.nextLine();
                                                Hotel t = esf.search_hotel(name1, esf.hotels);
                                                if (t != null) {
                                                    boolean flag3 = false;
                                                    while (!flag3) {
                                                        System.out.println("1.Welfare service\n2.Add room\n3.Sell room\n4.Exit");
                                                        int courser3 = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (courser3) {
                                                            case 1: {
                                                                System.out.println("1.Add welfare service\n2.Delete welfare service");
                                                                int count2 = sc.nextInt();
                                                                sc.nextLine();
                                                                if (count2 == 1) {

                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.add_welfare_service3(name, t)) {
                                                                        name = sc.nextLine();
                                                                    }
                                                                } else if (count2 == 2) {
                                                                    esf.show_welfare_service();
                                                                    String name = sc.nextLine();
                                                                    while (!esf.delete_welfare_service3(name, t)) {
                                                                        name = sc.nextLine();
                                                                    }

                                                                } else
                                                                    System.out.println("Wrong choice!\nTry again");
                                                                break;
                                                            }
                                                            case 2: {
                                                                if (esf.capital >= 50) {
                                                                    System.out.println("Enter the room number :");
                                                                    int room_num = sc.nextInt();
                                                                    System.out.println("Enter the bed number :");
                                                                    int bed_num = sc.nextInt();
                                                                    System.out.println("Enter the area :");
                                                                    double area = sc.nextDouble();
                                                                    sc.nextLine();
                                                                    esf.capital -= t.add_room(room_num, bed_num, area);
                                                                    System.out.println("Room created successfully!\n\n__________________________________\n");
                                                                } else
                                                                    System.out.println("The remaining capital is : " + esf.capital + "\nYou lack money!\nSorry\n\n__________________________________\n");
                                                                break;
                                                            }
                                                            case 3: {
                                                                double v = 0;
                                                                int room_num;
                                                                while (v == 0) {
                                                                    System.out.println("Enter the room number :");
                                                                    room_num = sc.nextInt();
                                                                    sc.nextLine();
                                                                    v = t.delete_room(room_num);
                                                                }
                                                                esf.capital += v;
                                                                break;
                                                            }
                                                            case 4: {
                                                                flag3 = true;
                                                                break;
                                                            }
                                                            default: {
                                                                System.out.println("Wrong choice\nTry again");
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else
                                                    System.out.println("Target not found!\nTry again\n\n_____________________________\n");
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("Enter the name of the hotel :");
                                                String name = sc.nextLine();
                                                Hotel t = esf.search_hotel(name, esf.hotels);
                                                if (t != null) {
                                                    double price = t.get_price() / 2;
                                                    esf.hotels.remove(t);
                                                    System.out.println("Hotel sold successfully!\n\n_____________________________\n");
                                                    esf.capital += price;
                                                } else
                                                    System.out.println("Target not found!\nTry again\n\n_____________________________\n");

                                            }
                                            case 4: {
                                                flag2 = true;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Wrong choice\nTry again");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 4: {
                                    System.out.println("_________________Show info_________________\nYou have " + esf.capital + " remaining capital\n" + esf.airports.size() + " airport\n" + esf.train_stations.size() + " train station\n" + esf.bus_stations.size() + " bus station\n" + esf.harbours.size() + " harbour\n" + esf.hotels.size() + " hotel");
                                    for (Hotel h : esf.hotels)
                                        h.get_room();
                                    System.out.println("Citizens :");
                                    for (person temp:esf.citizen)
                                        System.out.println("Name : "+temp.getName()+"\nFamily : "+temp.getFamily()+"Career : "+ temp.getCareer()+"________________");
                                    System.out.println("Enter the name of the terminal you want information for :");
                                    esf.show_terminal_info(sc.nextLine());
                                    break;
                                }
                                case 5:
                                {
                                    System.out.println("1.By airplane\n2.By train\n3.by bus\n4.By ship");
                                    int cs=sc.nextInt();
                                    sc.nextLine();
                                    if (cs!=1&cs!=2&cs!=3&cs!=4)
                                        System.out.println("Wrong choice!\nTry again");
                                    else
                                    {
                                        try
                                        {
                                            System.out.println("Available terminals :\n_____________________________");
                                            esf.show_terminal_for_travel(cs);
                                            String origin_name = sc.nextLine();
                                            System.out.println("Available cities :\n_____________________________");
                                            iran.show_city_for_travel(esf);
                                            City dc = iran.search_city(sc.nextLine());
                                            if (dc == null|esf.search_terminal_arrival(origin_name,cs)==null)
                                                throw new Incorrect_entry_exception("City or terminal not found!");
                                            if (esf.search_terminal_departure(origin_name,cs)==null)
                                                throw new Incorrect_entry_exception("This terminal does not have any vehicle to travel!");
                                            esf.search_terminal_arrival(origin_name,cs).get_vehicle_info_for_travel();
                                            String vehicle_id=sc.nextLine();
                                            System.out.println("Destination terminals :");
                                            dc.show_terminal_for_travel(cs);
                                            String destination_name=sc.nextLine();
                                            esf.show_driver(cs);
                                            person driver=esf.search_person(sc.nextLine(), esf.citizen);
                                            esf.check_driver(cs,driver);
                                            esf.show_passengers();
                                            System.out.println("\nType End to finish\n");
                                            String passenger=sc.nextLine();
                                            ArrayList<person>passengers=new ArrayList<>();
                                            while (!passenger.equals("End"))
                                            {
                                                passengers.add(esf.search_person(passenger, esf.citizen));
                                                passenger=sc.nextLine();
                                            }
                                            System.out.println("Enter travel id :");
                                            String id=sc.nextLine();
                                            System.out.println("Enter travel date :");
                                            String date=sc.nextLine();
                                            esf.make_travel(id,date,origin_name,destination_name,vehicle_id,driver,passengers,dc,cs);
                                        }
                                        catch (Exception ex)
                                        {
                                            System.out.println(ex.getMessage());
                                        }
                                    }
                                    break;
                                }
                                case 6:
                                {
                                    System.out.println("1.Airports\n2.Train stations\n3.Bus stations\n4.Harbours");
                                    int cs2=sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Type :\narrival\nor\ndeparture\nor\nboth");
                                    try
                                    {
                                        esf.show_travel_history(cs2,sc.nextLine());
                                    }
                                    catch (Exception ex)
                                    {
                                        System.out.println(ex.getMessage());
                                    }
                                    break;
                                }
                                case 7: {
                                    System.out.println("Type citizen's name and last name :");
                                    String name=sc.next();
                                    String family=sc.next();
                                    sc.nextLine();
                                    System.out.println("Enter birth date and location :");
                                    String birth_date=sc.next();
                                    String birth_loc=sc.next();
                                    System.out.println("Enter salary :");
                                    int salary=sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter the career and gender (each in one line):");
                                    esf.citizen.add(new person(name,family,birth_date,birth_loc,salary,sc.nextLine(),sc.nextLine()));
                                    break;
                                }
                                case 8: {
                                    System.out.println("1.Create a bank\n2.Enter a bank\n3.Destroy a bank\n4.Exit\n________________________________");
                                    try {
                                        switch (sc.nextLine())
                                        {
                                            case "1": {
                                                System.out.println("Enter the name :");
                                                esf.create_bank(sc.nextLine());
                                                break;
                                            }
                                            case "2": {
                                                System.out.println("Enter the name :");
                                                Bank bank = esf.search_bank(sc.nextLine());
                                                System.out.println("1.Create an account\n2.Enter an account\n3.Delete account\n4.Show info");
                                                switch (sc.nextLine())
                                                {
                                                    case "1": {
                                                        System.out.println("Enter these properties in order and each in one line :1.username 2.password 3.owners name 4.initial amount");
                                                        double temp;
                                                        bank.create_account(sc.nextLine(),sc.nextLine(), esf.search_person(sc.nextLine(), esf.citizen), (temp = sc.nextDouble()));
                                                        sc.nextLine();
                                                        esf.capital-=temp;
                                                        break;
                                                    }
                                                    case "2": {
                                                        System.out.println("Enter username and password each in one line :");
                                                        bank.search_account(sc.nextLine(),sc.nextLine());
                                                        System.out.println("1.Deposit\n2.With drawl\n3.Show info");
                                                        switch (sc.nextLine())
                                                        {
                                                            case "1": {
                                                                double temp;
                                                                do {
                                                                    System.out.println("Enter the amount you want to deposit (if this cycle is repeating it means you lack enough capital) :\nCapital : "+esf.capital);
                                                                    temp = sc.nextDouble();
                                                                    sc.nextLine();
                                                                } while (esf.capital<temp);
                                                                bank.deposit(temp);
                                                                esf.capital-=temp;
                                                                break;
                                                            }
                                                            case "2": {
                                                                //?????????????????????????????
                                                                double temp = 0;
                                                                System.out.println("Following security procedures you should enter your username and password and requesting amount :");
                                                                try {
                                                                    bank.with_drawl(sc.nextLine(),sc.nextLine(),(temp=sc.nextDouble()));
                                                                } catch (Non_profit_account_exception np) {
                                                                    System.out.println(np.getMessage());
                                                                }
                                                                finally {
                                                                    sc.nextLine();
                                                                    esf.capital+=temp;
                                                                }
                                                                break;
                                                            }
                                                            case "3": {
                                                                bank.show_account_info();
                                                                break;
                                                            }
                                                            default: {
                                                                throw new Incorrect_entry_exception("Wrong cursor!");
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case "3": {
                                                        System.out.println("Enter username and password each in one line :");
                                                        bank.delete_account(sc.nextLine(),sc.nextLine());
                                                        break;
                                                    }
                                                    case "4": {
                                                        bank.show_info();
                                                        break;
                                                    }
                                                    default: {
                                                        throw new Incorrect_entry_exception("Wrong cursor!");
                                                    }
                                                }
                                                break;
                                            }
                                            case "3": {
                                                System.out.println("Enter the name :");
                                                esf.destroy_bank(sc.nextLine());
                                                break;
                                            }
                                            case "4": {
                                                break;
                                            }
                                            default: {
                                                throw new Incorrect_entry_exception("Wrong cursor!");
                                            }
                                        }
                                        break;
                                    } catch (Exception ex) {
                                        System.out.println(ex.getMessage());
                                    }
                                }
                                case 9: {
                                    flag = true;
                                    break;
                                }
                                default: {
                                    System.out.println("Wrong choice!\nTry again");
                                    break;
                                }
                            }
                        }
                        flag=false;
                    }
                    else
                        System.out.println("City not found");
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the city:");
                    iran.destroy_city(sc.nextLine());
                    break;
                }
                case 4:
                {
                    try {
                        System.out.println("Table type info:");
                        cities_info=new FileReader("D:\\project faze3\\cities info.csv");
                        CSVReader csr=new CSVReader(cities_info);
                        String[]result;
                        while ((result=csr.readNext())!=null)
                            System.out.printf("%-10s|%-10s|%-10s|%-11s|%-17s|%-15s|%-11s|%-12s\n",result[0],result[1],result[2],result[3],result[4],result[5],result[6],result[7]);
                        csr.close();
                        cities_info.close();
                    }catch (FileNotFoundException ex) {
                        System.out.println("No table info file has been created yet!\nTry updating your files!");
                    }
                    System.out.println("\n_____________________________\n\nTo see full info type yes otherwise type no");
                    if (sc.nextLine().equals("yes"))
                    iran.get_info();
                    break;
                }
                case 5:
                {
                    Bank.end = true;
                    for (City c:iran.cities)
                        for (Bank b:c.banks) {
                            b.money_maker.join();
                            b.money_maker = null;
                        }
                    save_file(iran);
                    for (City c: iran.cities)
                        for (Bank b:c.banks)
                            b.start();
                    break;
                }
                case 6:
                {
                    fn_end = false;
                    System.out.println("Type 1 to exit!");
                    Thread h = new Thread(alaki::fn);
                    h.start();
                    if (sc.nextLine().equals("1"))
                        fn_end = true;
                    break;
                }
                case 7:
                {
                    flag0=true;
                    break;
                }
                default:
                {
                    System.out.println("Wrong answer!\nTry again\n_____________________________");
                    break;
                }
            }
        }
        System.out.println("This process may take 30 seconds please wait!");
        Bank.end = true;
        for (City c:iran.cities)
            for (Bank b:c.banks) {
                b.money_maker.join();
                b.money_maker = null;
            }
        System.out.println("\n\n\n__________________________________________________________\nThis program is about to finish do you want to save your files (no need if you have updated them before quiting) type yes or no");
        if (sc.nextLine().equals("yes"))
            save_file(iran);

    }
    public static void lack_capital(City esf)
    {
        System.out.println("The remaining capital is : "+esf.capital+"\nYou lack money!\nSorry\n\n__________________________________\n");
    }
    static void target_not_found()
    {
        System.out.println("Target not found!\n\n__________________________________\n");
    }
    static void save_file(Country iran) throws IOException {
        System.out.println("Updating files now!\n_____________________________");
        cities_info2=new FileWriter("D:\\project faze3\\cities info.csv");
        cities_obj2=new FileOutputStream("D:\\project faze3\\cities obj.txt");
        country_obj2=new FileOutputStream("D:\\project faze3\\country obj.txt");
        cio2=new ObjectOutputStream(cities_obj2);
        cuo2=new ObjectOutputStream(country_obj2);
        cuo2.writeObject(iran);
        for (City temp:iran.cities)
            cio2.writeObject(temp);
        CSVWriter cs=new CSVWriter(cities_info2);
        cs.writeNext(new String[]{"Name","Wealth","Population","Airport num","Train station num","Bus station num","Harbour num","Vehicle num"});
        for (City temp:iran.cities)
            cs.writeNext(new String[]{temp.get_name(),String.valueOf(temp.capital),String.valueOf(temp.citizen.size()),String.valueOf(temp.airports.size()),String.valueOf(temp.train_stations.size()),String.valueOf(temp.bus_stations.size()),String.valueOf(temp.harbours.size()), temp.vehicle_num()});
        cs.close();
        cuo2.close();
        cio2.close();
        country_obj2.close();
        cities_obj2.close();
        cities_info2.close();
        System.out.println("\n_____________________________\nFiles updated successfully!\n\n\n_____________________________");
    }

    public void fn(){
        while (!fn_end) {
            transactions.clear();
            n_transaction = false;
            synchronized (this) {
                while (!n_transaction) {
                    try {
                        wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }
            if (fn_end)
                break;
            for (transaction t : transactions)
                t.show_info();
        }
    }
    public void no()
    {
        synchronized (this)
        {
            notifyAll();
        }
    }
}
