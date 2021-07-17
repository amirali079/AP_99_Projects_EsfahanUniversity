package Main.Exception;

public class Invalid_date extends InvalidJourney{
    String msg ;
    public Invalid_date(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return msg;
    }
}
