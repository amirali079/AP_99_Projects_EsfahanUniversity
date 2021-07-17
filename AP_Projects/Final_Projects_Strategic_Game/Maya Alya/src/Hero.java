import java.awt.*;

public class Hero {
    public int power;
    public int speed;
    public int health;
    protected int x;
    protected int y;
    public Sprite shape;
    public MovingThread movingThread;

    public void setX(int x) {
        this.x = x;
        shape.x = x*50+10;
    }

    public void setY(int y) {
        this.y = y;
        shape.y = y*100+10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Hero(int power, int speed, int health, int x, int y, Sprite shape)
    {
        movingThread = new MovingThread();
        this.power = power;
        this.health = health;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.shape = shape;
    }
}
