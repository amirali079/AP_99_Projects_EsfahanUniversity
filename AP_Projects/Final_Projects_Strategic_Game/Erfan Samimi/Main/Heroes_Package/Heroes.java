package Main.Heroes_Package;


import Main.Graphics.GameBoardPanel;
import Main.*;

import java.io.Serializable;


public abstract class Heroes extends GameObjects implements Runnable , Serializable {

    Speed speed ;
    public boolean move = true ;
    boolean kill = false ;


    //--------------------------------------------------------------------------------------------------


    public Heroes (Team team , int power , int health , Speed speed , int locationX , int locationY , int red , int green , int blue  ){
        super(team , health , power , locationX , locationY , red , green , blue);
        this.speed = speed;
//        Thread t = new Thread(this , "move hero");
//        t.start();
    }

    //--------------------------------------------------------------------------------------------------

    public static void startMovingTeamObjects(Team team){

        for (GameObjects g : team.getGameObjects()){

            if (g instanceof Castle)
                continue;

            Thread t = new Thread((Heroes)g, "move hero");
            t.start();
        }


    }

    void moveHero() throws InterruptedException {

        long sleepTime ;

        if(this.speed.equals(Speed.SLOW))
            sleepTime = 3000;

        else
            sleepTime = 1500;


        Thread.sleep(sleepTime);





        if (move && ! isKilled() && !Main.gameFinished){


            int heroLocX = this.getLocation()[0];
            int heroLocY = this.getLocation()[1];

            System.out.println(this.name + " current location ~> x : " + heroLocX + " | y : " + heroLocY );

            int enemyLocX = this.getTeam().getEnemyCastle().getLocation()[0];
            int enemyLocY = this.getTeam().getEnemyCastle().getLocation()[1];

            int distanceX = Math.abs(enemyLocX - heroLocX);
            int distanceY = Math.abs(enemyLocY - heroLocY);

            int number = 1 ;




            if ( distanceX > distanceY) {

                if (enemyLocX - heroLocX < 0)
                    number = -1;

                this.setLocation(heroLocX + number, heroLocY);
            }

            else {

                if (enemyLocY - heroLocY < 0)
                    number = -1;

                this.setLocation(heroLocX, heroLocY + number);
            }

            Main.gameFrame.changeColor(heroLocX , heroLocY , GameBoardPanel.defaultColor , "");  // set last location color to default

            heroLocX = this.getLocation()[0];
            heroLocY = this.getLocation()[1];

            Main.gameFrame.changeColor(heroLocX ,heroLocY , this.color , this.getTeam().getTeamName()); // update new location color

            System.out.println(this.name + " after move Location ~> x : " + heroLocX + " | y : " + heroLocY );

        }



    }




    @Override
    public void run(){

        while (! isKilled() && !Main.gameFinished){

            try {
                this.moveHero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



}
