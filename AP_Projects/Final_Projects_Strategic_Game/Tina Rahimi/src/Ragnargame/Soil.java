package Ragnargame;

import javax.swing.*;

public class Soil extends Hero{
    
    public Soil(String Team, int x, int y) {
        super(100, 10, 1, Team, x, y);

        if(Team.equals(Name.Team1)) {
            setImg(new ImageIcon("src/Ragnargame2/Soil1.png"));
        } else {
            setImg(new ImageIcon("src/Ragnargame2/Soil2.png"));
        }

    }
    
}
