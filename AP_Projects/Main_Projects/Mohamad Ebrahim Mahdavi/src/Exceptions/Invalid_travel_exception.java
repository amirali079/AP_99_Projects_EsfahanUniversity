package Exceptions;

public class Invalid_travel_exception extends Exception{
    @Override
    public String getMessage() {
        return "Error!\nThis kind of travel is invalid!";
    }
}
