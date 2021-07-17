package Main.controller;

import Main.Buildings.Hotel;
import Main.City;
import Main.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;

public class BuildHotel {

    ArrayList<String> services = new ArrayList<>();
    @FXML
    private TextField nameTXT;

    @FXML
    private TextField addressTXT;

    @FXML
    private RadioButton Restaurant;

    @FXML
    private RadioButton Cafe;

    @FXML
    private RadioButton Club;

    @FXML
    private RadioButton Gym;

    @FXML
    private RadioButton Pool;

    @FXML
    void done(ActionEvent event) {
        int star = star();
        if (City.Cost.Hotel.getCost() > Country.country.inputCity.getInventory()) {
            JOptionPane.showMessageDialog(null, "Not enough money ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (notCompleted()) {
                JOptionPane.showMessageDialog(null, "Fields are not completed!", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                Hotel hotel = new Hotel(nameTXT.getText(), addressTXT.getText(),star);
                hotel.addServices(services);
                Country.country.inputCity.addHotels(hotel);

                JOptionPane.showMessageDialog(null, "Done ! ", "successful", JOptionPane.INFORMATION_MESSAGE);
                addressTXT.clear();
                nameTXT.clear();
            }
        }
    }

    public boolean notCompleted() {

        boolean name = nameTXT.getText().isEmpty();
        boolean address = addressTXT.getText().isEmpty();
        boolean service = IsAnyServiceSelected();

        return name || address || !service;
    }

    public boolean IsAnyServiceSelected() {
        return Cafe.isSelected() || Restaurant.isSelected() || Pool.isSelected() || Club.isSelected() || Gym.isSelected();
    }

    public int star() {
        int counter = 0;
        if (Cafe.isSelected()) {
            ++counter;
            services.add(Cafe.getText());
        }
        if (Pool.isSelected()) {
            ++counter;
            services.add(Pool.getText());
        }
        if (Club.isSelected()) {
            ++counter;
            services.add(Club.getText());
        }
        if (Gym.isSelected()) {
            ++counter;
            services.add(Gym.getText());
        }
        if (Restaurant.isSelected()) {
            ++counter;
            services.add(Restaurant.getText());
        }
        return counter;
    }
}

