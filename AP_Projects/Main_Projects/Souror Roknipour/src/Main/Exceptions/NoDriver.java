package Main.Exceptions;

public class NoDriver extends CancelTrip{
    public NoDriver() {
        super("error : The origin terminal has no driver !");
    }
}
