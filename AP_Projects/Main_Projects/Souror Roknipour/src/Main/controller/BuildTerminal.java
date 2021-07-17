package Main.controller;

import Main.City;
import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BuildTerminal implements Initializable {

    @FXML
    private TextField nameTXT;

    @FXML
    private TextField addressTXT;

    @FXML
    private Spinner<Integer> area;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        area.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(300, 3000, 400, 50));
    }

    @FXML
    void done(ActionEvent event) {
        if (City.Cost.BusTerminal.getCost() > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (notCompleted()) {
                JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Country.country.inputCity.addBus_Terminal(nameTXT.getText(), addressTXT.getText(), area.getValue());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
                addressTXT.clear();
                nameTXT.clear();
            }
        }
    }

    public boolean notCompleted() {

        boolean name = nameTXT.getText().isEmpty();
        boolean address = addressTXT.getText().isEmpty();

        return name || address;
    }
}

