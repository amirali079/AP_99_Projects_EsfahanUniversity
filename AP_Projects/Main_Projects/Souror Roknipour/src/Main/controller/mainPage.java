package Main.controller;

import Main.Country;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class mainPage implements Initializable , Serializable {

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private Label City;

    @FXML
    private ImageView InventoryIcon;

    @FXML
    private Label Inventory;

    @FXML
    private ImageView peopleIcon;

    @FXML
    private Label people;

    @FXML
    private ImageView moneyIcon;

    @FXML
    private Label bankMoney;

    @FXML
    private TabPane tabPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Country.country.inputCity.setCityPage(this);
        City.setText(Country.country.inputCity.getName());

        peopleIcon.setImage(new Image("Main/people.png"));
        InventoryIcon.setImage(new Image("Main/Money.png"));
        moneyIcon.setImage(new Image("Main/Financial.png"));

        people.setText(String.valueOf(Country.country.inputCity.getPopulation()));
        Inventory.setText(String.valueOf(Country.country.inputCity.getInventory()));
        bankMoney.setText(String.valueOf(Country.country.inputCity.getTotalMoney()));

    }

    public void setInventory(int inventory) {

        Platform.runLater(() -> Inventory.setText(String.valueOf(inventory)));
    }

    public void setBankMoney(double money) {

        Platform.runLater(() -> {
            bankMoney.setText(String.valueOf(money));
        });
    }

    @FXML
    void BuildPort(ActionEvent event) {

        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Shipping Port");
        tabPane.getTabs().add(tab);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildPort.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        tab.setContent(loader.getRoot());
    }

    @FXML
    void buyTrain(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Buy Train");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuyTrain.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void buyBus(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Buy Bus");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuyBus.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BuyBoat(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Buy Boat");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuyBoat.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BuyCargo(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Buy Cargo plane");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuyCargo.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BuyPlane(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Buy Passenger Plane");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuyPlane.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BuyShip(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Buy Ship");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuyShip.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void buildAirport(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Airport");
        tabPane.getTabs().add(tab);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildAirport.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        tab.setContent(loader.getRoot());
    }

    @FXML
    void buildHotel(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Hotel");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildHotel.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void buildRailway(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Railway");
        tabPane.getTabs().add(tab);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildRailway.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        tab.setContent(loader.getRoot());
    }

    @FXML
    void buildRoom(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Room");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildRoom.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void buildTerminal(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Bus Terminal");
        tabPane.getTabs().add(tab);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildTerminal.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        tab.setContent(loader.getRoot());
    }

    @FXML
    void showCitizens(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show Citizens");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowCitizens.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void showCost(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show Costs");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Costs.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BuildBank(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Build Bank");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BuildBank.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void HireForAirport(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Hire for Airport");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/AHire.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void HireForPort(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Hire for ShippingPort");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/SHire.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void HireForRailway(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Hire for Railway");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/RHire.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void HireForTerminal(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Hire for BusTerminal");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/THire.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void ShowHotels(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show Hotels");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowHotels.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void ShowPorts(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show ports");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowShippingPorts.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void ShowRailways(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show Railways");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowRailways.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void ShowTerminals(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show BusTerminals");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowBusTerminals.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void ShowAirports(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Show Airports");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowAirports.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void TrainTravel(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Train Traveling");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/TrainTravel.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void PortTravel(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Marine Traveling");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/MarineTravel.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void AirTravel(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Plane Traveling");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/AirTravel.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BusTravel(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Bus Traveling");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/BusTravel.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }


    @FXML
    void ShowTravels(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Travels");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/tableShow/Travels.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        tab.setContent(loader.getRoot());

    }

    @FXML
    void backMenu(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/CountryPge/CountryPage.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        mainRoot.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

    @FXML
    void BankCreate(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Bank Create");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/CreatBankAccount.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void BankInfo(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Banks Info");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/ShowBanks.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }

    @FXML
    void bankLogIn(ActionEvent event) {
        Tab tab = new Tab();
        tab.setClosable(true);
        tab.setText("Banks Login");
        tabPane.getTabs().add(tab);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/cityPage/LogInBank.fxml"));
        try {
            loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        tab.setContent(loader.getRoot());
    }
}
