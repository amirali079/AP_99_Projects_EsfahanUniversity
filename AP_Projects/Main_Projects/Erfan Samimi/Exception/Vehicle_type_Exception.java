package Main.Exception;

public class Vehicle_type_Exception extends  InvalidJourney{
    String msg ;
    public Vehicle_type_Exception(String msg){
        this.msg = msg ;
    }


    public String toString(){
        return msg;
    }
}
