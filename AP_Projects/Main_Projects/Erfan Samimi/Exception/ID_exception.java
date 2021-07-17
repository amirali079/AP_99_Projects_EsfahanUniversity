package Main.Exception;

public class ID_exception extends RuntimeException{
    String msg ;

    public ID_exception(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return this.msg;
    }
}
