package Main.Exception;

public class InvalidInput extends RuntimeException {
    InvalidInput(){
        super();
    }
    public InvalidInput(String msg){
        super(msg);
    }
}
