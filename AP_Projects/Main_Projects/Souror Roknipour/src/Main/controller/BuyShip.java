package Main.controller;

import Main.Buildings.Shipping_port;
import Main.City;
import Main.Country;
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


public class BuyShip implements Initializable {
    @FXML
    private TableView<Shipping_port> view;

    @FXML
    private ScrollPane scroll1;

    @FXML
    private VBox ShippingRoot;

    @FXML
    private VBox fuelRoot;

    @FXML
    private ChoiceBox<String> fuel;

    @FXML
    private VBox fuelRoot1;

    @FXML
    private ChoiceBox<String> ShipType;

    @FXML
    private TextField capacityTXT;

    @FXML
    private TextField companyTXT;

    @FXML
    private Spinner<Integer> depth;

    @FXML
    private Button DoneBTN;

    @FXML
    void Buy(ActionEvent event) {
        if (City.Cost.Ship.getCost() > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!notCompleted()) {
            if (!IsDigit(capacityTXT.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Capacity field !", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Shipping_port shippingPort = view.getSelectionModel().getSelectedItem();
                shippingPort.addShips(fuel.getValue(), ShipType.getValue(), Integer.parseInt(capacityTXT.getText()), companyTXT.getText(), depth.getValue());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fuel.getItems().addAll("HFO", "LSMGO", "LSHFO", "MGO", "Petrol");
        ShipType.getItems().addAll("RORO", "General Cargo", "BUlK Carrier", "Tanker", "Passenger Ship", "Product Carrier", "Container Carrier");

        depth.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(50, 800, 70, 10));


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/ShippingPorts.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ShippingRoot.getChildren().add(loader.getRoot());
        view = loader.getRoot();
    }

    public boolean notCompleted() {
        boolean fuelType = fuel.getSelectionModel().isEmpty();
        boolean type = ShipType.getSelectionModel().isEmpty();
        boolean cpaTXT = capacityTXT.getText().isEmpty();
        boolean coTXT = companyTXT.getText().isEmpty();
        boolean table = view.getSelectionModel().isEmpty();


        return fuelType || type || coTXT || cpaTXT || table;
    }

    public boolean IsDigit(String txt) {
        for (int i = 0; i < txt.length(); i++) {
            if (!Character.isDigit(txt.charAt(i))) return false;
        }
        return true;
    }
}

