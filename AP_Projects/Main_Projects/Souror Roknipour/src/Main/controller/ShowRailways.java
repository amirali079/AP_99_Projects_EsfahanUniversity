package Main.controller;

import Main.Buildings.Railway_station;
import Main.Person;
import Main.Vehicles.Train;
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

public class ShowRailways implements Initializable {

    TableView<Railway_station> TView;
    TableView<Person> LView;
    TableView<Train> TrainView;
    @FXML
    private VBox TRoot;

    @FXML
    private VBox TrainRoot;

    @FXML
    private VBox LRoot;

    @FXML
    void Select(ActionEvent event) {
        if (!TView.getSelectionModel().isEmpty()) {
            Railway_station railwayStation = TView.getSelectionModel().getSelectedItem();
            LView.getItems().clear();
            TrainView.getItems().clear();
            LView.getItems().addAll(railwayStation.getLeaders());
            TrainView.getItems().addAll(railwayStation.getTrains());
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Railways.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        TRoot.getChildren().add(loader.getRoot());
        TView = loader.getRoot();
        //--------------------------------------------------------
        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Citizens.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        LRoot.getChildren().add(loader2.getRoot());
        LView = loader2.getRoot();
        //----------------------------------------------------------
        FXMLLoader loader3 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Trains.fxml"));
        try {
            loader3.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        TrainRoot.getChildren().add(loader3.getRoot());
        TrainView = loader3.getRoot();
    }
}
