package Main.Buildings;
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private int Cost_Construction;
    private int RoomNumber;
    private int Number_of_bed;
    private int Area;
    private int Accommodation_price;
    private static final ArrayList<Room> rooms = new ArrayList<>();

    public Room(int cost_construction,int roomNumber, int number_of_bed, int area, int accommodation_price) {
        RoomNumber = roomNumber;
        Number_of_bed = number_of_bed;
        Area = area;
        Accommodation_price = accommodation_price;
        Cost_Construction=cost_construction;
    }

    public void AddRoom(Room room) {
        rooms.add(room);
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getNumber_of_bed() {
        return Number_of_bed;
    }

    public int getArea() {
        return Area;
    }

    public int getAccommodation_price() {
        return Accommodation_price;
    }

    public int getCost_Construction() {
        return Cost_Construction;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setNumber_of_bed(int number_of_bed) {
        Number_of_bed = number_of_bed;
    }

    public void setArea(int area) {
        Area = area;
    }

    public void setAccommodation_price(int accommodation_price) {
        Accommodation_price = accommodation_price;
    }

    public void setCost_Construction(int cost_Construction) {
        Cost_Construction = cost_Construction;
    }

    public static void showRoom(Room room){
        System.out.format("Cost Construction: %d , Accommodation price: %d , Number of bed: %d , Area: %d\n",room.getCost_Construction(),room.getAccommodation_price(),room.getNumber_of_bed(),room.getArea());

    }
    public static void ShowRooms() {
        System.out.println("\n***********************************SHOW ROOMS***********************************");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.format("\n(Room Number:%d) Cost Construction: %d , Accommodation price: %d , Number of bed: %d , Area: %d", i,rooms.get(i).getCost_Construction(),rooms.get(i).getAccommodation_price(),rooms.get(i).getNumber_of_bed(),rooms.get(i).getArea());
            System.out.println();
        }
    }
}
