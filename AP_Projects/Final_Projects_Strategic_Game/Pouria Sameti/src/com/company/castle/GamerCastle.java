package com.company.castle;
import com.company.graphics.GamePanel;
import com.company.heroPackage.Hero;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class GamerCastle extends Thread implements Serializable
{
    private int XDirection ;
    private int YDirection ;
    public boolean isContinue ;
    private boolean win ;
    private ArrayList<Hero> allHero;
    private int health;
    private JLabel castleLabel ;
    private static int DirectionUnit = 70 ;
    public static GamerCastle currentGamerCastle ;


    public GamerCastle(int XDirection, int YDirection, ArrayList<Hero> heroes) {
        currentGamerCastle = this ;
        this.XDirection = XDirection ;
        this.YDirection = YDirection ;
        allHero = new ArrayList<>(heroes);
        this.health = 20;
        castleLabel = new JLabel() ;
        this.win = true ;
        this.isContinue = true ;
        setHeroesPosition();
    }

    public void createCastleLabel(JPanel gamePanel)
    {
        castleLabel = new JLabel() ;
        castleLabel.setIcon(new ImageIcon("src\\icons\\castle.png"));
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                gamePanel.add(castleLabel) ;
                castleLabel.setBounds(XDirection,YDirection,125,125);
                return null ;
            }
        }.execute();
    }

    private void setHeroesPosition() {
        int heroCounter = 1 ;
        for (Hero h : getAllHero())
        {
            h.setYDirection(getYDirection() + (DirectionUnit * heroCounter));
            h.setXDirection(getXDirection() - DirectionUnit);
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

    public void addHeroTOPanel(JPanel gamePanel) {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                for (Hero h : getAllHero())
                    gamePanel.add(h.getHeroLabel()) ;
                return null ;
            }
        }.execute();
    }

    public void move() {
        if (this.isContinue()) {
            for (Hero h : getAllHero())
                if (!h.isDead()) {
                    int XDistance = Math.abs(h.getXDirection() - EnemyCastle.currentEnemyCastle.getXDirection());
                    int YDistance = Math.abs(h.getYDirection() - EnemyCastle.currentEnemyCastle.getYDirection());
                    if (XDistance >= YDistance) {
                        h.setXDirection(Math.abs(h.getXDirection() + h.getSpeed()));
                    }


                    if (YDistance > XDistance) {
                        if (h.getYDirection() < EnemyCastle.currentEnemyCastle.getYDirection()) {
                            h.setYDirection(Math.abs(h.getYDirection() + h.getSpeed()));
                        } else {
                            h.setYDirection(Math.abs(h.getYDirection() - h.getSpeed()));
                        }
                    }
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
    }

    public void shootToHero(Hero hero, Hero Target) {
        if(isContinue())
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
                public Object doInBackground()
                {
                    for (Hero h : getAllHero())
                        if (!h.isDead())
                        {
                            int xDistance = Math.abs(h.getXDirection() - EnemyCastle.currentEnemyCastle.getXDirection());
                            int yDistance = Math.abs(h.getYDirection() - EnemyCastle.currentEnemyCastle.getYDirection());
                            if (xDistance < 20 && yDistance < 20) {
                                EnemyCastle.currentEnemyCastle.setHealth(EnemyCastle.currentEnemyCastle.getHealth() - h.getPerformance());
                                h.setDead(true);
                            }
                        }
                    return null ;
                }
            }.execute();
        }
    }

    public boolean isAllDead()
    {
        boolean isAllDead = true ;
        for (Hero H : getAllHero())
            if (!H.isDead())
                isAllDead = false ;
        return isAllDead ;
    }

    public void updateGamerInfo()
    {
        if (isContinue())
        {
            if(getHealth() <= 0)
            {
                new SwingWorker<>(){
                    @Override
                    public Object doInBackground() {
                        setWin(false);
                        String message = "GAME OVER" ;
                        ImageIcon icon = new ImageIcon("src\\icons\\skull - 2.png") ;
                        GamePanel.showWinner.setText(message);
                        GamePanel.showWinner.setIcon(icon);
                        setContinue(false);
                        EnemyCastle.currentEnemyCastle.setContinue(false);
                        return null ;
                    }
                }.execute();
            }


            if (this.isAllDead() && EnemyCastle.currentEnemyCastle.isAllDead())
            {
                if (getHealth() > EnemyCastle.currentEnemyCastle.getHealth())
                {
                    new SwingWorker<>(){
                        @Override
                        public Object doInBackground() {
                            setWin(true);
                            String message = "Win" ;
                            ImageIcon icon = new ImageIcon("src\\icons\\trophy - 2.png") ;
                            GamePanel.showWinner.setText(message);
                            GamePanel.showWinner.setIcon(icon);
                            setContinue(false);
                            EnemyCastle.currentEnemyCastle.setContinue(false);
                            return null ;
                        }
                    }.execute();
                }

                else
                {
                    new SwingWorker<>(){
                        @Override
                        public Object doInBackground() {
                            setWin(false);
                            String message = "GAME OVER" ;
                            ImageIcon icon = new ImageIcon("src\\icons\\skull - 2.png") ;
                            GamePanel.showWinner.setText(message);
                            GamePanel.showWinner.setIcon(icon);
                            setContinue(false);
                            EnemyCastle.currentEnemyCastle.setContinue(false);
                            return null ;
                        }
                    }.execute();
                }
            }

            else
            {
                new SwingWorker<>(){
                    @Override
                    public Object doInBackground() {
                        GamePanel.GamerPB.setValue(getHealth() * 5);
                        if (getHealth() < 5)
                            GamePanel.GamerPB.setBackground(new Color(102,0,0));

                        else
                            GamePanel.GamerPB.setBackground(new Color(0,51,0));
                        return null ;
                    }
                }.execute();
            }
        }
    }


   @Override
    public void run()
   {
       while (true)
       {
           try
           {
               Thread.sleep(100);

               updateGamerInfo();
               move();

               for (Hero GH : getAllHero())
                   for (Hero EH : EnemyCastle.currentEnemyCastle.getAllHero())
                       if (!GH.isDead())
                           if (!EH.isDead())
                               shootToHero(GH, EH);


               for (Hero h : getAllHero())
                   h.updateHero();

               shootToCastle();
           }
           catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }

    public void setContinue(boolean Continue) { this.isContinue = Continue; }
    public boolean isContinue() { return isContinue; }

    public int getXDirection() { return XDirection; }
    public int getYDirection() { return YDirection; }

    public void setWin(boolean win) { this.win = win; }
    public boolean isWin() { return win; }

    public void setHealth(int health) { this.health = health; }
    public int getHealth() { return health; }

     public ArrayList<Hero> getAllHero() { return allHero; }
}