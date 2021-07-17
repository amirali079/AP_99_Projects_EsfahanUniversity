package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Soil extends Hero
{
    Soil(int x, int y ,Castle castle, String name) throws IOException
    {
        this.castle = castle;
        this.health = 30;
        this.speed = 1;
        this.power = 30;
        this.x = x;
        this.y = y;

        Image temp1 = ImageIO.read(new File("I:\\image\\soil.png"));
        Image temp2 = temp1.getScaledInstance(50,50,Image.SCALE_DEFAULT);

        this.ImgIcon = new ImageIcon(temp2);
        Hero.icons.add(ImgIcon);
        Background.btns[x][y].setIcon(this.ImgIcon);

        Thread SoilThread = new Thread(() ->
        {
            do
            {
                if(Background.starter.isAlive())
                {
                    try
                    {
                        Main.b.moveHero(this);
                    }
                    catch (InterruptedException ignored) {}
                }

            }while(this.health > 0);
        });

        Background.heroThread.add(SoilThread);
        SoilThread.start();
    }
}
