package Main.controller;

import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Enter {

    @FXML
    private TextField CityTXT;

    @FXML
    private AnchorPane root;

    @FXML
    void done(ActionEvent event) {
        try {
            Country.country.inputCity = Country.country.getCities(CityTXT.getText());
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/mainPage.fxml"));
            try {
                loader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            root.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.getRoot()));
            stage.show();
            stage.setOnCloseRequest(e -> {
                Country.country.save();
                System.exit(0);
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
