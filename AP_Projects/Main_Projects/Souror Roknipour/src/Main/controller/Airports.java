package Main.controller;

import Main.Buildings.Airport;
import Main.Buildings.Bus_Terminal;
import Main.Buildings.Terminal;
import Main.Country;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Airports implements Initializable {


    @FXML
    private TableView<Terminal> AirPortTable;

    @FXML
    private TableColumn<Airport,Integer> ID;

    @FXML
    private TableColumn<Airport,String> Name;

    @FXML
    private TableColumn<Airport,String> city;

    @FXML
    private TableColumn<Airport,String > Address;

    @FXML
    private TableColumn<Airport,Double> Cost;

    @FXML
    private TableColumn<Airport,Double> Area;

    @FXML
    private TableColumn<Airport,Integer> Vehicles;

    @FXML
    private TableColumn<Airport, Integer> Runways;

    @FXML
    private TableColumn<Airport,Boolean> international;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        city.setCellValueFactory(new PropertyValueFactory<>("City_name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Vehicles.setCellValueFactory(new PropertyValueFactory<>("Number_of_vehicles"));
        international.setCellValueFactory(new PropertyValueFactory<>("international"));
        Runways.setCellValueFactory(new PropertyValueFactory<>("Number_of_runways"));
        Area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        for (Terminal x : Country.country.inputCity.getTerminals()) {
            if (x instanceof Airport) {
                AirPortTable.getItems().add(x);
            }
        }
    }
}
