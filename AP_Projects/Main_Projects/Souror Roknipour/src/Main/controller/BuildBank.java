package Main.controller;

import Main.City;
import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class BuildBank {

    @FXML
    private TextField bankTXT;

    @FXML
    void done(ActionEvent event) {
        try {
            if (City.Cost.Bank.getCost() > Country.country.inputCity.getInventory()) {
                JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Country.country.inputCity.addBank(bankTXT.getText());
                bankTXT.clear();
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            bankTXT.clear();
            JOptionPane.showMessageDialog(null, "Invalid bank name !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

