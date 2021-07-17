package com.company.castle;
import com.company.graphics.GamePanel;
import com.company.heroPackage.Hero;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class EnemyCastle extends Thread implements Serializable
{
    private int XDirection ;
    private int YDirection  ;
    private boolean isContinue ;
    private ArrayList<Hero> allHero ;
    private int health;
    private JLabel castleLabel ;
    public static EnemyCastle currentEnemyCastle ;
    private static int DirectionUnit = 70 ;


    public EnemyCastle(int XDirection, int YDirection, ArrayList<Hero> heroes)
    {
        currentEnemyCastle = this ;
        this.XDirection = XDirection ;
        this.YDirection = YDirection ;
        allHero = new ArrayList<>(heroes) ;
        this.health = 20 ;
        setHeroesPosition();
        isContinue = true ;
    }


    public void createCastleLabel(JPanel gamePanel)
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                castleLabel = new JLabel() ;
                gamePanel.add(castleLabel) ;
                castleLabel.setIcon(new ImageIcon("src\\icons\\castle.png"));
                castleLabel.setBounds(XDirection,YDirection,125,125);
                return null ;
            }
        }.execute();
    }

    private void setHeroesPosition()
    {
        int heroCounter = 1 ;
        for (Hero h : getAllHero())
        {
            h.setYDirection(getYDirection() + (DirectionUnit * heroCounter));
            h.setXDirection(getXDirection() + DirectionUnit);
            heroCounter ++ ;
        }
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                for (Hero h : getAllHero())
                    h.getHeroLabel().setBounds(h.getXDirection(),h.getYDirection(),64,64);
                return null ;
            }
        }.execute();
    }

    public void addHeroTOPanel(JPanel gamePanel)
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                for (Hero h : getAllHero())
                    gamePanel.add(h.getHeroLabel()) ;
                return null ;
            }
        }.execute();
    }

    public boolean isAllDead()
    {
        boolean isAllDead = true ;
        for (Hero H : getAllHero())
            if (!H.isDead())
                isAllDead = false ;
        return isAllDead ;
    }

    public void updateEnemyInfo()
    {
        if (isContinue())
        {
            if(getHealth() <= 0)
            {
                new SwingWorker<>(){
                    @Override
                    public Object doInBackground() {
                        GamerCastle.currentGamerCastle.setWin(true);
                        String message = "Win" ;
                        ImageIcon icon = new ImageIcon("src\\icons\\trophy - 2.png") ;
                        GamePanel.showWinner.setText(message);
                        GamePanel.showWinner.setIcon(icon);
                        setContinue(false);
                        GamerCastle.currentGamerCastle.setContinue(false);
                        return null ;
                    }
                }.execute();
            }

            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    GamePanel.EnemyPB.setValue(getHealth() * 5);
                    if (getHealth() < 5)
                        GamePanel.EnemyPB.setBackground(new Color(102,0,0));


                    else
                        GamePanel.EnemyPB.setBackground(new Color(0,51,0));

                    return null ;
                }
            }.execute();
        }
    }

    public void move() {
        if (this.isContinue())
        {
            for (Hero h : getAllHero())
                if (!h.isDead()) {
                    int XDistance = Math.abs(GamerCastle.currentGamerCastle.getXDirection() - h.getXDirection());
                    int YDistance = Math.abs(GamerCastle.currentGamerCastle.getYDirection() - h.getYDirection());
                    if (XDistance >= YDistance) {
                        h.setXDirection(h.getXDirection() - h.getSpeed());
                    }

                    if (YDistance > XDistance) {
                        if (h.getYDirection() > GamerCastle.currentGamerCastle.getYDirection())
                            h.setYDirection(h.getYDirection() - h.getSpeed());
                        if (h.getYDirection() < GamerCastle.currentGamerCastle.getYDirection())
                            h.setYDirection(h.getYDirection() + h.getSpeed());
                    }
                }
            new SwingWorker<>() {
                @Override
                public Object doInBackground() {
                    for (Hero h : getAllHero())
                        h.getHeroLabel().setBounds(h.getXDirection(), h.getYDirection(), 64, 64);
                    return null;
                }
            }.execute();
        }
    }

    public void shootToHero(Hero hero, Hero Target)
    {
        if (isContinue())
        {
            int XDistance = Math.abs(hero.getXDirection() - Target.getXDirection());
            int YDistance = Math.abs(hero.getYDirection() - Target.getYDirection()) ;
            if (XDistance < 64 && YDistance < 64)
            {
                hero.setHealth(hero.getHealth() - Target.getPerformance());
                hero.setPerformance(hero.getPerformance() - (Target.getPerformance()) / 2);
                hero.setSpeed(hero.getSpeed() - (Target.getPerformance()) / 2);
                Target.setHealth(Target.getHealth() - hero.getPerformance());
                Target.setPerformance(Target.getPerformance() - (hero.getPerformance()) / 2);
                Target.setSpeed(Target.getSpeed() - (hero.getPerformance()) / 2);
            }
        }
    }

    public void shootToCastle()
    {
        if (isContinue())
        {
            new SwingWorker<>(){
                @Override
                public Object doInBackground() {
                    for (Hero h : getAllHero())
                        if (!h.isDead())
                        {
                            int xDistance = Math.abs(h.getXDirection() - GamerCastle.currentGamerCastle.getXDirection());
                            int yDistance = Math.abs(h.getYDirection() - GamerCastle.currentGamerCastle.getYDirection());
                            if (xDistance < 20 && yDistance < 20) {
                                GamerCastle.currentGamerCastle.setHealth(GamerCastle.currentGamerCastle.getHealth() - h.getPerformance());
                                h.setDead(true);
                            }
                        }
                    return null ;
                }
            }.execute();
        }
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(100);

                updateEnemyInfo();
                move();

                for (Hero EH : getAllHero())
                    for (Hero GH : GamerCastle.currentGamerCastle.getAllHero())
                        if (!EH.isDead())
                            if (!GH.isDead())
                                shootToHero(EH, GH);

                for (Hero h : getAllHero())
                    h.updateHero();

                shootToCastle();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getXDirection() { return XDirection; }
    public int getYDirection() { return YDirection; }

    public void setContinue(boolean aContinue) { this.isContinue = aContinue; }
    public boolean isContinue() { return isContinue; }

    public void setHealth(int health) { this.health = health; }
    public int getHealth() { return health; }

    public ArrayList<Hero> getAllHero() { return allHero; }
}
