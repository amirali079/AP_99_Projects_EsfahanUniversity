package Main.controller;

import Main.City;
import Main.Country;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowCities implements Initializable {

    TableView<City> cityTableView;
    @FXML
    private BorderPane City;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Cities.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        cityTableView = loader.getRoot();
        cityTableView.getItems().addAll(Country.country.getCities());
        City.setCenter(cityTableView);
    }
}
