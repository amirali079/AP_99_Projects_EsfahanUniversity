package Main.Vehicles;

abstract public class Shipping_vehicle extends Vehicle {
    String fuel_type ;
    int min_depth ;

    Shipping_vehicle(String fuel_type , int min_depth , int price , int capacity , String ID , String companyName){
        super(price , capacity , ID , companyName) ;
        this.fuel_type = fuel_type ;
        this.min_depth = min_depth ;
    }
}
