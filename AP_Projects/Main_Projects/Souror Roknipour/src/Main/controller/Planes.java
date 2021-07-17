package Main.controller;

import Main.Vehicles.Passenger_aircraft;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Planes implements Initializable {
    @FXML
    private TableView<Passenger_aircraft> PlaneTable;

    @FXML
    private TableColumn<Passenger_aircraft, Integer> ID;

    @FXML
    private TableColumn<Passenger_aircraft, Double> price;

    @FXML
    private TableColumn<Passenger_aircraft, Integer> capacity;

    @FXML
    private TableColumn<Passenger_aircraft, String> company;

    @FXML
    private TableColumn<Passenger_aircraft, String> fuel;

    @FXML
    private TableColumn<Passenger_aircraft, String> seatClass;

    @FXML
    private TableColumn<Passenger_aircraft, Integer> crews;

    @FXML
    private TableColumn<Passenger_aircraft, Integer> LandingLen;

    @FXML
    private TableColumn<Passenger_aircraft, Integer> Height;

    @FXML
    private TableColumn<Passenger_aircraft, Integer> Ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        LandingLen.setCellValueFactory(new PropertyValueFactory<>("Landing_strip_len"));
        Height.setCellValueFactory(new PropertyValueFactory<>("Max_flight_Height"));
        seatClass.setCellValueFactory(new PropertyValueFactory<>("seatClass"));
        crews.setCellValueFactory(new PropertyValueFactory<>("crew_number"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        Ticket.setCellValueFactory(new PropertyValueFactory<>("ticketCost"));
    }
}
