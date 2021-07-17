package Main.Exception;

public class InvalidPerson extends Invalid_input{

    String msg;
    public InvalidPerson( String msg ){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return msg;
    }
}
