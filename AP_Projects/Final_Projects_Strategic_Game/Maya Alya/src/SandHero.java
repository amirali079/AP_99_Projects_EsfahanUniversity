import java.awt.*;

public class SandHero extends Hero{
    public SandHero(int power,
                   int speed,
                   int health,
                   int x,
                   int y, Color color) {
        super(power, speed, health, x, y,new Sprite(x*50+10,y*100+10,50,50,1,1, color));

    }
}
