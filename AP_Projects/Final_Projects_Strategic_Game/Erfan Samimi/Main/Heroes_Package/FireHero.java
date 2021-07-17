package Main.Heroes_Package;

import Main.Team;

public class FireHero extends Heroes {

    public FireHero(Team team, int locationX , int locationY){
        super(team , 1500 , 1700 , Speed.FAST, locationX , locationY ,237, 91, 0);
    }
}
