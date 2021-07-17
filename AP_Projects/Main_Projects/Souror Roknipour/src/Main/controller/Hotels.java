package Main.controller;

import Main.Buildings.Hotel;
import Main.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class Hotels implements Initializable {

    @FXML
    private TableView<Hotel> HotelTable;

    @FXML
    private TableColumn<Hotel, Integer> ID;

    @FXML
    private TableColumn<Hotel, String> Name;

    @FXML
    private TableColumn<Hotel, String> Address;

    @FXML
    private TableColumn<Hotel, Integer> Room;

    @FXML
    private TableColumn<Hotel, Double> Cost;

    @FXML
    private TableColumn<Hotel, String> Star;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Room.setCellValueFactory(new PropertyValueFactory<>("Number_of_rooms"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        Star.setCellValueFactory(new PropertyValueFactory<>("Star"));

        HotelTable.getItems().addAll(Country.country.inputCity.getHotels());
    }

    public TableView<Hotel> getHotelTable() {
        return HotelTable;
    }
}

