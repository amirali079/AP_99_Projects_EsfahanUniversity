package Main;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Main.Bank.Bank;
import Main.Bank.BankAccount;
import Main.Buildings.*;
import javax.swing.*;
import Main.Exception.*;
import Main.Graphics.BankAccountGraphic;
import Main.Graphics.FinancialManagement;
import Main.Graphics.LoginPage;
import Main.Graphics.SignUpPage;
import Main.Person.Job;
import Main.Vehicles.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String countryName = null;

        File file = new File("cities.txt");
        if(file.isFile()){
            try {
                FileReader userInfo=new FileReader("user.txt");
                BufferedReader bufferedReader=new BufferedReader(userInfo);
                String []info=bufferedReader.readLine().split(" ");
                String Info = String.format("Hi %s %s\nWelcome To The Electronic City!", info[0], info[1]);
                JOptionPane.showMessageDialog(null, Info, "WELCOME BACK BOSS!", JOptionPane.INFORMATION_MESSAGE);
                readCitiesFromFile();
                countryName=readCountryFromFile();
                for (int i=0;i<Country.getCities().size();i++){
                    for (int j=0;j<Country.getCities().get(i).getBanks().size();j++){
                        for (int k=0;k<Country.getCities().get(i).getBanks().get(j).getBankAccounts().size();k++){
                            Country.getCities().get(i).getBanks().get(j).getBankAccounts().get(k).profitCalculate();
                        }
                    }
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }else {
            String Name = JOptionPane.showInputDialog(null, "Please Enter Your Name", "WHAT'S YOUR NAME?", JOptionPane.QUESTION_MESSAGE);
            while (Name.length() <= 2) {
                try {
                    throw new InvalidInput("ERROR:The Name Should Be At least 3 characters!");
                } catch (InvalidInput invalidInput) {
                    System.out.println(invalidInput.getMessage());
                    Toolkit.getDefaultToolkit().beep();
                    Name = JOptionPane.showInputDialog(null, "Please Enter Your Name Again!", "WHAT'S YOUR NAME?", JOptionPane.QUESTION_MESSAGE);
                }
            }
            Answer1[] answer1 = Answer1.values();
            int answer3 = JOptionPane.showOptionDialog(null, "Please Select Your Gender", "WHAT'S YOUR GENDER?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, answer1, null);
            String Gender;
            if (answer3 == 0)
                Gender = "Mr";
            else
                Gender = "Miss";

            String Info = String.format("Hi %s %s\nWelcome To The Electronic City!", Gender, Name);
            JOptionPane.showMessageDialog(null, Info, "WELCOME BOSS!", JOptionPane.INFORMATION_MESSAGE);
            try {
                FileWriter countryInfo=new FileWriter("user.txt") ;
                countryInfo.write(String.format("%s %s",Gender,Name));
                countryInfo.close();
            }catch (Exception exception){
                exception.printStackTrace();
            }
            countryName = JOptionPane.showInputDialog(null, "Dear " + Gender + " " + Name + " Please Enter Your Country Name", "What's Your Country Name Boss?", JOptionPane.QUESTION_MESSAGE);
            while (countryName.length() <= 2) {
                try {
                    throw new InvalidInput("ERROR:The Country Name Should Be At least 3 characters!");
                } catch (InvalidInput invalidInput) {
                    System.out.println(invalidInput.getMessage());
                    Toolkit.getDefaultToolkit().beep();
                    countryName = JOptionPane.showInputDialog(null, "Dear " + Gender + " " + Name + " Please Enter Your Country Name Again!", "What's Your Country Name Boss?", JOptionPane.QUESTION_MESSAGE);
                }
            }
            String CapitalName = JOptionPane.showInputDialog(null, "Dear " + Gender + " " + Name + " Please Enter Your Capital Name Of " + countryName, "What's The Capital Name Of " + countryName + " Boss?", JOptionPane.QUESTION_MESSAGE);
            while (CapitalName.length() <= 2) {
                try {
                    throw new InvalidInput("ERROR:The Capital Name Should Be At least 3 characters!");
                } catch (InvalidInput invalidInput) {
                    System.out.println(invalidInput.getMessage());
                    Toolkit.getDefaultToolkit().beep();
                    CapitalName = JOptionPane.showInputDialog(null, "Dear " + Gender + " " + Name + " Please Enter Your Capital Name Of " + countryName + " Again!", "What's The Capital Name Of " + countryName + " Boss?", JOptionPane.QUESTION_MESSAGE);
                }
            }
            City capital = new City(CapitalName);
            Country.AddCapital(capital);

            capital.AddCapitalPerson("reza", "jafari", 1379, "shiraz", Person.Job.pilot, "Male", 100, false);
            capital.AddCapitalPerson("kiarash", "samadi", 1381, "isfahan", Person.Job.pilot, "Male", 110, false);
            capital.AddCapitalPerson("farbod", "samadi", 1386, "isfahan", Person.Job.pilot, "Male", 120, false);
            capital.AddCapitalPerson("mahdi", "ahmadi", 1360, "tehran", Person.Job.pilot, "Male", 130, false);
            capital.AddCapitalPerson("farokh", "samadi", 1330, "roudbar", Person.Job.pilot, "Male", 140, false);
            capital.AddCapitalPerson("farshad", "samadi", 1345, "tehran", Person.Job.pilot, "Male", 150, false);
            capital.AddCapitalPerson("farzad", "samadi", 1343, "tehran", Person.Job.pilot, "Male", 160, false);
            capital.AddCapitalPerson("kasra", "rezaei", 1381, "isfahan", Person.Job.pilot, "Male", 170, false);
            capital.AddCapitalPerson("ali", "goli", 1360, "isfahan", Person.Job.pilot, "Male", 180, false);
            capital.AddCapitalPerson("kasra", "samadi", 1379, "isfahan", Person.Job.pilot, "Male", 190, false);
            capital.AddCapitalPerson("milad", "hatami", 1350, "mashhad", Person.Job.pilot, "Male", 150, false);
            capital.AddCapitalPerson("reza", "rostami", 1335, "kerman", Person.Job.pilot, "Male", 133, false);
            capital.AddCapitalPerson("mohsen", "nikkhah", 1345, "tabriz", Person.Job.pilot, "Male", 140, false);
            capital.AddCapitalPerson("alireza", "sajadi", 1355, "yazd", Person.Job.pilot, "Male", 160, false);
            capital.AddCapitalPerson("masih", "amooei", 1365, "isfahan", Person.Job.pilot, "Male", 145, false);
            capital.AddCapitalPerson("qhasem", "alaei", 1360, "isfahan", Person.Job.pilot, "Male", 155, false);
            capital.AddCapitalPerson("arash", "kasraei", 1365, "isfahan", Person.Job.pilot, "Male", 177, false);
            capital.AddCapitalPerson("siavash", "kimiaei", 1365, "isfahan", Person.Job.pilot, "Male", 148, false);
            capital.AddCapitalPerson("ali", "zerehpoosh", 1345, "isfahan", Person.Job.pilot, "Male", 165, false);
            capital.AddCapitalPerson("parsa", "tabatabaei", 1379, "isfahan", Person.Job.pilot, "Male", 185, false);

            capital.AddCapitalPerson("hassan", "hosseini", 1379, "tabriz", Person.Job.malvan, "Male", 100, false);
            capital.AddCapitalPerson("ali", "abbasi", 1340, "yazd", Person.Job.malvan, "Male", 90, false);
            capital.AddCapitalPerson("taha", "yazdani", 1380, "karman", Person.Job.malvan, "Male", 95, false);
            capital.AddCapitalPerson("pouya", "irandoost", 1380, "tahran", Person.Job.malvan, "Male", 80, false);
            capital.AddCapitalPerson("amir", "alavi", 1370, "khansar", Person.Job.malvan, "Male", 75, false);
            capital.AddCapitalPerson("javad", "harooni", 1345, "isfahan", Person.Job.malvan, "Male", 80, false);
            capital.AddCapitalPerson("ali", "askari", 1379, "gilan", Person.Job.malvan, "Male", 85, false);
            capital.AddCapitalPerson("mohammad", "mortezaei", 1379, "mazandaran", Person.Job.malvan, "Male", 110, false);
            capital.AddCapitalPerson("masih", "baqheri", 1379, "tehran", Person.Job.malvan, "Male", 130, false);
            capital.AddCapitalPerson("pedram", "samaei", 1379, "shiraz", Person.Job.malvan, "Male", 120, false);
            capital.AddCapitalPerson("pedram", "bidram", 1368, "qhom", Person.Job.malvan, "Male", 125, false);
            capital.AddCapitalPerson("reaz", "samani", 1345, "tabriz", Person.Job.malvan, "Male", 135, false);
            capital.AddCapitalPerson("kimia", "ahmadi", 1369, "yazd", Person.Job.malvan, "Female", 140, false);
            capital.AddCapitalPerson("zahra", "akbari", 1367, "semnan", Person.Job.malvan, "Female", 123, false);
            capital.AddCapitalPerson("fatemeh", "yazdani", 1360, "yazd", Person.Job.malvan, "Female", 127, false);
            capital.AddCapitalPerson("diba", "pourahmadi", 1345, "mazandaran", Person.Job.malvan, "Female", 145, false);
            capital.AddCapitalPerson("vahid", "akbari", 1337, "khozestan", Person.Job.malvan, "Male", 125, false);
            capital.AddCapitalPerson("mohammad", "alizadeh", 1346, "boushehr", Person.Job.malvan, "Male", 145, false);
            capital.AddCapitalPerson("mohammadreaz", "alimardani", 1361, "semnan", Person.Job.malvan, "Male", 169, false);
            capital.AddCapitalPerson("pouria", "poursorkh", 1355, "qhom", Person.Job.malvan, "Male", 173, false);

            capital.AddCapitalPerson("kiarash", "rezaei", 1340, "semnan", Person.Job.bus_driver, "Male", 50, false);
            capital.AddCapitalPerson("mohsen", "afshri", 1341, "tehran", Person.Job.bus_driver, "Male", 55, false);
            capital.AddCapitalPerson("pouria", "zeraei", 1345, "amol", Person.Job.bus_driver, "Male", 60, false);
            capital.AddCapitalPerson("behnam", "bani", 1347, "tehran", Person.Job.bus_driver, "Male", 65, false);
            capital.AddCapitalPerson("farbod", "rajabi", 1383, "shiraz", Person.Job.bus_driver, "Male", 70, false);
            capital.AddCapitalPerson("kian", "rostami", 1346, "yazd", Person.Job.bus_driver, "Male", 75, false);
            capital.AddCapitalPerson("kasra", "sotani", 1330, "kashan", Person.Job.bus_driver, "Male", 80, false);
            capital.AddCapitalPerson("mahdi", "khalili", 1336, "rasht", Person.Job.bus_driver, "Male", 67, false);
            capital.AddCapitalPerson("arshia", "mahvash", 1348, "mazandaran", Person.Job.bus_driver, "Male", 78, false);
            capital.AddCapitalPerson("ashkan", "sani", 1365, "mashhad", Person.Job.bus_driver, "Male", 90, false);
            capital.AddCapitalPerson("ahmad", "taqhipour", 1356, "tabriz", Person.Job.bus_driver, "Male", 80, false);
            capital.AddCapitalPerson("mehdi", "rostami", 1367, "yazd", Person.Job.bus_driver, "Male", 85, false);
            capital.AddCapitalPerson("sohrab", "rasooli", 1374, "booshehr", Person.Job.bus_driver, "Male", 65, false);
            capital.AddCapitalPerson("morteza", "vakili", 1378, "kashan", Person.Job.bus_driver, "Male", 66, false);
            capital.AddCapitalPerson("hadi", "emami", 1378, "dezfool", Person.Job.bus_driver, "Male", 45, false);
            capital.AddCapitalPerson("shayan", "shafiei", 1369, "tehran", Person.Job.bus_driver, "Male", 50, false);
            capital.AddCapitalPerson("ali", "asadi", 1371, "rasht", Person.Job.bus_driver, "Male", 55, false);
            capital.AddCapitalPerson("mohammad", "alizadeh", 1356, "shahrkord", Person.Job.bus_driver, "Male", 60, false);
            capital.AddCapitalPerson("ramin", "qhasemi", 1360, "sabzevar", Person.Job.bus_driver, "Male", 62, false);
            capital.AddCapitalPerson("mohsem", "matin", 1358, "mashhad", Person.Job.bus_driver, "Male", 56, false);

            capital.AddCapitalPerson("bashir", "shadmani", 1360, "mashhad", Person.Job.Locomotive_driver, "Male", 80, false);
            capital.AddCapitalPerson("amir", "zarei", 1370, "khozestan", Person.Job.Locomotive_driver, "Male", 90, false);
            capital.AddCapitalPerson("babak", "soltani", 1371, "fars", Person.Job.Locomotive_driver, "Male", 100, false);
            capital.AddCapitalPerson("javad", "bakhshandeh", 1350, "booshehr", Person.Job.Locomotive_driver, "Male", 110, false);
            capital.AddCapitalPerson("khosro", "mirhaj", 1350, "semnan", Person.Job.Locomotive_driver, "Male", 85, false);
            capital.AddCapitalPerson("roozbeh", "fekri", 1336, "hamedan", Person.Job.Locomotive_driver, "Male", 82, false);
            capital.AddCapitalPerson("sasha", "alavi", 1378, "zanjan", Person.Job.Locomotive_driver, "Male", 95, false);
            capital.AddCapitalPerson("shahab", "mokhtari", 1365, "najafabad", Person.Job.Locomotive_driver, "Male", 120, false);
            capital.AddCapitalPerson("ali", "samadi", 1345, "qhazvin", Person.Job.Locomotive_driver, "Male", 130, false);
            capital.AddCapitalPerson("kaveh", "kiani", 1364, "saveh", Person.Job.Locomotive_driver, "Male", 125, false);
            capital.AddCapitalPerson("parisa", "dolatshahi", 1362, "ilam", Person.Job.Locomotive_driver, "female", 135, false);
            capital.AddCapitalPerson("sahar", "karimi", 1366, "fars", Person.Job.Locomotive_driver, "female", 147, false);
            capital.AddCapitalPerson("sadiqheh", "sadegi", 1364, "isfahan", Person.Job.Locomotive_driver, "female", 129, false);
            capital.AddCapitalPerson("alireza", "yahaqhi", 1357, "zanjan", Person.Job.Locomotive_driver, "Male", 145, false);
            capital.AddCapitalPerson("bahram", "sadat", 1358, "golestan", Person.Job.Locomotive_driver, "Male", 142, false);
            capital.AddCapitalPerson("yaser", "mohseni", 1354, "zanjan", Person.Job.Locomotive_driver, "Male", 137, false);
            capital.AddCapitalPerson("mehdi", "moeini", 1367, "ahwaz", Person.Job.Locomotive_driver, "Male", 133, false);
            capital.AddCapitalPerson("majid", "rajaei", 1349, "ardebil", Person.Job.Locomotive_driver, "Male", 130, false);
            capital.AddCapitalPerson("mohammadreza", "pasha", 1354, "saveh", Person.Job.Locomotive_driver, "Male", 127, false);
            capital.AddCapitalPerson("soheil", "yazdanbakhsh", 1352, "ardebil", Person.Job.Locomotive_driver, "Male", 152, false);

            capital.AddCapitalPerson("darya", "darabi", 1364, "tabriz", Person.Job.crew, "female", 50, false);
            capital.AddCapitalPerson("gita", "ebadi", 1360, "zanjan", Person.Job.crew, "female", 55, false);
            capital.AddCapitalPerson("hellen", "qhasemi", 1365, "boohehr", Person.Job.crew, "female", 60, false);
            capital.AddCapitalPerson("kimia", "kamrava", 1367, "tabriz", Person.Job.crew, "female", 65, false);
            capital.AddCapitalPerson("mahla", "qhafoori", 1370, "kerman", Person.Job.crew, "female", 70, false);
            capital.AddCapitalPerson("niloofar", "darabi", 1368, "hormozgan", Person.Job.crew, "female", 75, false);
            capital.AddCapitalPerson("shiva", "soltani", 1350, "ardebil", Person.Job.crew, "female", 80, false);
            capital.AddCapitalPerson("mohammad", "razdani", 1355, "saveh", Person.Job.crew, "Male", 85, false);
            capital.AddCapitalPerson("kian", "majlesi", 1360, "ahvaz", Person.Job.crew, "Male", 90, false);
            capital.AddCapitalPerson("parsa", "rasooli", 1365, "qhom", Person.Job.crew, "Male", 95, false);
            capital.AddCapitalPerson("solmaz", "mansoori", 1357, "kashan", Person.Job.crew, "female", 56, false);
            capital.AddCapitalPerson("sara", "nasirian", 1357, "sari", Person.Job.crew, "female", 55, false);
            capital.AddCapitalPerson("maryam", "vafaei", 1359, "saveh", Person.Job.crew, "female", 45, false);
            capital.AddCapitalPerson("zahra", "mohammadi", 1348, "tabriz", Person.Job.crew, "female", 40, false);
            capital.AddCapitalPerson("farzaneh", "javadi", 1365, "tabriz", Person.Job.crew, "female", 65, false);
            capital.AddCapitalPerson("nahid", "teimoori", 1368, "chabahar", Person.Job.crew, "female", 75, false);
            capital.AddCapitalPerson("ehteram", "noohi", 1364, "tabriz", Person.Job.crew, "female", 85, false);
            capital.AddCapitalPerson("parvaneh", "samadi", 1354, "roudbar", Person.Job.crew, "female", 86, false);
            capital.AddCapitalPerson("sakineh", "hoseinzadeh", 1359, "shiraz", Person.Job.crew, "female", 87, false);
            capital.AddCapitalPerson("najme", "katiraei", 1364, "qhom", Person.Job.crew, "female", 68, false);

        }
        Passenger_plane passenger_plane1 = new Passenger_plane(400, 30, 0, "Air bus", 2000, 100, 10, 40);
        Passenger_plane passenger_plane2 = new Passenger_plane(450, 35, 0, "Mahan", 3000, 90, 10, 50);
        Passenger_plane passenger_plane3 = new Passenger_plane(300, 30, 0, "ATR", 3500, 80, 15, 45);
        Passenger_plane passenger_plane4 = new Passenger_plane(350, 25, 0, "Boeing", 4000, 110, 5, 40);
        Passenger_plane passenger_plane5 = new Passenger_plane(500, 20, 0, "Air bus", 4500, 120, 15, 60);

        passenger_plane1.AddPassengerPlanes(passenger_plane1);
        passenger_plane2.AddPassengerPlanes(passenger_plane2);
        passenger_plane3.AddPassengerPlanes(passenger_plane3);
        passenger_plane4.AddPassengerPlanes(passenger_plane4);
        passenger_plane5.AddPassengerPlanes(passenger_plane5);

        Cargo_plane cargo_plane1 = new Cargo_plane(500, 100, 0, "Air bus", 1000, 500, 500000);
        Cargo_plane cargo_plane2 = new Cargo_plane(600, 200, 0, "Mahan", 900, 400, 600000);
        Cargo_plane cargo_plane3 = new Cargo_plane(700, 150, 0, "ATR", 800, 300, 400000);
        Cargo_plane cargo_plane4 = new Cargo_plane(650, 250, 0, "Boeing", 1100, 200, 300000);
        Cargo_plane cargo_plane5 = new Cargo_plane(550, 170, 0, "Air bus", 1200, 100, 320000);

        cargo_plane1.AddCargoPlanes(cargo_plane1);
        cargo_plane2.AddCargoPlanes(cargo_plane2);
        cargo_plane3.AddCargoPlanes(cargo_plane3);
        cargo_plane4.AddCargoPlanes(cargo_plane4);
        cargo_plane5.AddCargoPlanes(cargo_plane5);

        Train train1 = new Train(100, 20, 0, "SamandRail", "Coal", Service.RESTAURANT, Service.RESTROOM, 20, 35, 2);
        Train train2 = new Train(200, 25, 0, "Aras", "Coal", Service.RESTAURANT, Service.RESTROOM, 25, 40, 3);
        Train train3 = new Train(300, 30, 0, "Isar", "Coal", Service.RESTAURANT, Service.TV, Service.RESTROOM, 30, 50, 4);
        Train train4 = new Train(500, 35, 0, "Raja", "Coal", Service.RESTAURANT, Service.COFFEE_SHOP, Service.RESTROOM, 35, 45, 5);
        Train train5 = new Train(200, 40, 0, "Saba", "Coal", Service.RESTAURANT, Service.RESTROOM, 25, 40, 3);

        train1.AddTrains(train1);
        train2.AddTrains(train2);
        train3.AddTrains(train3);
        train4.AddTrains(train4);
        train5.AddTrains(train5);


        Bus bus1 = new Bus(100, 10, 0, "Scania", "Benzin", 2, 200, 3);
        Bus bus2 = new Bus(110, 15, 0, "Volvo", "Gazoeil", 2, 100, 2);
        Bus bus3 = new Bus(90, 20, 0, "Iran khodro", "Benzin", 3, 250, 4);
        Bus bus4 = new Bus(95, 25, 0, "Scania", "Gazoeil", 2, 150, 3);
        Bus bus5 = new Bus(100, 30, 0, "King Long", "Benzin", 3, 200, 2);

        bus1.AddBuses(bus1);
        bus2.AddBuses(bus2);
        bus3.AddBuses(bus3);
        bus4.AddBuses(bus4);
        bus5.AddBuses(bus5);


        Ship ship1 = new Ship(400, 20, 0, "Mitsubishi", "Gazoeil", 500, 5, 10);
        Ship ship2 = new Ship(200, 25, 0, "Mitsubishi", "Gazoeil", 600, 10, 15);
        Ship ship3 = new Ship(150, 35, 0, "Hyundai", "Gazoeil", 650, 15, 20);
        Ship ship4 = new Ship(250, 40, 0, "Mitsubishi", "Gazoeil", 400, 15, 15);
        Ship ship5 = new Ship(300, 45, 0, "Hyundai", "Gazoeil", 450, 20, 10);

        ship1.AddShips(ship1);
        ship2.AddShips(ship2);
        ship3.AddShips(ship3);
        ship4.AddShips(ship4);
        ship5.AddShips(ship5);

        Boat boat1 = new Boat(50, 3, 0, "Hyundai", "Benzin", 100, "wooden");
        Boat boat2 = new Boat(70, 4, 0, "Mitsubishi", "Benzin", 120, "metallic");
        Boat boat3 = new Boat(60, 5, 0, "Hyundai", "Benzin", 80, "metallic");
        Boat boat4 = new Boat(65, 5, 0, "Mitsubishi", "Benzin", 90, "metallic");
        Boat boat5 = new Boat(55, 4, 0, "Hyundai", "Benzin", 100, "wooden");

        boat1.AddBoats(boat1);
        boat2.AddBoats(boat2);
        boat3.AddBoats(boat3);
        boat4.AddBoats(boat4);
        boat5.AddBoats(boat5);

        City City;
        try {
        while (true){
            BankAccount.isEntered=false;
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"\n**************MAIN MENU**************"+ConsoleColors.RESET);
            System.out.format(ConsoleColors.BLUE_BRIGHT+"COUNTRY: %S",countryName+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BRIGHT+"\nCAPITAL: "+Country.getCities().get(0).getCityName().toUpperCase()+ConsoleColors.RESET);
            Country.ShowBudgetAndPopulation();
            System.out.println(ConsoleColors.PURPLE_BRIGHT+"\n(1)Add a City\n(2)Enter To a City\n(3)Financial Management\n(4)Show Cities\n(5)Exit"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BRIGHT+"Please Enter a number : "+ConsoleColors.RESET);
            switch (sc.nextInt()){
                case 1://Add a City
                    System.out.println("Please Enter The Name Of The City That You Want To Add:");
                    String CityName=sc.next();
                    while (CityName.length()<=2) {
                        try {
                                throw new InvalidInput("ERROR:The City Name Should Be At least 3 characters!");
                        } catch (InvalidInput invalidInput) {
                            System.out.println(invalidInput.getMessage());
                            Toolkit.getDefaultToolkit().beep();
                            System.out.println("Please Enter The Correct City Name:");
                            CityName = sc.next();
                        }
                    }
                    Country.AddCity(CityName);
                    break;
                case 2://Enter a City
                        Country.ShowCities();
                        System.out.println("\nPlease Select a City To Enter:");
                        City=Country.EnterACity(sc.nextInt());
                        boolean situation=true;
                        while (situation) {
                            System.out.format(ConsoleColors.CYAN_BOLD_BRIGHT + "\n**************%S CITY**************\n", City.getCityName() + ConsoleColors.CYAN_BOLD_BRIGHT + ConsoleColors.RESET);
                            City.Show_Money_and_Population();
                            System.out.println(ConsoleColors.GREEN_BRIGHT + "\n(1)Terminals\n(2)Hotels\n(3)People\n(4)Travels\n(5)Bank\n(6)Back To The Main Menu" + ConsoleColors.RESET);
                            System.out.println("Please enter a number : ");
                            int adad = sc.nextInt();
                            switch (adad) {
                                //Terminals
                                case 1:
                                    boolean situation1 = true;
                                    while (situation1){
                                    System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n**************TERMINALS**************" + ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.PURPLE_BRIGHT + "(1)Airport\n(2)Railway Station\n(3)Bus Terminal\n(4)Shipping Port\n(5)Back \n" + ConsoleColors.RESET);
                                    int adad2 = sc.nextInt();
                                    switch (adad2) {
                                        case 1:
                                            //Airport
                                            boolean situation5 = true;
                                            while (situation5) {
                                                System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n**************AIRPORT***************" + ConsoleColors.RESET);
                                                System.out.println(ConsoleColors.BLUE_BRIGHT + "(1)Buy a new Airport\n(2)Buy a new passenger plane\n(3)Buy a new Cargo plane\n(4)Hiring Pilots\n(5)Show All Passenger Planes\n(6)Show All Cargo Planes\n(7)Back" + ConsoleColors.RESET);
                                                int adad3 = sc.nextInt();
                                                switch (adad3) {
                                                    case 1:
                                                        //Buy a new Airports
                                                        if (!(City.isConstructedTerminal("Airport"))) {
                                                            System.out.println("Your Terminal Name is : "+City.getCityName() + " Airport Terminal");
                                                            System.out.println("Please Enter The Area of This Terminal: ");
                                                            int Area= sc.nextInt();
                                                            System.out.println("Please Enter The Number Of Run Ways :");
                                                            int NumberOfRunWays=sc.nextInt();
                                                            int Cost=Area+ (NumberOfRunWays * 10);
                                                            Airport airport = new Airport(Cost, City.getCityName(), City.getCityName() + " Airport Terminal", "Iran_" + City.getCityName(), Area, 0, "true", NumberOfRunWays);
                                                            Airport.ShowAirport(airport);
                                                            System.out.println("Do You Want To Buy? Yes/No ");
                                                            String answer = sc.next();
                                                            if (answer.startsWith("Y") || answer.startsWith("y")) {
                                                                if (City.payMoney(airport.getCost_Construction())) {
                                                                    City.AddTerminal(airport);
                                                                }
                                                            } else break;
                                                        } else System.out.println("You Bought a Airport!!!");
                                                        break;
                                                    case 2:
                                                        //Buy a new passenger plane
                                                        if (City.isConstructedTerminal("Airport")) {
                                                            Passenger_plane.ShowPassengerPlanes();
                                                            System.out.println("\nWhich Passenger plane do you want to buy?(Please enter Passenger plane ID)");
                                                            int PassengerPlaneID = sc.nextInt();
                                                            if (City.payMoney(Passenger_plane.getPassenger_planes().get(PassengerPlaneID).getPrice())) {
                                                                ((Airport) City.ReturnTerminal("Airport")).AddPassenger_plane(Passenger_plane.getPassenger_planes().get(PassengerPlaneID));
                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY AIRPORT UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 3:
                                                        //Buy a new Cargo plane
                                                        if (City.isConstructedTerminal("Airport")) {
                                                            Cargo_plane.ShowCargoPlanes();
                                                            System.out.println("\nWhich Cargo Plane do you want to buy?(Please enter Cargo plane ID)");
                                                            int CargoPlanesID = sc.nextInt();
                                                            if (City.payMoney(Cargo_plane.getCargo_planes().get(CargoPlanesID).getPrice())) {
                                                                ((Airport) City.ReturnTerminal("Airport")).AddCargo_plane(Cargo_plane.getCargo_planes().get(CargoPlanesID));
                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY AIRPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 4:
                                                        //Hiring Pilots
                                                        if (City.isConstructedTerminal("Airport")) {
                                                            try {
                                                                City.Show_NotHiredPeople_By_Job(2);
                                                                System.out.println("\nWhich Pilot do you want to hire?(Please enter Pilot ID)");
                                                                int PilotID = sc.nextInt();
                                                                if (City.payMoney(City.getPerson().get(PilotID).getEmployment_salary())) {
                                                                    ((Airport) City.ReturnTerminal("Airport")).Add_Leaders(City.getPerson().get(PilotID));
                                                                    City.getPerson().get(PilotID).setEmployment_situation(true);
                                                                    System.out.println("PILOT HIRING WAS SUCCESSFUL!");
                                                                }
                                                            }catch (ThereWasNoDriver thereWasNoDriver){
                                                                System.out.println(thereWasNoDriver.getMessage());
                                                                Toolkit.getDefaultToolkit().beep();
                                                            }

                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY AIRPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 5:
                                                        //Show All Passenger Planes
                                                        if (City.isConstructedTerminal("Airport")) {
                                                            Airport airport = (Airport) City.ReturnTerminal("Airport");
                                                            airport.ShowPassengerPlanes();
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY AIRPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 6:
                                                        //Show All Cargo Planes
                                                        if (City.isConstructedTerminal("Airport")) {
                                                            Airport airport = (Airport) City.ReturnTerminal("Airport");
                                                            airport.ShowCargoPlanes();
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY AIRPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 7:
                                                        situation5 = false;
                                                        break;
                                                }
                                            }
                                            break;
                                        case 2:
                                            //Railway Station
                                            boolean situation6 = true;
                                            while (situation6) {
                                                System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n***********RAILWAY STATION************" + ConsoleColors.RESET);
                                                System.out.println(ConsoleColors.BLUE_BRIGHT + "(1)Buy a new Railway Station\n(2)Buy a new Train\n(3)Hiring Locomotive driver\n(4)Show All Trains\n(5)Back" + ConsoleColors.RESET);
                                                switch (sc.nextInt()) {
                                                    case 1:
                                                        //Buy a new Railway Station
                                                        if (!(City.isConstructedTerminal("RailwayStation"))) {
                                                            System.out.println("Your Terminal Name is : "+City.getCityName() + " RailwayStation Terminal");
                                                            System.out.println("Please Enter The Area of This Terminal: ");
                                                            int Area= sc.nextInt();
                                                            System.out.println("Please Enter The Number Of Input Rails : ");
                                                            int NumberOfInputRails=sc.nextInt();
                                                            System.out.println("Please Enter The Number Of Output Rails : ");
                                                            int NumberOfOutputRails=sc.nextInt();
                                                            int Cost=Area+((NumberOfInputRails+NumberOfOutputRails) * 10);
                                                            RailwayStation railwaystation = new RailwayStation(Cost, City.getCityName(), City.getCityName() + " RailwayStation Terminal", "Iran_" + City.getCityName(), Area, 0, NumberOfInputRails, NumberOfOutputRails);
                                                            RailwayStation.showRailwayStation(railwaystation);
                                                            System.out.println("Do You Want To Buy? Yes/No ");
                                                            String answer = sc.next();
                                                            if (answer.startsWith("Y") || answer.startsWith("y")) {
                                                                if (City.payMoney(railwaystation.getCost_Construction())) {
                                                                    City.AddTerminal(railwaystation);
                                                                }
                                                            } else break;
                                                        } else System.out.println("You Bought a RailwayStation!!!");
                                                        break;
                                                    case 2:
                                                        //Buy a new Train
                                                        if (City.isConstructedTerminal("RailwayStation")) {
                                                            Train.ShowTrains();
                                                            System.out.println("\nWhich Train do you want to buy?(Please enter Train ID)");
                                                            int TrainID = sc.nextInt();
                                                            if (City.payMoney(Train.getTrains().get(TrainID).getPrice())) {
                                                                ((RailwayStation) City.ReturnTerminal("RailwayStation")).AddTrains(Train.getTrains().get(TrainID));
                                                                Train.getTrains().remove(TrainID);

                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY RAILWAYSTATIONS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 3:
                                                        //Hiring Locomotive driver
                                                        if (City.isConstructedTerminal("RailwayStation")) {
                                                            try {
                                                                City.Show_NotHiredPeople_By_Job(4);
                                                                System.out.println("\nWhich LocomotiveDriver do you want to hire?(Please enter LocomotiveDriver ID)");
                                                                int LocomotiveDriverID = sc.nextInt();
                                                                if (City.payMoney(City.getPerson().get(LocomotiveDriverID).getEmployment_salary())) {
                                                                    ((RailwayStation) City.ReturnTerminal("RailwayStation")).Add_Leaders(City.getPerson().get(LocomotiveDriverID));
                                                                    City.getPerson().get(LocomotiveDriverID).setEmployment_situation(true);
                                                                    System.out.println("LOCOMOTIVE DRIVER HIRING WAS SUCCESSFUL!");
                                                                }
                                                            }catch (ThereWasNoDriver thereWasNoDriver){
                                                                System.out.println(thereWasNoDriver.getMessage());
                                                                Toolkit.getDefaultToolkit().beep();
                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY RAILWAYSTATIONS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 4:
                                                        //Show All Trains
                                                        if (City.isConstructedTerminal("RailwayStation")) {
                                                            RailwayStation railwayStation = (RailwayStation) City.ReturnTerminal("RailwayStation");
                                                            railwayStation.ShowTrains();
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY RAILWAYSTATIONS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 5:
                                                        situation6 = false;
                                                        break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            //BusTerminal
                                            boolean situation7 = true;
                                            while (situation7){
                                            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n**************BUS TERMINAL*************" + ConsoleColors.RESET);
                                            System.out.println(ConsoleColors.BLUE_BRIGHT + "(1)Buy a new Bus Terminals\n(2)Buy a new Bus\n(3)Hiring BusDriver\n(4)Show All Buss\n(5)Back" + ConsoleColors.RESET);
                                            int adad4 = sc.nextInt();
                                            switch (adad4) {
                                                case 1:
                                                    //Buy a new Bus Terminals
                                                    if (!(City.isConstructedTerminal("BusTerminal"))) {
                                                        System.out.println("Your Terminal Name is : "+City.getCityName() + " BusTerminal Terminal");
                                                        System.out.println("Please Enter The Area of This Terminal: ");
                                                        int Area= sc.nextInt();
                                                        int Cost=Area;
                                                        BusTerminal busTerminal = new BusTerminal(Cost, City.getCityName(), City.getCityName() + " BusTerminal Terminal", "Iran_" + City.getCityName(), Area, 0);
                                                        BusTerminal.showBusTerminals(busTerminal);
                                                        System.out.println("\nDo You Want To Buy? Yes/No ");
                                                        String answer = sc.next();
                                                        if (answer.startsWith("Y") || answer.startsWith("y")) {
                                                            if (City.payMoney(busTerminal.getCost_Construction())) {
                                                                City.AddTerminal(busTerminal);
                                                            }
                                                        } else break;
                                                    } else System.out.println("You Bought a BusTerminal!!!");
                                                    break;
                                                case 2:
                                                    //Buy a new Bus
                                                    if (City.isConstructedTerminal("BusTerminal")) {
                                                        Bus.ShowBuses();
                                                        System.out.println("\nWhich Bus do you want to buy?(Please enter Bus ID)");
                                                        int BusID = sc.nextInt();
                                                        if (City.payMoney(Bus.getBuses().get(BusID).getPrice())) {
                                                            ((BusTerminal) City.ReturnTerminal("BusTerminal")).AddBus(Bus.getBuses().get(BusID));

                                                        }
                                                    } else {
                                                        System.out.println("ERROR! YOU DON'T HAVE ANY BusTerminal UNTIL NOW");
                                                        Toolkit.getDefaultToolkit().beep();
                                                    }
                                                    break;
                                                case 3:
                                                    //Hiring BusDriver
                                                    if (City.isConstructedTerminal("BusTerminal")) {
                                                        try {
                                                            City.Show_NotHiredPeople_By_Job(3);
                                                            System.out.println("\nWhich BusDriver do you want to hire?(Please enter BusDriver ID)");
                                                            int BusDriverID = sc.nextInt();
                                                            if (City.payMoney(City.getPerson().get(BusDriverID).getEmployment_salary())) {
                                                                ((BusTerminal) City.ReturnTerminal("BusTerminal")).Add_Leaders(City.getPerson().get(BusDriverID));
                                                                City.getPerson().get(BusDriverID).setEmployment_situation(true);
                                                                System.out.println("Bus DRIVER HIRING WAS SUCCESSFUL!");
                                                            }
                                                        }catch (ThereWasNoDriver thereWasNoDriver){
                                                            System.out.println(thereWasNoDriver.getMessage());
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                    } else {
                                                        System.out.println("ERROR! YOU DON'T HAVE ANY BUSTERMINALS UNTIL NOW");
                                                        Toolkit.getDefaultToolkit().beep();
                                                    }
                                                    break;
                                                case 4:
                                                    //Show All Buss
                                                    if (City.isConstructedTerminal("BusTerminal")) {
                                                        BusTerminal busTerminal = (BusTerminal) City.ReturnTerminal("BusTerminal");
                                                        busTerminal.ShowBuses();
                                                    } else {
                                                        System.out.println("ERROR! YOU DON'T HAVE ANY BUSTERMINALS UNTIL NOW");
                                                        Toolkit.getDefaultToolkit().beep();
                                                    }
                                                    break;
                                                case 5:
                                                    situation7=false;
                                                    break;
                                            }
                                        }
                                            break;
                                        case 4:
                                            //ShippingPort
                                            boolean situation8=true;
                                            while (situation8) {
                                                System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n************SHIPPING PORT************" + ConsoleColors.RESET);
                                                System.out.println(ConsoleColors.BLUE_BRIGHT + "(1)Buy a new Shipping Ports\n(2)Buy a new Ship\n(3)Buy a new Boat\n(4)Hiring Malwan\n(5)Show All Ships\n(6)Show All Boats\n(7)Back" + ConsoleColors.RESET);
                                                int adad5 = sc.nextInt();
                                                switch (adad5) {
                                                    case 1:
                                                        //Buy a new Shipping Ports
                                                        if (!(City.isConstructedTerminal("ShippingPort"))) {
                                                            System.out.println("Your Terminal Name is : "+City.getCityName() + " ShippingPort Terminal");
                                                            System.out.println("Please Enter The Area of This Terminal: ");
                                                            int Area= sc.nextInt();
                                                            System.out.println("Please Enter The Number Of Docks Of This Terminal : ");
                                                            int NumberOfDocks=sc.nextInt();
                                                            int Cost=Area+(NumberOfDocks*10);
                                                            ShippingPort shippingPort = new ShippingPort(Cost, City.getCityName(), City.getCityName() + " ShippingPort Terminal", "Iran_" + City.getCityName(), Area, 0, NumberOfDocks);
                                                            ShippingPort.showShippingPort(shippingPort);
                                                            System.out.println("Do You Want To Buy? Yes/No ");
                                                            String answer = sc.next();
                                                            if (answer.startsWith("Y") || answer.startsWith("y")) {
                                                                if (City.payMoney(shippingPort.getCost_Construction())) {
                                                                    City.AddTerminal(shippingPort);
                                                                }
                                                            } else break;
                                                        } else System.out.println("You Bought a ShippingPort!!!");
                                                        break;
                                                    case 2:
                                                        //Buy a new Ship
                                                        if (City.isConstructedTerminal("ShippingPort")) {
                                                            Ship.ShowShips();
                                                            System.out.println("\nWhich Ship do you want to buy?(Please enter Ship ID)");
                                                            int ShipID = sc.nextInt();
                                                            if (City.payMoney(Ship.getShips().get(ShipID).getPrice())) {
                                                                ((ShippingPort) City.ReturnTerminal("ShippingPort")).AddShip(Ship.getShips().get(ShipID));
                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY ShippingPort UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 3:
                                                        //Buy a new Boat
                                                        if (City.isConstructedTerminal("ShippingPort")) {
                                                            Boat.ShowBoats();
                                                            System.out.println("\nWhich Boat do you want to buy?(Please enter Boat ID)");
                                                            int BoatID = sc.nextInt();
                                                            if (City.payMoney(Boat.getBoats().get(BoatID).getPrice())) {
                                                                ((ShippingPort) City.ReturnTerminal("ShippingPort")).AddBoat(Boat.getBoats().get(BoatID));
                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY ShippingPort UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 4:
                                                        //Hiring Malwan
                                                        if (City.isConstructedTerminal("ShippingPort")) {
                                                            try {
                                                                City.Show_NotHiredPeople_By_Job(1);
                                                                System.out.println("\nWhich Malwan do you want to hire?(Please enter Malwan ID)");
                                                                int MalwanID = sc.nextInt();
                                                                if (City.payMoney(City.getPerson().get(MalwanID).getEmployment_salary())) {
                                                                    ((ShippingPort) City.ReturnTerminal("ShippingPort")).Add_Leaders(City.getPerson().get(MalwanID));
                                                                    City.getPerson().get(MalwanID).setEmployment_situation(true);
                                                                    System.out.println("MALWAN HIRING WAS SUCCESSFUL!");
                                                                }
                                                            }catch (ThereWasNoDriver thereWasNoDriver){
                                                                System.out.println(thereWasNoDriver.getMessage());
                                                                Toolkit.getDefaultToolkit().beep();
                                                            }
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY SHIPPINGPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 5:
                                                        //Show All Ships
                                                        if (City.isConstructedTerminal("ShippingPort")) {
                                                            ShippingPort shippingPort = (ShippingPort) City.ReturnTerminal("ShippingPort");
                                                            shippingPort.ShowShips();
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY SHIPPINGPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 6:
                                                        //Show All Boats
                                                        if (City.isConstructedTerminal("ShippingPort")) {
                                                            ShippingPort shippingPort = (ShippingPort) City.ReturnTerminal("ShippingPort");
                                                            shippingPort.ShowBoats();
                                                        } else {
                                                            System.out.println("ERROR! YOU DON'T HAVE ANY SHIPPINGPORTS UNTIL NOW");
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                        break;
                                                    case 7:
                                                        situation8=false;
                                                        break;
                                                }
                                            }
                                            break;
                                        case 5:
                                            situation1=false;
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    //Hotels
                                    boolean situation2=true;
                                    while (situation2) {
                                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n****************HOTEL****************" + ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.PURPLE_BRIGHT +"(1)Buy a new Hotel\n(2)Add Hotel Rooms\n(3)Hiring Crews\n(4)Show Hotels\n(5)Back\n" + ConsoleColors.RESET);
                                        int adad3 = sc.nextInt();
                                        switch (adad3) {
                                            case 1:
                                                //Buy a new Hotel
                                                Hotel hotel = null;
                                                System.out.println("Please Enter Your Hotel Name: ");
                                                sc.nextLine();
                                                String hotelName = sc.nextLine();
                                                ArrayList<Service> services = new ArrayList<>();
                                                System.out.println("****************SERVICES****************");
                                                services.add(Service.RESTAURANT);
                                                services.add(Service.RESTROOM);
                                                services.add(Service.COFFEE_SHOP);
                                                services.add(Service.TV);
                                                services.add(Service.CINEMA);
                                                services.add(Service.GYM);
                                                services.add(Service.SWIMMINGPOOL);
                                                for (int i = 0; i < services.size(); i++) {
                                                    System.out.format("(ID:%d) , %s\n", i, services.get(i));
                                                }
                                                System.out.println("How many Services do you want to add? (1-5)");
                                                int teded = sc.nextInt();
                                                if (teded == 1) {
                                                    System.out.println("Please Select 1 Service to add to the Hotel");
                                                    hotel = new Hotel(hotelName, 200, "Iran_" + City.getCityName(), 1, 0, services.get(sc.nextInt()));

                                                } else if (teded == 2) {
                                                    System.out.println("Please Select 2 Services to add to the Hotel");
                                                    hotel = new Hotel(hotelName, 300, "Iran_" + City.getCityName(), 2, 0, services.get(sc.nextInt()), services.get(sc.nextInt()));

                                                } else if (teded == 3) {
                                                    System.out.println("Please Select 3 Services to add to the Hotel");
                                                    hotel = new Hotel(hotelName, 400, "Iran_" + City.getCityName(), 3, 0, services.get(sc.nextInt()), services.get(sc.nextInt()), services.get(sc.nextInt()));

                                                } else if (teded == 4) {
                                                    System.out.println("Please Select 4 Services to add to the Hotel");
                                                    hotel = new Hotel(hotelName, 500, "Iran_" + City.getCityName(), 4, 0, services.get(sc.nextInt()), services.get(sc.nextInt()), services.get(sc.nextInt()), services.get(sc.nextInt()));

                                                } else if (teded == 5) {
                                                    System.out.println("Please Select 5 Services to add to the Hotel");
                                                    hotel = new Hotel(hotelName, 600, "Iran_" + City.getCityName(), 5, 0, services.get(sc.nextInt()), services.get(sc.nextInt()), services.get(sc.nextInt()), services.get(sc.nextInt()), services.get(sc.nextInt()));
                                                }
                                                Hotel.ShowHotel(hotel);
                                                System.out.println("Do You Want To Buy? Yes/No ");
                                                String answer = sc.next();
                                                if (answer.startsWith("Y") || answer.startsWith("y")) {
                                                    if (City.payMoney(hotel.getCost_Construction())) {
                                                        City.AddHotel(hotel);
                                                        hotel.setConstructed(true);
                                                    }
                                                } else break;
                                                break;
                                            case 2:
                                                //Add Hotel Rooms
                                                Room room = null;
                                                City.showHotels();
                                                System.out.println("Which hotel do ypu want to add room ? (Please enter Hotel ID that you want)");
                                                int hotelID = sc.nextInt();
                                                System.out.println("Please enter the Area of the room :");
                                                int roomArea = sc.nextInt();
                                                System.out.println("Please enter Number of room bed : (1-5)");
                                                int BedNum = sc.nextInt();
                                                if (BedNum == 1) {
                                                    room = new Room(50, 0, 1, roomArea, 10);
                                                } else if (BedNum == 2) {
                                                    room = new Room(60, 0, 2, roomArea, 20);
                                                } else if (BedNum == 3) {
                                                    room = new Room(70, 0, 3, roomArea, 30);
                                                } else if (BedNum == 4) {
                                                    room = new Room(80, 0, 4, roomArea, 50);
                                                } else if (BedNum == 5) {
                                                    room = new Room(90, 0, 5, roomArea, 60);
                                                }
                                                Room.showRoom(room);
                                                System.out.println("Do You Want To Buy? Yes/No ");
                                                String Answer = sc.next();
                                                if (Answer.startsWith("Y") || Answer.startsWith("y")) {
                                                    if (City.payMoney(room.getCost_Construction())) {
                                                        City.getHotels().get(hotelID).AddRoom(room);
                                                    }
                                                } else break;
                                                break;
                                            case 3:
                                                //Hiring Crews
                                                if (City.getHotels().size() != 0) {
                                                    try {
                                                        City.showHotels();
                                                        System.out.println("\n\nPlease Select a Hotel (Please enter Hotel ID that you want)");
                                                        int HotelID = sc.nextInt();
                                                        City.Show_NotHiredPeople_By_Job(5);
                                                        System.out.println("\nWhich Crew do you want to hire?(Please enter Crew ID)");
                                                        int CrewID = sc.nextInt();
                                                        if (City.payMoney(City.getPerson().get(CrewID).getEmployment_salary())) {
                                                            City.getHotels().get(HotelID).AddCrew(City.getPerson().get(CrewID));
                                                            City.getPerson().get(CrewID).setEmployment_situation(true);
                                                            System.out.println("CREW HIRING WAS SUCCESSFUL!");
                                                        }
                                                    }catch (ThereWasNoDriver thereWasNoDriver){
                                                        System.out.println(thereWasNoDriver.getMessage());
                                                    }
                                                } else {
                                                    System.out.println("ERROR! YOU DON'T HAVE ANY HOTELS UNTIL NOW");
                                                    Toolkit.getDefaultToolkit().beep();
                                                }
                                                break;
                                            case 4:
                                                //Show Hotels
                                                City.showHotels();
                                                break;
                                            case 5:
                                                situation2 = false;
                                                break;
                                        }
                                    }
                                    break;
                                case 3:
                                    //People
                                    boolean situation3=true;
                                    while (situation3) {
                                        City.Show_Money_and_Population();
                                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n***************PEOPLE****************" + ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.PURPLE_BRIGHT + "(1)Show All People\n(2)Show People By Job\n(3)Back\n" + ConsoleColors.RESET);
                                        switch (sc.nextInt()) {
                                            case 1:
                                                City.ShowPeople();
                                                break;
                                            case 2:
                                                Job[] jobs = Job.values();
                                                for (int i = 0; i < jobs.length; i++) {
                                                    System.out.format("(%d)%s\n", i + 1, jobs[i]);
                                                }
                                                System.out.println("Please select number of a job to show ");
                                                City.Show_People_By_Job(sc.nextInt());
                                                break;
                                            case 3:
                                                situation3=false;
                                                break;
                                        }
                                    }
                                    break;

                                case 4: //Travels
                                    boolean situation4=true;
                                    while (situation4) {
                                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n****************TRAVEL****************" + ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.PURPLE_BRIGHT +"(1)Create a New Travel\n(2)Show The History Of Travels\n(3)Back"+ ConsoleColors.RESET);
                                        switch (sc.nextInt()) {
                                            case 1://Create a New Travel
                                                try {
                                                    Country.ShowCitiesWithoutBeginningCity(City);
                                                    System.out.format("\nBeginning City : %s \n", City.getCityName());
                                                    System.out.println("Please Select Destination City : (Enter City ID)");
                                                    City DestinationCity = Country.getCities().get(sc.nextInt());
                                                    try {
                                                        City.ShowTerminals();
                                                        System.out.println("Please Select a Terminal in Beginning City (" + City.getCityName() + ")");
                                                        int BeginningTerminalID = sc.nextInt();
                                                        Terminal BeginningTerminal = City.getTerminals().get(BeginningTerminalID);
                                                        try {
                                                            DestinationCity.ShowTerminals();
                                                            Vehicle vehicle = null;
                                                            System.out.println("Please Select a Terminal in Destination City (" + DestinationCity.getCityName() + ")");
                                                            Terminal DestinationTerminal = DestinationCity.getTerminals().get(sc.nextInt());
                                                            try {
                                                                if (BeginningTerminal.getClass().getName().equals(DestinationTerminal.getClass().getName())) {
                                                                    try {
                                                                        City.ShowVehicles(BeginningTerminalID);
                                                                        System.out.println("Please Enter Vehicle ID:");
                                                                        int VehicleID = sc.nextInt();
                                                                        if (BeginningTerminal.getClass().getName().contains("Airport")) {
                                                                            Airport airport = (Airport) BeginningTerminal;
                                                                            vehicle = airport.getAir_vehicles().get(VehicleID);
                                                                        } else if (BeginningTerminal.getClass().getName().contains("RailwayStation")) {
                                                                            RailwayStation railwayStation = (RailwayStation) BeginningTerminal;
                                                                            vehicle = railwayStation.getTrains().get(VehicleID);
                                                                        } else if (BeginningTerminal.getClass().getName().contains("BusTerminal")) {
                                                                            BusTerminal busTerminal = (BusTerminal) BeginningTerminal;
                                                                            vehicle = busTerminal.getBuses().get(VehicleID);
                                                                        } else if (BeginningTerminal.getClass().getName().contains("ShippingPort")) {
                                                                            ShippingPort shippingPort = (ShippingPort) BeginningTerminal;
                                                                            vehicle = shippingPort.getSea_vehicles().get(VehicleID);
                                                                        }
                                                                        try {
                                                                            if (BeginningTerminal.getLeaders().size() != 0) {
                                                                                for (int x = 0; x < BeginningTerminal.getLeaders().size(); x++) {
                                                                                    System.out.format("(ID:%d) Name: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n", x, BeginningTerminal.getLeaders().get(x).getName(), BeginningTerminal.getLeaders().get(x).getFamily(), BeginningTerminal.getLeaders().get(x).getYear_of_Birth(), BeginningTerminal.getLeaders().get(x).getPlace_of_Birth(), BeginningTerminal.getLeaders().get(x).getJob().name(), BeginningTerminal.getLeaders().get(x).getGender(), BeginningTerminal.getLeaders().get(x).getEmployment_salary(), BeginningTerminal.getLeaders().get(x).isEmployment_situation());
                                                                                }
                                                                                System.out.println("Please Select a Driver (Via Driver ID)");
                                                                                int DriverID = sc.nextInt();
                                                                                Person Driver = BeginningTerminal.getLeaders().get(DriverID);
                                                                                City.showPeopleNotHired();
                                                                                assert vehicle != null;
                                                                                System.out.println("Your Vehicle Capacity is : " + (vehicle.getCapacity() - 1));
                                                                                System.out.println("How many person that they want to travel ? ");
                                                                                int number_of_passengers = sc.nextInt();
                                                                                ArrayList<Person> passengers = new ArrayList<>();
                                                                                passengers.add(Driver);
                                                                                try {
                                                                                    if (number_of_passengers > (vehicle.getCapacity() - 1) || number_of_passengers < (vehicle.getCapacity() - 1) / 2) {
                                                                                        if (number_of_passengers > (vehicle.getCapacity() - 1))
                                                                                            throw new FullCapacity("ERROR:Full Capacity!");
                                                                                        else
                                                                                            throw new InvalidPassengers("ERROR:The Number Of Passengers Is Less Than Half the capacity of the car!");
                                                                                    } else {
                                                                                        System.out.println("Please Select People that they want to Travel : (Via Person ID)");
                                                                                        for (int i = 0; i < number_of_passengers; i++) {
                                                                                            passengers.add(City.getPerson().get(sc.nextInt()));
                                                                                        }
                                                                                        double travelCost = BeginningTerminal.CalculateTravelCost(passengers, vehicle);
                                                                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                                                                        LocalDateTime now = LocalDateTime.now();
                                                                                        String Date = dtf.format(now);
                                                                                        System.out.println("Date : "+Date);
                                                                                        System.out.println("Please Enter a ID for this Travel:");
                                                                                        int id=sc.nextInt();
                                                                                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Travel Cost : " + travelCost + "$"+ConsoleColors.RESET);
                                                                                        BeginningTerminal.Travel(City, DestinationCity, BeginningTerminal, DestinationTerminal, passengers, Driver, vehicle, id, Date, travelCost);
                                                                                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Travel Was Successful!"+ConsoleColors.RESET);
                                                                                    }
                                                                                } catch (FullCapacity | InvalidPassengers x) {
                                                                                    System.out.println(x.getMessage());
                                                                                    Toolkit.getDefaultToolkit().beep();
                                                                                }
                                                                            } else
                                                                                throw new ThereWasNoDriver("ERROR:There Was No Driver In This Terminal!");
                                                                        } catch (ThereWasNoDriver thereWasNoDriver) {
                                                                            System.out.println(thereWasNoDriver.getMessage());
                                                                            Toolkit.getDefaultToolkit().beep();
                                                                        }
                                                                    } catch (ThereWasNoCar thereWasNoCar) {
                                                                        System.out.println(thereWasNoCar.getMessage());
                                                                        Toolkit.getDefaultToolkit().beep();
                                                                    }

                                                                } else
                                                                    throw new WrongTerminal("ERROR:You Select Wrong Terminal In Destination Terminal!");
                                                            } catch (InvalidTravel invalidTravel) {
                                                                System.out.println(invalidTravel.getMessage());
                                                                Toolkit.getDefaultToolkit().beep();
                                                            }

                                                        } catch (ThereWasNoTerminal thereWasNoTerminal) {
                                                            System.out.println(thereWasNoTerminal.getMessage());
                                                            Toolkit.getDefaultToolkit().beep();
                                                        }
                                                    } catch (ThereWasNoTerminal thereWasNoTerminal) {
                                                        System.out.println(thereWasNoTerminal.getMessage());
                                                        Toolkit.getDefaultToolkit().beep();
                                                    }

                                                } catch (ThereWasNoDestinationCity thereWasNoDestinationCity) {
                                                    System.out.println(thereWasNoDestinationCity.getMessage());
                                                    Toolkit.getDefaultToolkit().beep();
                                                }
                                                break;
                                            case 2://Show The History Of Travels
                                                City.ShowTerminals();
                                                System.out.println("Which Terminal do you want to the see History of Travels ? (Select via Terminal ID)");
                                                int TerminalID = sc.nextInt();
                                                Terminal terminal = City.terminals.get(TerminalID);
                                                terminal.TravelHistory();
                                                break;
                                            case 3://Back
                                                situation4=false;
                                                break;
                                        }
                                    }
                                    break;
                                case 5://Bank
                                    boolean situation5=true;
                                    while (situation5){
                                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "\n****************BANK****************" + ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.PURPLE_BRIGHT +"(1)Add A New Bank\n(2)Enter To A Bank\n(3)Back"+ ConsoleColors.RESET);
                                        switch (sc.nextInt()){
                                            case 1://Add Bank
                                                System.out.println("Please Enter Bank Name:" );
                                                sc.nextLine();
                                                String bankName=sc.nextLine();
                                                Bank bank=new Bank(bankName);
                                                City.AddBank(bank);
                                                break;
                                            case 2://Enter To A Bank
                                                if(City.getBanks().size()!=0){
                                                    City.ShowBanks();
                                                    System.out.println("\nWhich Bank do you want to enter ? (Select via Bank ID)");
                                                    int bankID=sc.nextInt();
                                                    Bank selectedbank=City.ReturnBank(bankID);
                                                    boolean situation6=true;
                                                    while (situation6){
                                                        System.out.format(ConsoleColors.CYAN_BOLD_BRIGHT + "\n**************%S*************\n",selectedbank.getBankName() + ConsoleColors.RESET);
                                                        System.out.println(ConsoleColors.BLUE_BRIGHT + "(1)Create Bank Account\n(2)Enter To A Bank Account\n(3)Bank Info\n(4)Back" + ConsoleColors.RESET);
                                                        switch (sc.nextInt()){
                                                            case 1://Create Bank Account
                                                                City.ShowPeople();
                                                                System.out.println("\nWhich Person Wants To Create a Bank Account (Select Via person ID)");
                                                                Person person=City.getPerson().get(sc.nextInt());
                                                                boolean found=false;
                                                                for (int i=0;i<selectedbank.getBankAccounts().size();i++){
                                                                    if(selectedbank.getBankAccounts().get(i).getTheAccountHolder()==person){
                                                                        found=true;
                                                                    }
                                                                }
                                                                if(!found){
                                                                    String cityName=City.getCityName();
                                                                    SwingUtilities.invokeLater(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            SignUpPage signUpPage = new SignUpPage(person, selectedbank,cityName);
                                                                            signUpPage.setVisible(true);
                                                                        }
                                                                    });
                                                                }else{
                                                                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"ERROR : THIS PERSON ALREADY HAVE AN ACCOUNT IN THIS BANK!"+ConsoleColors.RESET);
                                                                    Toolkit.getDefaultToolkit().beep();
                                                                }
                                                                break;
                                                            case 2://Enter To A Bank Account
                                                                if (selectedbank.getBankAccounts().size()!=0){
                                                                            LoginPage loginPage=new LoginPage(selectedbank);
                                                                            loginPage.setVisible(true);
                                                                            while (loginPage.isShowing()){}
                                                                            String username1=loginPage.username;
                                                                            String password1=loginPage.password;
                                                                            BankAccount bankAccount1=selectedbank.validateBankAccount(username1,password1);
                                                                    if (bankAccount1!=null){
                                                                        Thread thread=new Thread(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                BankAccountGraphic bankAccountGraphic=new BankAccountGraphic(bankAccount1,selectedbank);
                                                                                bankAccountGraphic.setVisible(true);
                                                                                bankAccountGraphic.updateMoneyAndTime();
                                                                            }
                                                                        });thread.start();
                                                                    }
                                                                }else {
                                                                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"ERROR! THERE IS NOT ANY BANK ACCOUNT IN THIS BANK"+ConsoleColors.RESET);
                                                                    Toolkit.getDefaultToolkit().beep();
                                                                }
                                                                break;
                                                            case 3://Bank Info
                                                                System.out.println(selectedbank.bankInfo());
                                                                break;
                                                            case 4:
                                                                situation6=false;
                                                                break;
                                                        }
                                                    }
                                                }else {
                                                    System.out.println("ERROR! THERE IS NOT ANY BANK IN THIS CITY");
                                                    Toolkit.getDefaultToolkit().beep();
                                                }
                                                break;
                                            case 3://Back
                                                situation5=false;
                                                break;
                                        }
                                    }
                                    break;
                                case 6://Back to the main menu
                                    situation=false;
                                    break;
                            }
                        }
                break;
                case 3://Financial Management
                    String country_Name=countryName;
                            Thread thread=new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    FinancialManagement financialManagement=new FinancialManagement(country_Name);
                                    BankAccount.isEntered=true;
                                    financialManagement.setVisible(true);
                                    financialManagement.updateMoney();
                                }
                            });thread.start();
                    break;
                case 4://Show Cities
                    Country.showCities();
                    break;
                case 5://Exit
                    Answer[] answer = Answer.values();
                    int answer2 = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, answer, null);
                    if (answer2 == 0){
                        ClearInfo();
                        for (int i=0;i<Country.getCities().size();i++){
                            saveCitiesInfo(Country.getCities().get(i));
                        }
                        saveCountryInfo(countryName);

                        System.exit(0);
                    }
                    else
                        break;
                    break;
            }
        }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    public static void saveCitiesInfo(City city){
        String fileName=String.format("%s.txt",city.getCityName().toLowerCase());
        FileOutputStream cities ;
        ObjectOutputStream objectOutputStream;
        try {
                cities=new FileOutputStream(fileName);
                objectOutputStream=new ObjectOutputStream(cities);
                objectOutputStream.writeObject(city);
                objectOutputStream.close();
                cities.close();

            FileWriter citiesInfo=new FileWriter("cities.txt",true);
            citiesInfo.write(String.format("%s,",city.getCityName().toLowerCase()));
            citiesInfo.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void saveCountryInfo(String countryName){
        try {
            FileWriter countryInfo=new FileWriter("country.txt") ;
            countryInfo.write(String.format("%s,%f,%d,%f",countryName,Country.TotalBudget,Country.TotalPopulation,Country.Total_money_of_all_accounts));
            countryInfo.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static void readCitiesFromFile(){
        try {
            FileReader citiesInfo=new FileReader("cities.txt");
            BufferedReader bufferedReader=new BufferedReader(citiesInfo);
            String []names=bufferedReader.readLine().split(",");
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            for (int i=0;i<names.length;i++){
                String fileName=String.format("%s.txt",names[i]);
                fileInputStream=new FileInputStream(fileName);
                objectInputStream=new ObjectInputStream(fileInputStream);
                Country.AddCitiesFromFile((City) (objectInputStream.readObject()));
                objectInputStream.close();
                fileInputStream.close();
            }
            bufferedReader.close();
            citiesInfo.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static String readCountryFromFile(){
        String countryName = null;
        try {
                FileReader countryInfo=new FileReader("country.txt");
                BufferedReader bufferedReader=new BufferedReader(countryInfo);
                String []info=bufferedReader.readLine().split(",");
                countryName=info[0];
                Country.TotalBudget=Double.parseDouble(info[1]);
                Country.TotalPopulation=Integer.parseInt(info[2]);
                Country.Total_money_of_all_accounts=Double.parseDouble(info[3]);
                bufferedReader.close();
                countryInfo.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return countryName;
    }
    public static void ClearInfo(){
        try {
            FileWriter cities=new FileWriter("cities.txt",false);
            cities.write("");
            cities.close();
            FileWriter country=new FileWriter("country.txt",false);
            country.write("");
            country.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
enum Answer{
    Exit,Cancel
}
enum Answer1{
    Male,Female;
}
class myObjectOutPut extends ObjectOutputStream{
    public myObjectOutPut() throws IOException {
        super();
    }
    public myObjectOutPut(OutputStream out) throws IOException {
        super(out);
    }
    public void writeStreamHeader(){
    }
}

