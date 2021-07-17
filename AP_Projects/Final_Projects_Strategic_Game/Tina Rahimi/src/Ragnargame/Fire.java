package Ragnargame;

import javax.swing.*;

public class Fire extends Hero{

    public Fire(String Team, int x, int y) {
        super(100, 10, 1, Team, x, y);

        if(Team.equals(Name.Team1)) {
            setImg(new ImageIcon("src/Ragnargame2/Fire1.png"));
        } else {
            setImg(new ImageIcon("src/Ragnargame2/Fire2.png"));
        }
    } 
}
