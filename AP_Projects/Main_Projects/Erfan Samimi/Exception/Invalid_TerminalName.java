package Main.Exception;

public class Invalid_TerminalName extends Invalid_input{
    String msg ;

    public Invalid_TerminalName(String msg){
        this.msg = msg;
    }

    public String toString(){
        return msg;
    }
}
