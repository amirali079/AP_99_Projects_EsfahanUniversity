package Main.controller;

import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Insert {


    @FXML
    private TextField CityTXT;

    @FXML
    void done(ActionEvent event) {
        try {
            Country.country.addCity(CityTXT.getText());
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            CityTXT.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
