package GameApp;

import GameApp.Controller.StartController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StartController startController = new StartController();
        stage.setScene(new Scene(startController.getStartView()));
        stage.setWidth(450);
        stage.setHeight(290);
        stage.show();
    }
}
