package Exceptions;

public class Max_capacity_exception extends Cancel_travel_exception{
    String message;
    public Max_capacity_exception() {
    }

    public Max_capacity_exception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        if (message.isEmpty())
            return "Error!\nYou have been reached the maximum capacity!";
        return message;
    }
}
