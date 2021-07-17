package Main.controller;

import Main.Vehicles.Ship;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Ships implements Initializable {

    @FXML
    private TableView<Ship> boatTable;

    @FXML
    private TableColumn<Ship, Integer> ID;

    @FXML
    private TableColumn<Ship, Double> price;

    @FXML
    private TableColumn<Ship, Integer> capacity;

    @FXML
    private TableColumn<Ship, String> company;

    @FXML
    private TableColumn<Ship, Integer> movement;

    @FXML
    private TableColumn<Ship, String> fuel;

    @FXML
    private TableColumn<Ship, String> ship;

    @FXML
    private TableColumn<Ship, Integer> Ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        movement.setCellValueFactory(new PropertyValueFactory<>("Min_movement_depth"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        Ticket.setCellValueFactory(new PropertyValueFactory<>("ticketCost"));
        ship.setCellValueFactory(new PropertyValueFactory<>("ship_type"));

    }
}


