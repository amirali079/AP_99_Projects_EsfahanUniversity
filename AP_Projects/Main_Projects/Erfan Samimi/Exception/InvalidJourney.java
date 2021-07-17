package Main.Exception;

public class InvalidJourney extends RuntimeException{
    @Override
    public String toString(){
        return "Invalid Journey";
    }
}
