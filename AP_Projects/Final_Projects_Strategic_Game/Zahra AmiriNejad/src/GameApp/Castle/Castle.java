package GameApp.Castle;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Castle {
    public int Health;
    public Image image;
    public Node CastleSample = new Rectangle(0, 0);
    public Text LeftLife;

    public Castle(int Health, String ImageAddress) {
        this.Health = Health;
        this.LeftLife = new Text("LIFE : " + Health);
        try {
            image = new Image(new FileInputStream(ImageAddress));
            CastleSample.maxWidth(image.getWidth());
            CastleSample.maxHeight(image.getHeight());
        } catch (FileNotFoundException ex) {
        }
    }

    public void render(GraphicsContext context) {
        context.drawImage(image, CastleSample.getTranslateX(), CastleSample.getTranslateY());
    }
}
