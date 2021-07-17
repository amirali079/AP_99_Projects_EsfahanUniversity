package Main.Exceptions;

public class NoTerminal extends InvalidTrip{
    public NoTerminal() {
        super("error : The origin City has no terminal !");
    }

    public NoTerminal(String message) {
        super(message);
    }
}
