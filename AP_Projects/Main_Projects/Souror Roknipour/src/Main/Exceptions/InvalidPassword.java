package Main.Exceptions;

public class InvalidPassword extends InvalidInput{
    public InvalidPassword() {
        super(" Error : your password must have at least 6 character !");
    }
}
