package com.company;
import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Hero implements Serializable
{
    static ArrayList<ImageIcon> icons = new ArrayList<>();

    ImageIcon ImgIcon;
    Castle castle;
    String team;
    int score;
    int health;
    int power;
    int speed;
    int x;
    int y;
}