package Main.controller;

import Main.Buildings.Airport;
import Main.Buildings.Terminal;
import Main.City;
import Main.Country;
import Main.Person;
import Main.Vehicles.Air_vehicles;
import Main.Vehicles.Passenger_aircraft;
import Main.Vehicles.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AirTravel implements Initializable {
    @FXML
    private TableView<Person> LView;
    @FXML
    private TableView<Passenger_aircraft> AirView;
    @FXML
    private TableView<Airport> desTView;
    @FXML
    private TableView<Airport> OriTView;
    @FXML
    private TableView<City> CityView;
    @FXML
    private TableView<Person> PassengersView;

    private ArrayList<Person> passengers = new ArrayList<>();
    private Person driver;
    private Airport terminal;
    private Airport DesRailway;
    private Passenger_aircraft plane;
    private City desCity;

    @FXML
    private BorderPane DesCityRoot;

    @FXML
    private BorderPane desTRoot;

    @FXML
    private BorderPane originTRoot;

    @FXML
    private BorderPane vehicleRoot;

    @FXML
    private BorderPane driverRoot;

    @FXML
    private BorderPane passengerRoot;

    @FXML
    void DesCityBTN(ActionEvent event) {
        if (!CityView.getSelectionModel().isEmpty()) {
            desCity = CityView.getSelectionModel().getSelectedItem();
            desTView.getItems().clear();
            for (Terminal x : desCity.getTerminals()) {
                if (x instanceof Airport) desTView.getItems().add((Airport) x);
            }
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void DesTBTN(ActionEvent event) {
        if (!desTView.getSelectionModel().isEmpty()) {
            DesRailway = desTView.getSelectionModel().getSelectedItem();
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void DoneBTN(ActionEvent event) {
        if (passengers != null && driver != null && DesRailway != null && terminal != null && plane != null && desCity != null) {
            if (checkCapacity(1 + passengers.size(), plane) || checkFullCapacity(1 + passengers.size(), plane)) {
                JOptionPane.showMessageDialog(null, "Error in Capacity!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                terminal.travel(DesRailway, plane, driver, passengers);
                passengers.clear();
                driver = null;
                plane = null;
                DesRailway = null;
                terminal = null;
                desCity = null;
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @FXML
    void DriverBTN(ActionEvent event) {
        if (!LView.getSelectionModel().isEmpty()) {
            driver = LView.getSelectionModel().getSelectedItem();
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void PassengerBTN(ActionEvent event) {
        try {
            if (!PassengersView.getSelectionModel().isEmpty()) {
                passengers.addAll(PassengersView.getSelectionModel().getSelectedItems());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    void originBTN(ActionEvent event) {
        if (!OriTView.getSelectionModel().isEmpty()) {
            terminal = OriTView.getSelectionModel().getSelectedItem();
            for (Air_vehicles x : terminal.getAir_vehicles()) {
                if (x instanceof Passenger_aircraft) AirView.getItems().add((Passenger_aircraft) x);
            }
            LView.getItems().addAll(terminal.getLeaders());
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @FXML
    void vehicleBTN(ActionEvent event) {
        if (!AirView.getSelectionModel().isEmpty()) {
            plane = AirView.getSelectionModel().getSelectedItem();
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkCapacity(int num, Vehicle vehicle) {
        if (num < (vehicle.getCapacity() / 2)) {
            return true;
        } else return false;
    }

    private boolean checkFullCapacity(int num, Vehicle vehicle) {

        if (num <= vehicle.getCapacity()) {
            return false;
        } else return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Airports.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        originTRoot.setCenter(loader.getRoot());
        OriTView = loader.getRoot();
        //--------------------------------------------------------
        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Airports.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        desTRoot.setCenter(loader2.getRoot());
        desTView = loader2.getRoot();
        //--------------------------------------------------------
        FXMLLoader loader3 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Citizens.fxml"));
        try {
            loader3.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        passengerRoot.setCenter(loader3.getRoot());
        PassengersView = loader3.getRoot();
        PassengersView.getItems().addAll(Country.country.inputCity.getCitizens());
        PassengersView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //----------------------------------------------------------
        FXMLLoader loader4 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Citizens.fxml"));
        try {
            loader4.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        driverRoot.setCenter(loader4.getRoot());
        LView = loader4.getRoot();
        //----------------------------------------------------------
        FXMLLoader loader5 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Planes.fxml"));
        try {
            loader5.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        vehicleRoot.setCenter(loader5.getRoot());
        AirView = loader5.getRoot();
        //-------------------------------------------------------------
        FXMLLoader loader6 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Cities.fxml"));
        try {
            loader6.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        DesCityRoot.setCenter(loader6.getRoot());
        CityView = loader6.getRoot();
        CityView.getItems().addAll(Country.country.getCities());
        CityView.getItems().remove(Country.country.inputCity);

    }
}