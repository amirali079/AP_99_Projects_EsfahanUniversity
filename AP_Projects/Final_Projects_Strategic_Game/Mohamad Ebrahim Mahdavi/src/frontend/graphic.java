package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class graphic extends JFrame {
    public ArrayList<JPanel> panels = new ArrayList<>();
    public ArrayList<ArrayList<JLabel>> labels = new ArrayList<>();
    public graphic() throws HeadlessException {
        setLayout(new GridLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,500);
    }
    public void set_game_size(int row,int column) {
        for (int i=0;i<row;i++) {
            JPanel temp = new JPanel();
            panels.add(temp);
            labels.add(new ArrayList<>());
            add(temp);
        }
        for (JPanel j:panels) {
            for (int i=0;i<column;i++) {
                JLabel temp = new JLabel();
                j.add(temp);
                labels.get(panels.indexOf(j)).add(temp);
            }
        }
    }

}
