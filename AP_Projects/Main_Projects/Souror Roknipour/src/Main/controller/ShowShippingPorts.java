package Main.controller;

import Main.Buildings.Shipping_port;
import Main.Person;
import Main.Vehicles.Marine_vehicles;
import Main.Vehicles.Ship;
import Main.Vehicles.boat;
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

public class ShowShippingPorts implements Initializable {

    TableView<Ship> ShipView;
    TableView<boat> BoatView;
    TableView<Person> LView;
    TableView<Shipping_port> TView;

    @FXML
    private VBox TRoot;


    @FXML
    private VBox ShipRoot;

    @FXML
    private VBox BoatsRoot;

    @FXML
    private VBox LRoot;

    @FXML
    void Select(ActionEvent event) {
        if (!TView.getSelectionModel().isEmpty()) {
            Shipping_port port = TView.getSelectionModel().getSelectedItem();
            LView.getItems().addAll(port.getLeaders());
            for (Marine_vehicles x : port.getMarine_vehicles()) {
                if (x instanceof Ship) ShipView.getItems().add((Ship) x);
                if (x instanceof boat) BoatView.getItems().add((boat) x);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/ShippingPorts.fxml"));
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
        FXMLLoader loader3 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Ships.fxml"));
        try {
            loader3.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ShipRoot.getChildren().add(loader3.getRoot());
        ShipView = loader3.getRoot();
        //-------------------------------------------------------------
        FXMLLoader loader4 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Boats.fxml"));
        try {
            loader4.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        BoatsRoot.getChildren().add(loader4.getRoot());
        BoatView = loader4.getRoot();
    }
}
