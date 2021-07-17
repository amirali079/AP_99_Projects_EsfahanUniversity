package Main.controller;

import Main.Buildings.Hotel;
import Main.City;
import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuildRoom implements Initializable {

    @FXML
    TableView<Hotel> view;

    @FXML
    private VBox root;

    @FXML
    private Spinner<Integer> area;

    @FXML
    private Spinner<Integer> beds;

    @FXML
    void done(ActionEvent event) {
        if (City.Cost.Room.getCost() > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (view.getSelectionModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                Hotel hotel = view.getSelectionModel().getSelectedItem();
                hotel.addRoom(area.getValue(), beds.getValue());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        beds.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 8, 2, 1));
        area.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(12, 48, 12, 6));

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Hotels.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        root.getChildren().add(loader.getRoot());
        Hotels hotels = loader.getController();
        view = hotels.getHotelTable();
    }

}
