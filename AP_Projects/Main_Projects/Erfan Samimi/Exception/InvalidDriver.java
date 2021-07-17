package Main.Exception;

public class InvalidDriver extends InvalidJourney{
    String msg;
    public InvalidDriver(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return msg;
    }
}
