package Main.controller;

import Main.Buildings.Bus_Terminal;
import Main.Person;
import Main.Vehicles.Inter_city_bus;
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

public class ShowBusTerminals implements Initializable {

    TableView<Bus_Terminal> TView;
    TableView<Person> LView;
    TableView<Inter_city_bus> BusView;
    @FXML
    private VBox TRoot;

    @FXML
    private VBox BusRoot;

    @FXML
    private VBox LRoot;

    @FXML
    void Select(ActionEvent event) {
        if (!TView.getSelectionModel().isEmpty()) {
            Bus_Terminal terminal = TView.getSelectionModel().getSelectedItem();
            LView.getItems().clear();
            BusView.getItems().clear();
            LView.getItems().addAll(terminal.getLeaders());
            BusView.getItems().addAll(terminal.getBuses());
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/BusTerminals.fxml"));
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
        FXMLLoader loader3 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Buses.fxml"));
        try {
            loader3.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        BusRoot.getChildren().add(loader3.getRoot());
        BusView = loader3.getRoot();

    }
}
