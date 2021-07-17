package Main.controller;

import Main.Buildings.Railway_station;
import Main.Buildings.Terminal;
import Main.Country;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Railways implements Initializable {


    @FXML
    private TableView<Terminal> RailTable;

    @FXML
    private TableColumn<Railway_station,Integer> ID;

    @FXML
    private TableColumn<Railway_station,String> Name;

    @FXML
    private TableColumn<Railway_station,String> city;

    @FXML
    private TableColumn<Railway_station,String > Address;

    @FXML
    private TableColumn<Railway_station,Double> Cost;

    @FXML
    private TableColumn<Railway_station,Double> Area;

    @FXML
    private TableColumn<Railway_station,Integer> Vehicles;

    @FXML
    private TableColumn<Railway_station, Integer> InputRails;

    @FXML
    private TableColumn<Railway_station, Integer> OutputRails;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        city.setCellValueFactory(new PropertyValueFactory<>("City_name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Vehicles.setCellValueFactory(new PropertyValueFactory<>("Number_of_vehicles"));
        Area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        InputRails.setCellValueFactory(new PropertyValueFactory<>("input_rails"));
        OutputRails.setCellValueFactory(new PropertyValueFactory<>("output_rails"));

        for (Terminal x : Country.country.inputCity.getTerminals()) {
            if (x instanceof Railway_station) {
                RailTable.getItems().add(x);
            }
        }
    }

}
