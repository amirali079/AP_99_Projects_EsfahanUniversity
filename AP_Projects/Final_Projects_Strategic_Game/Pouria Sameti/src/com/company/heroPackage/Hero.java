package com.company.heroPackage;
import javax.swing.*;
import java.io.Serializable;


public abstract class Hero implements Serializable
{
    private boolean isEnemy ;
    private boolean isDead ;
    private int performance ;
    private int health ;
    private int speed ;
    private int xDirection ;
    private int yDirection ;
    private JLabel heroLabel ;
    private HeroType type ;


    public Hero(boolean isEnemy,int performance,int health,int speed, HeroType type)
    {
        this.isEnemy = isEnemy ;
        this.isDead = false ;
        this.performance = performance ;
        this.health = health ;
        this.speed = speed ;
        this.type = type ;
        setHeroImage(type);
    }


    //Hero type
    public enum HeroType
    {
        Ice,Wind,Fire,Earth
    }

    public void setHeroImage(HeroType type)
    {
        heroLabel = new JLabel() ;
        if (type.equals(HeroType.Ice) && isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\enemy - ice knight.png"));
        if (type.equals(HeroType.Ice) && !isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\gamer - ice knight.png"));
        if (type.equals(HeroType.Fire) && isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\enemy - fire knight.png"));
        if (type.equals(HeroType.Fire) && !isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\gamer -fire knight.png"));
        if (type.equals(HeroType.Wind) && isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\enemy - wind knight.png"));
        if (type.equals(HeroType.Wind) && !isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\gamer - wind knight.png"));
        if (type.equals(HeroType.Earth) && isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\enemy - earth knight.png"));
        if (type.equals(HeroType.Earth) && !isEnemy)
            heroLabel.setIcon(new ImageIcon("src\\icons\\gamer - earth knight.png"));
    }


    public void updateHero()
    {
        if (getHealth() <= 0)
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    setDead(true);
                    getHeroLabel().setIcon(new ImageIcon("src\\icons\\blood.png"));
                    return null ;
                }
            }.execute();
        }
    }


    public void setEnemy(boolean enemy) { isEnemy = enemy; }
    public boolean isEnemy() { return isEnemy; }

    public void setDead(boolean dead) { isDead = dead; }
    public boolean isDead() { return isDead; }

    public void setXDirection(int xDirection) { this.xDirection = xDirection; }
    public int getXDirection() { return xDirection; }

    public void setYDirection(int yDirection) { this.yDirection = yDirection; }
    public int getYDirection() { return yDirection; }

    public void setPerformance(int performance) { this.performance = performance; }
    public int getPerformance() { return performance; }

    public void setHealth(int health) { this.health = health; }
    public int getHealth() { return health; }

    public void setSpeed(int speed) { this.speed = speed; }
    public int getSpeed() { return speed; }


    public JLabel getHeroLabel() { return heroLabel; }

    public HeroType getType() { return type; }
}
