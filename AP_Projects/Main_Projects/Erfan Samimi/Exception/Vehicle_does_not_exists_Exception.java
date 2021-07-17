package Main.Exception;

public class Vehicle_does_not_exists_Exception extends Invalid_input{

    String msg;

    public Vehicle_does_not_exists_Exception(String msg){
        this.msg = msg ;
    }
    public String toString(){
        return msg;
    }
}
