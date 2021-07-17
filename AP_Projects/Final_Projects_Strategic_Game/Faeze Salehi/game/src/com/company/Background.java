package com.company;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Background extends JFrame
{
    static JButton[][] btns = new JButton[12][8];
    static Thread starter = new Thread(()->{});
    static ArrayList<Thread> heroThread = new ArrayList<>();

    static ArrayList<Hero> heroes = new ArrayList<>();
    static ImageIcon castleIcon;

    Castle castle1;
    Castle castle2;

    JPanel jPS;
    JLabel l1;
    JLabel l2;

    int overFlag = 0;

    Background() throws IOException
    {
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,700);
        this.setLocationRelativeTo(null);

        JPanel jp = new JPanel();
        jp.setBackground(Color.BLACK);

        GridLayout gl = new GridLayout(12,8);
        gl.setHgap(4); gl.setVgap(4); jp.setLayout(gl);

        JButton start = new JButton("start");
        start.addActionListener(e-> starter.start());

        JButton pause = new JButton("pause");
        pause.addActionListener(e->
        {
            for(Thread t : heroThread)
            {
                try
                {
                    t.sleep(1000);
                }
                catch (InterruptedException ignored) {}
            }
        });

        JButton save = new JButton("save");
        save.addActionListener(e->
            new Thread(() ->
            {
                do
                {
                    if(overFlag == 1)
                    {
                        try
                        {
                            File file = new File("I:\\files\\Hero.txt");
                            FileOutputStream fos = new FileOutputStream(file,true);
                            ObjectOutputStream oos;

                            if(file.length() < 50)
                                oos = new ObjectOutputStream(fos);
                            else
                                oos = new MyObjectOutputStream(fos);

                            for(Hero h : heroes)
                            {
                                oos.writeObject(h);
                            }

                            JOptionPane.showMessageDialog(rootPane,"Saved");
                            break;
                        }
                        catch (IOException ignored) {}
                    }

                }while(true);

            }).start()
        );

        JButton score = new JButton("score");
        score.addActionListener(e->
            new Thread(() ->
            {
                JFrame jf = new JFrame("Score");
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setLocationRelativeTo(null);

                jPS = new JPanel();

                l1 = new JLabel("Team 1 : " + castle1.score);
                l2 = new JLabel("Team 2 : " + castle2.score);

                jPS.add(l1);
                jPS.add(l2);
                jf.add(jPS);
                jf.pack();
                jf.setVisible(true);

            }).start()
        );

        JPanel ps = new JPanel();
        ps.add(start);
        ps.add(pause);
        ps.add(score);
        ps.add(save);

        for(int i=0 ; i< btns.length ; ++i)
        {
            for(int j=0 ; j < btns[0].length ; ++j)
            {
                btns[i][j] = new JButton();
                jp.add(btns[i][j]);
            }
        }

        createIcon();

        this.add(jp);
        this.add(ps,BorderLayout.SOUTH);
        this.setVisible(true);
    }

    void moveHero(Hero hero) throws InterruptedException
    {
        while((hero.x != hero.castle.x || hero.y != hero.castle.y) && hero.health>0)
        {
            int dif1 = hero.castle.x - hero.x;
            int dif2 = hero.castle.y - hero.y;

            btns[hero.x][hero.y].setIcon(null);

            if(hero.speed == 2 && ((hero.castle.x==0 && hero.x<=3) || (hero.castle.x==11 && hero.x>=9)) )
                hero.speed = 1;

            if(Math.abs(dif1) > Math.abs(dif2))
            {
                if(dif1 < 0)
                    hero.x -= hero.speed;
                else
                    hero.x += hero.speed;
            }
            else
            {
                if(dif2 < 0)
                    hero.y -= hero.speed;
                else
                    hero.y += hero.speed;
            }

            if(btns[hero.x][hero.y].getIcon() == null)
            {
                btns[hero.x][hero.y].setIcon(hero.ImgIcon);
                Thread.sleep(1000);
            }

            else
            {
                int flag = 0;
                for(Hero h : heroes)
                {
                    if(h.x == hero.x  &&  h.y == hero.y && (h.castle != hero.castle))
                    {
                        flag = 1;
                        while (h.health > 0 && hero.health > 0)
                        {
                            h.health -= hero.power;
                            hero.health -= h.power;
                        }

                        if(h.health < hero.health)
                        {
                            btns[hero.x][hero.y].setIcon(hero.ImgIcon);
                            hero.castle.score += hero.power;
                            hero.score += hero.power;

                            if(l1 != null)
                                l1.setText("Team 1 : " + castle1.score);
                        }

                        else if(hero.health < h.health)
                        {
                            btns[hero.x][hero.y].setIcon(h.ImgIcon);
                            h.castle.score += h.power;
                            h.score += h.power;

                            if(l2 != null)
                                l2.setText("Team 2 : " + castle2.score);
                        }

                        else
                        {
                            btns[hero.x][hero.y].setIcon(null);
                            ++hero.castle.score;
                            ++h.castle.score;

                            ++hero.score;
                            ++h.score;

                            if(l1 != null && l2 != null)
                            {
                                l1.setText("Team 1 : " + castle1.score);
                                l2.setText("Team 2 : " + castle2.score);
                            }
                        }

                        if(jPS != null)
                        {
                            jPS.revalidate();
                            jPS.repaint();
                        }
                        break;
                    }
                }

                if(flag == 0)
                {
                    if(!btns[hero.x][hero.y].getIcon().equals(castleIcon))
                        Thread.sleep(2000);
                    else
                    {
                        hero.castle.health -= hero.power;

                        if(hero.castle.health == 0)
                        {
                            for(Thread t : heroThread)
                            {
                                t.interrupt();
                            }

                            overFlag = 1;
                            JOptionPane.showMessageDialog(rootPane,"Game Over");
                        }
                    }
                }
            }

            this.repaint();
        }
    }

    void createIcon() throws IOException
    {
        castle1 = new Castle(0,6,"first");
        castle2 = new Castle(11,3,"second");

        castleIcon = castle1.CastleIcon;

        Wind w1 = new Wind(0,0,castle2,"team1");
        Fire f1 = new Fire(0,1,castle2,"team1");
        Ice i1  = new Ice(0,2,castle2,"team1");
        Soil s1 = new Soil(0,3,castle2,"team1");
        Fire f4 = new Fire(0,4,castle2,"team1");
        Wind w4 = new Wind(0,5,castle2,"team1");
        Soil s4 = new Soil(0,7,castle2,"team1");
        //Ice i1  = new Ice(1,0,castle2,"team1");
        //Fire f1 = new Fire(1,1,castle2,"team1");
        //Soil s1 = new Soil(1,2,castle2,"team1");
        //Wind w1 = new Wind(1,3,castle2,"team1");
        //Ice i1  = new Ice(1,4,castle2,"team1");
        Fire f2 = new Fire(1,5,castle2,"team1");
        //Soil s1 = new Soil(1,6,castle2,"team1");
        Wind w2 = new Wind(1,7,castle2,"team1");

        Ice i = new Ice(11,0,castle1,"team2");
        Soil s2 = new Soil(11,1,castle1,"team2");
        Wind w3 = new Wind(11,2,castle1,"team2");
        Fire f5 = new Fire(11,4,castle1,"team2");
        Ice i2 = new Ice(11,5,castle1,"team2");
        //Wind w1 = new Wind(11,6,castle1,"team2");
        //Soil s1 = new Soil(11,7,castle1,"team2");
        //Fire f1 = new Fire(10,0,castle1,"team2");
        //Ice i1  = new Ice(10,1,castle1,"team2");
        Soil s5 = new Soil(10,2,castle1,"team2");
        //Wind w1 = new Wind(10,3,castle1,"team2");
        Fire f3 = new Fire(10,4,castle1,"team2");
        Soil s3 = new Soil(10,5,castle1,"team2");
        //Ice i1  = new Ice(10,6,castle1,"team2");
        Wind w7 = new Wind(10,7,castle1,"team2");

        heroes.add(w1);
        heroes.add(f1);
        heroes.add(i1);
        heroes.add(s1);
        heroes.add(f4);
        heroes.add(w4);
        heroes.add(s4);
        heroes.add(f2);
        heroes.add(w2);
        heroes.add(i);
        heroes.add(s2);
        heroes.add(w3);
        heroes.add(f5);
        heroes.add(i2);
        heroes.add(s5);
        heroes.add(f3);
        heroes.add(s3);
        heroes.add(w7);
    }
}

class MyObjectOutputStream extends ObjectOutputStream
{
    public MyObjectOutputStream() throws IOException
    {
        super();
    }

    public MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    @Override
    public void writeStreamHeader() throws IOException {}
}