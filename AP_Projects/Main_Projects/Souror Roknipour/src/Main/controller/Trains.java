package Main.controller;

import Main.Vehicles.Train;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.naming.spi.InitialContextFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class Trains implements Initializable {

    @FXML
    private TableView<Train> TrainTable;

    @FXML
    private TableColumn<Train, Integer> ID;

    @FXML
    private TableColumn<Train, Double> price;

    @FXML
    private TableColumn<Train, Integer> capacity;

    @FXML
    private TableColumn<Train, String> company;

    @FXML
    private TableColumn<Train, Integer> speed;

    @FXML
    private TableColumn<Train, Integer> wagons;

    @FXML
    private TableColumn<Train, String> fuel;

    @FXML
    private TableColumn<Train, String> stars;

    @FXML
    private TableColumn<Train,Integer> Ticket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        speed.setCellValueFactory(new PropertyValueFactory<>("Max_speed"));
        wagons.setCellValueFactory(new PropertyValueFactory<>("Number_of_wagons"));
        stars.setCellValueFactory(new PropertyValueFactory<>("star"));
        fuel.setCellValueFactory(new PropertyValueFactory<>("fuel_type"));
        Ticket.setCellValueFactory(new PropertyValueFactory<>("ticketCost"));

    }
}


