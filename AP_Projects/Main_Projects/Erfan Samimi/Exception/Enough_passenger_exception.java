package Main.Exception;

public class Enough_passenger_exception extends CanceledJourney{
    String msg ;
    public Enough_passenger_exception(String msg){
        this.msg = msg;
    }
    @Override
    public String toString(){
        return msg;
    }
}
