package Exceptions;

public class Low_capacity_exception extends Cancel_travel_exception{
    String message;
    public Low_capacity_exception() {
    }

    public Low_capacity_exception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        if (message.isEmpty())
            return "Error!\nYour passengers did not reach minimum capacity!";
        return message;
    }
}
