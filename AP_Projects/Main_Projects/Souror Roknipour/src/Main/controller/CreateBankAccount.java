package Main.controller;

import Main.Buildings.Bank.Bank;
import Main.Country;
import Main.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateBankAccount implements Initializable {

    private TableView<Bank> banks;
    private TableView<Person> Owners;
    private Bank bank;
    private Person Owner;

    @FXML
    private BorderPane root;

    @FXML
    private VBox vroot;

    @FXML
    private TextField username;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField amount;

    @FXML
    private VBox bankRoot;

    @FXML
    private VBox OwnerRoot;

    @FXML
    void bankSelect(ActionEvent event) {
        if (!banks.getSelectionModel().isEmpty()) {
            bank = banks.getSelectionModel().getSelectedItem();
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void done(ActionEvent event) {
        try {
            if (bank == null || Owner == null) throw new Exception("Bank or Owner not selected!");
            bank.createAccount(pass.getText(), username.getText(), Owner, Double.parseDouble(amount.getText()));
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void ownerSelect(ActionEvent event) {
        if (!Owners.getSelectionModel().isEmpty()) {
            Owner = Owners.getSelectionModel().getSelectedItem();
            JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Banks.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        bankRoot.getChildren().add(loader.getRoot());
        banks = loader.getRoot();
        //---------------------------------------
        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/Citizens.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        OwnerRoot.getChildren().add(loader2.getRoot());
        Owners = loader2.getRoot();
        Owners.getItems().addAll(Country.country.inputCity.getCitizens());

    }
}
