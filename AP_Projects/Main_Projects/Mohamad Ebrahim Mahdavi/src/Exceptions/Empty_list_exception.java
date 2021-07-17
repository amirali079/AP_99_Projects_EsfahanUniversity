package Exceptions;

public class Empty_list_exception extends Exception{
    @Override
    public String getMessage() {
        return "This list is empty!\nTry with another list!";
    }
}
