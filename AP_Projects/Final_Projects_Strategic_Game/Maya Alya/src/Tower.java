import java.awt.*;

public class Tower {
    public int health;
    public Sprite shape;
    public Tower(int x, int y, int w, int h, Color color)
    {
        health = 10000;
        shape = new Sprite(x,y,w,h,1,1,color);
    }
}
