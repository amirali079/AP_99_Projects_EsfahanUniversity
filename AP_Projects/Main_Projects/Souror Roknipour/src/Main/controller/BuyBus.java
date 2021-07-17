package Main.controller;

import Main.Buildings.Bus_Terminal;
import Main.Buildings.Railway_station;
import Main.City;
import Main.Country;
import Main.Vehicles.Train;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyBus implements Initializable {

    @FXML
    TableView<Bus_Terminal> view;

    @FXML
    private ToggleGroup fuelGroup;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox TerminalRoot;

    @FXML
    private VBox fuelRoot;

    @FXML
    private RadioButton gas;

    @FXML
    private RadioButton petrol;

    @FXML
    private RadioButton gasoline;

    @FXML
    private TextField capacityTXT;

    @FXML
    private TextField companyTXT;

    @FXML
    private ChoiceBox<Integer> speed;

    @FXML
    private ChoiceBox<String> BusType;

    @FXML
    private Button DoneBTN;

    @FXML
    void Buy(ActionEvent event) {

        if ((City.Cost.Bus.getCost()) > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (notCompleted()) {
                JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!IsDigit(capacityTXT.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Capacity field !", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bus_Terminal terminal = view.getSelectionModel().getSelectedItem();
                terminal.addBuses(Integer.parseInt(capacityTXT.getText()), companyTXT.getText(), speed.getValue(), whichSelected(), BusType.getValue());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        speed.getItems().addAll(150, 200, 250, 300, 350);
        BusType.getItems().addAll("VIP", "Normal");
        fuelGroup = new ToggleGroup();
        gas.setToggleGroup(fuelGroup);
        gasoline.setToggleGroup(fuelGroup);
        petrol.setToggleGroup(fuelGroup);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/BusTerminals.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        TerminalRoot.getChildren().add(loader.getRoot());
        view = loader.getRoot();
    }


    public boolean IsAnyFuelSelected() {
        return gasoline.isSelected() || gas.isSelected() || petrol.isSelected();
    }

    public boolean notCompleted() {
        boolean type = BusType.getSelectionModel().isEmpty();
        boolean spd = speed.getSelectionModel().isEmpty();
        boolean cpaTXT = capacityTXT.getText().isEmpty();
        boolean coTXT = companyTXT.getText().isEmpty();
        boolean fuel = IsAnyFuelSelected();
        boolean table = view.getSelectionModel().isEmpty();

        return type || spd || coTXT || cpaTXT || !fuel || table;
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

}


