package Main.controller;

import Main.Buildings.Bank.BankAccount;
import Main.Buildings.Bank.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class BankOperation implements Initializable {

    BankAccount account;
    @FXML
    private VBox vroot;
    @FXML
    private TableView<Transaction> view;
    @FXML
    private TextField deposit;

    @FXML
    private TextField withdraw;

    @FXML
    void Deposit(ActionEvent event) {
        if (!deposit.getText().isEmpty() && Double.parseDouble(deposit.getText()) > 0 && account != null) {
            account.deposit(Double.parseDouble(deposit.getText()));
            view.getItems().clear();
            view.getItems().addAll(account.getTransactions());
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void Withdraw(ActionEvent event) {
        if (!withdraw.getText().isEmpty() && Double.parseDouble(withdraw.getText()) > 0 && account != null) {
            account.withdrawal(Double.parseDouble(withdraw.getText()));
            view.getItems().clear();
            view.getItems().addAll(account.getTransactions());

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Transactions.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        vroot.getChildren().add(loader.getRoot());
        view = loader.getRoot();
    }
    public void setView(){
        view.getItems().addAll(account.getTransactions());
    }
}
