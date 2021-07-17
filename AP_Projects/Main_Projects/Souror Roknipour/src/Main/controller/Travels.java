package Main.controller;

import Main.Buildings.Terminal;
import Main.Country;
import Main.trip.Travel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Travels implements Initializable {

    @FXML
    private TableView<Travel> TravelTable;

    @FXML
    private TableView<Terminal> terminalTable;

    @FXML
    private TableColumn<Terminal, String> toString;

    private Terminal terminal;
    @FXML
    private TableColumn<Travel, Integer> ID;

    @FXML
    private TableColumn<Travel, String> Date;

    @FXML
    private TableColumn<Travel, Integer> Cost;

    @FXML
    private TableColumn<Travel, String> Origin;

    @FXML
    private TableColumn<Travel, String> DesT;

    @FXML
    private TableColumn<Travel, String> DesCity;

    @FXML
    private TableColumn<Travel, String> VehicleID;

    @FXML
    private ChoiceBox<String> Type;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            Origin.setCellValueFactory(new PropertyValueFactory<>("originT"));
            Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
            DesCity.setCellValueFactory(new PropertyValueFactory<>("desCity"));
            DesT.setCellValueFactory(new PropertyValueFactory<>("desT"));
            Date.setCellValueFactory(new PropertyValueFactory<>("date"));
            VehicleID.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
            toString.setCellValueFactory(new PropertyValueFactory<>("toString"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (Country.country.inputCity.getTerminals().size() > 0) {
            terminalTable.getItems().addAll(Country.country.inputCity.getTerminals());
        }
    }

    @FXML
    void Both(ActionEvent event) {
        TravelTable.getItems().clear();
        if (!terminalTable.getSelectionModel().isEmpty()) {
            terminal = terminalTable.getSelectionModel().getSelectedItem();
            TravelTable.getItems().addAll(terminal.getTravels());

        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void InComing(ActionEvent event) {
        TravelTable.getItems().clear();
        if (!terminalTable.getSelectionModel().isEmpty()) {
            terminal = terminalTable.getSelectionModel().getSelectedItem();
            for (Travel x : terminal.getTravels()) if (!x.isOutGoing()) TravelTable.getItems().add(x);

        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void outGoing(ActionEvent event) {
        TravelTable.getItems().clear();
        if (!terminalTable.getSelectionModel().isEmpty()) {
            terminal = terminalTable.getSelectionModel().getSelectedItem();
            for (Travel x : terminal.getTravels()) if (x.isOutGoing()) TravelTable.getItems().add(x);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
