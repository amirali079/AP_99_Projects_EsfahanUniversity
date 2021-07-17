package Main.controller;

import Main.Buildings.Bank.Bank;
import Main.Buildings.Bank.BankAccount;
import Main.Country;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInBank implements Initializable {

    @FXML
    private BorderPane transView;
    @FXML
    private TableView<Bank> view;

    private Bank bank;
    private BankAccount account;
    @FXML
    private BorderPane root;

    @FXML
    private VBox vroot;

    @FXML
    private TextField username;

    @FXML
    private PasswordField pass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Banks.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        view = loader.getRoot();
        view.setMaxWidth(Double.MAX_VALUE);

        root.setCenter(view);
        root.setLeft(vroot);
    }

    @FXML
    void done(ActionEvent event) {
        if (!view.getSelectionModel().isEmpty()) {
            try {
                bank = view.getSelectionModel().getSelectedItem();
                account = bank.getBankAccount(username.getText(), pass.getText());
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BankOperation.fxml"));
                try {
                    loader.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                ((BankOperation) loader.getController()).setAccount(account);
                ((BankOperation) loader.getController()).setView();
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.getRoot()));
                stage.show();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
