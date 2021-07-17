package Exceptions;

public class Invalid_driver_exception extends Cancel_travel_exception{
    String message;
    public Invalid_driver_exception() {
    }

    public Invalid_driver_exception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        if (message.isEmpty())
            return "Error!\nThe driver that you have chosen is not available!";
        return message;
    }
}
