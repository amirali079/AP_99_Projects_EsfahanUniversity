package Main;

import Main.Bank.Bank;
import Main.Bank.BankAccount;
import Main.Bank.Transaction;
import Main.Bank.TransactionType;
import Main.Building.*;
import Main.Exception.*;
import Main.Graphics.CountryMenu;
import Main.Graphics.NewGameJDialog;
import Main.Vehicles.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static City selectedCity;


    public static void main(String[] args) {

        NewGameJDialog t = new NewGameJDialog();
        t.setVisible(true);

//        Test t = new Test();


//        System.out.print("New Game ? ");
//        String str = new Scanner(System.in).nextLine();
//
//        if (str.equals("yes")){
//            SavingGame.clearAllFiles();
//            System.out.println("Starting new game");
//        }

        System.out.println("Exiting NewGameJDialog");

        //-------------------------------------------

        try {
            SavingGame.restoreGame();

        }
        catch (IOException | ClassNotFoundException  ex){
            ex.printStackTrace();
        }

        //-------------------------------------------


        Thread save = new Thread(new SavingGame() , "save" );
        save.start();

        new CountryMenu();

        System.out.println("Exiting CountryMenu");

        while (true) {
            try {
                citiesMenu();
            } catch (RuntimeException ex) {
                System.out.println(ex.toString());
            }
        }


    }



    //================================================

    static void  citiesMenu() {
        System.out.println("\n\n\t\t\t\t\t=== Cities Menu  === \n");
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===============================================");
        System.out.println("\n 1-Build New City \n 2-Enter To A City  \n 3-Show Cities Information \n 4-Show Country info \n 5- Modirat mali");
        System.out.println("\n===============================================");
        System.out.print("\nEnter your choice : ");


        try {
            int choice = sc.nextInt();
            if (choice == 1)
                buildCity();

            else if (choice == 2) {
                selectedCity = selectCity();
                mainMenu();
            } else if (choice == 3)
                showCitiesInformation();

            else if (choice == 4) {
                System.out.println("\n\n\t\t\t\t\t=== Country Info  === \n");
                System.out.println();
                System.out.println("Total Budget : " + Country.totalBudget());
                System.out.println("Total population : " + Country.totalPopulation());
                citiesMenu();
            }

            else if (choice == 5){


//                String listener = sc.nextLine();

//                while(  listener.isEmpty() ) {

                    BankAccount.showLog = true;
//                }

//                if (! listener.isEmpty()){
//                    System.out.println("+++ " + listener);
//                    BankAccount.showLog = false ;
//                    citiesMenu();
//                }


            }

            else
                citiesMenu();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            citiesMenu();
        }

    }

    static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===============================================\n");


        System.out.println("City : " + selectedCity.getCityName());
        System.out.println("Money : " + selectedCity.getBudget());

        System.out.println("\n\n 1-Build Terminal \n 2-Buy Vehicle \n 3-Engage \n 4-Build Hotel" +
                " \n 5-Build Room For Hotels \n 6-Make new journey \n 7-Show Status \n 8-Show Cities Menu \n 9-Banks ");
        System.out.println("\n===============================================");
        System.out.print("\nEnter your choice : ");
        int choice = -1;
        try{
            choice =sc.nextInt();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            citiesMenu();
        }

        try {



            if (choice == 1)
                buildTerminal();

            else if (choice == 2)
                buyVehicles();

            else if (choice == 3)
                engage();

            else if (choice == 4)
                buildHotel();

            else if (choice == 5)
                build_Room_In_Hotel();

            else if (choice == 6)
                makeNewJourney();

            else if (choice == 7)
                showStatus();

            else if (choice == 8) {
                citiesMenu();
            }

            else if (choice ==9)
                bankMenu();
            else
                mainMenu();
        }
        catch (RuntimeException ex){
//            System.out.println(ex.toString());
            ex.printStackTrace();
            mainMenu();
        }
    }

    static void showMoney(){
        System.out.println("\n+++ You have " + selectedCity.getBudget() + " $\n");
    }

    //=======================================================================================

    static void makeNewJourney() {
        System.out.println("\n\n\t\t\t\t\t=== Make New Journey  === \n");
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> passengerList = new ArrayList<Person>();

        //get number of passengers
        System.out.print("Enter number of passengers : ");

        int number_of_passengers =0;


        number_of_passengers = sc.nextInt();

        //show id of people in selected city
        int counter =0;
        System.out.println("People IDs in " + selectedCity.getCityName() + " : ");
        for (Person a : selectedCity.getPersonList()) {
            if (counter % 10 ==0)
                System.out.println();

            if ( ! a.getHired() ) {
                System.out.print(a.getID() + " - ");
                counter ++;
            }
        }
        System.out.println();

        // get passengers
        for (int i =0 ; i < number_of_passengers ; i++) {
            System.out.print("Enter ID of passenger" + (i+1) + " : ");
            int id = sc.nextInt();
            passengerList.add( Person.find_Person_from_ID(id));
        }


        checkPassengersValidity(passengerList);


        //====================================================

        //get Terminals information
        sc.nextLine();
        System.out.print("Enter name of starting Terminal : ");
        String starting = sc.nextLine();
        System.out.print("Enter name of destination Terminal : ");
        String destination = sc.nextLine();

//        Terminal startingTerminal = Terminal.getTerminalByName(starting);
//        Terminal destinationTerminal = Terminal.getTerminalByName(destination);


//        checkTerminalsValidity( startingTerminal , destinationTerminal);

        //get vehicle info

        System.out.print("Enter ID of vehicle : ");
        String vehicleID = sc.nextLine();

//        Vehicle vehicle = Vehicle.getVehicleByID(vehicleID);

//        checkVehicleValidity(vehicle , startingTerminal , passengerList.size());


        // get driver

        System.out.print("Enter id of driver : ");
        int id = sc.nextInt();

//        Person driver = Person.find_Person_from_ID(id);
//        checkDriverValidity(driver , vehicle , startingTerminal);


        // get journey info
        sc.nextLine();
        System.out.print("Enter ID of this journey : ");
        String journeyID = sc.nextLine();

        System.out.print("Enter day number of this journey : ");
        int day = sc.nextInt();

        System.out.print("Enter month number of this journey : ");
        int month = sc.nextInt();

//        checkDateValidity(day ,month);

        System.out.print("Enter ticket price : ");
        int price = sc.nextInt();


//        startingTerminal.newJourney(startingTerminal , destinationTerminal , passengerList , driver , vehicle , journeyID ,day , month , price);

        mainMenu();


    }

    static void checkDateValidity( int day , int month){
//        if (day >31 || day < 1)
//            throw new Invalid_date("Invalid day ! ");
//
//        if(month > 12  || month < 1)
//            throw new Invalid_date("Invalid month ! ");
    }

    static void checkPassengersValidity(ArrayList<Person> passengers){
//        for ( Person a : passengers){
//            if ( passengers.indexOf(a) != passengers.lastIndexOf(a) )
//                throw new InvalidPassengers("More than one person with " + a.getID() + " ID in list");
//
//            if ( ! selectedCity.getPersonList().contains(a))
//                throw new InvalidPassengers("Person " + a.getID() + " not in " + selectedCity.getCityName());
//
//            if (a.getHired())
//                throw new InvalidPassengers("Person " + a.getID() + " is working in " + selectedCity.getCityName() + " and can not go to journey");
//        }


    }


    static void checkTerminalsValidity(Terminal starting , Terminal destination){



//        if ( starting == destination )
//            throw  new Same_starting_and_destination_terminal_Exception();
//
//        if ( starting.getTerminalType() != destination.getTerminalType() )
//            throw new Starting_and_destination_terminal_type_Exception();
//
//        if (starting.getVehiclesList().size() == 0)
//            throw new No_Vehicle_In_Terminal_Exception();
//
//        if (destination.getVehiclesList().size() >= destination.max_number_of_vehicle())
//            throw new Terminal_Vehicle_Capacity_Exception();
//
//
//        boolean isExist = false ;
//        for (Terminal a : selectedCity.getTerminalList()){
//
//            if ( a.getTerminalName() == starting.getTerminalName())
//                isExist = true;
//        }
//
//        if ( ! isExist)
//            throw new Invalid_TerminalName( starting.getTerminalName() + " Terminal does not exist in " + selectedCity.getCityName());
//
//
//

    }


    static void checkVehicleValidity(Vehicle selectedVehicle, Terminal startingTerminal , int numberOfPassengers) {




//        if ( selectedVehicle instanceof CargoPlane )
//            throw new Vehicle_type_Exception("Can not use a Cargo airplane for transform passengers");
//
//        if (selectedVehicle.getVehicleType() == "Air_transport_vehicle"  &&  startingTerminal.getTerminalType() != "Airport")
//            throw new Vehicle_type_Exception("You can travel with Airplane between Airports ");
//
//        if (selectedVehicle.getVehicleType() == "Train"  &&  startingTerminal.getTerminalType() != "TrainStation")
//            throw new Vehicle_type_Exception("You can travel with Train between Train Stations");
//
//        if (selectedVehicle.getVehicleType() == "Bus"  &&  startingTerminal.getTerminalType() != "BusTerminal")
//            throw new Vehicle_type_Exception("You can travel with Bus between Bus Terminals ");
//
//        if (selectedVehicle.getVehicleType() == "Shipping_vehicle"  &&  startingTerminal.getTerminalType() != "ShippingPort")
//            throw new Vehicle_type_Exception("You can travel with a Shipping vehicle  between Shipping ports ");
//
//
//        if ( ! startingTerminal.getVehiclesList().contains(selectedVehicle) )
//            throw new Vehicle_does_not_exists_Exception("No vehicle exits with this id in " + startingTerminal.getTerminalType() + " terminal ");
//
//        if ( numberOfPassengers < selectedVehicle.getCapacity()/2D )
//            throw new Enough_passenger_exception("At least half of passenger capacity must be reserved");
//
//        if (numberOfPassengers > selectedVehicle.getCapacity()){
//            throw new Enough_passenger_exception("Number of passengers is more than selected vehicle passenger capacity");
//        }



    }


    static void checkDriverValidity(Person driver , Vehicle vehicle , Terminal starting){

//        if ( ! starting.getDriversList().contains(driver) )
//            throw new InvalidDriver("Driver does not in " + starting.getTerminalName() + " Terminal");

    }


    //========================================================================================

    static void buildCity(){
        System.out.println("\n\n\t\t\t\t\t=== Build City  === \n");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of city : ");
        String name = sc.nextLine();
        System.out.print("Enter the budget amount : ");
        int budget = sc.nextInt();

        City newCity = new City(name , budget);
        System.out.println("-----");
        System.out.println("Done");
        System.out.println("-----");

        citiesMenu();    }

    static City selectCity(){

        System.out.println("\n\n\t\t\t\t\t=== Select A City  === \n");
        Scanner sc = new Scanner(System.in);

        int counter = 1 ;
        System.out.println("   Name : \t\t   Budget: ");
        for ( City a : City.getCitiesList()){
            System.out.println(counter + " -\t" + a.getCityName() + "\t\t\t" + a.getBudget() );
            counter ++ ;
        }

        System.out.print("\nEnter number of your Choice : ");
        int choice = sc.nextInt();

        return City.getCitiesList().get( choice - 1);
    }

    static void showCitiesInformation(){
        System.out.println("\n\n\t\t\t\t\t===  Show Cities Information  === \n");
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Show information of all cities \n 2 - Select a city to show its information ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();
        System.out.println();

        if (choice == 1 ){
            for (City a : City.getCitiesList())
                a.showInfo();
        }

        else if ( choice == 2 ){
            City city = selectCity();
            city.showInfo();
        }


        citiesMenu();


    }


    //========================================================================================

    static void showStatus(){
        System.out.println("\n\n\t\t\t\t\t=== Show Status === \n");
        Scanner sc = new Scanner(System.in);

        System.out.println("****** population : \n");
        System.out.println("Your city population : " + selectedCity.getPersonList().size());
        System.out.println("Your city has " + Person.number_of_jobs("pilot" , selectedCity.getPersonList()) + " pilot(s)" );
        System.out.println("Your city has " + Person.number_of_jobs("driver" , selectedCity.getPersonList()) + " driver(s)");
        System.out.println("Your city has " + Person.number_of_jobs("sailor" , selectedCity.getPersonList()) + " sailor(s)");
        System.out.println("Your city has " + Person.number_of_jobs("locomotive driver" , selectedCity.getPersonList()) + " locomotive driver(s)");
        System.out.println("Your city has " + Person.number_of_jobs("flight attendant" , selectedCity.getPersonList()) + " flight attendant(s)");
        System.out.println("Your city has " + Person.number_of_jobs("employee" , selectedCity.getPersonList()) + " employee(s)");
        System.out.println("People list : ");

        int counter =0;
        for (Person a : selectedCity.getPersonList()) {
            if (counter % 10 == 0)
                System.out.println();
            System.out.print(a.getID() + " - ");
            counter ++ ;
        }
        System.out.println();



        System.out.println("\n\n****** Places : \n");
        System.out.println("You have " + selectedCity.getCityAirportList().size() + " Airport(s)");
        System.out.println("You have " + selectedCity.getCityBusTerminalList().size() + " Bus Terminal(s)");
        System.out.println("You have " + selectedCity.getCityHotelList().size() + " Hotel(s)");
        System.out.println("You have " + selectedCity.getCityShippingPortList().size() + " Shipping Port(s)");
        System.out.println("You have " + selectedCity.getCityTrainStationList().size() + " Train Station(s)");

        System.out.println("\n\n****** Vehicles : \n");
        System.out.println("You have " + selectedCity.getBoatsList().size() + " Boat(s)");
        System.out.println("You have " + selectedCity.getBusesList().size() + " Bus(es)");
        System.out.println("You have " + selectedCity.getCargoPlanesList().size() + " Cargo Plane(s)");
        System.out.println("You have " + selectedCity.getPassenger_airplanesList().size() + " Passenger Airplane(s)");
        System.out.println("You have " + selectedCity.getShipsList().size() + " Ship(s)");
        System.out.println("You have " + selectedCity.getTrainsList().size() + " Train(s)");



        //=====================================================================================================================================

        System.out.print("\n\nDo you want to show more information ? (y/n) : ");
        String moreInfo = sc.nextLine();

        if (moreInfo.equals("y")){
            System.out.println("\n\n****** Show More Information ******\n");
            System.out.println(" 1-Airport(s) more info \n 2-Bus Terminal(s) more info \n 3-Hotel(s) more info \n 4-Shipping Port(s) more info \n 5-Train Station(s) more info \n 6-Show Journey history of " + selectedCity.getCityName() + " City");
            System.out.print("\nEnter number of your choice : ");
            int choice = sc.nextInt();
            System.out.println("\n===============================================");

            if (choice == 1)
                airportsInfo();

            if (choice == 2)
                busTerminalsInfo();

            if (choice == 3)
                hotelsInfo();

            if (choice == 4)
                shippingPortsInfo();

            if (choice == 5)
                trainStationsInfo();

            if(choice == 6)
                showJourneyHistory();


        }
        else
            mainMenu();

    }

    static void airportsInfo(){
        System.out.println("\n\n\t\t\t\t\t=== Show More Information About Airplane(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all airports \n 2-Show information of a selected airport : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Airports ++++++\n");

//            for (Airport a : selectedCity.getCityAirportList())
//                a.showInfo();

            System.out.println("\n\n ****** Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Airport name : " );
            for (Airport a : selectedCity.getCityAirportList()){
                System.out.println(counter + "\t\t\t\t" + a.getTerminalName());
                counter++;
            }

            System.out.print("\nEnter number of airport : ");
            int numberAirport = sc.nextInt();
            System.out.println("\n\n");

//            selectedCity.getCityAirportList().get(numberAirport-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void busTerminalsInfo(){
        System.out.println("\n\n\t\t\t\t\t=== Show More Information About Bus Terminal(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all bus terminals \n 2-Show information of a selected bus terminal : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Bus Terminals ++++++\n");

            for (Bus_Terminal a : selectedCity.getCityBusTerminalList())
                a.showInfo();

            System.out.println("\n\n ****** Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Bus terminal name :" );
            for (Bus_Terminal a :selectedCity.getCityBusTerminalList()){
                System.out.println(counter + "\t\t\t\t\t" + a.getTerminalName());
                counter++;
            }

            System.out.print("\nEnter number of bus terminal : ");
            int numberBusTerminal = sc.nextInt();
            System.out.println("\n\n");

            selectedCity.getCityBusTerminalList().get(numberBusTerminal-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void hotelsInfo(){
        System.out.println("\n\n\t\t\t\t\t=== Show More Information About Hotel(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all hotels \n 2-Show information of a selected hotel : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Hotels ++++++\n");

            for (Hotel a : selectedCity.getCityHotelList())
                a.showInfo();

            System.out.println("\n\n ****** Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t     Hotel name : " );
            for (Hotel a : selectedCity.getCityHotelList()){
                System.out.println(counter + "\t\t\t\t" + a.getHotelName());
                counter++;
            }

            System.out.print("\nEnter number of hotel : ");
            int numberHotel = sc.nextInt();
            System.out.println("\n\n");

            selectedCity.getCityHotelList().get(numberHotel-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void shippingPortsInfo(){
        System.out.println("\n\n\t\t\t\t\t=== Show More Information About Shipping Port(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all shipping ports \n 2-Show information of a selected shipping port : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Shipping Ports ++++++\n");

            for (ShippingPort a : selectedCity.getCityShippingPortList())
                a.showInfo();

            System.out.println("\n\n ****** Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Shipping port name : " );
            for (ShippingPort a : selectedCity.getCityShippingPortList()){
                System.out.println(counter + "\t\t\t\t\t" + a.getTerminalName());
                counter++;
            }

            System.out.print("\nEnter number of shipping port : ");
            int numberShippingPort = sc.nextInt();
            System.out.println("\n\n");

            selectedCity.getCityShippingPortList().get(numberShippingPort-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void trainStationsInfo(){
        System.out.println("\n\n\t\t\t\t\t=== Show More Information About Train Station(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all train stations \n 2-Show information of a selected train station : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Train Stations ++++++\n");

            for (TrainStation a : selectedCity.getCityTrainStationList())
                a.showInfo();

            System.out.println("\n\n ****** Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Train station name :" );
            for (TrainStation a : selectedCity.getCityTrainStationList()){
                System.out.println(counter + "\t\t\t\t\t" + a.getTerminalName());
                counter++;
            }

            System.out.print("\nEnter number of train station : ");
            int numberTrainStation = sc.nextInt();
            System.out.println("\n\n");

            selectedCity.getCityTrainStationList().get(numberTrainStation-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void showJourneyHistory(){
        System.out.println("\n\n\t\t\t\t\t=== Show More Information About Train Station(s) ===\n");
        Scanner sc = new Scanner(System.in);

        int counter = 1;

        System.out.println("Terminal List :");
        for(Terminal a : selectedCity.getTerminalList()){
            System.out.println(counter + "- " + a.getTerminalName());
            counter++;
        }

        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        Terminal selectedTerminal = selectedCity.getTerminalList().get(choice-1);

        System.out.println(" 1- Show journeys that " + selectedTerminal.getTerminalName() + " was the starting point");
        System.out.println(" 2- Show journeys that " + selectedTerminal.getTerminalName() + " was the destination point");
        System.out.println(" 3- Show all journeys of " + selectedTerminal.getTerminalName() + " terminal");

        System.out.print("\nEnter number of your choice : ");
        int choice2 = sc.nextInt();

        if (choice2 == 1)
            selectedTerminal.journeyHistory(true , false);

        else if (choice2 ==2 )
            selectedTerminal.journeyHistory(false , true);

        else if (choice2 == 3)
            selectedTerminal.journeyHistory(true , true);


        mainMenu();
    }


    //=======================================================================================

    static void bankMenu(){
        System.out.println("\n\n 1-Add new Bank \n 2-Enter to a bank ");
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        if (choice == 1)
            addBank();
        else if (choice == 2)
            enterToBank();
    }

    static void addBank(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of Bank : ");
        String name = sc.nextLine();

        Bank newBank = new Bank(name);

        selectedCity.addBank(newBank);

    }

    static void enterToBank(){

        Scanner sc = new Scanner(System.in);

        int counter = 1;
        for (Bank b : selectedCity.getBanks()) {
            System.out.println(counter + " - " + b.getName());
            counter ++;
        }


        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        Bank selectedBank = selectedCity.getBanks().get(choice-1);

        System.out.println("\n 1- make new account \n 2- Enter to a account \n 3- Show bank Information ");
        System.out.print("\nEnter number of your choice : ");
        int choice2 = sc.nextInt();

        if (choice2 == 1)
            newAccount(selectedBank);

        else if (choice2 == 2){
            counter =1;
            for (BankAccount a : selectedBank.getAccounts()){
                System.out.println(counter + " - " + a.getUserName());
                counter ++;
            }

            System.out.print("Enter number of your choice : ");
            int choice3 = sc.nextInt();


            BankAccount account = selectedBank.getAccounts().get(choice3-1);

            sc.nextLine();
            System.out.print("Enter password of selected account : ");
            String password = sc.nextLine();

            if (password.equals(account.getPassword()))
                accountMenu(account);

            else
                System.out.println("Password is incorrect ! ");

        }

        else if (choice == 3 ){
            System.out.printf("name : %s  |  total money : %f  | number of active accounts : %d " , selectedBank.getName() , selectedBank.getTotalMoney() , selectedBank.getActiveAccounts());
        }

    }


    static void newAccount(Bank bank){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username : ");
        String username = sc.nextLine();
        System.out.print("Enter password : ");
        String password = sc.nextLine();



        int counter =0;
        for (Person a : selectedCity.getPersonList()) {
            if (counter % 10 == 0)
                System.out.println();
            System.out.print(a.getID() + " - ");
            counter ++ ;
        }

        System.out.print("\n Enter id of owner of this account : ");
        int id = sc.nextInt();

        Person pr = Person.find_Person_from_ID(id);

        System.out.print("Enter starting account balance : ");
        double balance = sc.nextDouble();


        BankAccount account = new BankAccount(balance , pr , username , password , bank ,selectedCity);
        bank.addAccount(account);
    }

    static void accountMenu( BankAccount account ){

        System.out.println("\n 1-Deposit \n 2-Withdrawal \n 3-Show Transactions ");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1 ){
            System.out.print("Enter amount of money : ");
            double amount = sc.nextDouble();

            Transaction transaction = new Transaction(amount , TransactionType.DEPOSIT);
            account.performTransaction(transaction);
        }

        else if (choice == 2 ){
            System.out.print("Enter amount of money : ");
            double amount = sc.nextDouble();

            Transaction transaction = new Transaction(amount , TransactionType.WITHDRAW);
            account.performTransaction(transaction);
        }

        else if (choice == 3){
            for (Transaction a : account.getAccountTransactions())
                a.showInfo();
        }

    }


    //=======================================================================================

    static void buildTerminal(){
        System.out.println("\n\n\t\t\t\t\t====== Build Terminal ======\n\n");
        System.out.println(" 1-Airport \n 2-Bus Terminal \n 3-Shipping port \n 4-Train station ");
        System.out.print("\nEnter your choice : ");
        Scanner sc = new Scanner(System.in) ;
        int choice = -1;

        try {
            choice = sc.nextInt();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            mainMenu();
        }

        try {

            if (choice == 1) {
                buildAirport();
            } else if (choice == 2) {
                buildBusTerminal();
            } else if (choice == 3) {
                buildShippingPort();
            } else if (choice == 4) {
                buildTrainStation();
            }
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            buildTerminal();
        }

        mainMenu();

    }

    static void buildAirport(){
        Scanner sc = new Scanner(System.in) ;

        System.out.println("\n\n\t\t\t\t\t=== Building Airport (1400 $)===\n\n" );
        System.out.print("Is it a International Airport ? (y/n) : ");
        String choice = sc.nextLine();
        boolean international ;
        if(choice.equals("y"))
            international = true ;
        else
            international = false ;

        System.out.println();

        System.out.print("Enter number of runways : ");
        int runways = sc.nextInt();
        System.out.println();

        System.out.print("Enter name of Airport : ");
        sc.nextLine();
        String airportName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of airport : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of airplanes : ");
//        sc.nextLine();
        int number_airplane = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 1400 + number_employees*30 ;

        if(finalPrice <= selectedCity.getBudget() ){
            System.out.println("Build this airport costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

            System.out.print("\nBuild this airport ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Airport newAirport = new Airport(international, runways, selectedCity, airportName, address, area, number_airplane, number_employees);
                selectedCity.addAirport(newAirport);

                selectedCity.withdrawalBudget(finalPrice);
                System.out.println("-----");
                System.out.println("Done");
                System.out.println("-----");

                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static  void buildBusTerminal(){
        Scanner sc = new Scanner(System.in) ;

        System.out.println("\n\n\t\t\t\t\t=== Bus Terminal (600 $)===\n\n" );



        System.out.print("Enter name of bus terminal : ");
//        sc.nextLine();
        String busTerminalName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of bus termianl : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of Buses : ");
//        sc.nextLine();
        int number_buses = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 600 + number_employees*30 ;

        if(finalPrice <= selectedCity.getBudget() ){
            System.out.println("Build this Bus terminal costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

            System.out.print("\nBuild this Bus terminal ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Bus_Terminal newBusTerminal = new Bus_Terminal( selectedCity, busTerminalName , address, area, number_buses , number_employees);
                selectedCity.addBusTerminal(newBusTerminal);
                selectedCity.withdrawalBudget(finalPrice);
                System.out.println("-----");
                System.out.println("Done");
                System.out.println("-----");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static void buildShippingPort(){
        Scanner sc = new Scanner(System.in) ;

        System.out.print("\n\n\t\t\t\t\t=== Shipping port (1000 $)===\n\n" );

        System.out.print("Enter number of waterfronts : ");
        int waterfronts = sc.nextInt();
        System.out.println();


        System.out.print("Enter name of shipping port : ");
        sc.nextLine();
        String shippingPortName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of shipping port : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of ships and boats : ");
//        sc.nextLine();
        int number_ships = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 1000 + number_employees*30 ;

        if(finalPrice <= selectedCity.getBudget() ){
            System.out.println("Build this shipping port costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

            System.out.print("\nBuild this shipping port ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                ShippingPort newShippingPort = new ShippingPort( waterfronts , selectedCity, shippingPortName , address, area, number_ships , number_employees);
                selectedCity.addShippingPort(newShippingPort);
                selectedCity.withdrawalBudget(finalPrice);
                System.out.println("-----");
                System.out.println("Done");
                System.out.println("-----");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static void buildTrainStation(){
        Scanner sc = new Scanner(System.in) ;

        System.out.print("\n\n\t\t\t\t\t=== Shipping port (1100 $)===\n\n" );

        System.out.print("Enter number of input rails : ");
        int inputRails = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of output rails : ");
        int outputRails = sc.nextInt();
        System.out.println();


        System.out.print("Enter name of train station : ");
        sc.nextLine();
        String trainStationName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of train station : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of trains : ");
//        sc.nextLine();
        int number_trains = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 1100 + number_employees*30 ;

        if(finalPrice <= selectedCity.getBudget() ){
            System.out.println("Build this train station costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

            System.out.print("\nBuild this train station ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                TrainStation newTrainStation = new TrainStation( inputRails , outputRails , selectedCity , trainStationName , address, area, number_trains , number_employees);
                selectedCity.addTrainStation(newTrainStation);
                selectedCity.withdrawalBudget(finalPrice);
                System.out.println("-----");
                System.out.println("Done");
                System.out.println("-----");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();
    }

    //==========================================================================================




    static void buyVehicles(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n\t\t\t\t\t====== Buy vehicles ======");
        System.out.println(" 1-boat \n 2-bus \n 3-cargo plane \n 4-passenger airplane \n 5-ship \n 6-train ");
        System.out.print("\nEnter your choice : ");
        int choice = -1;
        try {
            choice = sc.nextInt();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            mainMenu();
        }

        try {
            ;

            if (choice == 1)
                buyBoat();

            if (choice == 2)
                buyBus();

            if (choice == 3)
                buyCargoPlane();

            if (choice == 4)
                buyPassengerAirplane();

            if (choice == 5)
                buyShip();

            if (choice == 6)
                buyTrain();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            buyVehicles();
        }


        mainMenu();

    }

    static void buyBoat(){
        System.out.println("\n\n\t\t\t\t\t=== Buy Boat (300 $) ===");
        Scanner sc = new Scanner(System.in);

        if (selectedCity.getCityShippingPortList().size() == 0){
            System.out.println("You have no shipping port to buy a boat for it ! ");
            mainMenu();
        }
        else {

            System.out.println("Number : \t Shipping port name : \t Maximum number of vehicles : \t Number of available vehicles : ");
            int counter = 1;
            for (ShippingPort a : selectedCity.getCityShippingPortList()) {
                System.out.println(counter + "\t\t\t\t\t" + a.getTerminalName() +"\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter ++ ;
            }
//            System.out.println("\n *** Completed ");
            System.out.print("\n\nEnter number of Shipping port that you want to buy a boat for it : ");
            int number_shippingPort = sc.nextInt();
            System.out.println();

            if (selectedCity.getCityShippingPortList().get(number_shippingPort-1).max_number_of_vehicle() == selectedCity.getCityShippingPortList().get(number_shippingPort-1).getNumber_of_bought_vehicles()){
                System.out.println("You bought maximum number of vehicle for this shipping port .");
                mainMenu();
            }


            //===========================================================================================================================


            System.out.print("Enter maximum distance that boat can go : ");
            int distance = sc.nextInt();
//        System.out.println("+++++  " + distance);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
//        System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter minimum water depth for boat : ");
            int min_depth = sc.nextInt();
//        System.out.println("+++++  " + min_depth);
            System.out.println();

            System.out.print("Enter capacity of boat : ");
            int capacity = sc.nextInt();
//        System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of boat : ");
            String ID = sc.nextLine();
//        System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of boat company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 300;

            if (finalPrice <= selectedCity.getBudget()) {
                System.out.println("Buy this boat costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

                System.out.print("\nBuy this boat ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Boat newBoat = new Boat(distance, fuel_type, min_depth, capacity, ID, company);
                    selectedCity.getCityShippingPortList().get(number_shippingPort - 1).addVehicle(newBoat);
                    selectedCity.withdrawalBudget(finalPrice);
                    System.out.println("-----");
                    System.out.println("Done");
                    System.out.println("-----");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyBus(){
        System.out.println("\n\n\t\t\t\t\t=== Buy Bus (200 $) ===");
        Scanner sc = new Scanner(System.in);

        if (Bus_Terminal.getBus_terminals_list().size() == 0){
            System.out.println("You have no Bus terminal to buy a bus for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of available vehicles : ");
            int counter = 1;
            for (Bus_Terminal a :selectedCity.getCityBusTerminalList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter ++ ;
            }
//            System.out.println("\n *** Completed ");
            System.out.print("\n\nEnter number of bus terminal that you want to buy a bus for it : ");
            int number_busTerminal = sc.nextInt();
            System.out.println();

            if (Bus_Terminal.getBus_terminals_list().get(number_busTerminal-1).max_number_of_vehicle() ==selectedCity.getCityBusTerminalList().get(number_busTerminal-1).getNumber_of_bought_vehicles()){
                System.out.println("You bought maximum number of vehicle for this bus terminal .");
                mainMenu();
            }

            //===========================================================================================================================
            sc.nextLine();
//            System.out.print("Enter type of bus class (business , economy ) : ");
//            String classType = sc.nextLine();
//            System.out.println("+++++  " + classType);
            System.out.println();

            System.out.print("Enter kilometer per liter : ");
            int kpl = sc.nextInt();
//            System.out.println("+++++  " + kpl);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
//            System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter max speed of this bus : ");
            int speed = sc.nextInt();
//            System.out.println("+++++  " + speed);
            System.out.println();

            System.out.print("Enter passenger capacity of bus : ");
            int capacity = sc.nextInt();
//            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of bus : ");
            String ID = sc.nextLine();
//            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of bus company : ");
            String company = sc.nextLine();
//            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 200;

            if (finalPrice <= selectedCity.getBudget()) {
                System.out.println("Buy this bus costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

                System.out.print("\nBuy this bus ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Bus newBus = new Bus("none", kpl, capacity, fuel_type, speed, capacity, company, ID);
                    selectedCity.getCityBusTerminalList().get(number_busTerminal-1).addVehicle(newBus);
                    selectedCity.withdrawalBudget(finalPrice);
                    System.out.println("-----");
                    System.out.println("Done");
                    System.out.println("-----");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyCargoPlane(){
        System.out.println("\n\n\t\t\t\t\t=== Buy Cargo Plane (700 $) ===");
        Scanner sc = new Scanner(System.in);

        if (selectedCity.getCityAirportList().size() == 0){
            System.out.println("You have no Airplane to buy a cargo plane for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of available vehicles : ");
            int counter = 1;
            for (Airport a : selectedCity.getCityAirportList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
//            System.out.println("\n *** Completed ");
            System.out.print("\n\nEnter number of Airport that you want to buy a Cargo plane for it : ");
            int number_airport = sc.nextInt();
            System.out.println();

            if (selectedCity.getCityAirportList().get(number_airport - 1).max_number_of_vehicle() == selectedCity.getCityAirportList().get(number_airport - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this Airplane .");
                mainMenu();
            }

            //===========================================================================================================================

            System.out.print("Enter total weight this plane can transport : ");
            int weight = sc.nextInt();
            System.out.println();

            System.out.print("Enter maximum height of flight : ");
            int height = sc.nextInt();
            System.out.println();

            sc.nextLine();
            System.out.print("Enter runway length : ");
            int runway = sc.nextInt();
            System.out.println();


            System.out.print("Enter passenger capacity of this plane ( max = 5 ) : ");
            int capacity = sc.nextInt();
            while (capacity > 5) {
                System.out.println("\nmaximum passenger capacity of plane is 5 , you entered : " + capacity);
                System.out.print("Enter passenger capacity of this plane ( max = 5 ) : ");
                capacity = sc.nextInt();
            }
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of cargo plane : ");
            String ID = sc.nextLine();
            System.out.println();

            System.out.print("Enter name of cargo plane company : ");
            String company = sc.nextLine();
            System.out.println();

            int finalPrice = 700;

            if (finalPrice <= selectedCity.getBudget()) {
                System.out.println("Buy this cargo plane costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

                System.out.print("\nBuy this cargo plane ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    CargoPlane newCargoPlane = new CargoPlane(weight, height, runway, capacity, ID, company);
                    selectedCity.getCityAirportList().get(number_airport-1).addVehicle( newCargoPlane);
                    selectedCity.withdrawalBudget(finalPrice);
                    System.out.println("-----");
                    System.out.println("Done");
                    System.out.println("-----");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyPassengerAirplane(){
        System.out.println("\n\n\t\t\t\t\t=== Buy Passenger Airplane (800 $) ===");
        Scanner sc = new Scanner(System.in);

        if (selectedCity.getCityAirportList().size() == 0){
            System.out.println("You have no Airport to buy a passenger airplane for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of available vehicles : ");
            int counter = 1;
            for (Airport a : selectedCity.getCityAirportList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
//            System.out.println("\n *** Completed ");
            System.out.print("\n\nEnter number of Airport that you want to buy a passenger airplane for it : ");
            int number_airport = sc.nextInt();
            System.out.println();

            if (selectedCity.getCityAirportList().get(number_airport - 1).max_number_of_vehicle() == selectedCity.getCityAirportList().get(number_airport - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this Airplane .");
                mainMenu();
            }

            //===========================================================================================================================

            System.out.print("Enter number of flight attendants: ");
            int flightAttendant = sc.nextInt();
//            System.out.println("+++++  " + flightAttendant);
            System.out.println();

            sc.nextLine();
//            System.out.print("Enter type of airplane class (business , economy ) : ");
//            String classType = sc.nextLine();
//            System.out.println("+++++  " + classType);
            System.out.println();

            System.out.print("Enter maximum height of flight : ");
            int height = sc.nextInt();
//            System.out.println("+++++  " + height);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter runway length : ");
            int runway = sc.nextInt();
//            System.out.println("+++++  " + runway);
            System.out.println();


            System.out.print("Enter passenger capacity of this plane : ");
            int capacity = sc.nextInt();
//            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of passenger airplane : ");
            String ID = sc.nextLine();
//            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of Passenger airplane company : ");
            String company = sc.nextLine();
//            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 800;

            if (finalPrice <= selectedCity.getBudget()) {
                System.out.println("Buy this passenger airplane costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

                System.out.print("\nBuy this passenger airplane ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Passenger_airplane newPassengerAirplane = new Passenger_airplane(flightAttendant, "none", height, runway, capacity, ID, company);
                    selectedCity.getCityAirportList().get(number_airport-1).addVehicle(newPassengerAirplane);
                    selectedCity.withdrawalBudget(finalPrice);
                    System.out.println("-----");
                    System.out.println("Done");
                    System.out.println("-----");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyShip(){
        System.out.println("\n\n\t\t\t\t\t=== Buy Ship (600 $) ===");
        Scanner sc = new Scanner(System.in);

        if (selectedCity.getCityShippingPortList().size() == 0){
            System.out.println("You have no shipping port to buy a ship for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of available vehicles : ");
            int counter = 1;
            for (ShippingPort a : selectedCity.getCityShippingPortList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
//            System.out.println("\n *** Completed ");
            System.out.print("\n\nEnter number of Shipping port that you want to buy a ship for it : ");
            int number_shippingPort = sc.nextInt();
            System.out.println();


            if (selectedCity.getCityShippingPortList().get(number_shippingPort - 1).max_number_of_vehicle() == selectedCity.getCityShippingPortList().get(number_shippingPort - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this shipping port .");
                mainMenu();
            }

            //===========================================================================================================================
            sc.nextLine();
//            System.out.print("Enter type of ship class (business , economy ) : ");
//            String classType = sc.nextLine();
//            System.out.println("+++++  " + classType);
            System.out.println();

            System.out.print("Enter length of this ship : ");
            int length = sc.nextInt();
//            System.out.println("+++++  " + length);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
//            System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter minimum water depth for ship : ");
            int min_depth = sc.nextInt();
//            System.out.println("+++++  " + min_depth);
            System.out.println();

            System.out.print("Enter capacity of ship : ");
            int capacity = sc.nextInt();
//            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of ship : ");
            String ID = sc.nextLine();
//            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of ship company : ");
            String company = sc.nextLine();
//            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 600;

            if (finalPrice <= selectedCity.getBudget()) {
                System.out.println("Buy this ship costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

                System.out.print("\nBuy this ship ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Ship newShip = new Ship("none", length, fuel_type, min_depth, capacity, ID, company);
                    selectedCity.getCityShippingPortList().get(number_shippingPort - 1).addVehicle(newShip);
                    selectedCity.withdrawalBudget(finalPrice);
                    System.out.println("-----");
                    System.out.println("Done");
                    System.out.println("-----");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyTrain(){
        System.out.println("\n\n\t\t\t\t\t=== Buy Train (500 $) ===");
        Scanner sc = new Scanner(System.in);


        if (selectedCity.getCityTrainStationList().size() == 0){
            System.out.println("You have no Train Station to buy a train for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of available vehicles : ");
            int counter = 1;
            for (TrainStation a : selectedCity.getCityTrainStationList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
//            System.out.println("\n *** Completed ");
            System.out.print("\n\nEnter number of Train Station that you want to buy a train for it : ");
            int number_trainStation = sc.nextInt();
            System.out.println();


            if (selectedCity.getCityTrainStationList().get(number_trainStation - 1).max_number_of_vehicle() == selectedCity.getCityTrainStationList().get(number_trainStation - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this Train Station .");
                mainMenu();
            }


            //===============================================================================================================================


            System.out.print("Enter number of wagons : ");
            int wagons = sc.nextInt();
//            System.out.println("+++++  " + wagons);
            System.out.println();

            System.out.print("Enter number of stars for this train : ");
            int stars = sc.nextInt();
//            System.out.println("+++++  " + stars);
            System.out.println();

            System.out.print("Enter fuel capacity  : ");
            int fuel_capacity = sc.nextInt();
//            System.out.println("+++++  " + fuel_capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
//            System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter max speed of this train : ");
            int speed = sc.nextInt();
//            System.out.println("+++++  " + speed);
            System.out.println();

            System.out.print("Enter passenger capacity of train : ");
            int capacity = sc.nextInt();
//            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of train : ");
            String ID = sc.nextLine();
//            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of train company : ");
            String company = sc.nextLine();
//            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 500;

            if (finalPrice <= selectedCity.getBudget()) {
                System.out.println("Buy this train costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

                System.out.print("\nBuy this train ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Train newTrain = new Train(wagons, stars, fuel_capacity, fuel_type, speed, capacity, company, ID);
                    selectedCity.getCityTrainStationList().get(number_trainStation - 1).addVehicle(newTrain);
                    selectedCity.withdrawalBudget(finalPrice);
                    System.out.println("-----");
                    System.out.println("Done");
                    System.out.println("-----");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }

    }

    //==============================================================

    static void engage(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-pilot \n 2-driver \n 3-sailor \n 4-locomotive driver \n 5-flight attendant \n 6-Employee");
        System.out.print("\nEnter your choice : ");
        int choice = -1;
        try {
            choice = sc.nextInt();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            mainMenu();
        }

        try {
            if (choice == 1)
                engagePilot();

            if (choice == 2)
                engageDriver();

            if (choice == 3)
                engageSailor();

            if (choice == 4)
                engageLocomotiveDriver();

            if (choice == 5)
                engageFlightAttendant();

            if (choice == 6)
                engageEmployee();
        }
        catch (RuntimeException ex){
            System.out.println(ex.toString());
            engage();
        }

        mainMenu();

    }

    static void engagePilot(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Engage Pilot ===");

        if (selectedCity.getCityAirportList().size() >0) {
            System.out.println("ID : \t Salary:");

            for (Person ap : selectedCity.getPersonList()) {
                if (ap.getJob().equals("pilot") && ap.getHired() == false) {
                    System.out.println(ap.getID() + "\t\t\t " + ap.getSalary());
                }
            }
//        System.out.println("\n** Completed\n");
            System.out.print("\nEnter ID of your choice : ");
            int ID = sc.nextInt();
            System.out.println();

            int counter = 1;
            System.out.println("number : \t number of hired pilots : ");
            for (Airport a : selectedCity.getCityAirportList()) {
                System.out.println(counter + "\t\t\t\t\t" + a.number_of_hired_drivers());
                counter++;
            }
//        System.out.println("\n** Completed\n");
            System.out.print("\nEnter number of Airport you want hire a pilot for it : ");
            int numberAirport = sc.nextInt();

            Person selected = Person.find_Person_from_ID(ID);
            if (selected.getJob().equals("pilot")) {
                Airport airport = selectedCity.getCityAirportList().get(numberAirport - 1);
                Person.engage(ID);
                airport.add_Driver(selected);
                selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                showMoney();
                mainMenu();
            }
            else {
                throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a pilot");
            }
        }
        else{
            System.out.println("You dont have airport so you cant engage pilot !");
            mainMenu();
        }


    }

    static void engageDriver(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Engage Driver ===");

        if (Bus_Terminal.getBus_terminals_list().size() > 0) {
            System.out.println("ID : \t Salary:");

            for (Person ap : selectedCity.getPersonList()) {
                if (ap.getJob().equals("driver") && ap.getHired() == false) {
                    System.out.println(ap.getID() + "\t\t\t " + ap.getSalary());
                }
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter ID of your choice : ");
            int ID = sc.nextInt();

            int counter = 1;
            System.out.println("number : \t number of hired drivers : ");
            for (Bus_Terminal a :selectedCity.getCityBusTerminalList()) {
                System.out.println(counter + "\t\t\t\t\t" + a.number_of_hired_drivers());
                counter++;
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter number of Bus Terminal you want hire a driver for it : ");
            int numberBusTerminal = sc.nextInt();

            Person selected = Person.find_Person_from_ID(ID);
            if (selected.getJob().equals("driver")) {
                Bus_Terminal bus_terminal  = selectedCity.getCityBusTerminalList().get(numberBusTerminal - 1);
                Person.engage(ID);
                bus_terminal.add_Driver(selected);

                selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                showMoney();
                mainMenu();
            }
            else {
                throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a driver");
            }
        }
        else {
            System.out.println("You dont have bus terminal so you cant engage driver ! ");
            mainMenu();
        }
    }

    static void engageSailor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Engage Sailor ===");

        if ( selectedCity.getCityShippingPortList().size() > 0) {
            System.out.println("ID : \t Salary:");

            for (Person ap : selectedCity.getPersonList()) {
                if (ap.getJob().equals("sailor") && ap.getHired() == false) {
                    System.out.println(ap.getID() + "\t\t\t " + ap.getSalary());
                }
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter ID of your choice : ");
            int ID = sc.nextInt();

            int counter = 1;
            System.out.println("number : \t number of hired sailors : ");
            for (ShippingPort a : selectedCity.getCityShippingPortList()) {
                System.out.println(counter + "\t\t\t\t\t" + a.number_of_hired_drivers());
                counter++;
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter number of Shipping Port you want hire a sailor for it : ");
            int numberShppingPort = sc.nextInt();

            Person selected = Person.find_Person_from_ID(ID);
            if (selected.getJob().equals("sailor")) {
                ShippingPort shippingPort = selectedCity.getCityShippingPortList().get(numberShppingPort - 1);
                Person.engage(ID);
                shippingPort.add_Driver(selected);
                selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                showMoney();
                mainMenu();
            }
            else {
                throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a sailor");
            }
        }
        else {
            System.out.println("You dont have shipping port so you cant engage sailor ! ");
            mainMenu();
        }
    }

    static void engageLocomotiveDriver(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Engage Locomotive Driver ===");

        if (selectedCity.getCityTrainStationList().size() > 0) {
            System.out.println("ID : \t Salary:");

            for (Person ap : selectedCity.getPersonList()) {
                if (ap.getJob().equals("locomotive driver") && ap.getHired() == false) {
                    System.out.println(ap.getID() + "\t\t\t " + ap.getSalary());
                }
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter ID of your choice : ");
            int ID = sc.nextInt();

            int counter = 1;
            System.out.println("number : \t number of hired Locomotive Driver : ");
            for (TrainStation a : selectedCity.getCityTrainStationList()) {
                System.out.println(counter + "\t\t\t\t\t" + a.number_of_hired_drivers());
                counter++;
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter number of Train Station you want hire a locomotive driver for it : ");
            int numberTrainStation = sc.nextInt();

            Person selected = Person.find_Person_from_ID(ID);
            if(selected.getJob().equals("locomotive driver")) {
                TrainStation trainStation = selectedCity.getCityTrainStationList().get(numberTrainStation - 1);
                Person.engage(ID);
                trainStation.add_Driver(selected);
                selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                showMoney();
                mainMenu();
            }
            else {
                throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a locomotive driver");
            }
        }
        else {
            System.out.println("You dont have train station so you cant engage locomotive driver ! ");
            mainMenu();
        }
    }

    static void engageFlightAttendant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Engage Flight Attendant ===");

        if (selectedCity.getCityAirportList().size() > 0) {
            System.out.println("ID : \t Salary:");

            for (Person ap : selectedCity.getPersonList()) {
                if (ap.getJob().equals("flight attendant") && ap.getHired() == false) {
                    System.out.println(ap.getID() + "\t\t\t " + ap.getSalary());
                }
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter ID of your choice : ");
            int ID = sc.nextInt();

            int counter = 1;
            System.out.println("number : \t number of hired Flight Attendant : ");
            for (Airport a : selectedCity.getCityAirportList()) {
                System.out.println(counter + "\t\t\t\t\t" + a.numberOfHiredFlightAttendants());
                counter++;
            }
            System.out.println("\n** Completed\n");
            System.out.print("Enter number of Airport you want hire a flight attendant for it : ");
            int numberAirport = sc.nextInt();

            Person selected = Person.find_Person_from_ID(ID);
            if (selected.getJob().equals("flight attendant")) {
                Airport airport = selectedCity.getCityAirportList().get(numberAirport - 1);
                Person.engage(ID);
                airport.addFlightAttendant(selected);
                ;
                selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                showMoney();
                mainMenu();
            }
            else {
                throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a flight attendant");
            }
        }
        else {
            System.out.println("You dont have airport so you cant engage flight attendant ! ");
            mainMenu();
        }
    }

    static void engageEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Engage Employee ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : selectedCity.getPersonList()){
            if(ap.getJob().equals("employee") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        System.out.println(" 1-Airport \n 2-Bus Terminal \n 4-Shipping Port \n 5-Train Station");
        System.out.print("\n Engage employee for : ");
        int employeeFor = sc.nextInt();

        if (employeeFor == 1 ){

            System.out.println("\n\n=== Engage Employee For Airport ===\n");

            int counter = 1;
            System.out.println("Number : \t Airplane name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (Airport a : selectedCity.getCityAirportList()){
                System.out.println(counter + "\t\t\t\t" + a.getTerminalName() + "\t\t\t\t\t" + a.max_number_of_employees() + "\t\t\t\t\t\t\t\t" + a.number_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of airplane you want hire employee for that : ");
            int numberAirport = sc.nextInt();

            if(selectedCity.getCityAirportList().get(numberAirport-1).number_of_hired_employees() < selectedCity.getCityAirportList().get(numberAirport-1).number_of_hired_employees() ){
                Person selected = Person.find_Person_from_ID(ID);
                if (selected.getJob().equals("employee")) {
                    Airport airport = selectedCity.getCityAirportList().get(numberAirport - 1);
                    Person.engage(ID);
                    airport.addEmployees(selected);
                    selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                    showMoney();
                    mainMenu();
                }
                else {
                    throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a employee");
                }
            }
            else {
                System.out.println("You cant engage an employee for this airport ! ");
                mainMenu();
            }
        }


        else if (employeeFor == 2){

            System.out.println("\n\n=== Engage Employee For Bus Terminal ===\n");

            int counter = 1;
            System.out.println("Number : \t Bus terminal name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (Bus_Terminal a :selectedCity.getCityBusTerminalList()){
                System.out.println(counter + "\t\t\t\t" + a.getTerminalName() + "\t\t\t\t\t\t" + a.max_number_of_employees() + "\t\t\t\t\t\t\t\t\t" + a.number_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of bus terminal you want hire employee for that : ");
            int numberBusTerminal = sc.nextInt();

            if(Bus_Terminal.getBus_terminals_list().get(numberBusTerminal-1).number_of_hired_employees() <selectedCity.getCityBusTerminalList().get(numberBusTerminal-1).max_number_of_employees() ){
                Person selected = Person.find_Person_from_ID(ID);
                if (selected.getJob().equals("employee")) {
                    Bus_Terminal bus_terminal = selectedCity.getCityBusTerminalList().get(numberBusTerminal - 1);
                    Person.engage(ID);
                    bus_terminal.addEmployees(selected);
                    selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                    showMoney();
                    mainMenu();
                }
                else {
                    throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a employee");
                }
            }
            else {
                System.out.println("You cant engage an employee for this bus terminal ! ");
                mainMenu();
            }

        }


//        else if (employeeFor == 3 ){
//
//            System.out.println("\n\n=== Engage Employee For Hotel ===\n");
//
//            int counter = 1;
//            System.out.println("Number : \t Hotel name : \t Maximum number of employee : \t Number of hired employees :  ");
//            for (Hotel a : selectedCity.getCityHotelList()){
//                System.out.println(counter + "\t\t\t   " + a.getHotelName() + "\t\t\t\t\t" + a.getNumber_of_Employees() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_hired_Employees());
//                counter ++ ;
//            }
//            System.out.print("\nEnter number of hotel you want hire employee for that : ");
//            int numberHotel = sc.nextInt();
//
//            if(selectedCity.getCityHotelList().get(numberHotel-1).getNumber_of_hired_Employees() < selectedCity.getCityHotelList().get(numberHotel-1).getNumber_of_Employees() ){
//                Person selected = Person.find_Person_from_ID(ID);
//                if (selected.getJob().equals("employee")) {
//                    Hotel hotel = selectedCity.getCityHotelList().get(numberHotel - 1);
//                    Person.engage(ID);
//                    hotel.addEmployee(selected);
//                    selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
//                    showMoney();
//                    mainMenu();
//                }
//                else {
//                    throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a employee");
//                }
//
//            }
//            else {
//                System.out.println("You cant engage an employee for this hotel ! ");
//                mainMenu();
//            }
//        }


        else if (employeeFor == 4 ) {
            System.out.println("\n\n=== Engage Employee For Shipping Port ===\n");

            int counter = 1;
            System.out.println("Number : \t Shipping port name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (ShippingPort a : selectedCity.getCityShippingPortList()){
                System.out.println(counter + "\t\t\t\t" + a.getTerminalName() + "\t\t\t\t\t\t" + a.max_number_of_employees() + "\t\t\t\t\t\t\t\t" + a.number_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of Shipping port you want hire employee for that : ");
            int numberShippingPort = sc.nextInt();

            if(selectedCity.getCityShippingPortList().get(numberShippingPort-1).number_of_hired_employees() < selectedCity.getCityShippingPortList().get(numberShippingPort-1).max_number_of_employees() ){
                Person selected = Person.find_Person_from_ID(ID);
                if (selected.getJob().equals("employee")) {
                    ShippingPort shippingPort = selectedCity.getCityShippingPortList().get(numberShippingPort - 1);
                    Person.engage(ID);
                    shippingPort.addEmployees(selected);
                    selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                    showMoney();
                    mainMenu();
                }
                else {
                    throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a employee");
                }
            }
            else {
                System.out.println("You cant engage an employee for this shipping port ! ");
                mainMenu();
            }
        }


        else if (employeeFor == 5){

            System.out.println("\n\n=== Engage Employee For Train Station ===\n");

            int counter = 1;
            System.out.println("Number : \t Train station name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (TrainStation a : selectedCity.getCityTrainStationList()){
                System.out.println(counter + "\t\t\t\t" + a.getTerminalName() + "\t\t\t\t\t\t\t" + a.max_number_of_employees() + "\t\t\t\t\t\t\t\t\t" + a.number_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of train station you want hire employee for that : ");
            int numberTrainStation= sc.nextInt();

            if(selectedCity.getCityTrainStationList().get(numberTrainStation-1).number_of_hired_employees() < selectedCity.getCityTrainStationList().get(numberTrainStation-1).max_number_of_employees() ){
                Person selected = Person.find_Person_from_ID(ID);
                if (selected.getJob().equals("employee")) {
                    TrainStation trainStation =  selectedCity.getCityTrainStationList().get(numberTrainStation - 1);
                    Person.engage(ID);
                    trainStation.addEmployees(Person.find_Person_from_ID(ID));
                    selectedCity.withdrawalBudget( Person.find_Person_from_ID(ID).getSalary() );
                    showMoney();
                    mainMenu();
                }
                else {
                    throw new InvalidPerson("Selected person is a " + selected.getJob() + " not a employee");
                }

            }
            else {
                System.out.println("You cant engage an employee for this Train Station ! ");
                mainMenu();
            }
        }

    }

    //==============================================================

    static void buildHotel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Build Hotel ===\n");

        System.out.print("Enter hotel name : ");
        String hotelName = sc.nextLine();
//        System.out.println("++++  " + hotelName);
        System.out.println();

        System.out.print("Enter address of this hotel : ");
        String address = sc.nextLine();
//        System.out.println("++++  " + address);

        System.out.println();

        System.out.print("Enter number of stars : ");
        int stars = sc.nextInt();
//        System.out.println("++++  " + stars);
        System.out.println();

        System.out.print("Enter number of rooms (each room = 150 $) : ");
        int rooms = sc.nextInt() ;
//        System.out.println("++++  " + rooms);
        System.out.println();

//        System.out.print("Enter number of employees (each employee = 30 $) :  ");
//        int employees = sc.nextInt() ;
        System.out.println();

        int finalPrice = (rooms * 150)  ;

        if(finalPrice <= selectedCity.getBudget() ){
            System.out.println("Build this Hotel costs : " + finalPrice + " $\nand now you have " + selectedCity.getBudget() + "$");

            System.out.print("\nBuild this hotel ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Hotel newHotel = new Hotel(hotelName , address , stars , rooms  );
                selectedCity.addHotel(newHotel);
                selectedCity.withdrawalBudget(finalPrice);
                System.out.println("-----");
                System.out.println("Done");
                System.out.println("-----");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static void build_Room_In_Hotel(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t=== Build rooms in hotel ===\n");
        int counter = 1 ;
        System.out.println("number of hotel \t max number of rooms \t number of builded rooms");
        for (Hotel a : selectedCity.getCityHotelList()){
            System.out.println(counter + "\t\t\t\t\t\t" + a.getNumber_of_rooms() + "\t\t\t\t\t\t" + a.getBuildedRooms() );
            counter++;
        }

        System.out.print("\nEnter number of hotel : ");
        int numHotel = sc.nextInt();

        Hotel hotel = selectedCity.getCityHotelList().get(numHotel-1);

        System.out.println("\n\n\t\t\t\t\t=== Build a room for  " +  hotel.getHotelName() + " ===\n");

        System.out.print("Enter room number : ");
        int roomNumber = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of beds : ");
        int beds = sc.nextInt();
        System.out.println();

        System.out.print("Enter room area : ");
        int roomArea = sc.nextInt();
        System.out.println();

        System.out.print("Enter fee for one night : ");
        int fee = sc.nextInt();
        System.out.println();

        sc.nextLine();
        System.out.print("Are you sure to build this room ? (y/n) : ");
        String confirm = sc.nextLine();
        System.out.println();


        if (confirm.equals("y")){
            hotel.addRoom(roomNumber , beds , roomArea , fee);
            System.out.println("-----");
            System.out.println("\nDone");
            System.out.println("-----");
        }
        else
            System.out.println("\nCanceled");


        mainMenu();


    }
}
