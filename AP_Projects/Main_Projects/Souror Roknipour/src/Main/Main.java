package Main;

import Main.Buildings.Bank.Bank;
import Main.Buildings.Bank.BankAccount;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;


public class Main extends Application {

    static void addPeople() {

        Country.country.addPerson("Sorour", "Rokni", "Dezful", Person.Job.Pilot, 1999, City.Cost.Pilot.getCost(), Person.Gender.Female);
        Country.country.addPerson("Reza", "Lotfi", "Tehran", Person.Job.Bus_driver, 2000, City.Cost.Bus_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Ali", "Shahabi", "Isfahan", Person.Job.Locomotive_driver, 1990, City.Cost.Locomotive_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Sara", "Safaei", "Shiraz", Person.Job.Crew, 1998, City.Cost.Crew.getCost(), Person.Gender.Female);
        Country.country.addPerson("Zahra", "Rahimi", "Yazd", Person.Job.Crew, 1999, City.Cost.Crew.getCost(), Person.Gender.Female);
        Country.country.addPerson("Amir", "Jahandari", "Tehran", Person.Job.Sailor, 1989, City.Cost.Sailor.getCost(), Person.Gender.Male);
        Country.country.addPerson("Saeid", "Ebrahimi", "Kashan", Person.Job.Bus_driver, 1996, City.Cost.Bus_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Taha", "Davari", "Ahvaz", Person.Job.Sailor, 1990, City.Cost.Sailor.getCost(), Person.Gender.Male);
        Country.country.addPerson("Mohammad", "Akbari", "Karaj", Person.Job.Sailor, 1988, City.Cost.Sailor.getCost(), Person.Gender.Male);
        Country.country.addPerson("Naser", "Sadeghi", "Tabriz", Person.Job.Locomotive_driver, 1980, City.Cost.Locomotive_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Maryam", "Safavi", "Mashhad", Person.Job.Crew, 1990, City.Cost.Crew.getCost(), Person.Gender.Female);
        Country.country.addPerson("Behnoush", "Bahadori", "Kerman", Person.Job.Crew, 1995, City.Cost.Crew.getCost(), Person.Gender.Female);
        Country.country.addPerson("Arash", "Madani", "Arak", Person.Job.Locomotive_driver, 1994, City.Cost.Locomotive_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Ahmad", "Dehghan", "Sari", Person.Job.Bus_driver, 1989, City.Cost.Bus_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Parsa", "Pirouzfar", "Hamedan", Person.Job.Locomotive_driver, 1988, City.Cost.Locomotive_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Parisa", "Asadi", "Sari", Person.Job.Sailor, 1987, City.Cost.Sailor.getCost(), Person.Gender.Female);
        Country.country.addPerson("Pourya", "Nazari", "Yazd", Person.Job.Sailor, 1989, City.Cost.Sailor.getCost(), Person.Gender.Male);
        Country.country.addPerson("Yalda", "Namjo", "Dezful", Person.Job.Pilot, 1980, City.Cost.Pilot.getCost(), Person.Gender.Female);
        Country.country.addPerson("Kian", "Nikzad", "Ahvaz", Person.Job.Pilot, 1982, City.Cost.Pilot.getCost(), Person.Gender.Male);
        Country.country.addPerson("Raha", "Kamyar", "Isfahan", Person.Job.Crew, 1992, City.Cost.Crew.getCost(), Person.Gender.Female);
        Country.country.addPerson("Arad", "Behrouzi", "Tehran", Person.Job.Bus_driver, 1995, City.Cost.Bus_driver.getCost(), Person.Gender.Male);
        Country.country.addPerson("Sheyda", "Shivaei", "Karaj", Person.Job.Pilot, 1988, City.Cost.Pilot.getCost(), Person.Gender.Female);

        Country.country.addCity("Capital");
        Country.country.getCities(1).addCitizens(Country.country.getCitizens());
        Country.country.save();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //file-----------------------------------
        File file = new File("Country.txt");
        if (file.length() == 0) {
            Country.country = new Country(file);
            addPeople();
        } else {
            ObjectInputStream Obj = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
            Country.country = (Country) Obj.readObject();
            startThreads();
        }
        //----------------------------------------

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("view/CountryPge/CountryPage.fxml"));
        loader.load();
        stage.setScene(new Scene(loader.getRoot()));
        stage.setOnCloseRequest(e -> {
            Country.country.save();
            System.exit(0);
        });
        stage.show();
    }

    public static void startThreads(){
        for (City city : Country.country.getCities()){
            for (Bank bank : city.getBanks()){
                for (BankAccount account : bank.getBankAccounts()){
                    account.Operation();
                }
            }
        }
        Country.country.StartTime();
    }
}

