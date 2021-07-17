package Main.controller;

import Main.Main;
import Main.Vehicles.boat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Boats implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        movement.setCellValueFactory(new PropertyValueFactory<>("Min_movement_depth"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        boat.setCellValueFactory(new PropertyValueFactory<>("boat_type"));
        oars.setCellValueFactory(new PropertyValueFactory<>("Number_of_oars"));
        Ticket.setCellValueFactory(new PropertyValueFactory<>("ticketCost"));

    }

    @FXML
    private TableColumn<boat, Integer> ID;

    @FXML
    private TableColumn<boat, Double> price;

    @FXML
    private TableColumn<boat, Integer> capacity;

    @FXML
    private TableColumn<boat, String> company;

    @FXML
    private TableColumn<boat, Integer> movement;

    @FXML
    private TableColumn<boat, String> fuel;

    @FXML
    private TableColumn<boat, String> boat;

    @FXML
    private TableColumn<boat, Integer> oars;

    @FXML
    private TableColumn<boat, Integer> Ticket;

    @FXML
    private TableView<boat> boatTable;


}

