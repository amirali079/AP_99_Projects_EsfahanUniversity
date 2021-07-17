package Main.controller;

import Main.Buildings.Bank.Bank;
import Main.Buildings.Bank.BankAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowBanks implements Initializable {

    TableView<Bank> BView;
    TableView<BankAccount> AView;
    @FXML
    private VBox BRoot;

    @FXML
    private VBox ARoot;

    @FXML
    void Select(ActionEvent event) {
        if (!BView.getSelectionModel().isEmpty()) {
            Bank bank = BView.getSelectionModel().getSelectedItem();
            AView.getItems().clear();
            AView.getItems().addAll(bank.getBankAccounts());
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
        BRoot.getChildren().add(loader.getRoot());
        BView = loader.getRoot();

        FXMLLoader loader2 = new FXMLLoader(this.getClass().getResource("../view/tableShow/BankAccounts.fxml"));
        try {
            loader2.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ARoot.getChildren().add(loader2.getRoot());
        AView = loader2.getRoot();
    }
}
