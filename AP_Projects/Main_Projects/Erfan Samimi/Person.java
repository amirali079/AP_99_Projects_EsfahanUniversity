package Main;


import Main.Exception.InvalidPerson;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    Scanner sc = new Scanner(System.in);

    private String firstname ;
    private String lastname ;
    private int birthDate ;
    private String birthPlace ;
    private String job ;
    private String gender ;
    private int salary ;
    private int ID ;
    private boolean hired = false ;
    private static ArrayList<Person> peopleList = new ArrayList<Person>() ;

    public Person(){

    }

    public Person(String job , int salary , int ID ){
        this(null , null , null , job , null , 0000 , salary , ID) ;
    }

    public Person(String firstname , String lastname , String birthPlace , String job , String gender , int birthDate , int salary , int ID ){
        this.firstname = firstname ;
        this.lastname = lastname ;
        this.birthDate = birthDate ;
        this.birthPlace = birthPlace ;
        this.job = job ;
        this.gender = gender ;
        this.salary = salary ;

        while ( ! uniqID(ID)){
            System.out.print("This ID is exists . Please enter a new ID : ");
            ID = sc.nextInt();
        }

        this.ID = ID ;
        peopleList.add(this);
    }

    public static ArrayList<Person> getPeopleList(){
        return peopleList ;
    }

    public static boolean uniqID(int id){
        for (Person a : peopleList){
            if (a.ID == id)
                return false;
        }
        return true ;
    }

    public int getID(){
        return this.ID;
    }

    public String getJob(){
        return this.job ;
    }

    public boolean getHired(){
        return this.hired;
    }

    public int getSalary(){
        return this.salary;
    }

    public static Person find_Person_from_ID(int ID){
        for (Person a : peopleList){
            if(a.ID == ID)
                return a;
        }
        throw new InvalidPerson("No person exists with this id ");

    }

    public static void engage (int ID){
        for (Person a : peopleList){
            if(a.ID == ID) {
                a.hired = true;
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("You engaged person " + ID + " as " + a.job + " with " + a.salary + "$");
                System.out.println("---------------------------------------------------------------------------");

            }
        }


    }

    public static int number_of_jobs( String job , ArrayList<Person> people){
        int counter = 0 ;
        for (Person a : people){
            if (a.job.equals(job))
                counter ++;
        }
        return counter ;
    }


    //=================================================================================================== Save people

    static String address = "/home/erfan/Projects/Java/Files/CityGame/people.csv";
    static boolean append = false;

    void savePerson() throws IOException {

        FileOutputStream people = new FileOutputStream(address , append);
        PrintWriter pw = new PrintWriter(people );

        pw.format("%s,%d,%d,%b\n" , this.job , this.salary , this.ID , this.hired);
        append = true;

        pw.close();
        people.close();

    }

    static void restorePeople() throws IOException {

        FileReader people = new FileReader(address );

        Scanner sc = new Scanner(people);

        while (sc.hasNextLine()){
            String [] person = sc.nextLine().split(",");
            Person newPerson = new Person(person[0] , Integer.parseInt(person[1])  ,  Integer.parseInt(person[2]) );
            newPerson.hired = Boolean.parseBoolean(person[3]);

        }

        people.close();
    }


}
