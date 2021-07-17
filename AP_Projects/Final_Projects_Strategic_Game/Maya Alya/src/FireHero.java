import java.awt.*;

public class FireHero extends Hero{

    public FireHero(int power,
                   int speed,
                   int health,
                   int x,
                   int y, Color color) {
        super(power, speed, health, x, y,new Sprite(x*50+10,y*100+10,100,100,10,10, color));
    }
}
