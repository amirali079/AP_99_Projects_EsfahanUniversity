package Main.controller;

import Main.Buildings.Shipping_port;
import Main.Buildings.Terminal;
import Main.Country;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ShippingPorts implements Initializable {

    @FXML
    private TableView<Terminal> PortTable;

    @FXML
    private TableColumn<Shipping_port,Integer> ID;

    @FXML
    private TableColumn<Shipping_port,String> Name;

    @FXML
    private TableColumn<Shipping_port,String> city;

    @FXML
    private TableColumn<Shipping_port,String > Address;

    @FXML
    private TableColumn<Shipping_port,Double> Cost;

    @FXML
    private TableColumn<Shipping_port,Double> Area;

    @FXML
    private TableColumn<Shipping_port,Integer> Vehicles;

    @FXML
    private TableColumn<Shipping_port,Integer> piers;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        city.setCellValueFactory(new PropertyValueFactory<>("City_name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Vehicles.setCellValueFactory(new PropertyValueFactory<>("Number_of_vehicles"));
        piers.setCellValueFactory(new PropertyValueFactory<>("piers"));
        Area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        for (Terminal x : Country.country.inputCity.getTerminals()) {
            if (x instanceof Shipping_port) {
                PortTable.getItems().add(x);
            }
        }
    }
}
