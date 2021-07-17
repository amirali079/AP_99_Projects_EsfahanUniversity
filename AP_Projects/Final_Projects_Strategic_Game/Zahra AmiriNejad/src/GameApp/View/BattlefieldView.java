package GameApp.View;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BattlefieldView extends Pane {
    private Canvas canvas;
    private GraphicsContext context;
    private Button SaveGame;

    public BattlefieldView() {

        this.setPrefSize(1100, 700);
        setCanvas(new Canvas(1100, 700));
        setContext(getCanvas().getGraphicsContext2D());
        getContext().setFill(Color.LIGHTGREEN);
        getContext().fillRect(0, 0, 1100, 700);
        this.getChildren().add(getCanvas());
        setSaveGame(new Button(" SAVE "));
        getSaveGame().setTranslateX(1030);
        getSaveGame().setTranslateY(630);
        this.getChildren().add(getSaveGame());

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getContext() {
        return context;
    }

    public void setContext(GraphicsContext context) {
        this.context = context;
    }

    public Button getSaveGame() {
        return SaveGame;
    }

    public void setSaveGame(Button saveGame) {
        SaveGame = saveGame;
    }
}
