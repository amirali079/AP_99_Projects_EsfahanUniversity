import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreboardJframe extends JFrame {
    static int i, i2;
    static String data[][] = {
            {"Fire1", String.valueOf(mainFrame.hf.getX() / 70), String.valueOf(mainFrame.hf.getY() / 70), String.valueOf(mainFrame.hf.getHealth()), String.valueOf(mainFrame.hf.getPower())},
            {"Wind1", String.valueOf(mainFrame.hw.getX() / 70), String.valueOf(mainFrame.hw.getY() / 70), String.valueOf(mainFrame.hw.getHealth()), String.valueOf(mainFrame.hw.getPower())},
            {"Ice1", String.valueOf(mainFrame.hi.getX() / 70), String.valueOf(mainFrame.hi.getY() / 70), String.valueOf(mainFrame.hi.getHealth()), String.valueOf(mainFrame.hi.getPower())},
            {"Soil1", String.valueOf(mainFrame.hs.getX() / 70), String.valueOf(mainFrame.hs.getY() / 70), String.valueOf(mainFrame.hs.getHealth()), String.valueOf(mainFrame.hs.getPower())},
            {"Defensive fire1", String.valueOf(mainFrame.f1.getX() / 70), String.valueOf(mainFrame.f1.getY() / 70), String.valueOf(mainFrame.f1.getHealth()), String.valueOf(mainFrame.f1.getPower())},
            {"Fire2", String.valueOf(mainFrame.hf2.getX() / 70), String.valueOf(mainFrame.hf2.getY() / 70), String.valueOf(mainFrame.hf2.getHealth()), String.valueOf(mainFrame.hf2.getPower())},
            {"Wind2", String.valueOf(mainFrame.hw2.getX() / 70), String.valueOf(mainFrame.hw2.getY() / 70), String.valueOf(mainFrame.hw2.getHealth()), String.valueOf(mainFrame.hw2.getPower())},
            {"Ice2", String.valueOf(mainFrame.hi2.getX() / 70), String.valueOf(mainFrame.hi2.getY() / 70), String.valueOf(mainFrame.hi2.getHealth()), String.valueOf(mainFrame.hi2.getPower())},
            {"Soil2", String.valueOf(mainFrame.hs2.getX() / 70), String.valueOf(mainFrame.hs2.getY() / 70), String.valueOf(mainFrame.hs2.getHealth()), String.valueOf(mainFrame.hs2.getPower())},
            {"Defensive fire2", String.valueOf(mainFrame.f2.getX() / 70), String.valueOf(mainFrame.f2.getY() / 70), String.valueOf(mainFrame.f2.getHealth()), String.valueOf(mainFrame.f2.getPower())},
            {"Castle(N)", String.valueOf(mainFrame.c2.getX() / 70), String.valueOf(mainFrame.c2.getY() / 70), String.valueOf(mainFrame.c2.getHealth()), "0"},
            {"Castle(S)", String.valueOf(mainFrame.c1.getX() / 70), String.valueOf(mainFrame.c1.getY() / 70), String.valueOf(mainFrame.c1.getHealth()), "0"}};

    static JButton stopbtn = new JButton("STOP");
    static JButton exitbtn = new JButton("EXIT");
    static JButton startbtn = new JButton("START");
    static JButton savebtn = new JButton("SAVE");
    static JButton resetbtn = new JButton("RESET");
    static JProgressBar jb;
    static JProgressBar jb2;
    JLabel lbl = new JLabel("War between two hero : ");
    JLabel lbl2 = new JLabel("Hero attack on the castle : ");

    static private TableModel getTableModel() {
        String column[] = {"Hero", "location(x)", "location(y)", "Health", "Power"};
        DefaultTableModel model = new DefaultTableModel(data, column);
        return model;
    }

    static JTable jt = new JTable(getTableModel());

    public ScoreboardJframe() {
        this.setSize(470, 380);
        this.setResizable(false);
        this.setTitle("ScoreBoard");
        SpringLayout sp = new SpringLayout();
        Container cre = new Container();
        this.setLayout(sp);
        JScrollPane sp2 = new JScrollPane(jt);
        sp2.setPreferredSize(new Dimension(470, 213));
        jb = new JProgressBar(0, 50);
        jb.setBounds(40, 40, 160, 30);
        jb.setValue(0);
        jb.setStringPainted(true);
        jb2 = new JProgressBar(0, 20);
        jb2.setBounds(40, 40, 160, 30);
        jb2.setValue(0);
        jb2.setStringPainted(true);
        this.add(lbl);
        this.add(lbl2);
        this.add(jb);
        this.add(jb2);
        this.add(sp2);
        resetbtn.setBackground(Color.white);
        this.add(resetbtn);
        stopbtn.setBackground(Color.YELLOW);
        this.add(stopbtn);
        exitbtn.setBackground(Color.RED);
        this.add(exitbtn);
        startbtn.setBackground(Color.green);
        this.add(startbtn);
        savebtn.setBackground(Color.pink);
        this.add(savebtn);
        sp.putConstraint(SpringLayout.WEST, sp2, 0, SpringLayout.WEST, cre);
        sp.putConstraint(SpringLayout.NORTH, sp2, 0, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, startbtn, 30, SpringLayout.WEST, cre);
        sp.putConstraint(SpringLayout.NORTH, startbtn, 290, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, stopbtn, 10, SpringLayout.EAST, startbtn);
        sp.putConstraint(SpringLayout.NORTH, stopbtn, 290, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, exitbtn, 10, SpringLayout.EAST, stopbtn);
        sp.putConstraint(SpringLayout.NORTH, exitbtn, 290, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, savebtn, 10, SpringLayout.EAST, exitbtn);
        sp.putConstraint(SpringLayout.NORTH, savebtn, 290, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, resetbtn, 10, SpringLayout.EAST, savebtn);
        sp.putConstraint(SpringLayout.NORTH, resetbtn, 290, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, jb, 250, SpringLayout.WEST, cre);
        sp.putConstraint(SpringLayout.NORTH, jb, 220, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, lbl, 10, SpringLayout.WEST, cre);
        sp.putConstraint(SpringLayout.NORTH, lbl, 220, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, jb2, 250, SpringLayout.WEST, cre);
        sp.putConstraint(SpringLayout.NORTH, jb2, 250, SpringLayout.NORTH, cre);
        sp.putConstraint(SpringLayout.WEST, lbl2, 10, SpringLayout.WEST, cre);
        sp.putConstraint(SpringLayout.NORTH, lbl2, 250, SpringLayout.NORTH, cre);
        this.setVisible(true);
    }

    public static void writeScoreBoard() throws IOException {
        FileWriter cities = new FileWriter("ScoreBoard2.csv", true);
        CSVWriter f = new CSVWriter(cities);
        String[] s = {"Fire1", String.valueOf(mainFrame.hf.getX() / 70), String.valueOf(mainFrame.hf.getY() / 70), String.valueOf(mainFrame.hf.getHealth()), String.valueOf(mainFrame.hf.getPower())};
        String[] s1 = {"Wind1", String.valueOf(mainFrame.hw.getX() / 70), String.valueOf(mainFrame.hw.getY() / 70), String.valueOf(mainFrame.hw.getHealth()), String.valueOf(mainFrame.hw.getPower())};
        String[] s2 = {"Ice1", String.valueOf(mainFrame.hi.getX() / 70), String.valueOf(mainFrame.hi.getY() / 70), String.valueOf(mainFrame.hi.getHealth()), String.valueOf(mainFrame.hi.getPower())};
        String[] s3 = {"Soil1", String.valueOf(mainFrame.hs.getX() / 70), String.valueOf(mainFrame.hs.getY() / 70), String.valueOf(mainFrame.hs.getHealth()), String.valueOf(mainFrame.hs.getPower())};
        String[] s10 = {"Defensive fire1", String.valueOf(mainFrame.f1.getX() / 70), String.valueOf(mainFrame.f1.getY() / 70), String.valueOf(mainFrame.f1.getHealth()), String.valueOf(mainFrame.f1.getPower())};
        String[] s4 = {"Fire2", String.valueOf(mainFrame.hf2.getX() / 70), String.valueOf(mainFrame.hf2.getY() / 70), String.valueOf(mainFrame.hf2.getHealth()), String.valueOf(mainFrame.hf2.getPower())};
        String[] s5 = {"Wind2", String.valueOf(mainFrame.hw2.getX() / 70), String.valueOf(mainFrame.hw2.getY() / 70), String.valueOf(mainFrame.hw2.getHealth()), String.valueOf(mainFrame.hw2.getPower())};
        String[] s6 = {"Ice2", String.valueOf(mainFrame.hi2.getX() / 70), String.valueOf(mainFrame.hi2.getY() / 70), String.valueOf(mainFrame.hi2.getHealth()), String.valueOf(mainFrame.hi2.getPower())};
        String[] s7 = {"Soil2", String.valueOf(mainFrame.hs2.getX() / 70), String.valueOf(mainFrame.hs2.getY() / 70), String.valueOf(mainFrame.hs2.getHealth()), String.valueOf(mainFrame.hs2.getPower())};
        String[] s11 = {"Defensive fire2", String.valueOf(mainFrame.f2.getX() / 70), String.valueOf(mainFrame.f2.getY() / 70), String.valueOf(mainFrame.f2.getHealth()), String.valueOf(mainFrame.f2.getPower())};
        String[] s8 = {"Castle(N)", String.valueOf(mainFrame.c2.getX() / 70), String.valueOf(mainFrame.c2.getY() / 70), String.valueOf(mainFrame.c2.getHealth()), "0"};
        String[] s9 = {"Castle(S)", String.valueOf(mainFrame.c1.getX() / 70), String.valueOf(mainFrame.c1.getY() / 70), String.valueOf(mainFrame.c1.getHealth()), "0"};
        f.writeNext(s);
        f.writeNext(s1);
        f.writeNext(s2);
        f.writeNext(s3);
        f.writeNext(s10);
        f.writeNext(s4);
        f.writeNext(s5);
        f.writeNext(s6);
        f.writeNext(s7);
        f.writeNext(s11);
        f.writeNext(s8);
        f.writeNext(s9);
        f.close();
        cities.close();
    }

    public static void readScoreBoard() throws FileNotFoundException {
        Scanner c = new Scanner(new FileReader("ScoreBoard2.csv"));
        String type1, type2, type3, type4, type5, type6, type7, type8, type9, type10, type11, type12;
        String[] types1, types2, types3, types4, types5, types6, types7, types8, types9, types10, types11, types12;

        type1 = c.nextLine();
        types1 = type1.replace("\"", "").split(",");
        mainFrame.hf.setX2(Integer.parseInt(types1[1]) * 70);
        mainFrame.hf.setY2(Integer.parseInt(types1[2]) * 70);
        mainFrame.hf.setHealth2(Integer.parseInt(types1[3]));

        type2 = c.nextLine();
        types2 = type2.replace("\"", "").split(",");
        mainFrame.hw.setX2(Integer.parseInt(types2[1]) * 70);
        mainFrame.hw.setY2(Integer.parseInt(types2[2]) * 70);
        mainFrame.hw.setHealth2(Integer.parseInt(types2[3]));

        type3 = c.nextLine();
        types3 = type3.replace("\"", "").split(",");
        mainFrame.hi.setX2(Integer.parseInt(types3[1]) * 70);
        mainFrame.hi.setY2(Integer.parseInt(types3[2]) * 70);
        mainFrame.hi.setHealth2(Integer.parseInt(types3[3]));

        type4 = c.nextLine();
        types4 = type4.replace("\"", "").split(",");
        mainFrame.hs.setX2(Integer.parseInt(types4[1]) * 70);
        mainFrame.hs.setY2(Integer.parseInt(types4[2]) * 70);
        mainFrame.hs.setHealth2(Integer.parseInt(types4[3]));

        type11 = c.nextLine();
        types11 = type11.replace("\"", "").split(",");
        mainFrame.f1.setX2(Integer.parseInt(types11[1]) * 70);
        mainFrame.f1.setY2(Integer.parseInt(types11[2]) * 70);
        mainFrame.f1.setHealth2(Integer.parseInt(types11[3]));

        type7 = c.nextLine();
        types7 = type7.replace("\"", "").split(",");
        mainFrame.hf2.setX2(Integer.parseInt(types7[1]) * 70);
        mainFrame.hf2.setY2(Integer.parseInt(types7[2]) * 70);
        mainFrame.hf2.setHealth2(Integer.parseInt(types7[3]));

        type8 = c.nextLine();
        types8 = type8.replace("\"", "").split(",");
        mainFrame.hw2.setX2(Integer.parseInt(types8[1]) * 70);
        mainFrame.hw2.setY2(Integer.parseInt(types8[2]) * 70);
        mainFrame.hw2.setHealth2(Integer.parseInt(types8[3]));

        type9 = c.nextLine();
        types9 = type9.replace("\"", "").split(",");
        mainFrame.hi2.setX2(Integer.parseInt(types9[1]) * 70);
        mainFrame.hi2.setY2(Integer.parseInt(types9[2]) * 70);
        mainFrame.hi2.setHealth2(Integer.parseInt(types9[3]));

        type10 = c.nextLine();
        types10 = type10.replace("\"", "").split(",");
        mainFrame.hs2.setX2(Integer.parseInt(types10[1]) * 70);
        mainFrame.hs2.setY2(Integer.parseInt(types10[2]) * 70);
        mainFrame.hs2.setHealth2(Integer.parseInt(types10[3]));

        type12 = c.nextLine();
        types12 = type12.replace("\"", "").split(",");
        mainFrame.f2.setX2(Integer.parseInt(types12[1]) * 70);
        mainFrame.f2.setY2(Integer.parseInt(types12[2]) * 70);
        mainFrame.f2.setHealth2(Integer.parseInt(types12[3]));

        type5 = c.nextLine();
        types5 = type5.replace("\"", "").split(",");
        mainFrame.c2.setX(Integer.parseInt(types5[1]) * 70);
        mainFrame.c2.setY(Integer.parseInt(types5[2]) * 70);
        mainFrame.c2.setHealth2(Integer.parseInt(types5[3]));

        type6 = c.nextLine();
        types6 = type6.replace("\"", "").split(",");
        mainFrame.c1.setX(Integer.parseInt(types6[1]) * 70);
        mainFrame.c1.setY(Integer.parseInt(types6[2]) * 70);
        mainFrame.c1.setHealth2(Integer.parseInt(types6[3]));


    }

}
