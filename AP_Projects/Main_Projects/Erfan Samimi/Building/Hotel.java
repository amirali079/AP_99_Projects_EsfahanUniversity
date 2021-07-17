package Main.Building;

import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;

import java.io.*;
import java.util.ArrayList;

public class Hotel implements Serializable{
    private String hotelName ;
    private int buildCost  ;
    private String address ;
    private int stars ;
    private int number_of_rooms ;
    private int builtRooms = 0 ;
//    private int number_of_employees ;

    private ArrayList<Room> roomList = new ArrayList<Room>() ;
    private static ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
//    transient private ArrayList<Person> employees = new ArrayList<Person>();
//    private ArrayList<Integer> employeeIDs = new ArrayList<>();

    enum Services {
        Breakfast , Lunch , Dinner , Pool ;
    }

    //======================================================================

    public Hotel(String hotelName, String address, int stars, int number_of_rooms){
        this.hotelName = hotelName ;
        this.buildCost =(number_of_rooms*150);
//        this.number_of_employees = number_of_employees ;
        this.address = address ;
        this.stars = stars ;
        this.number_of_rooms = number_of_rooms;
        hotelsList.add(this);
    }

    //=======================================================================

    public void addRoom( int roomNumber , int number_of_beds , int roomArea , int fee_per_night ){
        if (this.roomList.size() <= this.number_of_rooms){

            this.roomList.add( new Room(roomNumber , number_of_beds , roomArea ,fee_per_night )) ;
            this.builtRooms++;

        }
        else
            System.out.println("You add maximum number of rooms for this hotel");
    }

    ArrayList <Room> getRoomList (){
        return roomList;
    }

    public static ArrayList<Hotel> getHotelsList (){ return hotelsList; }

    int getHotelPrice(){
        return this.buildCost ;
    }

    public int getNumber_of_rooms(){ return this.number_of_rooms; }

    public int getBuildedRooms() { return this.builtRooms; }

    public String getHotelName(){
        return this.hotelName;
    }

//    public int getNumber_of_Employees(){
//        return number_of_employees;
//    }

//    public int getNumber_of_hired_Employees(){
//        return employees.size();
//    }

    public static Hotel get_Hotel_ByName(String name){
        for (Hotel h : hotelsList){
            if (h.hotelName.equals(name))
                return h;
        }
        return null;
    }

//    public void addEmployee(Person empl){
//        employees.add(empl);
//    }


    public String showInfo(){


        String str = "\nHotel name : " + hotelName + "\nAddress : " + address + "\nNumber of stars : " + stars + "\nMaximum number of hotel rooms : " + number_of_rooms +
                "\nNumber of built rooms : " + builtRooms ;


        return str ;
    }



    //=============================================================================================== Saving Hotel




    public static boolean firstObjectSave = true;
    private static String fileAddress = "/home/erfan/Projects/Java/Files/CityGame/hotels.txt";

    public void saveHotel() throws IOException {

//        for (Person a : this.employees)
//            this.employeeIDs.add(a.getID());



        //---------------


        if (firstObjectSave){
            FileOutputStream fout = new FileOutputStream(fileAddress );
            ObjectOutputStream obOut = new ObjectOutputStream(fout);
            obOut.writeObject(this);
            firstObjectSave = false;
            obOut.close();
            fout.close();
        }

        else{
            FileOutputStream fout = new FileOutputStream(fileAddress , true);
            CustomObjectOutputClass obOut = new CustomObjectOutputClass(fout);
            obOut.writeObject(this);
            obOut.close();
            fout.close();
        }



    }


    public static void restoreHotel() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(fileAddress);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){

                Hotel newHotel = (Hotel) obIn.readObject();

//                newHotel.employees = new ArrayList<>();

//                for (int id : newHotel.employeeIDs)
//                    newHotel.employees.add( Person.find_Person_from_ID(id));

                hotelsList.add(newHotel);

            }
        }
        catch (EOFException ex){}


        fin.close();

    }

}

class Room implements Serializable {
    private int  roomNumber ;
    private int number_of_beds ;
    private int roomArea ;
    private int fee_per_night ;

    Room(int roomNumber , int number_of_beds , int roomArea , int fee_per_night){
        this.roomNumber = roomNumber ;
        this.number_of_beds = number_of_beds ;
        this.roomArea = roomArea ;
        this.fee_per_night = fee_per_night ;
    }
}
