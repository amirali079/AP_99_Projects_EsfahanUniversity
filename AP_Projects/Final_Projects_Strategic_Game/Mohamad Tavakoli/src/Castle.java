import javax.swing.*;
import java.awt.*;

public class Castle {
    private Image bg = new ImageIcon("Castle.png").getImage();
    private int Health;
    private final int x;
    private final int y;
    private JProgressBar bar;

    public Castle(int x, int y) {
        this.x = x;
        this.y = y;
        Health = 300;
        bar = new JProgressBar(0 , Health);
        bar.setValue(Health);
        bar.setSize(30 , 10);
        bar.setLocation(this.x , this.y);
        bar.setForeground(Color.MAGENTA);
    }

    public JProgressBar getBar() {
        return bar;
    }

    void paint(Graphics g) {
        g.drawImage(bg , x , y, 100 , 100 , null);
    }

    synchronized public int getHealth() {
        return Health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    synchronized public void setHealth(int health) {
        Health = health;
    }
}