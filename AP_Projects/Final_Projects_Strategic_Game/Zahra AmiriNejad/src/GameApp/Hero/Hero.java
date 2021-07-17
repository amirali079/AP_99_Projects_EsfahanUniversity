package GameApp.Hero;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hero {
    public int Live;
    public Image image;
    public Node HeroSample;
    public Text LeftLife;
    public int Power;
    public double Velocity;
    public int Score;
    public Text ScoreText;

    public Hero(int Live, String imageAddress, int Power) {
        this.Live = Live;
        this.LeftLife = new Text("LIFE : " + Live);
        HeroSample = new Rectangle(0, 0);
        try {
            image = new Image(new FileInputStream(imageAddress));
            HeroSample.maxWidth(image.getWidth());
            HeroSample.maxHeight(image.getHeight());
        } catch (FileNotFoundException ex) {
        }
        this.Power = Power;
        this.Score = 0;
        this.ScoreText = new Text("SCORE : " + Score);
    }

    public boolean isAlive() {
        if (Live <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void render(GraphicsContext context) {
        context.drawImage(image, HeroSample.getTranslateX(), HeroSample.getTranslateY());
    }
}
