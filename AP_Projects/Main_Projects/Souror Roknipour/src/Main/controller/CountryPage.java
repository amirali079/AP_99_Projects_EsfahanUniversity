package Main.controller;

import Main.Country;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class CountryPage implements Initializable, Serializable {

    @FXML
    private ImageView InventoryIcon;

    @FXML
    private ImageView peopleIcon;

    @FXML
    private Label Inventory;

    @FXML
    private Label people;

    @FXML
    private TabPane tabPane;

    @FXML
    private HBox HRoot;

    @FXML
    private Label City;


    @FXML
    void Enter(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Enter");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/CountryPge/Enter.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void InsertCity(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Insert");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/CountryPge/Insert.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void ShowCities(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Cities");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/CountryPge/ShowCities.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());

    }

    @FXML
    void management(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/CountryPge/Manage.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Country.country.setCountryPage(this);
        peopleIcon.setImage(new Image("Main/people.png"));
        InventoryIcon.setImage(new Image("Main/Money.png"));

        people.setText(String.valueOf(Country.country.getPopulation()));
        Inventory.setText(String.valueOf(Country.country.getInventory()));

    }

    public void setInventory() {
        Platform.runLater(() -> Inventory.setText(String.valueOf(Country.country.getInventory())));
    }


}
