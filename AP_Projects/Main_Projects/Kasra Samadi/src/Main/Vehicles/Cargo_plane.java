package Main.Vehicles;
import java.io.Serializable;
import java.util.ArrayList;
// هواپیمای باربری
public class Cargo_plane extends Air_Vehicle implements Serializable {
    private int Total_portable_weight;//مجموع وزن قابل حمل
    private static final ArrayList<Cargo_plane> cargo_planes=new ArrayList<>();

    public Cargo_plane(int price, int capacity, int ID, String company_builder_name, int maximum_flight_altitude, int band_length_required_for_Landing, int total_portable_weight) {
        super(price, capacity, ID, company_builder_name, maximum_flight_altitude, band_length_required_for_Landing);
        Total_portable_weight = total_portable_weight;
    }
    public void AddCargoPlanes(Cargo_plane cargo_plane){
        cargo_planes.add(cargo_plane);
    }

    public static ArrayList<Cargo_plane> getCargo_planes() {
        return cargo_planes;
    }

    public int getTotal_portable_weight() {
        return Total_portable_weight;
    }

    public void setTotal_portable_weight(int total_portable_weight) {
        Total_portable_weight = total_portable_weight;
    }

    public static void ShowCargoPlanes(){
        System.out.println("\n*************************************************************SHOW CARGO PLANE*************************************************************");
        for(int i=0;i<cargo_planes.size();i++){
            System.out.format("\n(ID:%d) Price: %d ,Capacity: %d , Company Builder Name: %s, Maximum Flight Altitude: %d , Band Length Required For Landing: %d , Total portable weight: %d  ",i,cargo_planes.get(i).getPrice(),cargo_planes.get(i).getCapacity(),cargo_planes.get(i).getCompany_builder_name(),cargo_planes.get(i).getMaximum_flight_altitude(),cargo_planes.get(i).getBand_length_required_for_Landing(),cargo_planes.get(i).getTotal_portable_weight());
            System.out.println();
        }
    }
}
