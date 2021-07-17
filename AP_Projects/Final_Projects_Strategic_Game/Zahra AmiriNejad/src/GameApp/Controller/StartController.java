package GameApp.Controller;

import GameApp.View.StartView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class StartController {
    private StartView startView;

    public StartController() {
        startView = new StartView();

        startView.getStart().setOnAction(event -> {
            TypeController typeController = new TypeController();
            Stage stage = new Stage();
            stage.setScene(new Scene(typeController.getTypeView()));
            stage.setWidth(1200);
            stage.setHeight(450);
            stage.show();
            startView.getScene().getWindow().hide();
        });

        startView.getContinue().setOnAction(event -> {
            if (new File("HERO.txt").length() == 0 && new File("ENEMY.txt").length() == 0) {
                JOptionPane.showMessageDialog(null, "NO SAVED GAME", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                TypeController.Read();
                startView.getScene().getWindow().hide();
            }
        });
    }

    public StartView getStartView() {
        return startView;
    }

    public void setStartView(StartView startView) {
        this.startView = startView;
    }
}
