package Main.Exceptions;

public class InvalidName extends InvalidInput{
    public InvalidName() {
        super("error : City name must have at least 4 character !");
    }
}
