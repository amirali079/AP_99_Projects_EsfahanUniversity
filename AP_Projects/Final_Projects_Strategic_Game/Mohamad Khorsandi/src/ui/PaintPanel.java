package ui;

import units.Team;
import units.Unit;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;

public class PaintPanel extends JPanel {

    public BufferedImage image;
    public boolean isFilled = false;
    public Unit filledBy;

    public void setImage(BufferedImage image, Team team) {

        this.image = team.getProperImg(image);

        this.repaint();
    }

    public void removeImage() {
        this.isFilled = false;
        this.repaint();
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());
        if (this.isFilled){
            int imgHeight = (int)(image.getHeight() * ((double)this.getWidth() / image.getWidth()));
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
