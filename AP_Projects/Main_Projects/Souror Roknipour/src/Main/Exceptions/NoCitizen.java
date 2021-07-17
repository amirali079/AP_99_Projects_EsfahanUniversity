package Main.Exceptions;

public class NoCitizen extends CancelTrip{
    public NoCitizen() {
        super("error : The origin City has no Citizens !");
    }
}
