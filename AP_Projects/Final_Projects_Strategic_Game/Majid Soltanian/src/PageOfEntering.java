import java.awt.event.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Jul 07 01:13:59 IRDT 2021
 */



/**
 * @author Brainrain
 */
public class PageOfEntering extends JFrame
{
    public PageOfEntering()
    {
        initComponents();
    }

    public FileInputStream fis;
    public BufferedInputStream bis;
    public Player player;
    public long pauseloc;
    public long total;
    public String Fileloc;
    public Button btnStop;
    public Button btnPlay;
    public Button btnPause;
    public String filepath=null;
    public String path;

    public void showTitle() throws InterruptedException
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                play("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\Teenage Mutant Ninja Turtles - Turtles Theme.mp3");

                imageOfLableTrue(logoOfGame);
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingTextOfTitle(C);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingTextOfTitle(L);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingTextOfTitle(A);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingTextOfTitle(S);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingTextOfTitle(H);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                designer.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                version.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    showLables();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    boolean firstStart = true;
    public void play(String path)
    {
        this.path = path;
        if(fis==null)
        {
            try
            {
                fis = new FileInputStream(new File(path));
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
                total = fis.available();
            }
            catch (FileNotFoundException | JavaLayerException ex)
            {

            }
            catch (IOException ex)
            {

            }
        }
        else
        {
            try
            {
                fis = new FileInputStream(new File(path));
                fis.skip(total-pauseloc);
            }
            catch (IOException ex)
            {

            }
            bis = new BufferedInputStream(fis);
            try
            {
                player = new Player(bis);
            }
            catch (Exception  ex)
            {

            }
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    if(bis !=null)
                    {
                        player.play();
                    }
                } catch (JavaLayerException ex)
                {
                    System.err.println(ex.getMessage());
                }

                if (firstStart)
                {
                    unshowPageOfEntering();
                }
            }
        }.start();
    }

    public void pause()
    {
        if(player !=null)
        {
            try
            {
                pauseloc = fis.available();
            }
            catch (IOException ex)
            {
            }
            player.close();
        }

    }

    private void unshowPageOfEntering()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0 ; i < 5 ; ++i)
                {
                    Main.newPageOfEntering.setSize(((-250 * i) + 1000), ((-182 * i) + 729));

                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                Main.newPageOfEntering.setVisible(false);

                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                Main.newPageOfPlay.setVisible(true);
                for (int i = 0 ; i < 5 ; ++i)
                {
                    Main.newPageOfPlay.setSize(450*i, 250*i);

                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                Main.newPageOfPlay.setValueOfLabels();

                firstStart = false;

                play("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\08 - sewer ~ art warehouse.mp3");

                /*try
                {
                    Main.pitt.walk();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    Main.patinga.walk();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    Main.george.walk();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    Main.ghatinga.walk();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    Main.william.walk();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    Main.witinga.walk();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }*/
            }
        }).start();
    }

    private void movingTextOfTitle(JLabel label)
    {
        label.setVisible(true);
        for (int i = 0 ; i < 11 ; ++i)
        {
            label.setLocation(label.getX(), (3*i));

            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        label.setLocation(label.getX(), 25);

        try
        {
            Thread.sleep(40);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        label.setLocation(label.getX(), 30);
    }

    public void showLables() throws InterruptedException
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                imageOfLableTrue(headOfPitt);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                nameOfPitt.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                healthOfPitt.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                powerOfPitt.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                speedOfPitt.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingImageOfLable(headOfPitt, "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\SCML_Edit\\");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }




                imageOfLableTrue(headOfPatinga);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                nameOfPatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                healthOfPatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                powerOfPatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                speedOfPatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingImageOfLable(headOfPatinga, "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\SCML_Edit\\");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }



                imageOfLableTrue(headOfGeorge);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                nameOfGeorge.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                healthOfGeorge.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                powerOfGeorge.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                speedOfGeorge.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingImageOfLable(headOfGeorge, "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\SCML_Edit\\");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }



                imageOfLableTrue(headOfGhatinga);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                nameOfGhatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                healthOfGhatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                powerOfGhatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                speedOfGhatinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingImageOfLable(headOfGhatinga, "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\SCML_Edit\\");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }



                imageOfLableTrue(headOfWilliam);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                nameOfWilliam.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                healthOfWilliam.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                powerOfWilliam.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                speedOfWilliam.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingImageOfLable(headOfWilliam, "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\SCML_Edit\\");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }



                imageOfLableTrue(headOfWitinga);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                nameOfWitinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                healthOfWitinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                powerOfWitinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                speedOfWitinga.setVisible(true);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                movingImageOfLable(headOfWitinga, "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\SCML_Edit\\");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void imageOfLableTrue(JLabel label)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                label.setVisible(true);

                for (int i = 0 ; i < 11 ; ++i)
                {
                    label.setSize((10*i), 100);

                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void movingImageOfLable(JLabel label, String path)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                label.setVisible(true);

                int i = 1 ;
                while (true)
                {
                    label.setIcon(new ImageIcon(path + (i) + ".png"));
                    i++;
                    if (i == 4)
                    {
                        i = 1;
                    }

                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void label8MouseClicked(MouseEvent e)
    {
        System.exit(0);
    }

    private void label8MouseEntered(MouseEvent e)
    {
        label8.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_close_window_32px_1.png"));
    }

    private void label8MouseExited(MouseEvent e)
    {
        label8.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_close_window_32px.png"));
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        backgroundPanel = new JPanel();
        headOfPitt = new JLabel();
        nameOfPitt = new JLabel();
        healthOfPitt = new JLabel();
        powerOfPitt = new JLabel();
        speedOfPitt = new JLabel();
        headOfGeorge = new JLabel();
        nameOfGeorge = new JLabel();
        powerOfGeorge = new JLabel();
        healthOfGeorge = new JLabel();
        speedOfGeorge = new JLabel();
        headOfWilliam = new JLabel();
        nameOfWilliam = new JLabel();
        healthOfWilliam = new JLabel();
        powerOfWilliam = new JLabel();
        speedOfWilliam = new JLabel();
        headOfPatinga = new JLabel();
        nameOfPatinga = new JLabel();
        healthOfPatinga = new JLabel();
        powerOfPatinga = new JLabel();
        speedOfPatinga = new JLabel();
        headOfGhatinga = new JLabel();
        nameOfGhatinga = new JLabel();
        healthOfGhatinga = new JLabel();
        powerOfGhatinga = new JLabel();
        speedOfGhatinga = new JLabel();
        headOfWitinga = new JLabel();
        nameOfWitinga = new JLabel();
        healthOfWitinga = new JLabel();
        powerOfWitinga = new JLabel();
        speedOfWitinga = new JLabel();
        C = new JLabel();
        L = new JLabel();
        A = new JLabel();
        S = new JLabel();
        H = new JLabel();
        gameOver = new JLabel();
        result = new JLabel();
        logoOfGame = new JLabel();
        designer = new JLabel();
        version = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setUndecorated(true);
        setIconImage(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_poison_48px_1.png").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== backgroundPanel ========
        {
            backgroundPanel.setLayout(null);

            //---- headOfPitt ----
            headOfPitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\SCML_Edit\\1_head_92.png"));
            headOfPitt.setVisible(false);
            backgroundPanel.add(headOfPitt);
            headOfPitt.setBounds(200, 305, 100, 100);

            //---- nameOfPitt ----
            nameOfPitt.setText("<html> Name :  <font color=\"630023\";\"red\"> Pitt </font> ");
            nameOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            nameOfPitt.setVisible(false);
            backgroundPanel.add(nameOfPitt);
            nameOfPitt.setBounds(310, 305, 160, 30);

            //---- healthOfPitt ----
            healthOfPitt.setText("<html>Health : <font color=\"630023\";\"red\"> 50 </font>");
            healthOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfPitt.setVisible(false);
            backgroundPanel.add(healthOfPitt);
            healthOfPitt.setBounds(310, 335, 160, 30);

            //---- powerOfPitt ----
            powerOfPitt.setText("<html>Power : <font color=\"630023\";\"red\"> 10 </font>");
            powerOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            powerOfPitt.setVisible(false);
            backgroundPanel.add(powerOfPitt);
            powerOfPitt.setBounds(310, 365, 160, 30);

            //---- speedOfPitt ----
            speedOfPitt.setText("<html>Speed : <font color=\"630023\";\"red\"> 50 </font>");
            speedOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            speedOfPitt.setVisible(false);
            backgroundPanel.add(speedOfPitt);
            speedOfPitt.setBounds(310, 395, 160, 30);

            //---- headOfGeorge ----
            headOfGeorge.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\SCML_Edit\\1_head_92.png"));
            headOfGeorge.setVisible(false);
            backgroundPanel.add(headOfGeorge);
            headOfGeorge.setBounds(200, 455, 100, 100);

            //---- nameOfGeorge ----
            nameOfGeorge.setText("<html>Name : <font color=\"DF1D1D\";\"red\"> George </font>");
            nameOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            nameOfGeorge.setVisible(false);
            backgroundPanel.add(nameOfGeorge);
            nameOfGeorge.setBounds(310, 450, 160, 30);

            //---- powerOfGeorge ----
            powerOfGeorge.setText("<html>Power : <font color=\"DF1D1D\";\"red\"> 20 </font>");
            powerOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            powerOfGeorge.setVisible(false);
            backgroundPanel.add(powerOfGeorge);
            powerOfGeorge.setBounds(310, 510, 160, 30);

            //---- healthOfGeorge ----
            healthOfGeorge.setText("<html>Health : <font color=\"DF1D1D\";\"red\"> 40 </font>");
            healthOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfGeorge.setVisible(false);
            backgroundPanel.add(healthOfGeorge);
            healthOfGeorge.setBounds(310, 480, 160, 30);

            //---- speedOfGeorge ----
            speedOfGeorge.setText("<html>Speed : <font color=\"DF1D1D\";\"red\"> 40 </font>");
            speedOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            speedOfGeorge.setVisible(false);
            backgroundPanel.add(speedOfGeorge);
            speedOfGeorge.setBounds(310, 540, 160, 30);

            //---- headOfWilliam ----
            headOfWilliam.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\SCML_Edit\\1_head_92.png"));
            headOfWilliam.setVisible(false);
            backgroundPanel.add(headOfWilliam);
            headOfWilliam.setBounds(200, 595, 100, 100);

            //---- nameOfWilliam ----
            nameOfWilliam.setText("<html>Name : <font color=\"F2E8B3\";\"red\"> William </font>");
            nameOfWilliam.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            nameOfWilliam.setVisible(false);
            backgroundPanel.add(nameOfWilliam);
            nameOfWilliam.setBounds(310, 590, 160, 30);

            //---- healthOfWilliam ----
            healthOfWilliam.setText("<html>Health : <font color=\"F2E8B3\";\"red\"> 30 </font>");
            healthOfWilliam.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfWilliam.setVisible(false);
            backgroundPanel.add(healthOfWilliam);
            healthOfWilliam.setBounds(310, 620, 160, 30);

            //---- powerOfWilliam ----
            powerOfWilliam.setText("<html>Power : <font color=\"F2E8B3\";\"red\"> 30 </font> ");
            powerOfWilliam.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            powerOfWilliam.setVisible(false);
            backgroundPanel.add(powerOfWilliam);
            powerOfWilliam.setBounds(310, 650, 160, 30);

            //---- speedOfWilliam ----
            speedOfWilliam.setText("<html>Speed : <font color=\"F2E8B3\";\"red\"> 30 </font>");
            speedOfWilliam.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            speedOfWilliam.setVisible(false);
            backgroundPanel.add(speedOfWilliam);
            speedOfWilliam.setBounds(310, 680, 160, 30);

            //---- headOfPatinga ----
            headOfPatinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\SCML_Edit\\2_head_92.png"));
            headOfPatinga.setVisible(false);
            backgroundPanel.add(headOfPatinga);
            headOfPatinga.setBounds(700, 310, 100, 100);

            //---- nameOfPatinga ----
            nameOfPatinga.setText("<html> \u0646\u0627\u0645 :   <font color=\"606060\";\"red\"> \u067e\u0627\u062a\u06cc\u0646\u06af\u0627 </font> ");
            nameOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            nameOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            nameOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            nameOfPatinga.setVisible(false);
            backgroundPanel.add(nameOfPatinga);
            nameOfPatinga.setBounds(530, 305, 160, 30);

            //---- healthOfPatinga ----
            healthOfPatinga.setText("<html> \u0633\u0644\u0627\u0645\u062a :   <font color=\"606060\";\"red\"> \u06f5\u06f0 </font> ");
            healthOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            healthOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            healthOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            healthOfPatinga.setVisible(false);
            backgroundPanel.add(healthOfPatinga);
            healthOfPatinga.setBounds(530, 335, 160, 30);

            //---- powerOfPatinga ----
            powerOfPatinga.setText("<html> \u0642\u062f\u0631\u062a :   <font color=\"606060\";\"red\"> \u06f1\u06f0 </font> ");
            powerOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            powerOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            powerOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            powerOfPatinga.setVisible(false);
            backgroundPanel.add(powerOfPatinga);
            powerOfPatinga.setBounds(530, 365, 160, 30);

            //---- speedOfPatinga ----
            speedOfPatinga.setText("<html> \u0633\u0631\u0639\u062a :   <font color=\"606060\";\"red\"> \u06f5\u06f0 </font> ");
            speedOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            speedOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            speedOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            speedOfPatinga.setVisible(false);
            backgroundPanel.add(speedOfPatinga);
            speedOfPatinga.setBounds(530, 395, 160, 30);

            //---- headOfGhatinga ----
            headOfGhatinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\SCML_Edit\\1_head_92.png"));
            headOfGhatinga.setVisible(false);
            backgroundPanel.add(headOfGhatinga);
            headOfGhatinga.setBounds(700, 455, 100, 100);

            //---- nameOfGhatinga ----
            nameOfGhatinga.setText("<html> \u0646\u0627\u0645 :   <font color=\"443C0C\";\"red\"> \u0642\u0627\u0637\u06cc\u0646\u06af\u0627 </font> ");
            nameOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            nameOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            nameOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            nameOfGhatinga.setVisible(false);
            backgroundPanel.add(nameOfGhatinga);
            nameOfGhatinga.setBounds(530, 450, 160, 30);

            //---- healthOfGhatinga ----
            healthOfGhatinga.setText("<html> \u0633\u0644\u0627\u0645\u062a :   <font color=\"443C0C\";\"red\"> \u06f4\u06f0 </font> ");
            healthOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            healthOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            healthOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            healthOfGhatinga.setVisible(false);
            backgroundPanel.add(healthOfGhatinga);
            healthOfGhatinga.setBounds(530, 480, 160, 30);

            //---- powerOfGhatinga ----
            powerOfGhatinga.setText("<html> \u0642\u062f\u0631\u062a :   <font color=\"443C0C\";\"red\"> \u06f2\u06f0 </font> ");
            powerOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            powerOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            powerOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            powerOfGhatinga.setVisible(false);
            backgroundPanel.add(powerOfGhatinga);
            powerOfGhatinga.setBounds(530, 510, 160, 30);

            //---- speedOfGhatinga ----
            speedOfGhatinga.setText("<html> \u0633\u0631\u0639\u062a :   <font color=\"443C0C\";\"red\"> \u06f4\u06f0 </font> ");
            speedOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            speedOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            speedOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            speedOfGhatinga.setVisible(false);
            backgroundPanel.add(speedOfGhatinga);
            speedOfGhatinga.setBounds(530, 540, 160, 30);

            //---- headOfWitinga ----
            headOfWitinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\SCML_Edit\\3_head_92.png"));
            headOfWitinga.setVisible(false);
            backgroundPanel.add(headOfWitinga);
            headOfWitinga.setBounds(700, 600, 100, 100);

            //---- nameOfWitinga ----
            nameOfWitinga.setText("<html> \u0646\u0627\u0645 :   <font color=\"754551\";\"red\"> \u0648\u06cc\u062a\u06cc\u0646\u06af\u0627 </font> ");
            nameOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            nameOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            nameOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            nameOfWitinga.setVisible(false);
            backgroundPanel.add(nameOfWitinga);
            nameOfWitinga.setBounds(530, 590, 160, 30);

            //---- healthOfWitinga ----
            healthOfWitinga.setText("<html> \u0633\u0644\u0627\u0645\u062a :   <font color=\"754551\";\"red\"> \u06f3\u06f0 </font> ");
            healthOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            healthOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            healthOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            healthOfWitinga.setVisible(false);
            backgroundPanel.add(healthOfWitinga);
            healthOfWitinga.setBounds(530, 620, 160, 30);

            //---- powerOfWitinga ----
            powerOfWitinga.setText("<html> \u0642\u062f\u0631\u062a :   <font color=\"754551\";\"red\"> \u06f3\u06f0 </font> ");
            powerOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            powerOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            powerOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            powerOfWitinga.setVisible(false);
            backgroundPanel.add(powerOfWitinga);
            powerOfWitinga.setBounds(530, 650, 160, 30);

            //---- speedOfWitinga ----
            speedOfWitinga.setText("<html> \u0633\u0631\u0639\u062a :   <font color=\"754551\";\"red\"> \u06f3\u06f0 </font> ");
            speedOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 24));
            speedOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            speedOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            speedOfWitinga.setVisible(false);
            backgroundPanel.add(speedOfWitinga);
            speedOfWitinga.setBounds(530, 680, 160, 30);

            //---- C ----
            C.setText("C");
            C.setFont(new Font("Viner Hand ITC", Font.BOLD, 48));
            C.setVisible(false);
            backgroundPanel.add(C);
            C.setBounds(505, 30, 45, 70);

            //---- L ----
            L.setText("L");
            L.setFont(new Font("Viner Hand ITC", Font.BOLD, 48));
            L.setVisible(false);
            backgroundPanel.add(L);
            L.setBounds(540, 30, 45, 70);

            //---- A ----
            A.setText("A");
            A.setFont(new Font("Viner Hand ITC", Font.BOLD, 48));
            A.setVisible(false);
            backgroundPanel.add(A);
            A.setBounds(576, 30, 45, 70);

            //---- S ----
            S.setText("S");
            S.setFont(new Font("Viner Hand ITC", Font.BOLD, 48));
            S.setVisible(false);
            backgroundPanel.add(S);
            S.setBounds(616, 30, 45, 70);

            //---- H ----
            H.setText("H");
            H.setFont(new Font("Viner Hand ITC", Font.BOLD, 48));
            H.setVisible(false);
            backgroundPanel.add(H);
            H.setBounds(650, 30, 45, 70);

            //---- gameOver ----
            gameOver.setText("GAME OVER");
            gameOver.setFont(new Font("Viner Hand ITC", Font.BOLD, 52));
            gameOver.setForeground(new Color(171, 32, 32));
            gameOver.setVisible(false);
            backgroundPanel.add(gameOver);
            gameOver.setBounds(340, 300, 350, 70);

            //---- result ----
            result.setText("Pirates win by 30 points and Giants lose by 10 points");
            result.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
            result.setVisible(false);
            backgroundPanel.add(result);
            result.setBounds(205, 375, 700, 70);

            //---- logoOfGame ----
            logoOfGame.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_poison_96px.png"));
            logoOfGame.setVisible(false);
            backgroundPanel.add(logoOfGame);
            logoOfGame.setBounds(390, 25, 100, 100);

            //---- designer ----
            designer.setText("Designed by Majid Soltanian");
            designer.setFont(new Font("Andalus", Font.BOLD, 18));
            designer.setVisible(false);
            backgroundPanel.add(designer);
            designer.setBounds(new Rectangle(new Point(505, 95), designer.getPreferredSize()));

            //---- version ----
            version.setText("V 1.01.001");
            version.setFont(new Font("Andalus", Font.BOLD, 14));
            version.setVisible(false);
            backgroundPanel.add(version);
            version.setBounds(505, 125, 226, 28);

            //---- label1 ----
            label1.setText("No.");
            label1.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            label1.setVisible(false);
            backgroundPanel.add(label1);
            label1.setBounds(260, 480, 70, 25);

            //---- label2 ----
            label2.setText("Pitt");
            label2.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            label2.setForeground(new Color(99, 0, 35));
            label2.setVisible(false);
            backgroundPanel.add(label2);
            label2.setBounds(330, 480, 70, 25);

            //---- label3 ----
            label3.setText("George");
            label3.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            label3.setForeground(new Color(223, 29, 29));
            label3.setVisible(false);
            backgroundPanel.add(label3);
            label3.setBounds(400, 480, 70, 25);

            //---- label4 ----
            label4.setText("William");
            label4.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            label4.setForeground(new Color(242, 232, 179));
            label4.setVisible(false);
            backgroundPanel.add(label4);
            label4.setBounds(470, 480, 70, 25);

            //---- label5 ----
            label5.setText("Patinga");
            label5.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            label5.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            label5.setForeground(new Color(96, 96, 96));
            label5.setVisible(false);
            backgroundPanel.add(label5);
            label5.setBounds(540, 480, 70, 25);

            //---- label6 ----
            label6.setText("Ghatinga");
            label6.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            label6.setForeground(new Color(68, 60, 12));
            label6.setVisible(false);
            backgroundPanel.add(label6);
            label6.setBounds(610, 480, 70, 25);

            //---- label7 ----
            label7.setText("Witinga");
            label7.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
            label7.setHorizontalAlignment(SwingConstants.CENTER);
            label7.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
            label7.setForeground(new Color(117, 69, 81));
            label7.setVisible(false);
            backgroundPanel.add(label7);
            label7.setBounds(680, 480, 70, 25);

            //---- label8 ----
            label8.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_close_window_32px.png"));
            label8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label8MouseClicked(e);
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    label8MouseEntered(e);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    label8MouseExited(e);
                }
            });
            backgroundPanel.add(label8);
            label8.setBounds(new Rectangle(new Point(960, 5), label8.getPreferredSize()));

            //---- backgroundLabel ----
            backgroundLabel.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\BACKGROUND.png"));
            backgroundLabel.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
            backgroundLabel.setOpaque(true);
            backgroundPanel.add(backgroundLabel);
            backgroundLabel.setBounds(0, 0, 1000, 729);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < backgroundPanel.getComponentCount(); i++) {
                    Rectangle bounds = backgroundPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = backgroundPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                backgroundPanel.setMinimumSize(preferredSize);
                backgroundPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(backgroundPanel);
        backgroundPanel.setBounds(0, 0, 1000, 729);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JPanel backgroundPanel;
    JLabel headOfPitt;
    JLabel nameOfPitt;
    JLabel healthOfPitt;
    JLabel powerOfPitt;
    JLabel speedOfPitt;
    JLabel headOfGeorge;
    JLabel nameOfGeorge;
    JLabel powerOfGeorge;
    JLabel healthOfGeorge;
    JLabel speedOfGeorge;
    JLabel headOfWilliam;
    JLabel nameOfWilliam;
    JLabel healthOfWilliam;
    JLabel powerOfWilliam;
    JLabel speedOfWilliam;
    JLabel headOfPatinga;
    JLabel nameOfPatinga;
    JLabel healthOfPatinga;
    JLabel powerOfPatinga;
    JLabel speedOfPatinga;
    JLabel headOfGhatinga;
    JLabel nameOfGhatinga;
    JLabel healthOfGhatinga;
    JLabel powerOfGhatinga;
    JLabel speedOfGhatinga;
    JLabel headOfWitinga;
    JLabel nameOfWitinga;
    JLabel healthOfWitinga;
    JLabel powerOfWitinga;
    JLabel speedOfWitinga;
    JLabel C;
    JLabel L;
    JLabel A;
    JLabel S;
    JLabel H;
    JLabel gameOver;
    JLabel result;
    JLabel logoOfGame;
    JLabel designer;
    JLabel version;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
