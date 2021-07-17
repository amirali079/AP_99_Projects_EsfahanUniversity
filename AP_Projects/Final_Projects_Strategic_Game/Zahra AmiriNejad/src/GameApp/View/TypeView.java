package GameApp.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TypeView extends HBox {
    private Button WATER;
    private Button AIR;
    private Button EARTH;
    private Button FIRE;

    public TypeView() {
        setWATER(new Button(" WATER "));
        setAIR(new Button(" AIR "));
        setEARTH(new Button(" EARTH "));
        setFIRE(new Button(" FIRE "));

        ImageView selectedImage1 = new ImageView();
        try {
            Image image1 = new Image(new FileInputStream("D:\\science\\mb computer\\CODE\\GamePhoto\\download (2).jpg"));
            selectedImage1.setImage(image1);
            selectedImage1.setFitWidth(450);
            selectedImage1.setFitHeight(200);
        } catch (FileNotFoundException ex) {
        }

        ImageView selectedImage2 = new ImageView();
        try {
            Image image2 = new Image(new FileInputStream("D:\\science\\mb computer\\CODE\\GamePhoto\\images (2).jpg"));
            selectedImage2.setImage(image2);
            selectedImage2.setFitWidth(450);
            selectedImage2.setFitHeight(200);
        } catch (FileNotFoundException ex) {
        }


        ImageView selectedImage3 = new ImageView();
        try {
            Image image3 = new Image(new FileInputStream("D:\\science\\mb computer\\CODE\\GamePhoto\\images (1).jpg"));
            selectedImage3.setImage(image3);
            selectedImage3.setFitWidth(450);
            selectedImage3.setFitHeight(200);
        } catch (FileNotFoundException ex) {
        }


        ImageView selectedImage4 = new ImageView();
        try {
            Image image4 = new Image(new FileInputStream("D:\\science\\mb computer\\CODE\\GamePhoto\\images.jpg"));
            selectedImage4.setImage(image4);
            selectedImage4.setFitWidth(450);
            selectedImage4.setFitHeight(200);
        } catch (FileNotFoundException ex) {
        }

        VBox firstColm = new VBox(getWATER(), getAIR());
        getWATER().setMaxWidth(Double.MAX_VALUE);
        getWATER().setAlignment(Pos.CENTER_LEFT);
        getAIR().setMaxWidth(Double.MAX_VALUE);
        getAIR().setAlignment(Pos.CENTER_LEFT);
        firstColm.setSpacing(190);

        VBox secColm = new VBox(selectedImage1, selectedImage2);
        secColm.setAlignment(Pos.TOP_CENTER);
        secColm.setSpacing(10);

        VBox thirdColm = new VBox(getEARTH(), getFIRE());
        getEARTH().setMaxWidth(Double.MAX_VALUE);
        getEARTH().setAlignment(Pos.CENTER_LEFT);
        getFIRE().setMaxWidth(Double.MAX_VALUE);
        getFIRE().setAlignment(Pos.CENTER_LEFT);
        thirdColm.setSpacing(190);


        VBox fourthColm = new VBox(selectedImage3, selectedImage4);
        fourthColm.setAlignment(Pos.TOP_CENTER);
        fourthColm.setSpacing(10);

        this.getChildren().addAll(firstColm, secColm, thirdColm, fourthColm);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

    public Button getWATER() {
        return WATER;
    }

    public void setWATER(Button WATER) {
        this.WATER = WATER;
    }

    public Button getAIR() {
        return AIR;
    }

    public void setAIR(Button AIR) {
        this.AIR = AIR;
    }

    public Button getEARTH() {
        return EARTH;
    }

    public void setEARTH(Button EARTH) {
        this.EARTH = EARTH;
    }

    public Button getFIRE() {
        return FIRE;
    }

    public void setFIRE(Button FIRE) {
        this.FIRE = FIRE;
    }
}
