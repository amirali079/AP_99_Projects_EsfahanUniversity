package Main.Exceptions;

public class InvalidCapacity extends CancelTrip{
    public InvalidCapacity() {
        super("LTH error ~ Less than half the capacity is filled !");
    }

    public InvalidCapacity(String message) {
        super(message);
    }
}
