package Main.controller;

import Main.City;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Cities implements Initializable {

    @FXML
    private TableView<City> CitiesTable;

    @FXML
    private TableColumn<City, Integer> ID;

    @FXML
    private TableColumn<City, String> Name;

    @FXML
    private TableColumn<City, Integer> Inventory;

    @FXML
    private TableColumn<City, Integer> population;

    @FXML
    private TableColumn<City, Integer> Terminals;

    @FXML
    private TableColumn<City, Integer> Hotels;

    @FXML
    private TableColumn<City, Integer> Banks;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("cityID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Inventory.setCellValueFactory(new PropertyValueFactory<>("Inventory"));
        population.setCellValueFactory(new PropertyValueFactory<>("population"));
        Terminals.setCellValueFactory(new PropertyValueFactory<>("TerminalSize"));
        Hotels.setCellValueFactory(new PropertyValueFactory<>("HotelSize"));
        Banks.setCellValueFactory(new PropertyValueFactory<>("BankSize"));

    }
}
