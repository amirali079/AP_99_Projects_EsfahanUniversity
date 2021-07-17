package Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    private String name;
    private String family;
    private int Year_of_Birth;
    private String Place_of_Birth;
    private Job job;
    private String Gender;
    private int Employment_salary;
    private boolean Employment_situation;


    public Person(String name, String family, int year_of_Birth, String place_of_Birth, Job job, String gender, int employment_salary,boolean Employment_situation) {
        this.name = name;
        this.family = family;
        this.Year_of_Birth = year_of_Birth;
        this.Place_of_Birth = place_of_Birth;
        this.job = job;
        this.Gender = gender;
        this.Employment_salary = employment_salary;
        this.Employment_situation=Employment_situation;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getYear_of_Birth() {
        return Year_of_Birth;
    }

    public String getPlace_of_Birth() {
        return Place_of_Birth;
    }

    public Job getJob() {
        return job;
    }

    public String getGender() {
        return Gender;
    }

    public int getEmployment_salary() {
        return Employment_salary;
    }

    public boolean isEmployment_situation() {
        return Employment_situation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setYear_of_Birth(int year_of_Birth) {
        Year_of_Birth = year_of_Birth;
    }

    public void setPlace_of_Birth(String place_of_Birth) {
        Place_of_Birth = place_of_Birth;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setEmployment_salary(int employment_salary) {
        Employment_salary = employment_salary;
    }

    public void setEmployment_situation(boolean employment_situation) {
        Employment_situation = employment_situation;
    }

    static enum Job{
        malvan,pilot,bus_driver,Locomotive_driver,crew;
    }

}
