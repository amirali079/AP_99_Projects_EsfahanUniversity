package backend;

import java.util.ArrayList;

public class Castle {
    ArrayList<Integer>coordination = new ArrayList<>();
    public int health = 120;

    public Castle(int x, int y) {
        coordination.add(x);
        coordination.add(y);
        Main.mp.buttons.get(y).get(x).setText("Castle");
    }
}
