package Main;

import java.io.Serializable;

public class Castle extends GameObjects implements Serializable {

    public Castle(Team team , int health , int power , int locationX , int locationY , int red , int green , int blue){
        super(team , health ,power ,locationX ,locationY , red ,green , blue);
    }

}
