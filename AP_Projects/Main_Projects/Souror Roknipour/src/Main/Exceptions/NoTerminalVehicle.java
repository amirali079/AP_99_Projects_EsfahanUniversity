package Main.Exceptions;

public class NoTerminalVehicle extends CancelTrip{
    public NoTerminalVehicle() {
        super("error : The origin Terminal has no vehicle !");
    }
}
