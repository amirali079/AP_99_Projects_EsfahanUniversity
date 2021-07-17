
package Ragnargame;

import javax.swing.*;

public class Ice extends Hero{

    public Ice(String Team, int x, int y) {
        super(100, 10, 1, Team, x, y);

        if(Team.equals(Name.Team1)) {
            setImg(new ImageIcon("src/Ragnargame2/Ice1.png"));
        } else {
            setImg(new ImageIcon("src/Ragnargame2/Ice2.png"));
        }
    }
    
}
