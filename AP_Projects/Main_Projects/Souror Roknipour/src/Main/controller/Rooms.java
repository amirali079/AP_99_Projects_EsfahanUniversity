package Main.controller;

import Main.Buildings.Room;
import Main.Country;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Rooms implements Initializable {

    @FXML
    private TableView<Room> RoomTable;

    @FXML
    private TableColumn<Room,Integer> ID;

    @FXML
    private TableColumn<Room,Integer> Area;

    @FXML
    private TableColumn<Room, Integer> Beds;

    @FXML
    private TableColumn<Room, Double> Cost;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Area.setCellValueFactory(new PropertyValueFactory<>("Area"));
        Beds.setCellValueFactory(new PropertyValueFactory<>("beds"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("Room_price"));
    }

    public TableView<Room> getRoomTable() {
        return RoomTable;
    }
}

