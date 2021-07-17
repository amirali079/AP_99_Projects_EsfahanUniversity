package backend;

public enum Type {
    wind(20,3,15),fire(20,2,30),ice(40,1,10),rock(25,2,20);
    int health;
    int speed;
    int power;

    Type(int health, int speed, int power) {
        this.health = health;
        this.speed = speed;
        this.power = power;
    }
}
