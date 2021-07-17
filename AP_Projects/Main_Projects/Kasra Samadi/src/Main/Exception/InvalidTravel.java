package Main.Exception;

public class InvalidTravel extends RuntimeException{
    public InvalidTravel() {
        super();
    }

    public InvalidTravel(String message) {
        super(message);
    }
}
