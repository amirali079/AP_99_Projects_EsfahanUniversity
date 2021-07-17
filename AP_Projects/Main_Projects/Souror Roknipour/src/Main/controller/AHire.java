package Main.controller;

import Main.Buildings.Airport;
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

public class AHire implements Initializable {

    TableView<Airport> TView;
    TableView<Person> LView;
    Airport airport;
    Person leader;
    @FXML
    private VBox TRoot;

    @FXML
    private VBox LRoot;

    @FXML
    void SelectLeader(ActionEvent event) {
        if (airport != null && !LView.getSelectionModel().isEmpty()) {
            leader = LView.getSelectionModel().getSelectedItem();
            airport.addLeaders(leader);
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void SelectTerminal(ActionEvent event) {
        if (!TView.getSelectionModel().isEmpty()) {
            airport = TView.getSelectionModel().getSelectedItem();
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

        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Citizens.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        LRoot.getChildren().add(loader2.getRoot());
        LView = loader2.getRoot();
        for (Person x : Country.country.inputCity.getCitizens()) {
            if (x.getJob().equals(Person.Job.Pilot) || x.getJob().equals(Person.Job.Crew)) LView.getItems().addAll(x);
        }

    }
}
