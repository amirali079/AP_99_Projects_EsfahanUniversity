package Main.Exceptions;

public class InvalidTrip extends RuntimeException{
    public InvalidTrip(String message) {
        super(message);
    }
}

