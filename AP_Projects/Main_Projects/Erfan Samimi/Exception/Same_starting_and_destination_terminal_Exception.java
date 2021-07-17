package Main.Exception;

public class Same_starting_and_destination_terminal_Exception extends InvalidJourney{
    @Override
    public String toString(){
        return "Starting and Destination terminal should be different";
    }
}
