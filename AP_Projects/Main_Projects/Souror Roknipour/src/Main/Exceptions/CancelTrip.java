package Main.Exceptions;

public class CancelTrip extends RuntimeException{
    public CancelTrip(String message) {
        super(message);
    }
}
