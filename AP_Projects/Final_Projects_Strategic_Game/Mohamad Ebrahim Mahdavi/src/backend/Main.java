package backend;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import frontend.*;

public class Main {
    public static Main s_main = new Main();
    public static main_page mp;
    public static final Object so = new Object();
    public Castle castle_A;
    public Castle castle_B;
    public boolean statues = true;
    public ArrayList<Hero>heroes_A = new ArrayList<>();
    public ArrayList<Hero>heroes_B = new ArrayList<>();
    ArrayList<Hero>confirmed_A = new ArrayList<>();
    ArrayList<Hero>confirmed_B = new ArrayList<>();
    boolean first_processing_done = false;
    boolean second_processing_done = false;

    public Thread main_thread = new Thread(() -> {
        for (Hero h:heroes_A)
            h.start();
        for (Hero h:heroes_B)
            h.start();
        while (castle_B.health>0 & castle_A.health>0 & statues) {
            synchronized (this) {
                while (confirmed_A.size()<heroes_A.size() & confirmed_B.size()<heroes_B.size()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //_________________________
            for (Hero h:heroes_A) {
                if (h.next_coordination.equals(castle_B.coordination)) {
                    h.movement_permission = true;
                    confirmed_A.remove(h);
                    castle_B.health -= h.properties.power;
                    h.point += h.properties.power;
                    continue;
                }
                boolean shared_coordination = false;
                for (Hero g:confirmed_A)
                    if (h.next_coordination.equals(g.next_coordination)) {
                        h.movement_permission = confirmed_A.indexOf(h) <= confirmed_A.indexOf(g);
                        shared_coordination = true;
                    }
                if (!shared_coordination)
                    h.movement_permission = true;
                confirmed_A.remove(h);
            }
            //__________________________
            for (Hero h:heroes_B) {
                if (h.next_coordination.equals(castle_A.coordination)) {
                    h.movement_permission = true;
                    confirmed_B.remove(h);
                    castle_A.health -= h.properties.power;
                    h.point += h.properties.power;
                    continue;
                }
                boolean shared_coordination = false;
                for (Hero g:confirmed_B)
                    if (h.next_coordination.equals(g.next_coordination)) {
                        h.movement_permission = confirmed_B.indexOf(h) <= confirmed_B.indexOf(g);
                        shared_coordination = true;
                    }
                if (!shared_coordination)
                    h.movement_permission = true;
                confirmed_B.remove(h);
            }

            synchronized (so) {
                second_processing_done = false;
                first_processing_done = true;
                for (Hero h:heroes_A) {
                    synchronized (h) {
                        h.notifyAll();
                    }
                }
                for (Hero h:heroes_B) {
                    synchronized (h) {
                        h.notifyAll();
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                first_processing_done = false;
            }
            //__________________________
            for (Hero h:heroes_A)
                for (Hero g:heroes_B)
                    if (h.coordination.equals(g.coordination))
                    {
                        h.properties.health -= g.properties.power;
                        g.properties.health -= h.properties.power;
                        h.point += h.properties.power;
                        g.point += g.properties.power;
                        break;
                    }

            second_processing_done = true;
            for (Hero ignored :heroes_A) {
                synchronized (Hero.so2) {
                    Hero.so2.notifyAll();
                    System.out.println("second processing done!");
                }
            }
            for (Hero ignored :heroes_B) {
                synchronized (Hero.so2) {
                    Hero.so2.notifyAll();
                }
            }
            if (heroes_B.isEmpty() & heroes_A.isEmpty()) {
                castle_B.health = 0;
                castle_A.health = 0;
                break;
            }
        }
        if (castle_A.health<=0 & castle_B.health<=0)
            JOptionPane.showMessageDialog(null,"Its a draw!");
        else if (castle_A.health<=0)
            JOptionPane.showMessageDialog(null,"Team B is the winner!");
        else if(!statues) {
            JOptionPane.showMessageDialog(null,"Game stopped!");
            for (Hero h:heroes_A)
                h.movement_permission = false;
            for (Hero h:heroes_B)
                h.movement_permission = false;
            first_processing_done = true;
            second_processing_done = true;
            try {
                Thread.sleep(2000);
                first_processing_done = false;
                second_processing_done = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Team A is the winner!");
    });

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the columns number in order:");
        mp = new main_page();
        mp.set_game_size(Integer.parseInt(sc.nextLine()));
        mp.setVisible(true);
        new Thread(() -> {
            first_page fp = new first_page();
            fp.setVisible(true);
        }).start();
    }
}
//_____________________

