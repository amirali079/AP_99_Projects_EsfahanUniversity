package Main.controller;

import Main.Buildings.Hotel;
import Main.Buildings.Room;
import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowHotels implements Initializable {

    TableView<Hotel> HView;
    TableView<Room> RView;
    @FXML
    private VBox HRoot;

    @FXML
    private VBox RRoot;

    @FXML
    void Select(ActionEvent event) {
        if (!HView.getSelectionModel().isEmpty()) {
            Hotel hotel = HView.getSelectionModel().getSelectedItem();
            RView.getItems().clear();
            RView.getItems().addAll(hotel.getRooms());
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Hotels.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        HRoot.getChildren().add(loader.getRoot());
        HView = loader.getRoot();

        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Rooms.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        RRoot.getChildren().add(loader2.getRoot());
        Rooms rooms = loader2.getController();
        RView = rooms.getRoomTable();
    }
}

