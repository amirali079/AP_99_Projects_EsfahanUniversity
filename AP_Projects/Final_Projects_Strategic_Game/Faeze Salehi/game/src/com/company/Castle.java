package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Castle
{
    int x;
    int y;
    int score;
    int health;
    ImageIcon CastleIcon;
    String name;

    Castle(int x , int y , String name) throws IOException
    {
        this.x = x;
        this.y = y;
        this.name = name;
        this.health = 10;
        this.score = 0;

        Image temp1 = ImageIO.read(new File("I:\\image\\castle2.png"));
        Image temp2 = temp1.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        CastleIcon = new ImageIcon(temp2);

        Background.btns[x][y].setIcon(CastleIcon);
    }
}
