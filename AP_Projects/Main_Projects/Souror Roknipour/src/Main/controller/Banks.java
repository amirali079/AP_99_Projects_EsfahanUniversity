package Main.controller;

import Main.Buildings.Bank.Bank;
import Main.Country;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Banks implements Initializable {
    @FXML
    private TableView<Bank> BanksTable;

    @FXML
    private TableColumn<Bank, String> Name;

    @FXML
    private TableColumn<Bank, String> City;

    @FXML
    private TableColumn<Bank, Double> Inventory;

    @FXML
    private TableColumn<Bank, Integer> ActiveAccounts;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        City.setCellValueFactory(new PropertyValueFactory<>("CityName"));
        Inventory.setCellValueFactory(new PropertyValueFactory<>("totalMoney"));
        ActiveAccounts.setCellValueFactory(new PropertyValueFactory<>("activeAccounts"));

        BanksTable.getItems().addAll(Country.country.inputCity.getBanks());

    }

}
