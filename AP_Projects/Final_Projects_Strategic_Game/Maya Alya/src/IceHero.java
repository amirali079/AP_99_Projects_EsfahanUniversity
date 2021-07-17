import java.awt.*;

public class IceHero extends Hero{

    public IceHero(int power,
                   int speed,
                   int health,
                   int x,
                   int y, Color color) {
        super(power, speed, health, x, y,new Sprite(x*50+10,y*100+10,80,100,10,2, color));

    }
}
