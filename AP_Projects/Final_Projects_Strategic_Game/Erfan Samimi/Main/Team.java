package Main;

import Main.Heroes_Package.Heroes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Handler;

public class Team implements Serializable {

    ArrayList<GameObjects> gameObjects = new ArrayList<>();

    Castle castle;
    Castle enemyCastle;
    String teamName ;


    public Team(int castleX , int castleY , String teamName ){

        this.teamName = teamName;
        this.castle = new Castle(this , 10000 , 500 , castleX , castleY , 78 , 81 , 84 );
        gameObjects.add(this.castle);


    }

    public void setEnemyCastle(Castle enemyCastle){
        this.enemyCastle = enemyCastle;
    }

    public GameObjects getEnemyCastle(){
        return this.enemyCastle;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public ArrayList<GameObjects> getGameObjects(){
        return this.gameObjects;
    }

    public String getTeamStatus(){

        String str = "";
        str += "Team Number : "+ this.teamName + "\n";


        for (GameObjects g : this.gameObjects){

            if (g.killed)
                continue;

            str += g.name + " Health : " + g.getHealth() + " \n";

        }

        return str;

    }

    public int getNumberOfAliveHeroes(){

        int counter =0;

        for (GameObjects g : this.gameObjects){
            if (g instanceof Heroes && !g.killed )
                counter++;
        }

        return counter;
    }

}
