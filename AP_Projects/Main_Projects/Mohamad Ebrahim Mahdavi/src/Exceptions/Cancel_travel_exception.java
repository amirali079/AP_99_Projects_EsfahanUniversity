package Exceptions;

public class Cancel_travel_exception extends Exception{
    @Override
    public String getMessage() {
        return "Error!\nDetails are not valid";
    }
}
