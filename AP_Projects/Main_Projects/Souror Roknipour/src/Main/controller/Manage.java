package Main.controller;

import Main.Buildings.Bank.Transaction;
import Main.Country;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Manage implements Initializable , Serializable {

    @FXML
    private BorderPane root;

    @FXML
    private TableView<Transaction> view;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Country.country.setManage(this);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Transactions.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        view = loader.getRoot();
        root.setCenter(view);

    }
    public void addTransaction(Transaction transaction){
        Platform.runLater(() -> view.getItems().add(transaction));
    }
}
