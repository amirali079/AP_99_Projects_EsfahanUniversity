package Main.Exceptions;

public class InvalidPassenger extends InvalidTrip{
    public InvalidPassenger() {
        super("error : The selected passenger does not have a travel permit !");
    }
}
