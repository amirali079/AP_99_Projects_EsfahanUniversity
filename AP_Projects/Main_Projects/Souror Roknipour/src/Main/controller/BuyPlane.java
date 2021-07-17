package Main.controller;

import Main.Buildings.Airport;
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

public class BuyPlane implements Initializable {

    @FXML
    private TableView<Airport> view;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox AirportRoot;

    @FXML
    private VBox TerminalRoot;

    @FXML
    private VBox fuelRoot;

    @FXML
    private ChoiceBox<String> fuel;

    @FXML
    private VBox fuelRoot1;

    @FXML
    private ChoiceBox<String> seet;

    @FXML
    private TextField capacityTXT;

    @FXML
    private TextField companyTXT;

    @FXML
    private Spinner<Integer> landing;

    @FXML
    private Spinner<Integer> height;

    @FXML
    private Button DoneBTN;

    @FXML
    void Buy(ActionEvent event) {
        if (City.Cost.PassengerPlane.getCost() > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!notCompleted()) {
            if (!IsDigit(capacityTXT.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Capacity field !", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                Airport airport = view.getSelectionModel().getSelectedItem();
                airport.addPassengerPlane(fuel.getValue(), seet.getValue(), Integer.parseInt(capacityTXT.getText()), companyTXT.getText(), height.getValue(), landing.getValue());
                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fuel.getItems().addAll(" JP_1", " JP_2", " JP_3", " JP_4", " JP_5", " JP_6", " JP_7", " JP_8", " JP_TS", " JP_10", " JP_900", " Jet_A", " Jet_A_1");
        seet.getItems().addAll("First_Class", "Economy_Class", "Business_class");

        height.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(750, 2000, 1200, 50));
        landing.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(300, 800, 450, 20));

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Airports.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        AirportRoot.getChildren().add(loader.getRoot());
        view = loader.getRoot();
    }

    public boolean notCompleted() {
        boolean fuelType = fuel.getSelectionModel().isEmpty();
        boolean seatClass = seet.getSelectionModel().isEmpty();
        boolean cpaTXT = capacityTXT.getText().isEmpty();
        boolean coTXT = companyTXT.getText().isEmpty();
        boolean table = view.getSelectionModel().isEmpty();

        return fuelType || seatClass || coTXT || cpaTXT || table;
    }

    public boolean IsDigit(String txt) {
        for (int i = 0; i < txt.length(); i++) {
            if (!Character.isDigit(txt.charAt(i))) return false;
        }
        return true;
    }
}



