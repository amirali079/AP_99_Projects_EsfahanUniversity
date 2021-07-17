package Exceptions;

public class Non_profit_account_exception extends Exception{
    String message;
    public Non_profit_account_exception(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        if (message == null)
            return "This account can not profit you any more!";
        return message;
    }
}
