package Main.controller;

import Main.Buildings.Airport;
import Main.Person;
import Main.Vehicles.*;
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

public class ShowAirports implements Initializable {

    TableView<Airport> TView;
    TableView<Person> LView;
    TableView<Passenger_aircraft> PlaneView;
    TableView<Cargo_plane> CargoView;

    @FXML
    private VBox TRoot;

    @FXML
    private VBox planeRoot;

    @FXML
    private VBox CargoRoot;

    @FXML
    private VBox LRoot;

    @FXML
    void Select(ActionEvent event) {
        if (!TView.getSelectionModel().isEmpty()) {
            Airport airport = TView.getSelectionModel().getSelectedItem();
            LView.getItems().clear();
            PlaneView.getItems().clear();
            CargoView.getItems().clear();
            LView.getItems().addAll(airport.getLeaders());
            for (Air_vehicles x : airport.getAir_vehicles()) {
                if (x instanceof Passenger_aircraft) PlaneView.getItems().add((Passenger_aircraft) x);
                if (x instanceof Cargo_plane) CargoView.getItems().add((Cargo_plane) x);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Airports.fxml"));
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
        FXMLLoader loader3 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Planes.fxml"));
        try {
            loader3.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        planeRoot.getChildren().add(loader3.getRoot());
        PlaneView = loader3.getRoot();
        //-------------------------------------------------------------
        FXMLLoader loader4 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Cargoes.fxml"));
        try {
            loader4.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        CargoRoot.getChildren().add(loader4.getRoot());
        CargoView = loader4.getRoot();
    }
}
