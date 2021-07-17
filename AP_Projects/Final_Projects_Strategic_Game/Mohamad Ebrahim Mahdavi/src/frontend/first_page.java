package frontend;

import backend.Castle;
import backend.Hero;
import backend.Main;
import javax.swing.*;

public class first_page extends JFrame{
    private JTextField fire_x;
    private JTextField fire_y;
    private JTextField ice_x;
    private JTextField ice_y;
    private JTextField rock_x;
    private JTextField rock_y;
    private JTextField wind_x;
    private JTextField wind_y;
    private JButton confirm_A_btn;
    private JButton confirm_B_btn;
    private JTextField castle_x;
    private JTextField castle_y;
    private JPanel main_jpl;
    private JButton ready_btn;

    public first_page() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(main_jpl);
        confirm_A_btn.addActionListener(e -> {
            Main.s_main.heroes_A.add(new Hero(backend.Type.fire,Integer.parseInt(fire_x.getText()),Integer.parseInt(fire_y.getText()),true));
            Main.s_main.heroes_A.add(new Hero(backend.Type.ice,Integer.parseInt(ice_x.getText()),Integer.parseInt(ice_y.getText()),true));
            Main.s_main.heroes_A.add(new Hero(backend.Type.rock,Integer.parseInt(rock_x.getText()),Integer.parseInt(rock_y.getText()),true));
            Main.s_main.heroes_A.add(new Hero(backend.Type.wind,Integer.parseInt(wind_x.getText()),Integer.parseInt(wind_y.getText()),true));
            Main.s_main.castle_A = new Castle(Integer.parseInt(castle_x.getText()),Integer.parseInt(castle_y.getText()));
            JOptionPane.showMessageDialog(null,"Team A is ready!");
        });
        confirm_B_btn.addActionListener(e -> {
            Main.s_main.heroes_B.add(new Hero(backend.Type.fire,Integer.parseInt(fire_x.getText()),Integer.parseInt(fire_y.getText()),false));
            Main.s_main.heroes_B.add(new Hero(backend.Type.ice,Integer.parseInt(ice_x.getText()),Integer.parseInt(ice_y.getText()),false));
            Main.s_main.heroes_B.add(new Hero(backend.Type.rock,Integer.parseInt(rock_x.getText()),Integer.parseInt(rock_y.getText()),false));
            Main.s_main.heroes_B.add(new Hero(backend.Type.wind,Integer.parseInt(wind_x.getText()),Integer.parseInt(wind_y.getText()),false));
            Main.s_main.castle_B = new Castle(Integer.parseInt(castle_x.getText()),Integer.parseInt(castle_y.getText()));
            JOptionPane.showMessageDialog(null,"Team B is ready!");
        });
        ready_btn.addActionListener(e -> Main.s_main.main_thread.start());
    }
}
