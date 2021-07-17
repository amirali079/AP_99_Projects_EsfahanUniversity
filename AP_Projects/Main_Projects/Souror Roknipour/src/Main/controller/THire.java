package Main.controller;

import Main.Buildings.Bus_Terminal;
import Main.Country;
import Main.Person;
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

public class THire implements Initializable {

    TableView<Bus_Terminal> TView;
    TableView<Person> LView;
    Bus_Terminal busTerminal;
    Person leader;
    @FXML
    private VBox TRoot;

    @FXML
    private VBox LRoot;


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

        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Citizens.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        LRoot.getChildren().add(loader2.getRoot());
        LView = loader2.getRoot();
        for (Person x : Country.country.inputCity.getCitizens()) {
            if (x.getJob().equals(Person.Job.Bus_driver)) LView.getItems().addAll(x);
        }
    }

    @FXML
    void SelectLeader(ActionEvent event) {
        if (busTerminal != null && !LView.getSelectionModel().isEmpty()) {
            leader = LView.getSelectionModel().getSelectedItem();
            busTerminal.addLeaders(leader);
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void SelectTerminal(ActionEvent event) {
        if (!TView.getSelectionModel().isEmpty()) {
            busTerminal = TView.getSelectionModel().getSelectedItem();
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
