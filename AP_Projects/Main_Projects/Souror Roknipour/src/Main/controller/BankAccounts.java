package Main.controller;

import Main.Buildings.Bank.BankAccount;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BankAccounts implements Initializable {

    @FXML
    private TableView<BankAccount> BankAccountsTable;

    @FXML
    private TableColumn<BankAccount, String> Owner;

    @FXML
    private TableColumn<BankAccount, String> Username;

    @FXML
    private TableColumn<BankAccount, String> Pass;

    @FXML
    private TableColumn<BankAccount, String> Bank;

    @FXML
    private TableColumn<BankAccount, Double> Inventory;

    @FXML
    private TableColumn<BankAccount, Integer> Time;

    @FXML
    private TableColumn<BankAccount, Boolean> Active;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        Username.setCellValueFactory(new PropertyValueFactory<>("username"));
        Pass.setCellValueFactory(new PropertyValueFactory<>("password"));
        Inventory.setCellValueFactory(new PropertyValueFactory<>("Inventory"));
        Time.setCellValueFactory(new PropertyValueFactory<>("remainTime"));
        Bank.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        Active.setCellValueFactory(new PropertyValueFactory<>("Active"));
    }
}
