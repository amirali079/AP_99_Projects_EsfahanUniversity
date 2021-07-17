package Main.Exceptions;

public class TerminalsIncompatibility extends CancelTrip {
    public TerminalsIncompatibility() {
        super("error : The origin and destination terminals are incompatible !");
    }
}
