package GameApp.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class StartView extends VBox {
    private Button Start;
    private Button Continue;

    public StartView() {
        Start = new Button(" START A NEW GAME ");
        Start.setMaxWidth(Double.MAX_VALUE);
        Start.setAlignment(Pos.CENTER);

        Continue = new Button(" CONTINUE THE PREVIOUS GAME ");
        Continue.setMaxWidth(Double.MAX_VALUE);
        Continue.setAlignment(Pos.CENTER);

        ImageView selectedImage1 = new ImageView();
        try {
            Image image1 = new Image(new FileInputStream("D:\\science\\mb computer\\CODE\\GamePhoto\\4_5987583456035473781.png"));
            selectedImage1.setImage(image1);
            selectedImage1.setFitWidth(450);
            selectedImage1.setFitHeight(200);
        } catch (FileNotFoundException ex) {
        }

        this.getChildren().addAll(Start, Continue, selectedImage1);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);
    }

    public Button getStart() {
        return Start;
    }

    public void setStart(Button start) {
        Start = start;
    }

    public Button getContinue() {
        return Continue;
    }

    public void setContinue(Button aContinue) {
        Continue = aContinue;
    }
}
