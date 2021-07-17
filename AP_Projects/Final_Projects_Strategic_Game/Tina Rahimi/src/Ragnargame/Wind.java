package Ragnargame;

import javax.swing.*;

public class Wind extends Hero {

    public Wind(String Team, int x, int y) {
        super(100, 10, 1, Team, x, y);

        if(Team.equals(Name.Team1)) {
            setImg(new ImageIcon("src/Ragnargame2/Wind1.png"));
        } else {
            setImg(new ImageIcon("src/Ragnargame2/wind2.png"));
        }

    }

}
