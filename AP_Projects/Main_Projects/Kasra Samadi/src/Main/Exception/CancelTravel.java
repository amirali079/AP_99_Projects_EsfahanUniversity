package Main.Exception;

public class CancelTravel extends RuntimeException{
    public CancelTravel() {
        super();
    }

    public CancelTravel(String message) {
        super(message);
    }


}
