package Main;
import Main.Bank.Bank;
import Main.Buildings.*;
import Main.Exception.ThereWasNoCar;
import Main.Exception.ThereWasNoDriver;
import Main.Exception.ThereWasNoTerminal;
import Main.Vehicles.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import  Main.Person.Job;
public class City implements Serializable {

    private String CityName;
    private final ArrayList<Person>persons=new ArrayList<>();
    private final ArrayList<Hotel>hotels=new ArrayList<>();
    public final ArrayList<Terminal>terminals=new ArrayList<>();
    public double Total_Money=10000;
    public int Population=0;
    private final ArrayList<Bank>banks=new ArrayList<>();

    public City(String cityName) {
        CityName = cityName;
        Country.TotalBudget+=Total_Money;
    }
    public void AddCapitalPerson(String name, String family, int yearOfBirth, String placeOfBirth,Job job,String gender,int Employment_salary,boolean Employment_situation){
        Person person=new Person(name,family,yearOfBirth,placeOfBirth,job,gender,Employment_salary,Employment_situation);
        persons.add(person);
        Population++;
        Country.TotalPopulation++;
    }
    public void AddPerson(Person person){
        persons.add(person);
        Population++;
    }
    public void RemovePerson(Person person){
        persons.remove(person);
        Population--;
    }

    public void AddHotel(Hotel hotel){
        hotels.add(hotel);
    }
    public void AddTerminal(Terminal terminal){
            terminals.add(terminal);

    }
    public ArrayList<Person> getPerson() {
        return persons;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Terminal> getTerminals() {
        return terminals;
    }

    public String getCityName() {
        return CityName;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public void Show_Money_and_Population(){
        System.out.format(ConsoleColors.YELLOW_BRIGHT+"\n(\uD83D\uDC6B:%d \uD83D\uDCB0:%f)"+ConsoleColors.RESET,Population,Total_Money);
    }
    public boolean payMoney(double money){
        if(money<=Total_Money){
            Total_Money-=money;
            Country.TotalBudget-=money;
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"\nMONEY WAS PAID!"+ConsoleColors.RESET);
            return true;
        }else{
            System.out.println("ERROR!:TOTAL MONEY WAS NOT ENOUGH");
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }
   public void increaseMoney(double money){
        Total_Money+=money;
        Country.TotalBudget+=money;
   }

    public boolean isConstructedTerminal(String TerminalName){
        boolean situation=false;
        for (int i=0;i<terminals.size();i++){
            if(terminals.get(i).getClass().getName().contains(TerminalName)){
                situation=true;
                break;
            }
        }
        return situation;
    }
    public Terminal ReturnTerminal(String TerminalName){
        for (int i=0;i<terminals.size();i++){
            if(terminals.get(i).getClass().getName().contains(TerminalName)){
                return terminals.get(i);
            }
        }
        return null;
    }
    public void ShowPeople(){
        System.out.println("\n*************************************************************SHOW ALL PEOPLE*************************************************************");
        for (int i=0;i<persons.size();i++){
            System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
        }

    }
    public void Show_People_By_Job(int num){
        System.out.println("\n*************************************************************SHOW PEOPLE BY JOB*************************************************************");

        switch (num){
            case 1:
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.malvan){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    }
                }
                break;
            case 2:
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.pilot){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    }
                }
                break;
            case 3:
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.bus_driver){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    }
                }
                break;
            case 4:
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.Locomotive_driver){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    }
                }
                break;
            case 5:
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.crew){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    }
                }
                break;
        }
    }
    public void showPeopleNotHired(){
        System.out.println("\n*************************************************************SHOW PEOPLE NOT HIRED*************************************************************");

        for (int i=0;i<persons.size();i++){
            if(!persons.get(i).isEmployment_situation()){
                System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());

            }
        }
    }
    public void Show_NotHiredPeople_By_Job(int num){
        System.out.println("\n*************************************************************SHOW NOT HIRED PEOPLE BY JOB*************************************************************");

        switch (num){
            case 1:
                boolean find=false;
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.malvan && persons.get(i).isEmployment_situation()==false){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                        find=true;
                    }
                }if (!find)throw new ThereWasNoDriver("ERROR:There Was No Malwan!");
                break;
            case 2:
                boolean find2=false;
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.pilot && persons.get(i).isEmployment_situation()==false){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    find2=true;
                    }
                }if (!find2)throw new ThereWasNoDriver("ERROR:There Was No Pilot!");
                break;
            case 3:
                boolean find3=false;
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.bus_driver && persons.get(i).isEmployment_situation()==false){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    find3=true;
                    }
                }if (!find3)throw new ThereWasNoDriver("ERROR:There Was No Bus Driver!");
                break;
            case 4:
                boolean fined4=false;
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.Locomotive_driver && persons.get(i).isEmployment_situation()==false){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                    fined4=true;
                    }
                }if (!fined4)throw new ThereWasNoDriver("ERROR:There Was No Locomotive Driver!");
                break;
            case 5:
                boolean find5=false;
                for (int i=0;i<persons.size();i++){
                    if(persons.get(i).getJob()== Person.Job.crew && persons.get(i).isEmployment_situation()==false){
                        System.out.format("\n(ID:%d) Name: %-15s , Family name: %-15s , Year of birth: %-4d , Place of birth: %-10s , Job: %-20s , Gender: %-10s , Employment salary: %-5d , Employment situation: %-6s\n",i,persons.get(i).getName(),persons.get(i).getFamily(),persons.get(i).getYear_of_Birth(),persons.get(i).getPlace_of_Birth(),persons.get(i).getJob().name(),persons.get(i).getGender(),persons.get(i).getEmployment_salary(),persons.get(i).isEmployment_situation());
                   find5=true;
                    }
                }if (!find5)throw new ThereWasNoDriver("ERROR:There Was No Crew!");
                break;
        }
    }
    public void ShowTerminals(){
        if(terminals.size()!=0){
            for (int i=0;i<terminals.size();i++){
                System.out.format("\n(ID:%d) City Name : %s , Terminal Name : %s , Address : %s , Area : %d , Number of vehicles : %d\n",i,terminals.get(i).getCity_name(),terminals.get(i).getTerminal_name(),terminals.get(i).getAddress(),terminals.get(i).getArea(),terminals.get(i).getNumber_of_vehicles());
            }
        }else throw new ThereWasNoTerminal("ERROR:There isn't any Terminals in this City!");

    }
    public void showTerminals(){
        for (int j=0;j<terminals.size();j++){
            if(terminals.get(j)instanceof Airport){
                System.out.println("AIRPORT: ");
                Airport airport=(Airport)terminals.get(j);
                System.out.format("City Name: %s , Terminal Name: %s , Address: %s , Number Of Vehicles: %s , Area: %s , Number Of Runways: %d , Airport Type: %s\n",airport.getCity_name(),airport.getTerminal_name(),airport.getAddress(),airport.getNumber_of_vehicles(),airport.getArea(),airport.getNumber_of_runways(),airport.getAirport_Type());
                System.out.println("Air Vehicles: ");
                for (int i=0;i<airport.getAir_vehicles().size();i++){
                    if(airport.getAir_vehicles().get(i)instanceof Passenger_plane) {
                        Passenger_plane passenger_plane=(Passenger_plane)airport.getAir_vehicles().get(i);
                        System.out.println("Passenger planes :");
                        System.out.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Number Of Crew: %d , Aircraft Classification Seats: %d\n",passenger_plane.getPrice(),passenger_plane.getCapacity(),passenger_plane.getCompany_builder_name(),passenger_plane.getMaximum_flight_altitude(),passenger_plane.getBand_length_required_for_Landing(),passenger_plane.getNumber_of_crew(),passenger_plane.getAircraft_classification_seats());
                        System.out.println();
                    }if(airport.getAir_vehicles().get(i)instanceof Cargo_plane){
                       Cargo_plane cargo_plane=(Cargo_plane) airport.getAir_vehicles().get(i);
                        System.out.println("Cargo plane :");
                        System.out.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Total portable weight: %d\n",cargo_plane.getPrice(),cargo_plane.getCapacity(),cargo_plane.getCompany_builder_name(),cargo_plane.getMaximum_flight_altitude(),cargo_plane.getBand_length_required_for_Landing(),cargo_plane.getTotal_portable_weight());
                        System.out.println();
                    }

                }
                System.out.println("PILOTS :");
                for (int x=0;x<airport.getLeaders().size();x++){
                    System.out.format("(ID:%d) Name: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n",x,airport.getLeaders().get(x).getName(),airport.getLeaders().get(x).getFamily(),airport.getLeaders().get(x).getYear_of_Birth(),airport.getLeaders().get(x).getPlace_of_Birth(),airport.getLeaders().get(x).getJob().name(),airport.getLeaders().get(x).getGender(),airport.getLeaders().get(x).getEmployment_salary(),airport.getLeaders().get(x).isEmployment_situation());

                }
            }if(terminals.get(j)instanceof RailwayStation){
                System.out.println("RailwayStation: ");
                RailwayStation railwayStation=(RailwayStation) terminals.get(j);
                System.out.format("City Name: %s , Terminal Name: %s , Address: %s , Number Of Vehicles: %s , Area: %s , Number Of Input Rails: %d , Number Of Output Rails: %d\n",railwayStation.getCity_name(),railwayStation.getTerminal_name(),railwayStation.getAddress(),railwayStation.getNumber_of_vehicles(),railwayStation.getArea(),railwayStation.getNumber_of_input_rails(),railwayStation.getNumber_of_output_rails());
                System.out.println("Trains: ");
                for (int i=0;i<railwayStation.getTrains().size();i++){
                        System.out.format("Price: %d , Capacity: %d , Company Builder Name: %s , Fuel Type: %s , Ticket Price: %d , Number of wagons: %d , Number of stars: %d\n",railwayStation.getTrains().get(i).getPrice(),railwayStation.getTrains().get(i).getCapacity(),railwayStation.getTrains().get(i).getCompany_builder_name(),railwayStation.getTrains().get(i).getFuel_type(),railwayStation.getTrains().get(i).getTicket_price(),railwayStation.getTrains().get(i).getNumber_of_wagons(),railwayStation.getTrains().get(i).getNumber_of_stars());
                        for (int w=0;j<railwayStation.getTrains().get(i).getServises().size();j++){
                            System.out.format(" [Services%d: %s]",w+1,railwayStation.getTrains().get(i).getServises().get(w));
                        }
                        System.out.println();
                    }
                System.out.println("LOCOMOTIVE DRIVERS :");
                for (int x=0;x<railwayStation.getLeaders().size();x++){
                    System.out.format("(ID:%d) Name: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n",x,railwayStation.getLeaders().get(x).getName(),railwayStation.getLeaders().get(x).getFamily(),railwayStation.getLeaders().get(x).getYear_of_Birth(),railwayStation.getLeaders().get(x).getPlace_of_Birth(),railwayStation.getLeaders().get(x).getJob().name(),railwayStation.getLeaders().get(x).getGender(),railwayStation.getLeaders().get(x).getEmployment_salary(),railwayStation.getLeaders().get(x).isEmployment_situation());
                }
                }if(terminals.get(j)instanceof BusTerminal){
                System.out.println("Bus Terminal: ");
                BusTerminal busTerminal=(BusTerminal) terminals.get(j);
                System.out.format("City Name: %s , Terminal Name: %s , Address: %s , Number Of Vehicles: %s , Area: %s\n",busTerminal.getCity_name(),busTerminal.getTerminal_name(),busTerminal.getAddress(),busTerminal.getNumber_of_vehicles(),busTerminal.getArea());
                System.out.println("Buses: ");
                    for(int k=0;k<busTerminal.getBuses().size();k++){
                        System.out.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Ticket Price: %d , Pollutant production by PPM: %d , Fuel consumption per kilometer by lit: %d\n",busTerminal.getBuses().get(k).getPrice(),busTerminal.getBuses().get(k).getCapacity(),busTerminal.getBuses().get(k).getCompany_builder_name(),busTerminal.getBuses().get(k).getFuel_type(),busTerminal.getBuses().get(k).getTicket_price(),busTerminal.getBuses().get(k).getPollutant_production_by_PPM(),busTerminal.getBuses().get(k).getFuel_consumption_per_kilometer_by_lit());
                        System.out.println();
                    }
                System.out.println("BUS DRIVERS :");
                for (int x=0;x<busTerminal.getLeaders().size();x++){
                    System.out.format("(ID:%d) Name: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n",x,busTerminal.getLeaders().get(x).getName(),busTerminal.getLeaders().get(x).getFamily(),busTerminal.getLeaders().get(x).getYear_of_Birth(),busTerminal.getLeaders().get(x).getPlace_of_Birth(),busTerminal.getLeaders().get(x).getJob().name(),busTerminal.getLeaders().get(x).getGender(),busTerminal.getLeaders().get(x).getEmployment_salary(),busTerminal.getLeaders().get(x).isEmployment_situation());

                }
            }if(terminals.get(j)instanceof ShippingPort){
                System.out.println("ShippingPort: ");
                ShippingPort shippingPort=(ShippingPort)terminals.get(j);
                System.out.format("City Name: %s , Terminal Name: %s , Address: %s , Number Of Vehicles: %s , Area: %s , Number Of Docks: %d\n",shippingPort.getCity_name(),shippingPort.getTerminal_name(),shippingPort.getAddress(),shippingPort.getNumber_of_vehicles(),shippingPort.getArea(),shippingPort.getNumber_of_dock());
                System.out.println("Sea Vehicles: ");
                for (int i=0;i<shippingPort.getSea_vehicles().size();i++){
                    if(shippingPort.getSea_vehicles().get(i)instanceof Ship) {
                        Ship ship=(Ship) shippingPort.getSea_vehicles().get(i);
                        System.out.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Number Of lifeboat: %d  ,Number Of Crew: %d\n",ship.getPrice(),ship.getCapacity(),ship.getCompany_builder_name(),ship.getFuel_type(),ship.getMinimum_depth_to_move(),ship.getNumber_of_lifeboats(),ship.getNumber_of_crew());
                        System.out.println();
                    }if(shippingPort.getSea_vehicles().get(i)instanceof Boat){
                        Boat boat=(Boat) shippingPort.getSea_vehicles().get(i);
                        System.out.format("Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Boat body type: %s\n",boat.getPrice(),boat.getCapacity(),boat.getCompany_builder_name(),boat.getFuel_type(),boat.getMinimum_depth_to_move(),boat.getBoat_body_type());
                        System.out.println();

                    }
                }
                System.out.println("MALVAN :");
                for (int x=0;x<shippingPort.getLeaders().size();x++){
                    System.out.format("(ID:%d) Name: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n",x,shippingPort.getLeaders().get(x).getName(),shippingPort.getLeaders().get(x).getFamily(),shippingPort.getLeaders().get(x).getYear_of_Birth(),shippingPort.getLeaders().get(x).getPlace_of_Birth(),shippingPort.getLeaders().get(x).getJob().name(),shippingPort.getLeaders().get(x).getGender(),shippingPort.getLeaders().get(x).getEmployment_salary(),shippingPort.getLeaders().get(x).isEmployment_situation());

                }
            }
        }
    }
        public void ShowVehicles(int TerminalID){
            Terminal terminal=terminals.get(TerminalID);
            if(terminal instanceof Airport){
                Airport airport=(Airport) terminal;
                if(airport.getAir_vehicles().size()!=0){
                    for (int i=0;i<airport.getAir_vehicles().size();i++){
                        if(airport.getAir_vehicles().get(i)instanceof Passenger_plane){
                            Passenger_plane passenger_plane=(Passenger_plane)airport.getAir_vehicles().get(i);
                            System.out.format("(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Number Of Crew: %d , Aircraft Classification Seats: %d\n",i,passenger_plane.getPrice(),passenger_plane.getCapacity(),passenger_plane.getCompany_builder_name(),passenger_plane.getMaximum_flight_altitude(),passenger_plane.getBand_length_required_for_Landing(),passenger_plane.getNumber_of_crew(),passenger_plane.getAircraft_classification_seats());
                        }
                    }
                }else throw new ThereWasNoCar("ERROR:There is no Passenger Plane in this Terminal!");
            }else if(terminal instanceof RailwayStation){
                RailwayStation railwayStation=(RailwayStation) terminal;
                if (railwayStation.getTrains().size()!=0){
                    for (int i=0;i<railwayStation.getTrains().size();i++){
                        System.out.format("(ID:%d) Price: %d , Capacity: %d , Company Builder Name: %s , Fuel Type: %s , Ticket Price: %d , Number of wagons: %d , Number of stars: %d\n",i,railwayStation.getTrains().get(i).getPrice(),railwayStation.getTrains().get(i).getCapacity(),railwayStation.getTrains().get(i).getCompany_builder_name(),railwayStation.getTrains().get(i).getFuel_type(),railwayStation.getTrains().get(i).getTicket_price(),railwayStation.getTrains().get(i).getNumber_of_wagons(),railwayStation.getTrains().get(i).getNumber_of_stars());

                        for (int j=0;j<railwayStation.getTrains().get(i).getServises().size();j++){
                            System.out.format(" [Services%d: %s]",j+1,railwayStation.getTrains().get(i).getServises().get(j));
                        }
                        System.out.println();
                    }
                }else throw new ThereWasNoCar("ERROR:There is no Train in this Terminal!");

            }else if(terminal instanceof BusTerminal){
                BusTerminal busTerminal=(BusTerminal) terminal;
                if (busTerminal.getBuses().size()!=0){
                    for (int i=0;i<busTerminal.getBuses().size();i++){
                        System.out.format("(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Ticket Price: %d , Pollutant production by PPM: %d , Fuel consumption per kilometer by lit: %d\n",i,busTerminal.getBuses().get(i).getPrice(),busTerminal.getBuses().get(i).getCapacity(),busTerminal.getBuses().get(i).getCompany_builder_name(),busTerminal.getBuses().get(i).getFuel_type(),busTerminal.getBuses().get(i).getTicket_price(),busTerminal.getBuses().get(i).getPollutant_production_by_PPM(),busTerminal.getBuses().get(i).getFuel_consumption_per_kilometer_by_lit());
                    }
                }else throw new ThereWasNoCar("ERROR:There is no Bus in this Terminal!");

            }else if(terminal instanceof ShippingPort){
                ShippingPort shippingPort=(ShippingPort) terminal;
                if(shippingPort.getSea_vehicles().size()!=0){
                    for (int i=0;i<shippingPort.getSea_vehicles().size();i++){
                        if(shippingPort.getSea_vehicles().get(i)instanceof Ship){
                            Ship ship=(Ship) shippingPort.getSea_vehicles().get(i);
                            System.out.format("(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Number Of lifeboat: %d  ,Number Of Crew: %d \n ",i,ship.getPrice(),ship.getCapacity(),ship.getCompany_builder_name(),ship.getFuel_type(),ship.getMinimum_depth_to_move(),ship.getNumber_of_lifeboats(),ship.getNumber_of_crew());

                        }else {
                            Boat boat=(Boat) shippingPort.getSea_vehicles().get(i);
                            System.out.format("(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Fuel Type: %s , Minimum deep to move: %d ,Boat body type: %s\n ",i,boat.getPrice(),boat.getCapacity(),boat.getCompany_builder_name(),boat.getFuel_type(),boat.getMinimum_depth_to_move(),boat.getBoat_body_type());
                        }
                    }
                }else throw new ThereWasNoCar("ERROR:There is no Sea Vehicle in this Terminal!");
            }
        }
        public void showHotels(){
            for(int i=0;i<hotels.size();i++) {
                System.out.format("\n(ID:%d) Hotel name: %s , Construction cost: %d , Address: %s , Star number: %d , Number of rooms: %d , Constructed Situation: %s , ", i, hotels.get(i).getHotel_name(), hotels.get(i).getCost_Construction(), hotels.get(i).getAddress(), hotels.get(i).getStar_number(), hotels.get(i).getNumber_of_rooms(), hotels.get(i).isConstructed());
                for (int j = 0; j < hotels.get(i).getServises().size(); j++) {
                    System.out.format(" [Services%d: %s]", j + 1, hotels.get(i).getServises().get(j));
                }
                System.out.println();
                if (hotels.get(i).getCrews().size() != 0){
                    System.out.println("CREWS :");
                for (int k = 0; k < hotels.get(i).getCrews().size(); k++) {
                    System.out.format("(ID:%d) Name: %s , Family name: %s , Year of birth: %d , Place of birth: %s , Job: %s , Gender: %s , Employment salary: %d , Employment situation: %s\n", k, hotels.get(i).getCrews().get(k).getName(), hotels.get(i).getCrews().get(k).getFamily(), hotels.get(i).getCrews().get(k).getYear_of_Birth(), hotels.get(i).getCrews().get(k).getPlace_of_Birth(), hotels.get(i).getCrews().get(k).getJob().name(), hotels.get(i).getCrews().get(k).getGender(), hotels.get(i).getCrews().get(k).getEmployment_salary(), hotels.get(i).getCrews().get(k).isEmployment_situation());

                }
            }
            }
        }
        public void AddBank(Bank bank){
        banks.add(bank);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"\nThe New Bank Was Added!"+ConsoleColors.RESET);

        }
        public void ShowBanks(){
            for (int i=0;i<banks.size();i++){
                System.out.format(ConsoleColors.RED_BRIGHT+"(ID:%d) %s"+ConsoleColors.RESET,i,banks.get(i).bankInfo());
            }
        }
        public Bank ReturnBank(int ID){
            return banks.get(ID);
        }
    }

