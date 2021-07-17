package Main.controller;
import Main.Vehicles.Inter_city_bus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Buses implements Initializable {

    @FXML
    private TableView<Inter_city_bus> boatTable;

    @FXML
    private TableColumn<Inter_city_bus, Integer> ID;

    @FXML
    private TableColumn<Inter_city_bus,Double> price;

    @FXML
    private TableColumn<Inter_city_bus, Integer> capacity;

    @FXML
    private TableColumn<Inter_city_bus,String> company;

    @FXML
    private TableColumn<Inter_city_bus, Integer> speed;

    @FXML
    private TableColumn<Inter_city_bus,String> fuel;

    @FXML
    private TableColumn<Inter_city_bus, String> bustype;

    @FXML
    private TableColumn<Inter_city_bus, Integer> Ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        speed.setCellValueFactory(new PropertyValueFactory<>("Max_speed"));
        bustype.setCellValueFactory(new PropertyValueFactory<>("bus_type"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        Ticket.setCellValueFactory(new PropertyValueFactory<>("ticketCost"));

    }
}
