package com.example.mohammad_es_faz4_gui.BackEnd;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Bank;
import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Terminal;
import com.example.mohammad_es_faz4_gui.BackEnd.Vehicles.Vehicle;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Country implements Serializable {
    public static final long TIME_CHANGE_COEFFICIENT = 61320;
    private static final Date startDate = new Date();
    private static boolean transactionsShown = true;
    private final ArrayList<City> cities = new ArrayList<>();
    private double countryBudget = 0;
    private double allInvestedMoney = 0;

    public Country(double countryBudget) {
        this.countryBudget = countryBudget;
    }

    public static long gameDate(long currentTimeMillis){
        return (currentTimeMillis - startDate.getTime()) * TIME_CHANGE_COEFFICIENT;
    }

    public static int searchPersonID(List<Person> list, int keyID) {
        Collections.sort(list);
        int low = 0;
        int high = list.size()-1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid).getID();
            int cmp = Integer.compare(midVal, keyID);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int searchTerminalID(List<Terminal> list, int keyID) {
        Collections.sort(list);
        int low = 0;
        int high = list.size()-1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid).getID();
            int cmp = Integer.compare(midVal, keyID);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int searchVehicleID(List<Vehicle> list, int keyID) {
        Collections.sort(list);
        int low = 0;
        int high = list.size()-1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid).getID();
            int cmp = Integer.compare(midVal, keyID);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static ArrayList<String> sellListReader(String fileName, int orderNumber) throws IOException {
        CsvListReader csvListReader = new CsvListReader(new FileReader(fileName), CsvPreference.STANDARD_PREFERENCE);
        int i = 0;
        while (i++ != orderNumber)
            csvListReader.read();
        return (ArrayList<String>) csvListReader.read();
    }

    public static boolean isTransactionsShown() {
        return transactionsShown;
    }

    public static void setTransactionsShown(boolean transactionsShown) {
        Country.transactionsShown = transactionsShown;
    }

    public double getCountryBudget() {
        countryBudget = 0;
        for (City city : cities)
            countryBudget += city.getMoney();
        return countryBudget;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public double getAllInvestedMoney() {
        allInvestedMoney = 0;
        for (City city: cities)
            for (Bank bank: city.getBanks())
                allInvestedMoney += bank.getAllMoney();
        return allInvestedMoney;
    }

    public static String toStringDate(Date fullDate){
        StringBuilder date = new StringBuilder();
        String[] splitDate = fullDate.toString().split(" ");
        date.append(splitDate[0]).append(", ").append(splitDate[2]).append(' ').append(splitDate[1]).append(' ').append(splitDate[5]).append(' ');
        return date.toString();
    }
}
