import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javazoom.jl.player.Player;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Jul 04 09:41:50 IRDT 2021
 */



/**
 * @author Brainrain
 */
public class PageOfPlay extends JFrame
{
    public PageOfPlay()
    {
        initComponents();
    }

    private void pittMouseClicked(MouseEvent e)
    {
        Main.pitt.runMode = true;
        Main.pitt.attackMode = true;


        Main.george.runMode = false;
        Main.george.attackMode = false;

        Main.william.runMode = false;
        Main.william.attackMode = false;
    }

    private void georgeMouseClicked(MouseEvent e)
    {
        Main.george.runMode = true;
        Main.george.attackMode = true;


        Main.pitt.runMode = false;
        Main.pitt.attackMode = false;

        Main.william.runMode = false;
        Main.william.attackMode = false;
    }

    private void williamMouseClicked(MouseEvent e)
    {
        Main.william.runMode = true;
        Main.william.attackMode = true;


        Main.pitt.runMode = false;
        Main.pitt.attackMode = false;

        Main.george.runMode = false;
        Main.george.attackMode = false;
    }

    private void backgroundLabelMouseClicked(MouseEvent e)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if ((Main.pitt.runMode) && (!Main.pitt.deathMode))
                {
                    try
                    {
                        Main.pitt.run();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.george.runMode) && (!Main.george.deathMode))
                {
                    try
                    {
                        Main.george.run();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.william.runMode) && (!Main.william.deathMode))
                {
                    try
                    {
                        Main.william.run();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void patingaMouseClicked(MouseEvent e)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if ((Main.pitt.attackMode) && (!Main.pitt.deathMode) && (!Main.patinga.deathMode) && (calculateTheDistance(Main.pitt.xCenterOfCharacter, Main.pitt.yCenterOfCharacter, Main.patinga.xCenterOfCharacter, Main.patinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.patinga.health = 0;

                        Main.patinga.idleMode = false;
                        Main.patinga.runMode = false;

                        Main.pitt.attack(pitt);

                        Main.patinga.death(patinga);

                        setValueOfLabels();

                        Main.pitt.idle();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.george.attackMode) && (!Main.george.deathMode) && (!Main.patinga.deathMode) && (calculateTheDistance(Main.george.xCenterOfCharacter, Main.george.yCenterOfCharacter, Main.patinga.xCenterOfCharacter, Main.patinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.patinga.health -= Main.george.power;

                        Main.patinga.idleMode = false;
                        Main.patinga.runMode = false;

                        Main.george.attack(george);

                        Main.patinga.death(patinga);

                        setValueOfLabels();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.william.attackMode) && (!Main.william.deathMode) && (!Main.patinga.deathMode) && (calculateTheDistance(Main.william.xCenterOfCharacter, Main.william.yCenterOfCharacter, Main.patinga.xCenterOfCharacter, Main.patinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.patinga.health -= Main.william.power;

                        Main.patinga.idleMode = false;
                        Main.patinga.runMode = false;

                        Main.william.attack(william);

                        Main.patinga.death(patinga);

                        setValueOfLabels();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void ghatingaMouseClicked(MouseEvent e)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if ((Main.pitt.attackMode) && (!Main.pitt.deathMode) && (!Main.ghatinga.deathMode) && (calculateTheDistance(Main.pitt.xCenterOfCharacter, Main.pitt.yCenterOfCharacter, Main.ghatinga.xCenterOfCharacter, Main.ghatinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.ghatinga.health = 0;

                        Main.ghatinga.idleMode = false;
                        Main.ghatinga.runMode = false;

                        Main.pitt.attack(pitt);

                        Main.ghatinga.death(ghatinga);

                        setValueOfLabels();

                        Main.pitt.idle();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.george.attackMode) && (!Main.george.deathMode) && (!Main.ghatinga.deathMode) && (calculateTheDistance(Main.george.xCenterOfCharacter, Main.george.yCenterOfCharacter, Main.ghatinga.xCenterOfCharacter, Main.ghatinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.ghatinga.health -= Main.george.power;

                        Main.ghatinga.idleMode = false;
                        Main.ghatinga.runMode = false;

                        Main.george.attack(george);

                        Main.ghatinga.death(ghatinga);

                        setValueOfLabels();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.william.attackMode) && (!Main.william.deathMode) && (!Main.ghatinga.deathMode) && (calculateTheDistance(Main.william.xCenterOfCharacter, Main.william.yCenterOfCharacter, Main.ghatinga.xCenterOfCharacter, Main.ghatinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.ghatinga.health -= Main.william.power;

                        Main.ghatinga.idleMode = false;
                        Main.ghatinga.runMode = false;

                        Main.william.attack(william);

                        Main.ghatinga.death(ghatinga);

                        setValueOfLabels();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }

            }
        }).start();
    }

    private void witingaMouseClicked(MouseEvent e)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if ((Main.pitt.attackMode) && (!Main.pitt.deathMode) && (!Main.witinga.deathMode) && (calculateTheDistance(Main.pitt.xCenterOfCharacter, Main.pitt.yCenterOfCharacter, Main.witinga.xCenterOfCharacter, Main.witinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.witinga.health = 0;

                        Main.witinga.idleMode = false;
                        Main.witinga.runMode = false;

                        Main.pitt.attack(pitt);

                        Main.witinga.death(witinga);

                        setValueOfLabels();

                        Main.pitt.idle();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.george.attackMode) && (!Main.george.deathMode) && (!Main.witinga.deathMode) && (calculateTheDistance(Main.george.xCenterOfCharacter, Main.george.yCenterOfCharacter, Main.witinga.xCenterOfCharacter, Main.witinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.witinga.health -= Main.george.power;

                        Main.witinga.idleMode = false;
                        Main.witinga.runMode = false;

                        Main.george.attack(george);

                        Main.witinga.death(witinga);

                        setValueOfLabels();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
                else if ((Main.william.attackMode) && (!Main.william.deathMode) && (!Main.witinga.deathMode) && (calculateTheDistance(Main.william.xCenterOfCharacter, Main.william.yCenterOfCharacter, Main.witinga.xCenterOfCharacter, Main.witinga.yCenterOfCharacter) < 500))
                {
                    try
                    {
                        Main.witinga.health -= Main.william.power;

                        Main.witinga.idleMode = false;
                        Main.witinga.runMode = false;

                        Main.william.attack(william);

                        Main.witinga.death(witinga);

                        setValueOfLabels();
                    }
                    catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private double calculateTheDistance(int xOne, int yOne, int xTwo, int yTwo)
    {
        return Math.sqrt((Math.pow((xTwo - xOne), 2)) + (Math.pow((yTwo - yOne), 2)));
    }


    public void setValueOfLabels()
    {

        Main.pitt.xCenterOfCharacter = (pitt.getX() + (pitt.getWidth()/2));
        Main.pitt.yCenterOfCharacter = (pitt.getY() + (pitt.getHeight()/2));
        healthOfPitt.setText("Health : " + Main.pitt.health);
        xCenterOfPitt.setText("x Center : " + Main.pitt.xCenterOfCharacter);
        yCenterOfPitt.setText("y Center : " + Main.pitt.yCenterOfCharacter);

        Main.george.xCenterOfCharacter = (george.getX() + (george.getWidth()/2));
        Main.george.yCenterOfCharacter = (george.getY() + (george.getHeight()/2));
        healthOfGeorge.setText("Health : " + Main.george.health);
        xCenterOfGeorge.setText("x Center : " + Main.george.xCenterOfCharacter);
        yCenterOfGeorge.setText("y Center : " + Main.george.yCenterOfCharacter);

        Main.william.xCenterOfCharacter = (william.getX() + (william.getWidth()/2));
        Main.william.yCenterOfCharacter = (william.getY() + (william.getHeight()/2));
        healthOfWilliam.setText("Health : " + Main.william.health);
        xCenterOfWillim.setText("x Center : " + Main.william.xCenterOfCharacter);
        yCenterOfWillim.setText("y Center : " + Main.william.yCenterOfCharacter);


        int healthOfPiratesInt = Main.pitt.health + Main.george.health + Main.william.health;
        if ((healthOfPiratesInt <= 120) && (healthOfPiratesInt >= 80))
        {
            healthOfPirates.setText("<html> O <br/> O <br/> O " + healthOfPiratesInt);
        }
        if ((healthOfPiratesInt < 80) && (healthOfPiratesInt >= 40))
        {
            healthOfPirates.setForeground(Color.GRAY);
            healthOfPirates.setText("<html> O <br/> O " + healthOfPiratesInt + " <br/> O ");
        }
        if ((healthOfPiratesInt < 40) && (healthOfPiratesInt >= 0))
        {
            healthOfPirates.setForeground(Color.red);
            healthOfPirates.setText("<html> O " + healthOfPiratesInt + " <br/> O <br/> O ");
        }


        Main.patinga.xCenterOfCharacter = (patinga.getX() + (patinga.getWidth()/2));
        Main.patinga.yCenterOfCharacter = (patinga.getY() + (patinga.getHeight()/2));
        healthOfPatinga.setText("سلامت :  " + convertEnglishNumbersToPersian(Main.patinga.health));
        xCenterOfPatinga.setText("طول مرکز :  " + convertEnglishNumbersToPersian(Main.patinga.xCenterOfCharacter));
        yCenterOfPatinga.setText("عرض مرکز :  " + convertEnglishNumbersToPersian(Main.patinga.yCenterOfCharacter));

        Main.ghatinga.xCenterOfCharacter = (ghatinga.getX() + (ghatinga.getWidth()/2));
        Main.ghatinga.yCenterOfCharacter = (ghatinga.getY() + (ghatinga.getHeight()/2));
        healthOfGhatinga.setText("سلامت :  " + convertEnglishNumbersToPersian(Main.ghatinga.health));
        xCenterOfGhatinga.setText("طول مرکز :  " + convertEnglishNumbersToPersian(Main.ghatinga.xCenterOfCharacter));
        yCenterOfGhatinga.setText("عرض مرکز :  " + convertEnglishNumbersToPersian(Main.ghatinga.yCenterOfCharacter));

        Main.witinga.xCenterOfCharacter = (witinga.getX() + (witinga.getWidth()/2));
        Main.witinga.yCenterOfCharacter = (witinga.getY() + (witinga.getHeight()/2));
        healthOfWitinga.setText("سلامت :  " + convertEnglishNumbersToPersian(Main.witinga.health));
        xCenterOfWitinga.setText("طول مرکز :  " + convertEnglishNumbersToPersian(Main.witinga.xCenterOfCharacter));
        yCenterOfWitinga.setText("عرض مرکز :  " + convertEnglishNumbersToPersian(Main.witinga.yCenterOfCharacter));


        int healthOfGiantsInt = Main.patinga.health + Main.ghatinga.health + Main.witinga.health;
        if ((healthOfGiantsInt <= 120) && (healthOfGiantsInt >= 80))
        {
            healthOfGiants.setText("<html> O <br/> O <br/> O <font face=\"Urdu Typesetting\"> " + convertEnglishNumbersToPersian(healthOfGiantsInt) + "</font>");
        }
        if ((healthOfGiantsInt < 80) && (healthOfGiantsInt >= 40))
        {
            healthOfGiants.setForeground(Color.GRAY);
            healthOfGiants.setText("<html> O <br/> O <font face=\"Urdu Typesetting\"> " + convertEnglishNumbersToPersian(healthOfGiantsInt) + "</font> <br/> O ");
        }
        if ((healthOfGiantsInt < 40) && (healthOfGiantsInt >= 0))
        {
            healthOfGiants.setForeground(Color.red);
            healthOfGiants.setText("<html> O <font face=\"Urdu Typesetting\"> " + convertEnglishNumbersToPersian(healthOfGiantsInt) + "</font> <br/> O <br/> O ");
        }

        boolean xx = true;
        if (healthOfPiratesInt < 40 && xx)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0 ; i < 5 ; ++i)
                    {
                        Main.newPageOfPlay.setSize(((-450 * i) + 1800), ((-250 * i) + 1000));

                        try
                        {
                            Thread.sleep(50);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
            Main.newPageOfPlay.setVisible(false);

            PageOfEntering newPageOfEntering = new PageOfEntering();
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    newPageOfEntering.setVisible(true);
                    for (int i = 0 ; i < 5 ; ++i)
                    {
                        newPageOfEntering.setSize((250 * i), (182 * i));

                        try
                        {
                            Thread.sleep(50);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();


            newPageOfEntering.logoOfGame.setVisible(true);
            newPageOfEntering.C.setVisible(true);
            newPageOfEntering.L.setVisible(true);
            newPageOfEntering.A.setVisible(true);
            newPageOfEntering.S.setVisible(true);
            newPageOfEntering.H.setVisible(true);
            newPageOfEntering.designer.setVisible(true);
            newPageOfEntering.version.setVisible(true);

            newPageOfEntering.gameOver.setVisible(true);

            newPageOfEntering.result.setText("Giants win by " + healthOfGiantsInt + " points and Pirates lose by " + healthOfPiratesInt + " points.");
            newPageOfEntering.result.setVisible(true);

            newPageOfEntering.label1.setVisible(true);
            newPageOfEntering.label2.setVisible(true);
            newPageOfEntering.label3.setVisible(true);
            newPageOfEntering.label4.setVisible(true);
            newPageOfEntering.label5.setVisible(true);
            newPageOfEntering.label6.setVisible(true);
            newPageOfEntering.label7.setVisible(true);
            try {
                fileRelatedTasks(newPageOfEntering.backgroundLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }

            xx = false;
        }
        else if(healthOfGiantsInt < 40 && xx)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0 ; i < 5 ; ++i)
                    {
                        Main.newPageOfPlay.setSize(((-450 * i) + 1800), ((-250 * i) + 1000));

                        try
                        {
                            Thread.sleep(50);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
            Main.newPageOfPlay.setVisible(false);

            PageOfEntering newPageOfEntering = new PageOfEntering();
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    newPageOfEntering.setVisible(true);
                    for (int i = 0 ; i < 5 ; ++i)
                    {
                        newPageOfEntering.setSize((250 * i), (182 * i));

                        try
                        {
                            Thread.sleep(50);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();


            newPageOfEntering.logoOfGame.setVisible(true);
            newPageOfEntering.C.setVisible(true);
            newPageOfEntering.L.setVisible(true);
            newPageOfEntering.A.setVisible(true);
            newPageOfEntering.S.setVisible(true);
            newPageOfEntering.H.setVisible(true);
            newPageOfEntering.designer.setVisible(true);
            newPageOfEntering.version.setVisible(true);

            newPageOfEntering.gameOver.setVisible(true);

            newPageOfEntering.result.setText("Pirates win by " + healthOfPiratesInt + " points and Giants lose by " + healthOfGiantsInt + " points.");
            newPageOfEntering.result.setVisible(true);

            newPageOfEntering.label1.setVisible(true);
            newPageOfEntering.label2.setVisible(true);
            newPageOfEntering.label3.setVisible(true);
            newPageOfEntering.label4.setVisible(true);
            newPageOfEntering.label5.setVisible(true);
            newPageOfEntering.label6.setVisible(true);
            newPageOfEntering.label7.setVisible(true);
            try {
                fileRelatedTasks(newPageOfEntering.backgroundLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void fileRelatedTasks(JLabel label) throws IOException
    {
        String path = "C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\Grades.csv";
        FileWriter fileWriter = new FileWriter(path, true);
        CSVWriter writer = new CSVWriter(fileWriter);

        writer.writeNext(new String[]{String.valueOf(Main.pitt.health), String.valueOf(Main.george.health), String.valueOf(Main.william.health), String.valueOf(Main.patinga.health), String.valueOf(Main.ghatinga.health), String.valueOf(Main.witinga.health)});

        writer.close();

        FileReader fileReader = new FileReader(path);
        CSVReader reader = new CSVReader(fileReader);

        ArrayList<String[]> grades = new ArrayList<>();
        grades = (ArrayList<String[]>) reader.readAll();

        JLabel[] numbers = new JLabel[grades.size()];
        for (int i = 0 ; i < numbers.length ; ++i)
        {
            numbers[i] = new JLabel();

            numbers[i].setText(String.valueOf(i+1));
            numbers[i].setFont(new Font("Viner Hand ITC", Font.BOLD, 12));

            if (i != numbers.length-1)
            {
                numbers[i].setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
            }
            else
            {
                numbers[i].setBorder(new MatteBorder(0, 0, 0, 1, Color.black));
            }

            numbers[i].setHorizontalAlignment(SwingConstants.CENTER);
            numbers[i].setVisible(true);
            label.add(numbers[i]);
            numbers[i].setBounds(260, ((25 * i) + 505), 70, 25);
        }

        JLabel[][] labels = new JLabel[grades.size()][];

        for (int i = 0 ; i < labels.length ; ++i)
        {
            labels[i] = new JLabel[6];

            for (int j = 0 ; j < labels[i].length ; ++j)
            {
                labels[i][j] = new JLabel();

                labels[i][j].setText(grades.get(i)[j]);
                labels[i][j].setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
                switch (j)
                {
                    case 0 :
                    {
                        labels[i][j].setForeground(new Color(99, 0, 35));
                        break;
                    }
                    case 1 :
                    {
                        labels[i][j].setForeground(new Color(223, 29, 29));
                        break;
                    }
                    case 2 :
                    {
                        labels[i][j].setForeground(new Color(242, 232, 179));
                        break;
                    }
                    case 3 :
                    {
                        labels[i][j].setForeground(new Color(96, 96, 96));
                        break;
                    }
                    case 4 :
                    {
                        labels[i][j].setForeground(new Color(68, 60, 12));
                        break;
                    }
                    case 5 :
                    {
                        labels[i][j].setForeground(new Color(117, 69, 81));
                        break;
                    }
                }

                if ((i != labels.length-1) && (j != labels[i].length-1))
                {
                    labels[i][j].setBorder(new MatteBorder(0, 0, 1, 1, Color.black));
                }
                else if ((i == labels.length-1) && (j == labels[i].length-1))
                {
                    labels[i][j].setBorder(new MatteBorder(0, 0, 0, 0, Color.black));
                }
                else if ((i != labels.length-1) && (j == labels[i].length-1))
                {
                    labels[i][j].setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
                }
                else if ((i == labels.length-1) && (j != labels[i].length-1))
                {
                    labels[i][j].setBorder(new MatteBorder(0, 0, 0, 1, Color.black));
                }



                labels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                labels[i][j].setVisible(true);
                label.add(labels[i][j]);
                labels[i][j].setBounds(((70 * j) + 330), ((25 * i) + 505), 70, 25);
            }
        }
    }

    private StringBuilder convertEnglishNumbersToPersian(int number)
    {
        StringBuilder persianNumber = new StringBuilder();

        for (String x : String.valueOf(number).split(""))
        {
            if (x.equalsIgnoreCase("1"))
            {
                persianNumber.append("۱");
            }
            else if(x.equalsIgnoreCase("2"))
            {
                persianNumber.append("۲");
            }
            else if(x.equalsIgnoreCase("3"))
            {
                persianNumber.append("۳");
            }
            else if(x.equalsIgnoreCase("4"))
            {
                persianNumber.append("۴");
            }
            else if(x.equalsIgnoreCase("5"))
            {
                persianNumber.append("۵");
            }
            else if(x.equalsIgnoreCase("6"))
            {
                persianNumber.append("۶");
            }
            else if(x.equalsIgnoreCase("7"))
            {
                persianNumber.append("۷");
            }
            else if(x.equalsIgnoreCase("8"))
            {
                persianNumber.append("۸");
            }
            else if(x.equalsIgnoreCase("9"))
            {
                persianNumber.append("۹");
            }
            else
            {
                persianNumber.append("۰");
            }
        }

        return persianNumber;
    }

    boolean pause;
    private void muteMouseClicked(MouseEvent e)
    {
        if (!pause)
        {
            pause = true;

            Main.newPageOfEntering.pause();
        }
        else
        {
            try
            {
                Main.newPageOfEntering.fis = new FileInputStream(new File(Main.newPageOfEntering.path));
                Main.newPageOfEntering.fis.skip(Main.newPageOfEntering.total-Main.newPageOfEntering.pauseloc);
            }
            catch (IOException ex)
            {

            }
            Main.newPageOfEntering.bis = new BufferedInputStream(Main.newPageOfEntering.fis);
            try
            {
                Main.newPageOfEntering.player = new Player(Main.newPageOfEntering.bis);
            }
            catch (Exception  ex)
            {

            }
        }
    }




    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        backgroundPanel = new JPanel();
        pitt = new JLabel();
        headOfPitt = new JLabel();
        healthOfPitt = new JLabel();
        xCenterOfPitt = new JLabel();
        yCenterOfPitt = new JLabel();
        george = new JLabel();
        headOfGeorge = new JLabel();
        healthOfGeorge = new JLabel();
        xCenterOfGeorge = new JLabel();
        yCenterOfGeorge = new JLabel();
        william = new JLabel();
        headOfWilliam = new JLabel();
        healthOfWilliam = new JLabel();
        xCenterOfWillim = new JLabel();
        yCenterOfWillim = new JLabel();
        healthOfPirates = new JLabel();
        patinga = new JLabel();
        headOfPatinga = new JLabel();
        healthOfPatinga = new JLabel();
        xCenterOfPatinga = new JLabel();
        yCenterOfPatinga = new JLabel();
        ghatinga = new JLabel();
        headOfGhatinga = new JLabel();
        healthOfGhatinga = new JLabel();
        xCenterOfGhatinga = new JLabel();
        yCenterOfGhatinga = new JLabel();
        witinga = new JLabel();
        headOfWitinga = new JLabel();
        healthOfWitinga = new JLabel();
        xCenterOfWitinga = new JLabel();
        yCenterOfWitinga = new JLabel();
        healthOfGiants = new JLabel();
        mute = new JLabel();
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        backgroundLabel2 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label1 = new JLabel();
        label4 = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setUndecorated(true);
        setIconImage(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_poison_48px_1.png").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== backgroundPanel ========
        {
            backgroundPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
            backgroundPanel.setLayout(null);

            //---- pitt ----
            pitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_WALK_000.png"));
            pitt.setBorder(null);
            pitt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pittMouseClicked(e);
                    pittMouseClicked(e);
                }
            });
            backgroundPanel.add(pitt);
            pitt.setBounds(0, 0, 284, 240);

            //---- headOfPitt ----
            headOfPitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\SCML_Edit\\1_head_92.png"));
            headOfPitt.setBorder(null);
            backgroundPanel.add(headOfPitt);
            headOfPitt.setBounds(15, 865, 100, 100);

            //---- healthOfPitt ----
            healthOfPitt.setText("Health : ");
            healthOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfPitt.setForeground(Color.white);
            backgroundPanel.add(healthOfPitt);
            healthOfPitt.setBounds(115, 880, 140, healthOfPitt.getPreferredSize().height);

            //---- xCenterOfPitt ----
            xCenterOfPitt.setText("x Center :");
            xCenterOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            xCenterOfPitt.setForeground(Color.white);
            backgroundPanel.add(xCenterOfPitt);
            xCenterOfPitt.setBounds(115, 910, 140, 30);

            //---- yCenterOfPitt ----
            yCenterOfPitt.setText("y Center :");
            yCenterOfPitt.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            yCenterOfPitt.setForeground(Color.white);
            backgroundPanel.add(yCenterOfPitt);
            yCenterOfPitt.setBounds(115, 940, 140, 30);

            //---- george ----
            george.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\PNG\\3_3-PIRATE_WALK_000.png"));
            george.setBorder(null);
            george.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    georgeMouseClicked(e);
                }
            });
            backgroundPanel.add(george);
            george.setBounds(0, 240, 264, 250);

            //---- headOfGeorge ----
            headOfGeorge.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\George\\SCML_Edit\\1_head_92.png"));
            headOfGeorge.setBorder(null);
            backgroundPanel.add(headOfGeorge);
            headOfGeorge.setBounds(270, 875, 100, 100);

            //---- healthOfGeorge ----
            healthOfGeorge.setText("Health : ");
            healthOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfGeorge.setForeground(Color.white);
            backgroundPanel.add(healthOfGeorge);
            healthOfGeorge.setBounds(370, 880, 140, 30);

            //---- xCenterOfGeorge ----
            xCenterOfGeorge.setText("x Center :");
            xCenterOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            xCenterOfGeorge.setForeground(Color.white);
            backgroundPanel.add(xCenterOfGeorge);
            xCenterOfGeorge.setBounds(370, 910, 140, 30);

            //---- yCenterOfGeorge ----
            yCenterOfGeorge.setText("y Center :");
            yCenterOfGeorge.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            yCenterOfGeorge.setForeground(Color.white);
            backgroundPanel.add(yCenterOfGeorge);
            yCenterOfGeorge.setBounds(370, 940, 140, 30);

            //---- william ----
            william.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\PNG\\1_entity_000_WALK_000.png"));
            william.setBorder(null);
            william.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    williamMouseClicked(e);
                }
            });
            backgroundPanel.add(william);
            william.setBounds(0, 490, 310, 258);

            //---- headOfWilliam ----
            headOfWilliam.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\William\\SCML_Edit\\1_head_92.png"));
            headOfWilliam.setBorder(null);
            backgroundPanel.add(headOfWilliam);
            headOfWilliam.setBounds(525, 875, 100, 100);

            //---- healthOfWilliam ----
            healthOfWilliam.setText("Health : ");
            healthOfWilliam.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfWilliam.setForeground(Color.white);
            backgroundPanel.add(healthOfWilliam);
            healthOfWilliam.setBounds(625, 880, 140, 30);

            //---- xCenterOfWillim ----
            xCenterOfWillim.setText("x Center :");
            xCenterOfWillim.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            xCenterOfWillim.setForeground(Color.white);
            backgroundPanel.add(xCenterOfWillim);
            xCenterOfWillim.setBounds(625, 910, 140, 30);

            //---- yCenterOfWillim ----
            yCenterOfWillim.setText("y Center :");
            yCenterOfWillim.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            yCenterOfWillim.setForeground(Color.white);
            backgroundPanel.add(yCenterOfWillim);
            yCenterOfWillim.setBounds(625, 940, 140, 30);

            //---- healthOfPirates ----
            healthOfPirates.setIcon(null);
            healthOfPirates.setBorder(null);
            healthOfPirates.setText("<html> O <br/> O <br/> O 120");
            healthOfPirates.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfPirates.setHorizontalAlignment(SwingConstants.CENTER);
            healthOfPirates.setForeground(Color.white);
            backgroundPanel.add(healthOfPirates);
            healthOfPirates.setBounds(780, 875, 100, 100);

            //---- patinga ----
            patinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\PNG\\Troll_02_1_WALK_000.png"));
            patinga.setBorder(null);
            patinga.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    patingaMouseClicked(e);
                }
            });
            backgroundPanel.add(patinga);
            patinga.setBounds(1480, 40, 320, 200);

            //---- headOfPatinga ----
            headOfPatinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Patinga\\SCML_Edit\\2_head_92.png"));
            headOfPatinga.setBorder(null);
            backgroundPanel.add(headOfPatinga);
            headOfPatinga.setBounds(1685, 875, 100, 100);

            //---- healthOfPatinga ----
            healthOfPatinga.setText("\u0633\u0644\u0627\u0645\u062a :  \u06f1 \u06f2 \u06f3 \u06f4 \u06f5 \u06f6 \u06f7 \u06f8 \u06f9 \u06f0");
            healthOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            healthOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            healthOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            healthOfPatinga.setForeground(Color.white);
            backgroundPanel.add(healthOfPatinga);
            healthOfPatinga.setBounds(1535, 875, 140, 30);

            //---- xCenterOfPatinga ----
            xCenterOfPatinga.setText("\u0637\u0648\u0644 \u0645\u0631\u06a9\u0632 : ");
            xCenterOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            xCenterOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            xCenterOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            xCenterOfPatinga.setForeground(Color.white);
            backgroundPanel.add(xCenterOfPatinga);
            xCenterOfPatinga.setBounds(1535, 905, 140, 30);

            //---- yCenterOfPatinga ----
            yCenterOfPatinga.setText("\u0639\u0631\u0636 \u0645\u0631\u06a9\u0632 : ");
            yCenterOfPatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            yCenterOfPatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            yCenterOfPatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            yCenterOfPatinga.setForeground(Color.white);
            backgroundPanel.add(yCenterOfPatinga);
            yCenterOfPatinga.setBounds(1535, 935, 140, 30);

            //---- ghatinga ----
            ghatinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\PNG\\Troll_01_1_WALK_000.png"));
            ghatinga.setBorder(null);
            ghatinga.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ghatingaMouseClicked(e);
                }
            });
            backgroundPanel.add(ghatinga);
            ghatinga.setBounds(1480, 290, 320, 200);

            //---- headOfGhatinga ----
            headOfGhatinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Ghatinga\\SCML_Edit\\1_head_92.png"));
            headOfGhatinga.setBorder(null);
            backgroundPanel.add(headOfGhatinga);
            headOfGhatinga.setBounds(1430, 875, 100, 100);

            //---- healthOfGhatinga ----
            healthOfGhatinga.setText("\u0633\u0644\u0627\u0645\u062a : ");
            healthOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            healthOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            healthOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            healthOfGhatinga.setForeground(Color.white);
            backgroundPanel.add(healthOfGhatinga);
            healthOfGhatinga.setBounds(1280, 875, 140, 30);

            //---- xCenterOfGhatinga ----
            xCenterOfGhatinga.setText("\u0637\u0648\u0644 \u0645\u0631\u06a9\u0632 : ");
            xCenterOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            xCenterOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            xCenterOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            xCenterOfGhatinga.setForeground(Color.white);
            backgroundPanel.add(xCenterOfGhatinga);
            xCenterOfGhatinga.setBounds(1280, 905, 140, 30);

            //---- yCenterOfGhatinga ----
            yCenterOfGhatinga.setText("\u0639\u0631\u0636 \u0645\u0631\u06a9\u0632 : ");
            yCenterOfGhatinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            yCenterOfGhatinga.setHorizontalAlignment(SwingConstants.TRAILING);
            yCenterOfGhatinga.setVerticalAlignment(SwingConstants.BOTTOM);
            yCenterOfGhatinga.setForeground(Color.white);
            backgroundPanel.add(yCenterOfGhatinga);
            yCenterOfGhatinga.setBounds(1280, 935, 140, 30);

            //---- witinga ----
            witinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\PNG\\Troll_03_1_WALK_000.png"));
            witinga.setBorder(null);
            witinga.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    witingaMouseClicked(e);
                }
            });
            backgroundPanel.add(witinga);
            witinga.setBounds(1480, 546, 320, 200);

            //---- headOfWitinga ----
            headOfWitinga.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Witinga\\SCML_Edit\\3_head_92.png"));
            headOfWitinga.setBorder(null);
            backgroundPanel.add(headOfWitinga);
            headOfWitinga.setBounds(1175, 875, 100, 100);

            //---- healthOfWitinga ----
            healthOfWitinga.setText("\u0633\u0644\u0627\u0645\u062a : ");
            healthOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            healthOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            healthOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            healthOfWitinga.setForeground(Color.white);
            backgroundPanel.add(healthOfWitinga);
            healthOfWitinga.setBounds(1025, 875, 140, 30);

            //---- xCenterOfWitinga ----
            xCenterOfWitinga.setText("\u0637\u0648\u0644 \u0645\u0631\u06a9\u0632 : ");
            xCenterOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            xCenterOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            xCenterOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            xCenterOfWitinga.setForeground(Color.white);
            backgroundPanel.add(xCenterOfWitinga);
            xCenterOfWitinga.setBounds(1025, 905, 140, 30);

            //---- yCenterOfWitinga ----
            yCenterOfWitinga.setText("\u0639\u0631\u0636 \u0645\u0631\u06a9\u0632 : ");
            yCenterOfWitinga.setFont(new Font("Urdu Typesetting", Font.BOLD, 22));
            yCenterOfWitinga.setHorizontalAlignment(SwingConstants.TRAILING);
            yCenterOfWitinga.setVerticalAlignment(SwingConstants.BOTTOM);
            yCenterOfWitinga.setForeground(Color.white);
            backgroundPanel.add(yCenterOfWitinga);
            yCenterOfWitinga.setBounds(1025, 935, 140, 30);

            //---- healthOfGiants ----
            healthOfGiants.setIcon(null);
            healthOfGiants.setBorder(null);
            healthOfGiants.setText("<html> O <br/> O <br/> O 120");
            healthOfGiants.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
            healthOfGiants.setHorizontalAlignment(SwingConstants.CENTER);
            healthOfGiants.setForeground(Color.white);
            backgroundPanel.add(healthOfGiants);
            healthOfGiants.setBounds(920, 875, 100, 100);

            //---- mute ----
            mute.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\icons8_mute_32px_2.png"));
            mute.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    muteMouseClicked(e);
                }
            });
            backgroundPanel.add(mute);
            mute.setBounds(new Rectangle(new Point(886, 900), mute.getPreferredSize()));

            //---- separator1 ----
            separator1.setOrientation(SwingConstants.VERTICAL);
            separator1.setBackground(Color.white);
            separator1.setForeground(Color.white);
            backgroundPanel.add(separator1);
            separator1.setBounds(900, 0, separator1.getPreferredSize().width, 1000);

            //---- separator2 ----
            separator2.setBackground(Color.white);
            separator2.setForeground(Color.white);
            backgroundPanel.add(separator2);
            separator2.setBounds(0, 850, 1800, separator2.getPreferredSize().height);

            //---- backgroundLabel2 ----
            backgroundLabel2.setBorder(new MatteBorder(2, 1, 1, 1, Color.white));
            backgroundLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            backgroundLabel2.setBackground(new Color(255, 255, 255, 90));
            backgroundLabel2.setIcon(null);
            backgroundLabel2.setOpaque(true);
            backgroundPanel.add(backgroundLabel2);
            backgroundLabel2.setBounds(0, 0, 1800, 1000);

            //---- label2 ----
            label2.setBackground(new Color(234, 187, 90));
            label2.setOpaque(true);
            backgroundPanel.add(label2);
            label2.setBounds(2, 2, 260, 55);

            //---- label3 ----
            label3.setBackground(new Color(224, 162, 61));
            label3.setOpaque(true);
            backgroundPanel.add(label3);
            label3.setBounds(245, 455, 45, 30);

            //---- label1 ----
            label1.setBorder(null);
            label1.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\BACKGROUND2.png"));
            backgroundPanel.add(label1);
            label1.setBounds(2, 8, 300, 400);

            //---- label4 ----
            label4.setBackground(new Color(224, 162, 61));
            label4.setOpaque(true);
            backgroundPanel.add(label4);
            label4.setBounds(245, 1460, 45, 30);

            //---- backgroundLabel ----
            backgroundLabel.setBorder(new MatteBorder(2, 2, 2, 2, Color.white));
            backgroundLabel.setHorizontalAlignment(SwingConstants.TRAILING);
            backgroundLabel.setBackground(new Color(224, 162, 61));
            backgroundLabel.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\BACKGROUND1.png"));
            backgroundLabel.setOpaque(true);
            backgroundLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backgroundLabelMouseClicked(e);
                }
            });
            backgroundPanel.add(backgroundLabel);
            backgroundLabel.setBounds(0, -20, 1800, 1020);

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
        backgroundPanel.setBounds(0, 0, 1800, 1000);

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
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JPanel backgroundPanel;
    JLabel pitt;
    JLabel headOfPitt;
    JLabel healthOfPitt;
    JLabel xCenterOfPitt;
    JLabel yCenterOfPitt;
    JLabel george;
    JLabel headOfGeorge;
    JLabel healthOfGeorge;
    JLabel xCenterOfGeorge;
    JLabel yCenterOfGeorge;
    JLabel william;
    JLabel headOfWilliam;
    JLabel healthOfWilliam;
    JLabel xCenterOfWillim;
    JLabel yCenterOfWillim;
    JLabel healthOfPirates;
    JLabel patinga;
    JLabel headOfPatinga;
    JLabel healthOfPatinga;
    JLabel xCenterOfPatinga;
    JLabel yCenterOfPatinga;
    JLabel ghatinga;
    JLabel headOfGhatinga;
    JLabel healthOfGhatinga;
    JLabel xCenterOfGhatinga;
    JLabel yCenterOfGhatinga;
    JLabel witinga;
    JLabel headOfWitinga;
    JLabel healthOfWitinga;
    JLabel xCenterOfWitinga;
    JLabel yCenterOfWitinga;
    JLabel healthOfGiants;
    JLabel mute;
    JSeparator separator1;
    JSeparator separator2;
    JLabel backgroundLabel2;
    JLabel label2;
    JLabel label3;
    JLabel label1;
    JLabel label4;
    JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}


    /*for ofoghi

            new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if (movePitt)
                {
                    int x = (int) MouseInfo.getPointerInfo().getLocation().getX()-60;
                    int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

                    xx = false;

                    int i = 0;
                    int j = 0;

                    int xvaisa = pitt.getX();
                    System.out.println("------------------------------  "+ x);
                    while (pitt.getX() < x-(pitt.getWidth()/2))
                    {
                        pitt.setLocation(((50*i)+xvaisa),0);
                        i++;
                        System.out.println(pitt.getX());


                        pitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_RUN_00" + (j) + ".png"));
                        j++;
                        if (j == 7)
                        {
                            j = 0;
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }

                    movePitt = false;

                    pitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_WALK_006.png"));
                    xx=true;
                    idle();

                    System.out.println(pitt.getLocation());
                }
            }
        }).start();*/


    /* for amodi

            new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                if (movePitt)
                {
                    int x = (int) MouseInfo.getPointerInfo().getLocation().getX()-284;
                    int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

                    xx = false;

                    int i = 0;
                    int j = 0;

                    int yvaisa = pitt.getY();
                    pitt.setVisible(true);
                    System.out.println("------------------------------  "+ y);
                    while (pitt.getY() < y-(pitt.getHeight()/2))
                    {
                        pitt.setLocation(0,((50*i)+yvaisa));
                        i++;
                        System.out.println(pitt.getY());


                        pitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_RUN_00" + (j) + ".png"));
                        j++;
                        if (j == 7)
                        {
                            j = 0;
                        }

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }

                    movePitt = false;
                    pitt.setIcon(new ImageIcon("C:\\Users\\Sun Media\\Desktop\\IntlijProjects\\Project\\ImagesOfProject\\Pitt\\PNG\\2_entity_000_WALK_006.png"));
                    xx=true;
                    idle();

                    System.out.println(pitt.getLocation());

                }
            }
        }).start();


     */