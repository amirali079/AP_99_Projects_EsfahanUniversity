package Exceptions;

public class Incorrect_entry_exception extends Exception{
    String message;
    public Incorrect_entry_exception() {
    }

    public Incorrect_entry_exception( String message1) {
        this.message = message1;
    }

    @Override
    public String getMessage() {
        if (message!=null)
        return message;
        return "Error!\nWrong entry try again!";
    }
}
