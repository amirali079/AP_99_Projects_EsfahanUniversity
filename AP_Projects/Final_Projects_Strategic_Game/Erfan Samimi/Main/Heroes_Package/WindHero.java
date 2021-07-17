package Main.Heroes_Package;

import Main.Team;

public class WindHero extends Heroes{

    public WindHero(Team team, int locationX , int locationY){
        super(team , 800 , 2000 , Speed.FAST, locationX , locationY , 245, 230, 105);
    }
}
