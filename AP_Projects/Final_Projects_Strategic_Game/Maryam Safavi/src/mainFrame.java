import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class mainFrame extends JFrame {
    static Icon iconwind1 = new ImageIcon("D:\\mabani_Dr.Ramezani\\wind1.png");
    static Icon iconwind2 = new ImageIcon("D:\\mabani_Dr.Ramezani\\wind2.png");
    static Icon iconfire1 = new ImageIcon("D:\\mabani_Dr.Ramezani\\fire1.png");
    static Icon iconfire2 = new ImageIcon("D:\\mabani_Dr.Ramezani\\fire2.png");
    static Icon iconice1 = new ImageIcon("D:\\mabani_Dr.Ramezani\\ice1.png");
    static Icon iconice2 = new ImageIcon("D:\\mabani_Dr.Ramezani\\ice2.png");
    static Icon iconsoil1 = new ImageIcon("D:\\mabani_Dr.Ramezani\\soil1.png");
    static Icon iconsoil2 = new ImageIcon("D:\\mabani_Dr.Ramezani\\soil2 .png");
    static Icon siahchaleh = new ImageIcon("D:\\mabani_Dr.Ramezani\\tile_13.png");
    static Icon iconcastle2 = new ImageIcon("D:\\mabani_Dr.Ramezani\\redRoofStraight.png");
    static Ice hi = new Ice(210, 0, false, mainFrame.iconice1, 1);
    static Fire hf = new Fire(0, 0, false, mainFrame.iconfire1, 1);
    static Soil hs = new Soil(350, 70, false, mainFrame.iconsoil1, 1);
    static Wind hw = new Wind(560, 70, false, mainFrame.iconwind1, 1);
    static Ice hi2 = new Ice(490, 490, false, mainFrame.iconice2, 2);
    static Fire hf2 = new Fire(420, 560, false, mainFrame.iconfire2, 2);
    static Soil hs2 = new Soil(70, 490, false, mainFrame.iconsoil2, 2);
    static Wind hw2 = new Wind(140, 560, false, mainFrame.iconwind2, 2);
    static Fire f1 = new Fire(280, 70, true, mainFrame.iconfire1, 1);
    static Fire f2 = new Fire(280, 490, true, mainFrame.iconfire2, 2);
    static BlackHoles syah;
    static Castle c1 = new Castle(280, 560, iconcastle2);
    static Castle c2 = new Castle(280, 0, iconcastle2);
    static ArrayList<Hero> team1 = new ArrayList();
    static ArrayList<Hero> team2 = new ArrayList();
    static PrintWriter writer = null;
    static MyTask process;

    public mainFrame() throws FileNotFoundException {
        ScoreboardJframe.readScoreBoard();
        this.setTitle("Battle Of The Heroes");
        this.setSize(650, 671);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Board r1 = new Board();
        Random R = new Random();
        int x, y;
        do {
            int z = R.nextInt(560);
            if (z % 70 == 0) {
                x = z;
                break;
            }
        } while (true);
        do {
            int c = R.nextInt(350);
            if (c % 70 == 0 && c != 0 && c != 70 && c != 140) {
                y = c;
                break;
            }
        } while (true);
        syah = new BlackHoles(x, y, siahchaleh);
        team1.add(hf);
        team1.add(hw);
        team1.add(hi);
        team1.add(hs);
        team1.add(f1);
        team2.add(hf2);
        team2.add(hw2);
        team2.add(hi2);
        team2.add(hs2);
        team2.add(f2);
        this.add(hw.jb);
        this.add(hf.jb);
        this.add(hi.jb);
        this.add(hs.jb);
        this.add(hw2.jb);
        this.add(hf2.jb);
        this.add(hi2.jb);
        this.add(hs2.jb);
        this.add(c1.jb);
        this.add(c2.jb);
        this.add(f1.jb);
        this.add(f2.jb);
        this.add(syah.jb);
        hw.jb.setPreferredSize(new Dimension(70, 70));
        hf.jb.setPreferredSize(new Dimension(70, 70));
        hi.jb.setPreferredSize(new Dimension(70, 70));
        hs.jb.setPreferredSize(new Dimension(70, 70));
        hw2.jb.setPreferredSize(new Dimension(70, 70));
        hf2.jb.setPreferredSize(new Dimension(70, 70));
        hi2.jb.setPreferredSize(new Dimension(70, 70));
        hs2.jb.setPreferredSize(new Dimension(70, 70));
        c1.jb.setPreferredSize(new Dimension(70, 70));
        c2.jb.setPreferredSize(new Dimension(70, 70));
        f1.jb.setPreferredSize(new Dimension(70, 70));
        f2.jb.setPreferredSize(new Dimension(70, 70));
        syah.jb.setPreferredSize(new Dimension(70, 70));
        c1.jb.setBounds(c1.getX(), c1.getY(), c1.jb.getPreferredSize().width, c1.jb.getPreferredSize().height);
        c2.jb.setBounds(c2.getX(), c2.getY(), c2.jb.getPreferredSize().width, c2.jb.getPreferredSize().height);
        hi.jb.setBounds(hi.getX(), hi.getY(), hi.jb.getPreferredSize().width, hi.jb.getPreferredSize().height);
        hw.jb.setBounds(hw.getX(), hw.getY(), hw.jb.getPreferredSize().width, hw.jb.getPreferredSize().height);
        hs.jb.setBounds(hs.getX(), hs.getY(), hs.jb.getPreferredSize().width, hs.jb.getPreferredSize().height);
        hf.jb.setBounds(hf.getX(), hf.getY(), hf.jb.getPreferredSize().width, hf.jb.getPreferredSize().height);
        hi2.jb.setBounds(hi2.getX(), hi2.getY(), hi2.jb.getPreferredSize().width, hi2.jb.getPreferredSize().height);
        hw2.jb.setBounds(hw2.getX(), hw2.getY(), hw2.jb.getPreferredSize().width, hw2.jb.getPreferredSize().height);
        hs2.jb.setBounds(hs2.getX(), hs2.getY(), hs2.jb.getPreferredSize().width, hs2.jb.getPreferredSize().height);
        hf2.jb.setBounds(hf2.getX(), hf2.getY(), hf2.jb.getPreferredSize().width, hf2.jb.getPreferredSize().height);
        f1.jb.setBounds(f1.getX(), f1.getY(), f1.jb.getPreferredSize().width, f1.jb.getPreferredSize().height);
        f2.jb.setBounds(f2.getX(), f2.getY(), f2.jb.getPreferredSize().width, f2.jb.getPreferredSize().height);
        syah.jb.setBounds(x, y, syah.jb.getPreferredSize().width, syah.jb.getPreferredSize().height);
        this.add(r1);
        this.setVisible(true);
        ScoreboardJframe.startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    process = new MyTask();
                    process.execute();
                } catch (Exception b) {
                    b.printStackTrace();
                }
            }
        });
        ScoreboardJframe.stopbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    process.stop();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        ScoreboardJframe.exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ScoreboardJframe.savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writer = new PrintWriter("ScoreBoard2.csv");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                writer.print("");
                try {
                    ScoreboardJframe.writeScoreBoard();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        ScoreboardJframe.resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hw.jb.setVisible(true);
                hi.jb.setVisible(true);
                hf.jb.setVisible(true);
                hs.jb.setVisible(true);
                hw2.jb.setVisible(true);
                hi2.jb.setVisible(true);
                hf2.jb.setVisible(true);
                hs2.jb.setVisible(true);
                hf.setX2(0);
                hf.setY2(0);
                hw.setX2(560);
                hw.setY2(70);
                hs.setX2(350);
                hs.setY2(70);
                hi.setX2(210);
                hi.setY2(0);
                hf2.setX2(420);
                hf2.setY2(560);
                hw2.setX2(140);
                hw2.setY2(560);
                hs2.setX2(70);
                hs2.setY2(490);
                hi2.setX2(490);
                hi2.setY2(490);
                hf.setHealth2(25);
                hw.setHealth2(75);
                hi.setHealth2(100);
                hs.setHealth2(50);
                hf2.setHealth2(25);
                hw2.setHealth2(75);
                hi2.setHealth2(100);
                hs2.setHealth2(50);
                c1.setHealth2(20);
                c2.setHealth2(20);
                f1.setHealth2(25);
                f2.setHealth2(25);
                hi.jb.setBounds(210, 0, hi.jb.getPreferredSize().width, hi.jb.getPreferredSize().height);
                hw.jb.setBounds(560, 70, hw.jb.getPreferredSize().width, hw.jb.getPreferredSize().height);
                hs.jb.setBounds(350, 70, hs.jb.getPreferredSize().width, hs.jb.getPreferredSize().height);
                hf.jb.setBounds(0, 0, hf.jb.getPreferredSize().width, hf.jb.getPreferredSize().height);
                hi2.jb.setBounds(490, 490, hi2.jb.getPreferredSize().width, hi2.jb.getPreferredSize().height);
                hw2.jb.setBounds(140, 560, hw2.jb.getPreferredSize().width, hw2.jb.getPreferredSize().height);
                hs2.jb.setBounds(70, 490, hs2.jb.getPreferredSize().width, hs2.jb.getPreferredSize().height);
                hf2.jb.setBounds(420, 560, hf2.jb.getPreferredSize().width, hf2.jb.getPreferredSize().height);
                ScoreboardJframe.jt.getModel().setValueAt(hf.getX() / 70, 0, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hf.getY() / 70, 0, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hs.getX() / 70, 3, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hs.getY() / 70, 3, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hi.getX() / 70, 2, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hi.getY() / 70, 2, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hw.getX() / 70, 1, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hw.getY() / 70, 1, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hf2.getX() / 70, 5, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hf2.getY() / 70, 5, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hs2.getX() / 70, 8, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hs2.getY() / 70, 8, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hi2.getX() / 70, 7, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hi2.getY() / 70, 7, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hw2.getX() / 70, 6, 1);
                ScoreboardJframe.jt.getModel().setValueAt(hw2.getY() / 70, 6, 2);
                ScoreboardJframe.jt.getModel().setValueAt(f1.getX() / 70, 4, 1);
                ScoreboardJframe.jt.getModel().setValueAt(f1.getY() / 70, 4, 2);
                ScoreboardJframe.jt.getModel().setValueAt(f2.getX() / 70, 9, 1);
                ScoreboardJframe.jt.getModel().setValueAt(f2.getY() / 70, 9, 2);
                ScoreboardJframe.jt.getModel().setValueAt(hi.getHealth(), 2, 3);
                ScoreboardJframe.jt.getModel().setValueAt(hf.getHealth(), 0, 3);
                ScoreboardJframe.jt.getModel().setValueAt(hw.getHealth(), 1, 3);
                ScoreboardJframe.jt.getModel().setValueAt(hs.getHealth(), 3, 3);
                ScoreboardJframe.jt.getModel().setValueAt(f1.getHealth(), 4, 3);
                ScoreboardJframe.jt.getModel().setValueAt(f2.getHealth(), 9, 3);
                ScoreboardJframe.jt.getModel().setValueAt(100, 7, 3);
                ScoreboardJframe.jt.getModel().setValueAt(25, 5, 3);
                ScoreboardJframe.jt.getModel().setValueAt(75, 6, 3);
                ScoreboardJframe.jt.getModel().setValueAt(50, 8, 3);
                ScoreboardJframe.jt.getModel().setValueAt(20, 11, 3);
                ScoreboardJframe.jt.getModel().setValueAt(20, 10, 3);
                game.sb.jb2.setValue(0);
                mainFrame.hf.stop();
                mainFrame.hs.stop();
                mainFrame.hi.stop();
                mainFrame.hw.stop();
                mainFrame.hf2.stop();
                mainFrame.hs2.stop();
                mainFrame.hi2.stop();
                mainFrame.hw2.stop();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }

    public static int search(Hero h) {
        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i) == h) {
                return i;
            }
        }
        for (int j = 0; j < team2.size(); j++) {
            if (team2.get(j) == h) {
                return j + 5;
            }
        }
        return 0;
    }

    public static void move1(Hero h, int xc, int yc) {
        int z = search(h);
        if (Math.abs(xc - h.getX()) > Math.abs(yc - h.getY())) {
            if (h.getY() == yc && Math.abs(xc - h.getX()) == 70) {
                if (h.getX() < xc) {
                    h.setX(+70);
                } else {
                    h.setX(-70);
                }

            } else {
                if (h.getX() < xc) {
                    h.setX(+(70 * h.getSpeed()));
                } else {
                    h.setX(-(70 * h.getSpeed()));
                }
            }
            ScoreboardJframe.jt.getModel().setValueAt(h.getX() / 70, z, 1);
        } else {
            if (Math.abs(yc - h.getY()) == 70 && xc == h.getX()) {
                h.setY(+70);
            } else {
                if (h.getY() + (70 * h.getSpeed()) > 560) {
                    if (h.getX() < xc) {
                        h.setX(+(70 * h.getSpeed()));
                    } else {
                        h.setX(-(70 * h.getSpeed()));
                    }
                } else {
                    h.setY(+(70 * h.getSpeed()));
                }
            }
            ScoreboardJframe.jt.getModel().setValueAt(h.getY() / 70, z, 2);
        }

    }

    public static void move2(Hero h, int xc, int yc) {
        int z = search(h);
        if (Math.abs(xc - h.getX()) > Math.abs(yc - h.getY())) {
            if (h.getY() == yc && Math.abs(xc - h.getX()) == 70) {
                if (h.getX() < xc) {
                    h.setX(+70);
                } else {
                    h.setX(-70);
                }

            } else {
                if (h.getX() < xc) {
                    h.setX(+(70 * h.getSpeed()));
                } else {
                    h.setX(-(70 * h.getSpeed()));
                }
            }
            ScoreboardJframe.jt.getModel().setValueAt(h.getX() / 70, z, 1);
        } else {
            if (Math.abs(yc - h.getY()) == 70 && xc == h.getX()) {
                h.setY(-70);
            } else {
                if (h.getY() - (70 * h.getSpeed()) < 0) {
                    if (h.getX() < xc) {
                        h.setX(+(70 * h.getSpeed()));
                    } else {
                        h.setX(-(70 * h.getSpeed()));
                    }
                } else {
                    h.setY(-(70 * h.getSpeed()));
                }
            }
            ScoreboardJframe.jt.getModel().setValueAt(h.getY() / 70, z, 2);
        }

    }

    public static boolean checkSyahchale(Hero h) {
        if (h.getX() == syah.getX() && h.getY() == syah.getY()) {
            return true;
        }
        return false;
    }

    public static void checkWar1(Hero h) throws InterruptedException {
        String name1 = null, name2 = null;
        int x = 0, y = 0;
        L3:
        for (int i = 0; i < team1.size(); i++) {
            y = search(team1.get(i));
            x = search(h);
            if (team1.get(i).getX() == h.getX() && team1.get(i).getY() == h.getY()) {
                if (team1.get(i) instanceof Ice) {
                    name1 = "ice1";
                } else if (team1.get(i) instanceof Wind) {
                    name1 = "wind1";
                } else if (team1.get(i) instanceof Fire) {
                    name1 = "fire1";
                } else if (team1.get(i) instanceof Soil) {
                    name1 = "soil1";
                }

                if (h instanceof Fire) {
                    name2 = "fire2";
                } else if (h instanceof Soil) {
                    name2 = "soil2";
                } else if (h instanceof Ice) {
                    name2 = "ice2";
                } else if (h instanceof Wind) {
                    name2 = "wind2";
                }
                while (true) {
                    team1.get(i).setHealth(h.getPower());
                    h.setHealth(team1.get(i).getPower());
                    game.sb.jb.setValue(game.sb.i);
                    game.sb.i += 50;
                    Thread.sleep(50);
                    ScoreboardJframe.jt.getModel().setValueAt(team1.get(i).getHealth(), y, 3);
                    ScoreboardJframe.jt.getModel().setValueAt(h.getHealth(), x, 3);

                    if (team1.get(i).getHealth() <= 0) {
                        ScoreboardJframe.jt.getModel().setValueAt("0", y, 3);
                        if (team1.get(i) instanceof Wind) {
                            team1.get(i).stop();
                            team1.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (team1.get(i) instanceof Ice) {
                            team1.get(i).stop();
                            team1.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (team1.get(i) instanceof Fire) {
                            team1.get(i).stop();
                            team1.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);

                        } else if (team1.get(i) instanceof Soil) {
                            team1.get(i).stop();
                            team1.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break L3;
                    } else if (h.getHealth() <= 0) {
                        ScoreboardJframe.jt.getModel().setValueAt("0", x, 3);
                        if (h instanceof Fire) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (h instanceof Soil) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (h instanceof Wind) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (h instanceof Ice) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break L3;
                    }
                }
            }
        }
    }

    public static void checkWar2(Hero h) throws InterruptedException {
        String name1 = null, name2 = null;
        int x = 0, y = 0;
        L3:
        for (int i = 0; i < team2.size(); i++) {
            y = search(team2.get(i));
            x = search(h);
            if (team2.get(i).getX() == h.getX() && team2.get(i).getY() == h.getY()) {
                if (team2.get(i) instanceof Fire) {
                    name1 = "fire2";
                } else if (team2.get(i) instanceof Soil) {
                    name1 = "soil2";
                } else if (team2.get(i) instanceof Ice) {
                    name1 = "ice2";
                } else if (team2.get(i) instanceof Wind) {
                    name1 = "wind2";
                }

                if (h instanceof Ice) {
                    name2 = "ice1";
                } else if (h instanceof Wind) {
                    name2 = "wind1";
                } else if (h instanceof Fire) {
                    if (h.define) {
                    } else {
                    }
                    name2 = "fire1";
                } else if (h instanceof Soil) {
                    name2 = "soil1";
                }
                while (true) {
                    team2.get(i).setHealth(h.getPower());
                    h.setHealth(team2.get(i).getPower());
                    game.sb.jb.setValue(game.sb.i);
                    game.sb.i += 50;
                    Thread.sleep(50);
                    ScoreboardJframe.jt.getModel().setValueAt(team2.get(i).getHealth(), y, 3);
                    ScoreboardJframe.jt.getModel().setValueAt(h.getHealth(), x, 3);
                    if (team2.get(i).getHealth() <= 0) {
                        ScoreboardJframe.jt.getModel().setValueAt("0", y, 3);
                        if (team2.get(i) instanceof Fire) {
                            team2.get(i).stop();
                            team2.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (team2.get(i) instanceof Soil) {
                            team2.get(i).stop();
                            team2.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (team2.get(i) instanceof Wind) {
                            team2.get(i).stop();
                            team2.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (team2.get(i) instanceof Ice) {
                            team2.get(i).stop();
                            team2.get(i).jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name2 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break L3;
                    } else if (h.getHealth() <= 0) {
                        ScoreboardJframe.jt.getModel().setValueAt("0", x, 3);
                        if (h instanceof Wind) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (h instanceof Ice) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (h instanceof Fire) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        } else if (h instanceof Soil) {
                            h.stop();
                            h.jb.setVisible(false);
                            JOptionPane.showMessageDialog(hw.jb, "The hero type " + name1 + " won", "result of the battle", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break L3;
                    }
                }
            }
        }
    }

    public static void checkCastle1(Hero h) throws InterruptedException {

        if (h.getX() == c1.getX() && h.getY() == c1.getY()) {
            while (true) {
                game.sb.jb2.setValue(game.sb.i2);
                game.sb.i2 += 50;
                c1.setHealth(h.getPower());
                ScoreboardJframe.jt.getModel().setValueAt(c1.getHealth(), 11, 3);
                Thread.sleep(0);
                if (c1.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(c1.jb, "team1 won", "result of the game", JOptionPane.INFORMATION_MESSAGE);
                    process.stop();
                    ScoreboardJframe.jt.getModel().setValueAt("0", 11, 3);
                    break;
                }
            }
        }
    }

    public static void checkCastle2(Hero h) throws InterruptedException {
        if (h.getX() == c2.getX() && h.getY() == c2.getY()) {
            while (true) {
                game.sb.jb2.setValue(game.sb.i2);
                game.sb.i2 += 50;
                c2.setHealth(h.getPower());
                ScoreboardJframe.jt.getModel().setValueAt(c2.getHealth(), 10, 3);
                Thread.sleep(50);
                if (c2.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(c2.jb, "team2 won", "result of the game", JOptionPane.INFORMATION_MESSAGE);
                    process.stop();
                    ScoreboardJframe.jt.getModel().setValueAt("0", 10, 3);
                    break;
                }
            }
        }

    }
}

class MyTask extends SwingWorker {
    @Override
    protected Object doInBackground() throws Exception {
        mainFrame.hf.run2();
        mainFrame.hs.run2();
        mainFrame.hi.run2();
        mainFrame.hw.run2();
        mainFrame.hf2.run2();
        mainFrame.hs2.run2();
        mainFrame.hi2.run2();
        mainFrame.hw2.run2();
        return null;
    }

    public void stop() throws InterruptedException {
        mainFrame.hf.stop();
        mainFrame.hs.stop();
        mainFrame.hi.stop();
        mainFrame.hw.stop();
        mainFrame.hf2.stop();
        mainFrame.hs2.stop();
        mainFrame.hi2.stop();
        mainFrame.hw2.stop();
        Thread.sleep(100);
    }
}