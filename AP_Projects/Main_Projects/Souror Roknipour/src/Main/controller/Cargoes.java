package Main.controller;

import Main.Vehicles.Cargo_plane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Cargoes implements Initializable {
    @FXML
    private TableView<Cargo_plane> CargoTable;

    @FXML
    private TableColumn<Cargo_plane, Integer> ID;

    @FXML
    private TableColumn<Cargo_plane, Double> price;

    @FXML
    private TableColumn<Cargo_plane, Integer> capacity;

    @FXML
    private TableColumn<Cargo_plane, String> company;

    @FXML
    private TableColumn<Cargo_plane, String> fuel;

    @FXML
    private TableColumn<Cargo_plane, String> cargoType;

    @FXML
    private TableColumn<Cargo_plane, Integer> weight;

    @FXML
    private TableColumn<Cargo_plane, Integer> LandingLen;

    @FXML
    private TableColumn<Cargo_plane, Integer> Height;

    @FXML
    private TableColumn<Cargo_plane, Integer> Ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        LandingLen.setCellValueFactory(new PropertyValueFactory<>("Landing_strip_len"));
        Height.setCellValueFactory(new PropertyValueFactory<>("Max_flight_Height"));
        weight.setCellValueFactory(new PropertyValueFactory<>("Total_portable_weight"));
        cargoType.setCellValueFactory(new PropertyValueFactory<>("cargo_type"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        Ticket.setCellValueFactory(new PropertyValueFactory<>("ticketCost"));
    }
}
