package Main.controller;

import Main.Buildings.Bus_Terminal;
import Main.Buildings.Terminal;
import Main.Country;
import Main.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Citizens implements Initializable {

        @FXML
        private TableView<Person> CitizensTable;

        @FXML
        private TableColumn<Person,Integer> ID;

        @FXML
        private TableColumn<Person,String> Name;

        @FXML
        private TableColumn<Person,String> Family;

        @FXML
        private TableColumn<Person, Integer> BirthYear;

        @FXML
        private TableColumn<Person, String> BirthPlace;

        @FXML
        private TableColumn<Person, Person.Gender> Gender;

        @FXML
        private TableColumn<Person, Person.Job> Job;

        @FXML
        private TableColumn<Person,Double> Rights;

        @FXML
        private TableColumn<Person,Boolean> NotHire;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Family.setCellValueFactory(new PropertyValueFactory<>("family"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        Job.setCellValueFactory(new PropertyValueFactory<>("Job"));
        NotHire.setCellValueFactory(new PropertyValueFactory<>("NotHire"));
        Rights.setCellValueFactory(new PropertyValueFactory<>("Employment_rights"));
        BirthPlace.setCellValueFactory(new PropertyValueFactory<>("birthplace"));
        BirthYear.setCellValueFactory(new PropertyValueFactory<>("birthYear"));

    }

    public TableView<Person> getCitizensTable() {
        return CitizensTable;
    }
}


