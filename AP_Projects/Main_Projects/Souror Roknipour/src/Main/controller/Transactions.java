package Main.controller;

import Main.Buildings.Bank.Transaction;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Transactions implements Initializable {
    @FXML
    private TableView<Transaction> TransactionTable;

    @FXML
    private TableColumn<Transaction, Double> Amount;

    @FXML
    private TableColumn<Transaction, String> Type;

    @FXML
    private TableColumn<Transaction, String> Date;

    @FXML
    private TableColumn<Transaction, String> Bank;

    @FXML
    private TableColumn<Transaction, String> account;

    @FXML
    private TableColumn<Transaction,String> City;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Type.setCellValueFactory(new PropertyValueFactory<>("type"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        City.setCellValueFactory(new PropertyValueFactory<>("city"));
        Bank.setCellValueFactory(new PropertyValueFactory<>("bank"));
        account.setCellValueFactory(new PropertyValueFactory<>("accountUser"));

    }
}
