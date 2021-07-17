import javax.swing.*;

public class BlackHoles {
    private int x, y;
    public JButton jb;

    public BlackHoles(int x, int y, Icon i) {
        this.x = x;
        this.y = y;
        jb = new JButton(i);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
