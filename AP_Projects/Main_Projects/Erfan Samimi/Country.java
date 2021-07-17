package Main;

import Main.Bank.Bank;

import java.util.ArrayList;

public class Country {

    static ArrayList<City> citiesList = City.getCitiesList();


    public static int getNumberOfCity(){

        return City.getCitiesList().size();

    }

    public static int totalPopulation (){

        int population =0 ;

        for (City c : citiesList){
            population += c.getPopulation();
        }

        return population;
    }

    public static int totalBudget(){

        int budget = 0 ;
        for (City c : citiesList){
            budget += c.getBudget();
        }

        return budget;
    }

    public static double getTotalMoneyInBanks(){

        double money =0;

        for (City city : City.getCitiesList()){

            for(Bank a : city.getBanks() ){

                money += a.getTotalMoney();

            }

        }

        return money;


    }

    

}
