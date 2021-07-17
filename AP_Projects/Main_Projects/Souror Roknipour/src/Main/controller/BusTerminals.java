package Main.controller;

import Main.Buildings.Bus_Terminal;
import Main.Buildings.Terminal;
import Main.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class BusTerminals implements Initializable {

    @FXML
    private TableView<Terminal> terminalTable;

    @FXML
    private TableColumn<Bus_Terminal,Integer> ID;

    @FXML
    private TableColumn<Bus_Terminal,String> Name;

    @FXML
    private TableColumn<Bus_Terminal,String> city;

    @FXML
    private TableColumn<Bus_Terminal,String > Address;

    @FXML
    private TableColumn<Bus_Terminal,Double> Cost;

    @FXML
    private TableColumn<Bus_Terminal,Double> Area;

    @FXML
    private TableColumn<Bus_Terminal,Integer> Vehicles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        city.setCellValueFactory(new PropertyValueFactory<>("City_name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Vehicles.setCellValueFactory(new PropertyValueFactory<>("Number_of_vehicles"));
        Area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        for (Terminal x : Country.country.inputCity.getTerminals()) {
            if (x instanceof Bus_Terminal) {
                terminalTable.getItems().add(x);
            }
        }
    }
}


