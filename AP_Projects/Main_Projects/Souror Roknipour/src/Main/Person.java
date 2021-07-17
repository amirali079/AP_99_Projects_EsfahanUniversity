package Main;
import java.io.Serializable;

public class Person implements Serializable {

    private final int ID;
    private static int counter = 0;
    private final String name;
    private boolean NotHire = true;
    private final String family;
    private final String birthplace;
    private final Job Job;
    private final int birthYear;
    private final double Employment_rights;
    private final Gender Gender;

    public enum Job {
        Sailor, Crew, Locomotive_driver, Bus_driver, Pilot
    }

    public enum Gender {
        Male, Female
    }

    public Person(String name, String family, String birthplace, Job job, int birthYear, double employment_rights, Gender gender) {
        this.name = name;
        this.ID = ++counter;
        this.family = family;
        this.birthplace = birthplace;
        Job = job;
        this.birthYear = birthYear;
        Employment_rights = employment_rights;
        Gender = gender;
        Country.country.setPopulation();
        Country.country.save();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public Job getJob() {
        return Job;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getEmployment_rights() {
        return Employment_rights;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setHire() {
        this.NotHire = false;
    }

    public boolean isNotHire() {
        return NotHire;
    }
}

