package Main.Vehicles;

abstract public class Land_transport_vehicle extends Vehicle{
    int fuel_capacity ;
    String fuel_type ; //gas , gas oil , CNG
    int speed ;

    Land_transport_vehicle(int fuel_capacity , String fuel_type , int speed , int price , int passenger_capacity , String name_company , String ID ){
        super(price , passenger_capacity , ID , name_company);
        this.fuel_capacity =fuel_capacity;
        this.fuel_type = fuel_type;
        this.speed = speed;
    }
}
