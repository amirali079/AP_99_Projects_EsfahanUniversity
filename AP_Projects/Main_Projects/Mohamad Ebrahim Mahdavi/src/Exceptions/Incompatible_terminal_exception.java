package Exceptions;

public class Incompatible_terminal_exception extends Invalid_travel_exception{
    String message;
    @Override
    public String getMessage() {
        if (message.isEmpty())
        return "Error!\nOrigin terminal is not compatible with the destination terminal!";
        return message;
    }

    public Incompatible_terminal_exception(String message) {
        this.message = message;
    }
    public Incompatible_terminal_exception(){
    }
}
