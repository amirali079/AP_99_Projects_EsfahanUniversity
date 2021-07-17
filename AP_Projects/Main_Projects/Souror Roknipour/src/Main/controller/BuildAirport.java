package Main.controller;

import Main.City;
import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BuildAirport implements Initializable {

    @FXML
    private TextField nameTXT;

    @FXML
    private TextField addressTXT;

    @FXML
    private Spinner<Integer> area;

    @FXML
    private Spinner<Integer> Runways;

    @FXML
    private CheckBox International;

    @FXML
    void done(ActionEvent event) {
        if (City.Cost.AirPort.getCost() > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (notCompleted()) {
                JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                Country.country.inputCity.addAirport(nameTXT.getText(), addressTXT.getText(), area.getValue(), Runways.getValue(), International.isSelected());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
                addressTXT.clear();
                nameTXT.clear();

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        area.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(300, 3000, 400, 50));
        Runways.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 2, 1));


    }

    public boolean notCompleted() {

        boolean name = nameTXT.getText().isEmpty();
        boolean address = addressTXT.getText().isEmpty();

        return name || address ;
    }
}
