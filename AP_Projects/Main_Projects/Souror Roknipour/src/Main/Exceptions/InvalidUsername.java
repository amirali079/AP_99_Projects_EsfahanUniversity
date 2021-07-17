package Main.Exceptions;

public class InvalidUsername extends InvalidInput{
    public InvalidUsername() {
        super(" Error : your username must have at least 4 character !");
    }
}
