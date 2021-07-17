package Main;
import Main.Exception.ThereWasNoDestinationCity;

import java.util.ArrayList;

public class Country {
    private final static ArrayList<City>cities=new ArrayList<>();
    public static int TotalPopulation=0;
    public static double TotalBudget=0;
    public static double Total_money_of_all_accounts=0;


    public static void AddCapital(City capital){
        cities.add(capital);
    }

    public static void AddCity(String CityName){
        City city=new City(CityName);
        cities.add(city);
    }


    public static ArrayList<City> getCities() {
        return cities;
    }

    public static void ShowCities(){
        System.out.println("\n*************************************************************SHOW ALL CITIES*************************************************************");
        for (int i=0;i<cities.size();i++){
            System.out.format("\n(ID:%d) City Name: %s\n",i,cities.get(i).getCityName());
        }
    }
    public static void showCities(){
        for (int i=0;i<cities.size();i++){
            System.out.format(ConsoleColors.CYAN_BOLD_BRIGHT+"%S CITY\n"+ConsoleColors.RESET,cities.get(i).getCityName());
            cities.get(i).showTerminals();
            cities.get(i).showHotels();

        }
    }
    public static void ShowCitiesWithoutBeginningCity(City BeginningCity){
        if (cities.size()-1!=0){
            System.out.println("\n*************************************************************SHOW ALL CITIES*************************************************************");
            for (int i=0;i<cities.size();i++){
                if (!(cities.get(i).getCityName().equals(BeginningCity.getCityName()))){
                    System.out.format("\n(ID:%d) City Name: %s\n",i,cities.get(i).getCityName());
                }
            }
        }else throw new ThereWasNoDestinationCity("ERROR:There Was No any Destination City!");

    }

    public static City EnterACity(int number){
      return cities.get(number);
    }
    public static void ShowBudgetAndPopulation(){
        System.out.format(ConsoleColors.YELLOW_BRIGHT+"(\uD83D\uDC6B:%d \uD83D\uDCB0:%f \uD83C\uDFE6:%f)\n"+ConsoleColors.RESET,Country.TotalPopulation,Country.TotalBudget,Country.Total_money_of_all_accounts);

    }
    public static void AddCitiesFromFile(City city){
        cities.add(city);
    }
}
