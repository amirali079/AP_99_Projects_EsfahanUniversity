package Main.Exception;

public class InvalidTransaction extends RuntimeException{
    String msg ;

    public InvalidTransaction(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return this.msg;
    }
}
