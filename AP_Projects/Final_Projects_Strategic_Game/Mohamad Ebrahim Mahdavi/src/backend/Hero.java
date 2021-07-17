package backend;

import javax.swing.*;
import java.util.ArrayList;

public class Hero extends Thread{
    public Type properties;
    boolean team_A;
    final Main t_main = Main.s_main;
    public static final Object so = new Object();
    public static final Object so2 = new Object();
    public int point;
    ArrayList<Integer>coordination = new ArrayList<>();
    ArrayList<Integer>next_coordination = new ArrayList<>();
    ArrayList<Integer>enemy_castle = new ArrayList<>();
    boolean movement_permission = false;
    public Hero(Type properties, int x, int y,boolean team_A) {
        this.properties = properties;
        coordination.add(x);
        coordination.add(y);
        this.team_A = team_A;
    }

    @Override
    public void run() {
        Main.mp.buttons.get(coordination.get(1)).get(coordination.get(0)).setText(properties.name());
        enemy_castle.clear();
        next_coordination.clear();
        if (team_A) {
            enemy_castle.add(Main.s_main.castle_B.coordination.get(0));
            enemy_castle.add(Main.s_main.castle_B.coordination.get(1));
        }
        else {
            enemy_castle.add(Main.s_main.castle_A.coordination.get(0));
            enemy_castle.add(Main.s_main.castle_A.coordination.get(1));
        }
        next_coordination.add(0);
        next_coordination.add(0);
        while (properties.health>0 & t_main.castle_A.health>0 & t_main.castle_B.health>0 & t_main.statues) {
            //____________________
            int i;
            if (Math.abs(coordination.get(0) - enemy_castle.get(0)) > Math.abs(coordination.get(1) - enemy_castle.get(1)))
                i = 0;
            else
                i = 1;
            //_______________
            if (coordination.get(i) - enemy_castle.get(i) >= 0) {
                if (coordination.get(i) - enemy_castle.get(i) >= properties.speed)
                    next_coordination.add(i, coordination.get(i) - properties.speed);
                else
                    next_coordination.add(i, enemy_castle.get(i));
            } else {
                if (enemy_castle.get(i) - coordination.get(i) >= properties.speed)
                    next_coordination.add(i, coordination.get(i) + properties.speed);
                else
                    next_coordination.add(i, enemy_castle.get(i));
            }
            next_coordination.remove(i+1);
            next_coordination.add(1 - i, coordination.get(1 - i));
            next_coordination.remove(2-i);

            synchronized (t_main) {
                if (team_A)
                    t_main.confirmed_A.add(this);
                else
                    t_main.confirmed_B.add(this);
                t_main.notifyAll();
            }

                while (!t_main.first_processing_done) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            synchronized (so) {
                if (movement_permission) {
                    Main.mp.buttons.get(coordination.get(1)).get(coordination.get(0)).setText("");
                    coordination.clear();
                    coordination.addAll(next_coordination);
                }
                Main.mp.buttons.get(coordination.get(1)).get(coordination.get(0)).setText(properties.name());
                Main.mp.repaint();
            }
            movement_permission = false;
            synchronized (so2) {
                while (!t_main.second_processing_done) {
                    try {
                        so2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        if (properties.health<=0) {
            if (team_A)
                t_main.heroes_A.remove(this);
            else
                t_main.heroes_B.remove(this);
            Main.mp.buttons.get(coordination.get(1)).get(coordination.get(0)).setText("");
            JOptionPane.showMessageDialog(null,properties.name()+" destroyed!");
        }
    }
}
