import java.awt.*;

public class WindHero extends Hero{
    public WindHero(int power,
                   int speed,
                   int health,
                   int x,
                   int y, Color color) {
        super(power, speed, health, x, y,new Sprite(x*50+10,y*100+10,100,30,10,1, color));

    }
}
