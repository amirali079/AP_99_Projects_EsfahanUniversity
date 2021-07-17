package Main.Vehicles;

abstract public class Air_transport_vehicle extends Vehicle {
    int max_flight_height ;
    int runway_length ;

    Air_transport_vehicle(int max_flight_height , int runway_length , int price , int capacity , String ID , String companyName ){
        super(price , capacity , ID , companyName) ;
        this.max_flight_height = max_flight_height ;
        this.runway_length = runway_length;
    }
}
