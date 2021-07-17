import javafx.beans.property.adapter.JavaBeanBooleanProperty;

import javax.swing.*;

public class Castle {
    private int x, y;
    private int health = 20;
    public JButton jb;

    public Castle(int x, int y, Icon i) {
        this.x = x;
        this.y = y;
        this.jb = new JButton(i);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public void setHealth2(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}