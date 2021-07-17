package Ragnargame;

import javax.swing.*;
import java.awt.*;

public class Castle extends JLabel {
     int Health = 50;
     int x;
     int y;
     ImageIcon img;

    public Castle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img.getImage(), x, y, 281, 202, null);
    }

}
