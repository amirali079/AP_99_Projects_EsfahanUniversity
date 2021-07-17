package Main.Exception;

public class InvalidPassengers extends Invalid_input{
    String msg ;
    public InvalidPassengers(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return this.msg;
    }
}
