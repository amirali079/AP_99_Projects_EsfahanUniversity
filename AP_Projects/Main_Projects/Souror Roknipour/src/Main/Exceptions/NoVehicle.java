package Main.Exceptions;

public class NoVehicle extends CancelTrip{
    public NoVehicle() {
        super("error : The origin City has no vehicle !");
    }
}
