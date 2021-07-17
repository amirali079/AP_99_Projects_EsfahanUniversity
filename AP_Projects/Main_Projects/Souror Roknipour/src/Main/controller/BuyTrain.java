package Main.controller;

import Main.Buildings.Railway_station;
import Main.City;
import Main.Country;
import Main.Vehicles.Train;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyTrain implements Initializable {

    ArrayList<String> services = new ArrayList<>();
    @FXML
    FXMLLoader loader;

    @FXML
    TableView<Railway_station> view;
    @FXML
    private Group serviceGroup;

    @FXML
    private ToggleGroup fuelGroup;

    @FXML
    private RadioButton fourbed;

    @FXML
    private RadioButton Restaurant;

    @FXML
    private RadioButton TV;

    @FXML
    private RadioButton sixbed;

    @FXML
    private RadioButton Cafe;

    @FXML
    private RadioButton gas;

    @FXML
    private RadioButton petrol;

    @FXML
    private RadioButton gasoline;

    @FXML
    private TextField companyTXT;

    @FXML
    private TextField capacityTXT;

    @FXML
    private ChoiceBox<Integer> speed;

    @FXML
    private ChoiceBox<Integer> wagons;

    @FXML
    private Button DoneBTN;

    @FXML
    private VBox railwayRoot;

    @FXML
    private AnchorPane root;

    @FXML
    private ScrollPane scroll;

    @FXML
    void Buy(ActionEvent event) {

        int TStar = star();
        if ((TStar * City.Cost.train_services.getCost()) + (City.Cost.Train.getCost()) > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (notCompleted()) {
                JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!IsDigit(capacityTXT.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Capacity field !", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Railway_station rail = view.getSelectionModel().getSelectedItem();
                Train train = new Train(Integer.parseInt(capacityTXT.getText()), companyTXT.getText(), speed.getValue(), whichSelected(), wagons.getValue(), TStar);
                train.addServices(services);
                rail.addTrain(train);
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        services.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        speed.getItems().addAll(150, 200, 250, 300, 350);
        wagons.getItems().addAll(6, 8, 10, 12, 14);
        fuelGroup = new ToggleGroup();
        gas.setToggleGroup(fuelGroup);
        gasoline.setToggleGroup(fuelGroup);
        petrol.setToggleGroup(fuelGroup);

        loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Railways.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        railwayRoot.getChildren().add(loader.getRoot());
        view = loader.getRoot();
    }

    public boolean IsAnyServiceSelected() {
        return Cafe.isSelected() || Restaurant.isSelected() || fourbed.isSelected() || sixbed.isSelected() || TV.isSelected();
    }

    public boolean IsAnyFuelSelected() {
        return gasoline.isSelected() || gas.isSelected() || petrol.isSelected();
    }

    public boolean notCompleted() {
        boolean wagon = wagons.getSelectionModel().isEmpty();
        boolean spd = speed.getSelectionModel().isEmpty();
        boolean cpaTXT = capacityTXT.getText().isEmpty();
        boolean coTXT = companyTXT.getText().isEmpty();
        boolean service = IsAnyServiceSelected();
        boolean fuel = IsAnyFuelSelected();
        boolean table = view.getSelectionModel().isEmpty();


        return wagon || spd || coTXT || cpaTXT || table || !service || !fuel;
    }

    public boolean IsDigit(String txt) {
        for (int i = 0; i < txt.length(); i++) {
            if (!Character.isDigit(txt.charAt(i))) return false;
        }
        return true;
    }

    public String whichSelected() {
        if (gasoline.isSelected()) return gasoline.getText();
        if (gas.isSelected()) return gas.getText();
        else return petrol.getText();
    }

    public int star() {
        int counter = 0;
        if (Cafe.isSelected()) {
            ++counter;
            services.add(Cafe.getText());
        }
        if (TV.isSelected()) {
            ++counter;
            services.add(TV.getText());
        }
        if (fourbed.isSelected()) {
            ++counter;
            services.add(fourbed.getText());
        }
        if (sixbed.isSelected()) {
            ++counter;
            services.add(sixbed.getText());
        }
        if (Restaurant.isSelected()) {
            ++counter;
            services.add(Restaurant.getText());
        }
        return counter;
    }

}


