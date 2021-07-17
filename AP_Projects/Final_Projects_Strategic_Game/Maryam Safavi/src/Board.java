import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i + 1) % 2 != 0 && (j + 1) % 2 != 0) {
                    g.drawRect(i * 70, j * 70, 70, 70);
                    g.setColor(Color.BLACK);
                } else if ((i + 1) % 2 == 0 && (j + 1) % 2 == 0) {
                    g.drawRect(i * 70, j * 70, 70, 70);
                    g.setColor(Color.BLACK);
                } else {
                    g.fillRect(i * 70, j * 70, 70, 70);
                    g.setColor(Color.BLACK);
                }
            }

        }


    }

}
